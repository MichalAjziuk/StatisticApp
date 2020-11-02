package com.example.statisticapp;

public class Training {
    private String name;
    private double time;
    private String intensity;
    private String dynamics;

    Training () {}

    public Training(String name, double time, String intensity, String dynamics) {
        this.name = name;
        this.time = time;
        this.intensity = intensity;
        this.dynamics = dynamics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public String getDynamics() {
        return dynamics;
    }

    public void setDynamics(String dynamics) {
        this.dynamics = dynamics;
    }
}
