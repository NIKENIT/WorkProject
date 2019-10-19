package com.unit5.location;

import com.unit5.transport.Transportation;

import java.util.Arrays;
import java.util.Comparator;

public class LocationTransportation {
    private long id;
    private Location locationFrom;
    private Location locationTo;
    private Transportation[] transportations;

    public LocationTransportation(long id, Location locationFrom, Location locationTo, Transportation[] transportations) {
        this.id = id;
        this.locationFrom = locationFrom;
        this.locationTo = locationTo;
        this.transportations = transportations;
    }

    public long getId() {
        return id;
    }

    public Location getLocationFrom() {
        return locationFrom;
    }

    public Location getLocationTo() {
        return locationTo;
    }

    public Transportation[] getTransportations() {
        return transportations;
    }

    public Number getLowestTotalPrice() {
        return Arrays.stream(transportations)
                .map(Transportation::getTotalPrice)
                .min(Comparator.comparing(Number::doubleValue))
                .orElse(0);
    }

    public Transportation getLowestTransportation() {
        return Arrays.stream(transportations)
                .min(Comparator.comparing(transportation -> transportation.getTotalPrice().doubleValue()))
                .orElse(null);
    }
}
