package com.unit5.transport;

public class Transportation {
    private TransportType type;
    private Number lengthInKilometers;
    private Number pricePerKilometer;

    public Transportation(TransportType type, Number lengthInKilometers, Number pricePerKilometer) {
        this.type = type;
        this.lengthInKilometers = lengthInKilometers;
        this.pricePerKilometer = pricePerKilometer;
    }

    public Number getLengthInKilometers() {
        return lengthInKilometers;
    }

    public Number getPricePerKilometer() {
        return pricePerKilometer;
    }

    public String getTransportTypeString() {
        switch (type) {
            case Air:
                return "Воздух";
            case Rail:
                return "Железная дорога";
            case Road:
                return "Автомобильная дорога";
            case Maritime:
                return "Водное пространство";
            default:
                return "Неизвестно";
        }
    }

    public Number getTotalPrice() {
        return pricePerKilometer.doubleValue() * lengthInKilometers.doubleValue();
    }
}
