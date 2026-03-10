package com.skiCheck;

public class Resort {
    private String name;
    private double longitude;
    private double latitude;
    private double snowDepth;
    private double temperature;

    public void setName(String name) {
        this.name = name;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setSnowDepth(double snowDepth) {
        this.snowDepth = snowDepth;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getSnowDepth() {
        return snowDepth;
    }

    public double getTemperature() {
        return temperature;
    }
}

