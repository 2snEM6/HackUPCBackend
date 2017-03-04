package com.alife.Handler;

import com.alife.Constants;
import com.alife.Entity.Message;
import com.alife.Util.HTTPResponse;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by macbook on 4/3/17.
 */
public class EmergencyMessagesHandler extends DatabaseHandler {

    private static String ENDPOINT = Constants.Firebase.Endpoints.RELATIONSHIPS.emergencyMessages;

    public static HTTPResponse getMessages(String emergencyID) {
        HTTPResponse httpResponse  = get(emergencyID, ENDPOINT);
        JSONObject messagesJSONObject = (JSONObject) httpResponse.getData();
        Map<String, Boolean> messages = new HashMap<>();
        messagesJSONObject.keySet().forEach(k -> {
            messages.put(k, true);
        });

        httpResponse.setData(messages);
        return httpResponse;
    }

    public static HTTPResponse addToEmergency(String emergencyID, String messageID, Message message) {
        return create(emergencyID, messageID, message, ENDPOINT);
    }

    public static HTTPResponse removeFromEmergency(String emergencyID, String messageID) {
        return delete(emergencyID,messageID, ENDPOINT);
    }

}
