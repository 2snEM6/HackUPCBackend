package com.alife.Entity;

/**
 * Created by macbook on 4/3/17.
 */
public class Alert {

    private Location location;
    private Integer type;
    private String requesterID;
    private String emergencyID;

    public Alert(Location location, Integer type, String requesterID) {
        this.location = location;
        this.type = type;
        this.requesterID = requesterID;
    }

    public Alert() {
    }

    public String getEmergencyID() {
        return emergencyID;
    }

    public void setEmergencyID(String emergencyID) {
        this.emergencyID = emergencyID;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRequesterID() {
        return requesterID;
    }

    public void setRequesterID(String requesterID) {
        this.requesterID = requesterID;
    }
}
