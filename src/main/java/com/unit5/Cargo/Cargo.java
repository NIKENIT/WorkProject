package com.unit5.Cargo;

import com.unit5.location.Location;

public class Cargo {
    private long id;
    private String name;
    private Number volume;
    private Location locationFrom;
    private Location locationTo;

    public Cargo(long id, String name, Number volume, Location locationFrom, Location locationTo) {
        this.id = id;
        this.name = name;
        this.volume = volume;
        this.locationFrom = locationFrom;
        this.locationTo = locationTo;
    }

    public long getId() {
        return id;
    }

    public Number getVolume() {
        return volume;
    }

    public Location getLocationFrom() {
        return locationFrom;
    }

    public Location getLocationTo() {
        return locationTo;
    }

    public String getName() {
        return name;
    }
}
