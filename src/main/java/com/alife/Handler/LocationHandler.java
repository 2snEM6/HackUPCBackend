package com.alife.Handler;

import com.alife.Constants;
import com.alife.Entity.Location;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.AddressType;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

/**
 * Created by macbook on 4/3/17.
 */
public class LocationHandler {

    private static GeoApiContext context = new GeoApiContext().setApiKey(Constants.GoogleMaps.API_KEY);

    public static void reverseGeoCode(Location location) {
        try {
            GeocodingResult[] geocodingResults = GeocodingApi.reverseGeocode(context, new LatLng(location.getLatitude(),
                    location.getLongitude())).await();
            System.out.println(geocodingResults[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
