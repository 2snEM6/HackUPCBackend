package com.alife.Handler;

import com.alife.Constants;
import com.alife.Entity.User;
import com.alife.Util.HTTPResponse;

/**
 * Created by admin on 04/03/2017.
 */
public class UserHandler extends DatabaseHandler {

    private static String ENDPOINT = Constants.Firebase.Endpoints.user;

    public static HTTPResponse create(String ID, User user) {
        return create(ID,user,ENDPOINT);
    }

    public static HTTPResponse create(User user) {
        return create(user,ENDPOINT);
    }

    public static HTTPResponse update(String ID, User user) {
        return update(ID, user, ENDPOINT);
    }

}
