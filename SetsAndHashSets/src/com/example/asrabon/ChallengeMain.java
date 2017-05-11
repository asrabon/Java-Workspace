package com.example.asrabon;

import java.util.*;

/**
 * Created by asrab on 5/7/2017.
 */
public class ChallengeMain {

    public static void main(String[] args) {
        Moon moon1 = new Moon("John", 344);
        Star star1 = new Star("John", 522);
        Map<List, HeavenlyBody> solarSystem = new HashMap<>();
        Set<HeavenlyBody> solarSystemSet = new HashSet<>();
        solarSystemSet.add(moon1);
        solarSystemSet.add(star1);
        System.out.println(moon1.getClass());
        for(HeavenlyBody heavenlyBody: solarSystemSet) {
            System.out.println(heavenlyBody.getName() + " " + heavenlyBody.getOrbitalPeriod());
        }
    }

}
