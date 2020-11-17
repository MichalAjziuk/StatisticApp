package com.example.statisticapp;

public class Match_DV {
    private int match_id;
    private String team1Name;
    private String team2Name;

    public Match_DV(int match_id, String team1Name, String team2Name) {
        this.match_id = match_id;
        this.team1Name = team1Name;
        this.team2Name = team2Name;
    }
    public Match_DV(){}

    @Override
    public String toString() {
        return team1Name + " vs " +team2Name;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public String getTeam1Name() {
        return team1Name;
    }

    public void setTeam1Name(String team1Name) {
        this.team1Name = team1Name;
    }

    public String getTeam2Name() {
        return team2Name;
    }

    public void setTeam2Name(String team2Name) {
        this.team2Name = team2Name;
    }
}
