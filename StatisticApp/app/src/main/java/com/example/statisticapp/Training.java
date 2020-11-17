package com.example.statisticapp;

public class Training {
    private String name;
    private int time;
    private String info;
    private String intensity;
    private String dynamics;

    Training () {}

    public Training(String name, int time, String info, String intensity, String dynamics) {
        this.name = name;
        this.time = time;
        this.info = info;
        this.intensity = intensity;
        this.dynamics = dynamics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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
