package com.alife.Util;


import com.alife.Constants;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import spark.QueryParamsMap;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class ObjectConverter {

    private static Gson gson = new Gson();

    public static String buildURL(String ENDPOINT, String ID, String parameter){
        return Constants.Firebase.Endpoints.BASE + ENDPOINT + "/" + ID + "/" + parameter;
    }

    public static <T> T sparkQueryMapToObject(QueryParamsMap queryParamsMap, Class<T> objectClass) {
        Map<String, Object> map = queryParamsMap
                .toMap()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue()[0]));
        return mapToObject(map, objectClass);
    }

    public static <T> T sparkQueryMapToMap(QueryParamsMap queryParamsMap) {
        Map<String, Object> map = queryParamsMap
                .toMap()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue()[0]));
        return (T) map;
    }

    public static <T> T mapToObject(Map<String, Object> map, Class<T> objectClass){
        JsonElement jsonElement = new Gson().toJsonTree(map);
        Object object = new Gson().fromJson(jsonElement, objectClass);
        return objectClass.cast(object);
    }

    public static Map<String, Object> objectToMap(Object object){
        if (object == null) return new HashMap();
        return gson.fromJson(gson.toJson(object),Map.class);
    }
}
