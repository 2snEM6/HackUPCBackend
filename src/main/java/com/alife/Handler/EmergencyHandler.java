package com.alife.Handler;

import com.alife.Constants;
import com.alife.Entity.Emergency;
import com.alife.Util.HTTPResponse;

import java.util.UUID;

/**
 * Created by macbook on 4/3/17.
 */
public class EmergencyHandler extends DatabaseHandler {

    private static String ENDPOINT = Constants.Firebase.Endpoints.emergency;

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
