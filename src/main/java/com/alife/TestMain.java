package com.alife;

import com.alife.Entity.Location;
import com.alife.Handler.LocationHandler;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

/**
 * Created by macbook on 4/3/17.
 */
public class TestMain {

    public static void main(String[] args) {


        LocationHandler.reverseGeoCode(new Location(41.234234, 2.12342424));


    }
}
