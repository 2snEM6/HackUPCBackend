package Entity;

/**
 * Created by macbook on 4/3/17.
 */
public class Emergency {

    private String ID;
    private Integer type;
    private Location location;

    public Emergency(String ID, Integer type, Location location) {
        this.ID = ID;
        this.type = type;
        this.location = location;
    }

    public Emergency() {
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
