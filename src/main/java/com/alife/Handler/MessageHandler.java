package com.alife.Handler;

import com.alife.Constants;
import com.alife.Entity.Message;
import com.alife.Util.HTTPResponse;

/**
 * Created by admin on 04/03/2017.
 */
public class MessageHandler extends DatabaseHandler {

    private static String ENDPOINT = Constants.Firebase.Endpoints.message;

    public static HTTPResponse create(String ID, Message message) {
        return create(ID,message,ENDPOINT);
    }

    public static HTTPResponse create(Message message) {
        return create(message,ENDPOINT);
    }

    public static HTTPResponse update(String ID, Message message) {
        return update(ID, message, ENDPOINT);
    }


}
