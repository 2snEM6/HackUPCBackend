package com.alife.Handler;

import com.alife.Constants;
import com.alife.Entity.Participation;
import com.alife.Util.HTTPResponse;

/**
 * Created by macbook on 4/3/17.
 */
public class ParticipationHandler extends DatabaseHandler {

    private static String ENDPOINT = Constants.Firebase.Endpoints.participation;

    public static HTTPResponse create(Participation participation) {
        return create(participation, ENDPOINT);
    }

    public static HTTPResponse create(String ID, Participation participation) {
        return create(ID, participation, ENDPOINT);
    }

    public static HTTPResponse get(String ID) {
        return get(ID);
    }


    public static HTTPResponse update(String ID, Participation participation) {
        return update(ID, participation, ENDPOINT);
    }

    public static HTTPResponse delete(String ID) {
        return delete(ID, ENDPOINT);
    }
}
