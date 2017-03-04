package com.alife.Entity;

import org.omg.CORBA.OBJ_ADAPTER;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by macbook on 4/3/17.
 */
public class Emergency {

    private String ID;
    private Integer type;
    private Location location;
    private Long _timestamp;
    private Map<String, Object> participations;

    public Emergency(String ID, Integer type, Location location) {
        this.ID = ID;
        this.type = type;
        this.location = location;
    }

    public Emergency() {
    }

    public Long get_timestamp() {
        return _timestamp;
    }

    public void set_timestamp(Long _timestamp) {
        this._timestamp = _timestamp;
    }

    public Map<String, Object> getParticipations() {
        return participations;
    }

    public void setParticipations(Map<String, Object> participations) {
        this.participations = participations;
    }

    public void addParticipation(String participationID) {
        if (participations == null) participations = new HashMap<>();
        participations.put(participationID, true);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
