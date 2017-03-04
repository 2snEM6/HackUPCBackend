package com.alife.Handler;

import com.alife.Constants;
import com.alife.Entity.User;
import com.alife.Util.HTTPResponse;
import org.json.JSONObject;

/**
 * Created by admin on 04/03/2017.
 */
public class UserHandler extends DatabaseHandler {

    private static String ENDPOINT = Constants.Firebase.Endpoints.user;

    public static HTTPResponse get(String ID) {
        HTTPResponse httpResponse = get(ID, ENDPOINT);
        User user = gson.fromJson(((JSONObject) httpResponse.getData()).toString(), User.class);
        httpResponse.setData(user);
        return httpResponse;
    }

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
