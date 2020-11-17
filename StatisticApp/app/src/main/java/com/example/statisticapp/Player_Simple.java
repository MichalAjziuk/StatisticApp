package com.example.statisticapp;

public class Player_Simple {
    private int player_id;
    private String NAME;
    private String SURNAME;

    public Player_Simple() {}

    public Player_Simple(int player_id, String NAME, String SURNAME) {
        this.player_id = player_id;
        this.NAME = NAME;
        this.SURNAME = SURNAME;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getSURNAME() {
        return SURNAME;
    }

    public void setSURNAME(String SURNAME) {
        this.SURNAME = SURNAME;
    }
}
