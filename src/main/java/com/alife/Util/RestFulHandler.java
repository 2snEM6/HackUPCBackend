package com.alife.Util;

import com.alife.Constants;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

/**
 * Created by macbook on 4/3/17.
 */
public class RestFulHandler {

    private RestFulHandler(){}

    public static JSONObject getFirebase(String url) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get(url + ".json").
                header("accept",  "application/json").
                queryString("auth", Constants.Firebase.Credentials.APISECRET).asJson();

        return response.getBody().getObject();
    }

    public static JSONObject getFirebaseObject(String url, String parameter) throws UnirestException {
        if (parameter != null){
            HttpResponse<JsonNode> response = Unirest.get(url + "/" + parameter + ".json").
                    header("accept",  "application/json").
                    queryString("auth", Constants.Firebase.Credentials.APISECRET).
                    asJson();
            return response.getBody().getObject();
        }

        HttpResponse<JsonNode> response = Unirest.get(url + ".json").
                header("accept",  "application/json").
                queryString("auth", Constants.Firebase.Credentials.APISECRET).
                asJson();

        return response.getBody().getObject();
    }

    public static String getFirebaseSingleValue(String url) throws UnirestException {
        HttpResponse<String> response = Unirest.get(url + ".json").
                header("accept",  "application/json").
                queryString("auth", Constants.Firebase.Credentials.APISECRET).
                asString();
        if (response.getBody().equals("null")){
            return null;
        }

        return response.getBody();
    }

    public static JSONObject getElasticObject(String url) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get(url).
                header("accept",  "application/json").asJson();

        return response.getBody().getObject();
    }

    public static JSONObject getFirebaseKeysOnly(String url) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get(url +".json").
                header("accept",  "application/json").
                queryString("shallow", true).
                queryString("auth", Constants.Firebase.Credentials.APISECRET).asJson();

        return response.getBody().getObject();
    }

    public static JSONObject post(String url, String json) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.post(url)
                .header("accept", "application/json")
                .body(new JSONObject(json))
                .asJson();

        return response.getBody().getObject();
    }

    public static JSONObject postElastic(String url, String json) throws UnirestException {
        HttpResponse<String> response = Unirest.post(url)
                .header("accept", "application/json")
                .body(new JSONObject(json))
                .asString();
        return new JSONObject(response.getBody());
        // TODO: 28/2/17 Handle exception
    }

    public static JSONObject put(String url, String json) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.put(url)
                .header("accept", "application/json")
                .body(new JSONObject(json))
                .asJson();

        return response.getBody().getObject();
    }

    public static JSONObject putElastic(String url, String json) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.post(url + "/_update")
                .header("accept", "application/json")
                .body(new JSONObject(json))
                .asJson();

        return response.getBody().getObject();
    }

    public static JSONObject postWithJsonBody(String url, String jsonObjectAsString) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.post(url)
                .header("accept", "application/json")
                .body(jsonObjectAsString)
                .asJson();

        return response.getBody().getObject();
    }

}
