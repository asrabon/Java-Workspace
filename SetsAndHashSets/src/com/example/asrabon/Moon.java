package com.example.asrabon;

/**
 * Created by asrab on 5/7/2017.
 */
public class Moon extends HeavenlyBody {

    public Moon(String name, double orbitalPeriod) {
        super(name, orbitalPeriod);
    }

    @Override
    public boolean addMoon(HeavenlyBody moon) {
        return false;
    }
}
