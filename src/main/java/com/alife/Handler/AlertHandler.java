package com.alife.Handler;

import com.alife.Constants;
import com.alife.Entity.Alert;
import com.alife.Util.HTTPResponse;
import org.json.JSONObject;


/**
 * Created by macbook on 4/3/17.
 */
public class AlertHandler extends DatabaseHandler {

    private static String ENDPOINT = Constants.Firebase.Endpoints.alert;

    public static HTTPResponse get(String ID) {
        HTTPResponse httpResponse = get(ID, ENDPOINT);
        JSONObject jsonObject = (JSONObject) httpResponse.getData();
        httpResponse.setData(gson.fromJson(jsonObject.toString(), Alert.class));
        return httpResponse;
    }

    public static HTTPResponse create(String ID, Alert alert) {
        return create(ID, alert, ENDPOINT);
    }

    public static HTTPResponse update(String ID, Alert alert) {
        return update(ID, alert, ENDPOINT);
    }

    public static HTTPResponse delete(String ID) {
        return delete(ID, ENDPOINT);
    }
}
