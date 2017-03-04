import Util.HTTPResponse;
import com.google.gson.Gson;

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

    private static void setup(){
        setupEndpoints();
    }

    private static void setupEndpoints() {
        utilEndpoints();
        userEndpoints();
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
            return new HTTPResponse(new HTTPResponse.Status(Constants.HTTPCodes.OK));
        },gson::toJson);
    }
}
