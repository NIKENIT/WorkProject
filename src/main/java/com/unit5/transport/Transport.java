package com.unit5.transport;

import java.math.BigDecimal;

public class Transport {
    private long id;
    private String name;
    private TransportType type;
    private BigDecimal price;
    private Integer maxVolume;

    public Transport(long id, String name, TransportType type, BigDecimal price, Integer maxVolume) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.maxVolume = maxVolume;
    }

    public long getId() {
        return id;
    }

    public TransportType getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getMaxVolume() {
        return maxVolume;
    }

    public String getName() {
        return name;
    }
}
