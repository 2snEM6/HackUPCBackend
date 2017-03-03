package Entity;

/**
 * Created by macbook on 4/3/17.
 */
public class Participation {

    private String ID;
    private String userID;
    private String emergencyID;
    private String joinDate;

    public Participation(String ID, String userID, String emergencyID, String joinDate) {
        this.ID = ID;
        this.userID = userID;
        this.emergencyID = emergencyID;
        this.joinDate = joinDate;
    }

    public Participation() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmergencyID() {
        return emergencyID;
    }

    public void setEmergencyID(String emergencyID) {
        this.emergencyID = emergencyID;
    }
}
