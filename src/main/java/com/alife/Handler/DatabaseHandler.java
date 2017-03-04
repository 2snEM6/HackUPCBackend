package com.alife.Handler;

import com.alife.Constants;
import com.alife.Util.HTTPResponse;
import com.alife.Util.ObjectConverter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.UUID;

/**
 * Created by macbook on 4/3/17.
 */
public class DatabaseHandler {

    public final static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public final static Gson gson = new GsonBuilder().create();

    public static HTTPResponse create(String ID, Object object, String databaseEndpoint){
        DatabaseReference databaseReference = database.getReference(databaseEndpoint);
        databaseReference.child(ID).setValue(object);
        return new HTTPResponse(new HTTPResponse.Status(Constants.HTTPCodes.OK), object);
    }

    public static HTTPResponse create(Object object, String databaseEndpoint){
        DatabaseReference databaseReference = database.getReference(databaseEndpoint);
        String ID = databaseReference.push().getKey();
        databaseReference.child(ID).setValue(object);
        return new HTTPResponse(new HTTPResponse.Status(Constants.HTTPCodes.OK), object, ID);
    }

    public static HTTPResponse update(String ID, Object object, String databaseEndpoint){
        DatabaseReference databaseReference = database.getReference(databaseEndpoint);
        databaseReference.child(ID).updateChildren(ObjectConverter.objectToMap(object));
        return new HTTPResponse(new HTTPResponse.Status(Constants.HTTPCodes.OK),ID);
    }


}
