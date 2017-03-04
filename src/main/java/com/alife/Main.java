package com.alife;

import com.alife.Entity.Emergency;
import com.alife.Entity.Participation;
import com.alife.Entity.Message;
import com.alife.Entity.User;
import com.alife.Handler.*;
import com.alife.Util.HTTPResponse;
import com.google.gson.Gson;
import com.sun.tools.internal.jxc.ap.Const;

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
    }

    private static void utilEndpoints() {
        get("/alife", (request, response) -> {
            response.type("application/json");
            return "I am alive";
        }, gson::toJson);
    }

    private static void userEndpoints() {
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
            return EmergencyHandler.create(gson.fromJson(request.body(), Emergency.class));
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
            return ParticipationHandler.create(participation);
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
            return MessageHandler.create(message);
        }, gson::toJson);
    }
}
