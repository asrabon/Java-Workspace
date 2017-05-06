package com.example.asrabon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sloan on 5/5/2017.
 */
public class Location {

    private final int locationID;
    private final String descritpion;
    private final Map<String, Integer> exits;

    public Location(int locationID, String descritpion) {
        this.locationID = locationID;
        this.descritpion = descritpion;
        this.exits = new HashMap<>();
        exits.put("Q", 0);
    }

    public void addExit(String direction, int location) {
        exits.put(direction, location);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }
}
