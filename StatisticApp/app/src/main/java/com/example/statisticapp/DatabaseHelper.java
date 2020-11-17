package com.example.statisticapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String USERS_TABLE = "USERS_TABLE";
    public static final String EMAIL = "EMAIL";
    public static final String PASSWORD = "PASSWORD";
    public static final String TEAM = "TEAM";
    public static final String ROLE = "ROLE";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "statsApp6.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tableUsers = "CREATE TABLE " + USERS_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + EMAIL + " TEXT, " + PASSWORD + " TEXT, " + TEAM + " TXT, " + ROLE + " TXT)";
        String tablePlayers = "CREATE TABLE PLAYERS "
                +" (PLAYER_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                +" NAME TEXT, "
                +" SURNAME TEXT, "
                +" AGE TEXT, "
                +" DATE_OF_BIRTH TEXT, "
                +" COUNTRY TEXT, "
                +" HEIGHT TEXT, "
                +" WEIGHT TEXT, "
                +" TEAM TEXT) ";

        String tableMatches = "CREATE TABLE MATCHES"
                +" (MATCH_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                +" NAME_TM1 TEXT, "
                +" NAME_TM2 TEXT, "
                +" DATE_OF_MATCH TEXT, "
                +" TM1_SCORE REAL, "
                +" TM2_SCORE REAL, "
                +" QT1_TM1 REAL, "
                +" QT2_TM1 REAL, "
                +" QT3_TM1 REAL, "
                +" QT4_TM1 REAL, "
                +" QT1_TM2 REAL, "
                +" QT2_TM2 REAL, "
                +" QT3_TM2 REAL, "
                +" QT4_TM2 REAL, "
                +" OVERTIME TEXT, "
                +" BEST_PLAYER_TM1 TEXT, "
                +" BEST_PLAYER_TM2 TEXT) ";

        String tableTraining = "CREATE TABLE TRAININGS"
                +" (TRAINING_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                +" NAME TEXT, "
                +" TIME REAL, "
                +" INFO TEXT, "
                +" INTENSITY TEXT, "
                +" DYNAMICS TEXT) ";

        String tablePlayersStats = "CREATE TABLE PLAYERS_STATS"
                +" (PLAYER_STATS_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                +" PLAYER_ID INTEGER, "
                +" MATCH_ID INTEGER, "
                +" POINTS REAL, "
                +" REBOUNDS REAL, "
                +" ASSISTS REAL, "
                +" STEALS REAL, "
                +" FOREIGN KEY(PLAYER_ID) REFERENCES PLAYERS(PLAYER_ID), "
                +" FOREIGN KEY(MATCH_ID) REFERENCES MATCHES(MATCH_ID) )";

        String tablePlayersProgress = "CREATE TABLE PLAYERS_PROGRESS"
                +" (PLAYER_PROGRESS_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                +" PLAYER_ID INTEGER, "
                +" TRAINING_ID INTEGER, "
                +" DATE_OF_TRAINING TEXT, "
                +" PHYSICAL_CONDITION TEXT, "
                +" FATIGUE REAL, "
                +" SPEED REAL, "
                +" JUMPING REAL, "
                +" MUSCULATURE REAL, "
                +" SATISFACTION TEXT, "
                +" FOREIGN KEY(PLAYER_ID) REFERENCES PLAYERS(PLAYER_ID), "
                +" FOREIGN KEY(TRAINING_Id) REFERENCES TRAININGS(TRAINING_ID) )";


        db.execSQL(tableUsers);
        db.execSQL(tablePlayers);
        db.execSQL(tableMatches);
        db.execSQL(tableTraining);
        db.execSQL(tablePlayersStats);
        db.execSQL(tablePlayersProgress);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }


    public boolean addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(EMAIL, user.getEmail());
        cv.put(PASSWORD, user.getPassword());
        cv.put(TEAM, user.getTeam());
        cv.put(ROLE, user.getRole());

        long insert = db.insertOrThrow(USERS_TABLE, null, cv);
        if(insert == -1) return false;
        else return true;
    }

    public boolean addPlayer(Player player){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("NAME",player.getName());
        cv.put("SURNAME",player.getSurname());
        cv.put("AGE",player.getAge());
        cv.put("DATE_OF_BIRTH",player.getDateOfBirth());
        cv.put("COUNTRY",player.getCountry());
        cv.put("HEIGHT",player.getHeight());
        cv.put("WEIGHT",player.getWeight());
        cv.put("TEAM",player.getTeam());

        long insert = db.insertOrThrow("PLAYERS",null,cv);
        if(insert == -1) return false;
        return true;
    }

    public boolean addMatch(Match match){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("NAME_TM1",match.getNameTeam1());
        cv.put("NAME_TM2",match.getNameTeam2());
        cv.put("DATE_OF_MATCH",match.getDateOfMatch());
        cv.put("TM1_SCORE",match.getTeam1score());
        cv.put("TM2_SCORE",match.getTeam2score());
        cv.put("QT1_TM1",match.getQt1team1());
        cv.put("QT2_TM1",match.getQt2team1());
        cv.put("QT3_TM1",match.getQt3team1());
        cv.put("QT4_TM1",match.getQt4team1());
        cv.put("QT1_TM2",match.getQt1team2());
        cv.put("QT2_TM2",match.getQt2team2());
        cv.put("QT3_TM2",match.getQt3team2());
        cv.put("QT4_TM2",match.getQt4team2());
        cv.put("OVERTIME",match.getOvertime());
        cv.put("BEST_PLAYER_TM1",match.getBpTeam1());
        cv.put("BEST_PLAYER_TM2",match.getBpTeam2());

        long insert = db.insertOrThrow("MATCHES",null,cv);
        if(insert == -1) return false;
        return true;
    }

    public boolean addTraining(Training training){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("NAME",training.getName());
        cv.put("INFO",training.getInfo());
        cv.put("TIME",training.getTime());
        cv.put("INTENSITY",training.getIntensity());
        cv.put("DYNAMICS",training.getDynamics());

        long insert = db.insertOrThrow("TRAININGS",null,cv);
        if(insert == -1) return false;
        return true;
    }

    public boolean addPlayerStats(PlayerStats playerStats){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("PLAYER_ID",playerStats.getPlayerId());
        cv.put("MATCH_ID",playerStats.getMatchId());
        cv.put("POINTS",playerStats.getPoints());
        cv.put("REBOUNDS",playerStats.getRebounds());
        cv.put("ASSISTS",playerStats.getAssists());
        cv.put("STEALS",playerStats.getSteals());

        long insert = db.insertOrThrow("PLAYERS_STATS",null,cv);
        if(insert == -1) return false;
        return true;
    }

    public boolean addPlayerProgress(PlayerProgress playerProgress){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("PLAYER_ID",playerProgress.getPlayerId());
        cv.put("TRAINING_ID",playerProgress.getTrainingId());
        cv.put("DATE_OF_TRAINING",playerProgress.getDateOfTraining());
        cv.put("PHYSICAL_CONDITION",playerProgress.getPhysicalCondition());
        cv.put("FATIGUE",playerProgress.getFatigue());
        cv.put("SPEED",playerProgress.getSpeed());
        cv.put("JUMPING",playerProgress.getJumping());
        cv.put("MUSCULATURE",playerProgress.getMusculature());
        cv.put("SATISFACTION",playerProgress.getSatisfaction());

        long insert = db.insertOrThrow("PLAYERS_PROGRESS",null,cv);
        if(insert == -1) return false;
        return true;
    }

    public boolean checkEmail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USERS_TABLE WHERE EMAIL=?", new String[]{email});
        if(cursor.getCount() > 0) return false;
        else return true;
    }

    public boolean checkEmailAndPassword(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USERS_TABLE WHERE EMAIL=? AND PASSWORD=?", new String [] {email, password});
        if(cursor.getCount() > 0) return true;
        return false;
    }

    public String checkRole(String email){
        String str = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT ROLE FROM USERS_TABLE WHERE EMAIL=?", new String [] {email});
        if (cursor.moveToFirst()) {
            str = cursor.getString(0);
        }
        return str;
    }

    public String checkTeam(String email){
        String str = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT TEAM FROM USERS_TABLE WHERE EMAIL=?", new String [] {email});
        if (cursor.moveToFirst()) {
            str = cursor.getString(0);
        }
        return str;
    }
    public void dropTable(){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+ USERS_TABLE);
    }


    public List<String> getAllPlayers(){
        List<String> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM PLAYERS";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        if(cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                String surname = cursor.getString(2);
                String team = cursor.getString(8);
                String player = name +" "+ surname +", "+ team ;
                returnList.add(player);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return returnList;
    }

    public List<Match_DV> getAllMatches(){
        List<Match_DV> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM MATCHES";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        if(cursor.moveToFirst()) {
            do {
                int match_id = cursor.getInt(0);
                String nameTM1 = cursor.getString(1);
                String nameTM2 = cursor.getString(2);
                Match_DV match_dv = new Match_DV(match_id,nameTM1,nameTM2);
                returnList.add(match_dv);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return returnList;
    }

    public Match getMatch(int match_id){
        Match match = new Match();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM MATCHES WHERE MATCH_ID=?", new String [] {String.valueOf(match_id)});
        if(cursor.moveToFirst()){
            String nameTM1 = cursor.getString(1);
            String nameTM2 = cursor.getString(2);
            String dateOfMatch = cursor.getString(3);
            int tm1score = cursor.getInt(4);
            int tm2score = cursor.getInt(5);
            int qt1tm1 = cursor.getInt(6);
            int qt2tm1 = cursor.getInt(7);
            int qt3tm1 = cursor.getInt(8);
            int qt4tm1 = cursor.getInt(9);
            int qt1tm2 = cursor.getInt(10);
            int qt2tm2 = cursor.getInt(11);
            int qt3tm2 = cursor.getInt(12);
            int qt4tm2 = cursor.getInt(13);
            String overtime = cursor.getString(14);
            String bptm1 = cursor.getString(15);
            String bptm2 = cursor.getString(16);
            match = new Match(nameTM1, nameTM2, dateOfMatch,tm1score,tm2score,
                    qt1tm1,qt2tm1,qt3tm1,qt4tm1,qt1tm2,qt2tm2,qt3tm2,qt4tm2,overtime,bptm1,bptm2);
        }
        cursor.close();
        db.close();
        return match;
    }

    public Player_Simple getPlayer(int player_id){
        Player_Simple player = new Player_Simple();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT PLAYER_ID, NAME, SURNAME FROM PLAYERS WHERE PLAYER_ID=?",new String [] {String.valueOf(player_id)});
        if(cursor.moveToFirst()){
            int player_ID = cursor.getInt(0);
            String name = cursor.getString(1);
            String surname = cursor.getString(2);
            player = new Player_Simple(player_ID,name, surname);
        }
        cursor.close();
        db.close();
        return player;
    }

    public PlayerStats getPlayerStats(int player_id){
        PlayerStats playerStats = new PlayerStats();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM PLAYERS_STATS WHERE PLAYER_ID=?",new String [] {String.valueOf(player_id)});
        if(cursor.moveToFirst()){
            int player_ID = cursor.getInt(0);
            int match_ID = cursor.getInt(1);
            int points = cursor.getInt(2);
            int rebounds = cursor.getInt(3);
            int assists = cursor.getInt(4);
            int steals = cursor.getInt(5);
            playerStats = new PlayerStats(player_ID,match_ID,points,rebounds,assists,steals);
        }
        cursor.close();
        db.close();
        return playerStats;
    }

    public PlayerProgress getPlayerProgress(int player_id){
        PlayerProgress playerProgress = new PlayerProgress();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM PLAYERS_PROGRESS WHERE PLAYER_ID=?",new String [] {String.valueOf(player_id)});
        if(cursor.moveToFirst()){
            int player_ID = cursor.getInt(0);
            int training_ID = cursor.getInt(1);
            String dateOfTraining = cursor.getString(2);
            String physical = cursor.getString(3);
            int fatigue = cursor.getInt(4);
            int speed = cursor.getInt(5);
            int jumping = cursor.getInt(6);
            int musculature = cursor.getInt(7);
            String satisfaction = cursor.getString(8);
            playerProgress = new PlayerProgress(player_ID,training_ID,dateOfTraining,physical,fatigue,speed,jumping,musculature,satisfaction);
        }
        cursor.close();
        db.close();
        return playerProgress;
    }



}
