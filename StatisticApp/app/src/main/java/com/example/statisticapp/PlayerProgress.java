package com.example.statisticapp;

public class PlayerProgress {
    private int playerId;
    private int trainingId;
    private String dateOfTraining;
    private String physicalCondition;
    private int fatigue;
    private int speed;
    private int jumping;
    private int musculature;
    private String satisfaction;

    PlayerProgress () {}

    public PlayerProgress(int playerId, int trainingId, String dateOfTraining, String physicalCondition, int fatigue, int speed, int jumping, int musculature, String satisfaction) {
        this.playerId = playerId;
        this.trainingId = trainingId;
        this.dateOfTraining = dateOfTraining;
        this.physicalCondition = physicalCondition;
        this.fatigue = fatigue;
        this.speed = speed;
        this.jumping = jumping;
        this.musculature = musculature;
        this.satisfaction = satisfaction;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    public String getDateOfTraining() {
        return dateOfTraining;
    }

    public void setDateOfTraining(String dateOfTraining) {
        this.dateOfTraining = dateOfTraining;
    }

    public String getPhysicalCondition() {
        return physicalCondition;
    }

    public void setPhysicalCondition(String physicalCondition) {
        this.physicalCondition = physicalCondition;
    }

    public int getFatigue() {
        return fatigue;
    }

    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getJumping() {
        return jumping;
    }

    public void setJumping(int jumping) {
        this.jumping = jumping;
    }

    public int getMusculature() {
        return musculature;
    }

    public void setMusculature(int musculature) {
        this.musculature = musculature;
    }

    public String getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(String satisfaction) {
        satisfaction = satisfaction;
    }
}
