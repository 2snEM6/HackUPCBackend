package com.alife.Handler;

import com.alife.Constants;

/**
 * Created by macbook on 4/3/17.
 */
public class AdminEmergenciesHandler extends DatabaseHandler {

    private static String ENDPOINT = Constants.Firebase.Endpoints.RELATIONSHIPS.adminEmergencies;

    public static void addToAdmin(String adminID, String emergencyID) {
        create(adminID,emergencyID, true, ENDPOINT);
    }

    public static void removeFromAdmin(String adminID, String emergencyID) {
        delete(adminID,emergencyID, ENDPOINT);
    }
}
