package com.example.statisticapp;

public class Match {
    private String dateOfMatch;
    private int team1score;
    private int team2score;
    private int qt1team1;
    private int qt2team1;
    private int qt3team1;
    private int qt4team1;
    private int qt1team2;
    private int qt2team2;
    private int qt3team2;
    private int qt4team2;
    private String overtime;
    private String bpTeam1;
    private String bpTeam2;

    Match () {}

    public Match(String dateOfMatch, int team1score, int team2score, int qt1team1, int qt2team1, int qt3team1, int qt4team1, int qt1team2, int qt2team2, int qt3team2, int qt4team2, String overtime, String bpTeam1, String bpTeam2) {
        this.dateOfMatch = dateOfMatch;
        this.team1score = team1score;
        this.team2score = team2score;
        this.qt1team1 = qt1team1;
        this.qt2team1 = qt2team1;
        this.qt3team1 = qt3team1;
        this.qt4team1 = qt4team1;
        this.qt1team2 = qt1team2;
        this.qt2team2 = qt2team2;
        this.qt3team2 = qt3team2;
        this.qt4team2 = qt4team2;
        this.overtime = overtime;
        this.bpTeam1 = bpTeam1;
        this.bpTeam2 = bpTeam2;
    }

    public String getDateOfMatch() {
        return dateOfMatch;
    }

    public void setDateOfMatch(String dateOfMatch) {
        this.dateOfMatch = dateOfMatch;
    }

    public int getTeam1score() {
        return team1score;
    }

    public void setTeam1score(int team1score) {
        this.team1score = team1score;
    }

    public int getTeam2score() {
        return team2score;
    }

    public void setTeam2score(int team2score) {
        this.team2score = team2score;
    }

    public int getQt1team1() {
        return qt1team1;
    }

    public void setQt1team1(int qt1team1) {
        this.qt1team1 = qt1team1;
    }

    public int getQt2team1() {
        return qt2team1;
    }

    public void setQt2team1(int qt2team1) {
        this.qt2team1 = qt2team1;
    }

    public int getQt3team1() {
        return qt3team1;
    }

    public void setQt3team1(int qt3team1) {
        this.qt3team1 = qt3team1;
    }

    public int getQt4team1() {
        return qt4team1;
    }

    public void setQt4team1(int qt4team1) {
        this.qt4team1 = qt4team1;
    }

    public int getQt1team2() {
        return qt1team2;
    }

    public void setQt1team2(int qt1team2) {
        this.qt1team2 = qt1team2;
    }

    public int getQt2team2() {
        return qt2team2;
    }

    public void setQt2team2(int qt2team2) {
        this.qt2team2 = qt2team2;
    }

    public int getQt3team2() {
        return qt3team2;
    }

    public void setQt3team2(int qt3team2) {
        this.qt3team2 = qt3team2;
    }

    public int getQt4team2() {
        return qt4team2;
    }

    public void setQt4team2(int qt4team2) {
        this.qt4team2 = qt4team2;
    }

    public String getOvertime() {
        return overtime;
    }

    public void setOvertime(String overtime) {
        this.overtime = overtime;
    }

    public String getBpTeam1() {
        return bpTeam1;
    }

    public void setBpTeam1(String bpTeam1) {
        this.bpTeam1 = bpTeam1;
    }

    public String getBpTeam2() {
        return bpTeam2;
    }

    public void setBpTeam2(String bpTeam2) {
        this.bpTeam2 = bpTeam2;
    }
}
