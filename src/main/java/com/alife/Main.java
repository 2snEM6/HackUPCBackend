package com.alife;

import com.alife.Entity.*;
import com.alife.Handler.*;
import com.alife.Util.HTTPResponse;
import com.google.gson.Gson;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

import static spark.Spark.*;

/**
 * Created by macbook on 4/3/17.
 */
public class Main {

    private static Gson gson = new Gson();

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return Constants.Spark.port; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        setup();
    }

    private static void setup() {
        FirebaseSetupHandler.init();
        setupEndpoints();
    }

    private static void setupEndpoints() {
        utilEndpoints();
        userEndpoints();
        emergencyEndpoints();
        participationEndpoints();
        messageEndPoints();
        alertEndpoints();
    }

    private static void alertEndpoints() {
        post("/alerts", (request, response) -> {
            response.type(Constants.Spark.responseType);
            String ID = UUID.randomUUID().toString();
            return AlertHandler.create(ID, gson.fromJson(request.body(), Alert.class));
        }, gson::toJson);

        put("/alerts/:id", (request, response) -> {
            response.type(Constants.Spark.responseType);
            return AlertHandler.update(request.params(":id"), gson.fromJson(request.body(), Alert.class),
                    request.params(":id"));
        }, gson::toJson);
    }

    private static void utilEndpoints() {
        get("/alife", (request, response) -> {
            response.type("application/json");
            return "I am alive";
        }, gson::toJson);
    }

    private static void userEndpoints() {

        post("/users/:id/emergencies/:emergencyID/handle", (request, response) -> {
            response.type(Constants.Spark.responseType);
            Emergency emergency = (Emergency) EmergencyHandler.get(request.params(":emergencyID")).getData();
            String administratorID = request.params(":id");
            String emergencyID = request.params(":emergencyID");

            String participationID = UUID.randomUUID().toString();
            Participation participation = new Participation();
            participation.setEmergencyID(emergencyID);
            participation.setJoinDate(DateTimeHandler.getCurrentDateAsISO8601());
            participation.setUserID(administratorID);
            ParticipationHandler.create(participationID, participation);

            emergency.addParticipation(participationID);
            EmergencyHandler.update(emergencyID, emergency);
            AdminEmergenciesHandler.addToAdmin(administratorID, emergencyID);

            return new HTTPResponse(new HTTPResponse.Status(Constants.HTTPCodes.OK));
        }, gson::toJson);

        post("/users/:id/emergencies/:emergencyID/resolve", (request, response) -> {
            response.type(Constants.Spark.responseType);
            String adminID = request.params(":id");
            String emergencyID = request.params(":emergencyID");
            Emergency emergency = (Emergency) EmergencyHandler.get(emergencyID).getData();

            emergency.getParticipations().forEach((k, v) -> {

                Participation participation  = (Participation) ParticipationHandler.get(k).getData();
                String userID = participation.getUserID();

                if (participation.getAsAdmin()) {
                    AdminEmergenciesHandler.removeFromAdmin(adminID, emergencyID);
                } else {
                    UserEmergenciesHandler.removeFromUser(userID, participation.getEmergencyID());
                }

                ParticipationHandler.delete(k);
            });

            ((Map) EmergencyMessagesHandler.getMessages(emergencyID).getData()).forEach((k, v) -> {
                MessageHandler.delete((String) k);
            });

            EmergencyHandler.delete(request.params(":emergencyID"));
            return new HTTPResponse(new HTTPResponse.Status(Constants.HTTPCodes.OK));
        }, gson::toJson);


        post("/users/:id/emergencies", (request, response) -> {
            response.type(Constants.Spark.responseType);
            String emergencyID = UUID.randomUUID().toString();
            String participationID = UUID.randomUUID().toString();

            Emergency emergency = gson.fromJson(request.body(), Emergency.class);
            emergency.set_timestamp(Instant.now().toEpochMilli());
            emergency.addParticipation(participationID);

            Participation participation = new Participation();
            participation.setAsAdmin(false);
            participation.setJoinDate(DateTimeHandler.getCurrentDateAsISO8601());
            participation.setUserID(request.params(":id"));
            participation.setEmergencyID(emergencyID);

            ParticipationHandler.create(participationID, participation);
            UserEmergenciesHandler.addToUser(request.params(":id"),emergencyID);

            return EmergencyHandler.create(emergencyID, emergency);
        }, gson::toJson);

        delete("/users/:id/emergencies/:emergencyID", (request, response) -> {
            response.type(Constants.Spark.responseType);
            String userID = request.params(":id");
            String emergencyID = request.params(":emergencyID");
            HTTPResponse httpResponseEmergency = EmergencyHandler.get(emergencyID);
            if (httpResponseEmergency.getStatus().getCode() == Constants.HTTPCodes.OK) {
                Emergency emergency = (Emergency) httpResponseEmergency.getData();
                Map<String, Object> participations = emergency.getParticipations();
                participations.forEach((k,v) -> {
                    ParticipationHandler.delete(k);
                });
                EmergencyHandler.delete(emergencyID);
                UserEmergenciesHandler.removeFromUser(userID, emergencyID);
            }
            return new HTTPResponse(new HTTPResponse.Status(Constants.HTTPCodes.OK));
        }, gson::toJson);

        post("/users/:id/emergencies/:emergencyID/messages", (request, response) -> {
            response.type(Constants.Spark.responseType);
            String emergencyID = request.params(":emergencyID");
            String userID = request.params(":id");
            String messageID = UUID.randomUUID().toString();
            HTTPResponse httpResponse = UserHandler.get(userID);

            if (httpResponse.getStatus().getCode() == Constants.HTTPCodes.OK) {
                User user = (User) httpResponse.getData();
                Message message = gson.fromJson(request.body(),Message.class);
                message.setSenderID(request.params(":id"));
                message.setSentDate(DateTimeHandler.getCurrentDateAsISO8601());
                message.setSenderName(user.getName());
                EmergencyMessagesHandler.addToEmergency(emergencyID,messageID,message);
                httpResponse = MessageHandler.create(messageID, message);
            }
            return httpResponse;
        }, gson::toJson);


        post("/users/:id", (request, response) -> {
            response.type(Constants.Spark.responseType);
            User user = gson.fromJson(request.body(), User.class);
            user.setSignUpDate(DateTimeHandler.getCurrentDateAsISO8601());
            return UserHandler.create(request.params(":id"), user);
        }, gson::toJson);

        put("/users/:id", (request, response) -> {
            response.type(Constants.Spark.responseType);
            return UserHandler.update(request.params(":id"), gson.fromJson(request.body(), User.class));
        }, gson::toJson);
    }

    private static void emergencyEndpoints() {
        post("/emergencies", (request, response) -> {
            response.type(Constants.Spark.responseType);
            return EmergencyHandler.create(UUID.randomUUID().toString(), gson.fromJson(request.body(), Emergency.class));
        }, gson::toJson);

        put("/emergencies/:id", (request, response) -> {
            response.type(Constants.Spark.responseType);
            return EmergencyHandler.update(request.params(":id"), gson.fromJson(request.body(), Emergency.class));
        }, gson::toJson);

        delete("/emergencies/:id", (request, response) -> {
            response.type(Constants.Spark.responseType);
            return EmergencyHandler.delete(request.params(":id"));
        }, gson::toJson);
    }

    private static void participationEndpoints() {
        post("/participations", (request, response) -> {
            response.type(Constants.Spark.responseType);
            Participation participation = gson.fromJson(request.body(), Participation.class);
            participation.setJoinDate(DateTimeHandler.getCurrentDateAsISO8601());
            return ParticipationHandler.create(UUID.randomUUID().toString(), participation);
        }, gson::toJson);

        put("/participations/:id", (request, response) -> {
            response.type(Constants.Spark.responseType);
            return ParticipationHandler.update(request.params(":id"), gson.fromJson(request.body(),
                    Participation.class));
        }, gson::toJson);

        delete("/participations/:id", (request, response) -> {
            response.type(Constants.Spark.responseType);
            return ParticipationHandler.delete(request.params(":id"));
        }, gson::toJson);
    }

    private static void messageEndPoints() {
        post("/messages", (request, response) -> {
            response.type(Constants.Spark.responseType);
            Message message = gson.fromJson(request.body(), Message.class);
            message.setSentDate(DateTimeHandler.getCurrentDateAsISO8601());
            return MessageHandler.create(UUID.randomUUID().toString(), message);
        }, gson::toJson);
    }
}
