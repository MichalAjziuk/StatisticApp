package com.example.statisticapp;

public class PlayerStats {
    private int playerId;
    private int matchId;
    private int points;
    private int rebounds;
    private int assists;
    private int steals;

    PlayerStats() {}

    public PlayerStats(int playerId, int matchId, int points, int rebounds, int assists, int steals) {
        this.playerId = playerId;
        this.matchId = matchId;
        this.points = points;
        this.rebounds = rebounds;
        this.assists = assists;
        this.steals = steals;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getRebounds() {
        return rebounds;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getSteals() {
        return steals;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }
}
