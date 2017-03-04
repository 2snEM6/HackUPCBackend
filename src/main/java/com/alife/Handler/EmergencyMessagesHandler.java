package com.alife.Handler;

import com.alife.Constants;
import com.alife.Entity.Message;
import com.alife.Util.HTTPResponse;

/**
 * Created by macbook on 4/3/17.
 */
public class EmergencyMessagesHandler extends DatabaseHandler {

    private static String ENDPOINT = Constants.Firebase.Endpoints.RELATIONSHIPS.emergencyMessages;

    public static HTTPResponse addToEmergency(String emergencyID, String messageID, Message message) {
        return create(emergencyID, messageID, message, ENDPOINT);
    }

    public static HTTPResponse removeFromEmergency(String emergencyID, String messageID) {
        return delete(emergencyID,messageID, ENDPOINT);
    }

}
