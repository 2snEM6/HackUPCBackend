package com.alife.Handler;

import com.alife.Constants;

/**
 * Created by macbook on 4/3/17.
 */
public class UserEmergenciesHandler extends DatabaseHandler {

    private static String ENDPOINT = Constants.Firebase.Endpoints.RELATIONSHIPS.userEmergencies;

    public static void addToUser(String userID, String emergencyID) {
        create(userID,emergencyID, true, ENDPOINT);
    }

    public static void removeFromUser(String userID, String emergencyID) {
        delete(userID,emergencyID, ENDPOINT);
    }
}
