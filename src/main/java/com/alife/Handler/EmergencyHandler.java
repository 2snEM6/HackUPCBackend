package com.alife.Handler;

import com.alife.Constants;
import com.alife.Entity.Emergency;
import com.alife.Util.HTTPResponse;
import com.alife.Util.RestFulHandler;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import java.util.UUID;

/**
 * Created by macbook on 4/3/17.
 */
public class EmergencyHandler extends DatabaseHandler {

    private static String ENDPOINT = Constants.Firebase.Endpoints.emergency;

    public static HTTPResponse get(String ID) {
        try {
            JSONObject jsonObject = RestFulHandler.getFirebase(Constants.Firebase.Endpoints.BASE + ENDPOINT + "/" + ID);
            Emergency emergency = gson.fromJson(jsonObject.toString(), Emergency.class);
            return new HTTPResponse(new HTTPResponse.Status(Constants.HTTPCodes.OK), emergency, ID);
        } catch (UnirestException e) {
            return new HTTPResponse(new HTTPResponse.Status(Constants.HTTPCodes.NOT_FOUND));
        }
    }

    public static HTTPResponse create(String ID, Emergency emergency) {
        return create(ID,emergency,ENDPOINT);
    }

    public static HTTPResponse create(Emergency emergency) {
        return create(emergency,ENDPOINT);
    }

    public static HTTPResponse update(String ID, Emergency emergency) {
        return update(ID, emergency, ENDPOINT);
    }

    public static HTTPResponse delete(String ID) {
        return delete(ID,ENDPOINT);
    }

}
