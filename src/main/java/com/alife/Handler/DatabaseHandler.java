package com.alife.Handler;

import com.alife.Constants;
import com.alife.Entity.Emergency;
import com.alife.Util.HTTPResponse;
import com.alife.Util.ObjectConverter;
import com.alife.Util.RestFulHandler;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import java.util.UUID;

/**
 * Created by macbook on 4/3/17.
 */
public class DatabaseHandler {

    public final static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public final static Gson gson = new GsonBuilder().create();

    public static HTTPResponse get(String ID, String databaseEndpoint) {
        try {
            JSONObject jsonObject = RestFulHandler.getFirebase(Constants.Firebase.Endpoints.BASE + databaseEndpoint + "/" + ID);
            return new HTTPResponse(new HTTPResponse.Status(Constants.HTTPCodes.OK), jsonObject, ID);
        } catch (UnirestException e) {
            return new HTTPResponse(new HTTPResponse.Status(Constants.HTTPCodes.NOT_FOUND));
        }
    }

    public static HTTPResponse create(String ID, Object object, String databaseEndpoint) {
        DatabaseReference databaseReference = database.getReference(databaseEndpoint);
        databaseReference.child(ID).setValue(object);
        return new HTTPResponse(new HTTPResponse.Status(Constants.HTTPCodes.OK), object, ID);
    }

    public static HTTPResponse create(Object object, String databaseEndpoint) {
        DatabaseReference databaseReference = database.getReference(databaseEndpoint);
        String ID = databaseReference.push().getKey();
        databaseReference.child(ID).setValue(object);
        return new HTTPResponse(new HTTPResponse.Status(Constants.HTTPCodes.OK), object, ID);
    }

    public static HTTPResponse create(String fatherID, String childID, Object object, String databaseEndpoint) {
        DatabaseReference databaseReference = database.getReference(databaseEndpoint);
        String ID = databaseReference.push().getKey();
        databaseReference.child(fatherID).child(childID).setValue(object);
        return new HTTPResponse(new HTTPResponse.Status(Constants.HTTPCodes.OK), object, ID);
    }

    public static HTTPResponse update(String ID, Object object, String databaseEndpoint) {
        DatabaseReference databaseReference = database.getReference(databaseEndpoint);
        databaseReference.child(ID).updateChildren(ObjectConverter.objectToMap(object));
        return new HTTPResponse(new HTTPResponse.Status(Constants.HTTPCodes.OK), ID);
    }

    public static HTTPResponse delete(String ID, String databaseEndpoint) {
        DatabaseReference databaseReference = database.getReference(databaseEndpoint);
        databaseReference.child(ID).removeValue();
        return new HTTPResponse(new HTTPResponse.Status(Constants.HTTPCodes.OK));
    }

    public static HTTPResponse delete(String fatherID, String childID, String databaseEndpoint) {
        DatabaseReference databaseReference = database.getReference(databaseEndpoint);
        databaseReference.child(fatherID).child(childID).removeValue();
        return new HTTPResponse(new HTTPResponse.Status(Constants.HTTPCodes.OK));
    }


}
