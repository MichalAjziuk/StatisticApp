package com.example.statisticapp;

public class Player {
    private String name;
    private String surname;
    private String age;
    private String dateOfBirth;
    private String country;
    private String height;
    private String weight;
    private String team;

    public Player(String name, String surname, String age, String dateOfBirth, String country, String height, String weight, String team) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.height = height;
        this.weight = weight;
        this.team = team;
    }
    public Player()
    {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
