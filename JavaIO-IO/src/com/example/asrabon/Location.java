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

    public Location(int locationID, String descritpion, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.descritpion = descritpion;
        if(exits == null) {
            exits = new HashMap<>();
        }
        this.exits = new HashMap<>(exits);
        exits.put("Q", 0);
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
