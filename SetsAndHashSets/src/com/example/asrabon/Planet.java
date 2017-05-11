package com.example.asrabon;

/**
 * Created by asrab on 5/7/2017.
 */
public class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod);
    }

    @Override
    public boolean addMoon(HeavenlyBody moon) {
        if(moon.getClass() == this.getClass()) {
            return super.addMoon(moon);
        }
        return false;
    }
}
