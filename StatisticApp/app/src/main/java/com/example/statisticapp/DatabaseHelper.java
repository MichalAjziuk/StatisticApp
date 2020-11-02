package com.example.statisticapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String USERS_TABLE = "USERS_TABLE";
    public static final String EMAIL = "EMAIL";
    public static final String PASSWORD = "PASSWORD";
    public static final String TEAM = "TEAM";
    public static final String ROLE = "ROLE";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "statsApp3.db", null, 1);
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
                +" DATE_OF_BIRTH NUMERIC, "
                +" COUNTRY TEXT, "
                +" HEIGHT TEXT, "
                +" WEIGHT TEXT, "
                +" TEAM TEXT) ";

        String tableMatches = "CREATE TABLE MATCHES"
                +" (MATCH_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                +" DATE_OF_MATCH NUMERIC, "
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
                +" INTENSITY TEXT, "
                +" DYNAMICS TEXT) ";

        String tablePlayerStats = "CREATE TABLE PLAYER_STATS"
                +" (PLAYER_STATS_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                +" PLAYER_ID INTEGER, "
                +" MATCH_ID INTEGER, "
                +" POINTS REAL, "
                +" REBOUNDS REAL, "
                +" ASSISTS REAL, "
                +" STEALS REAL, "
                +" FOREIGN KEY(PLAYER_ID) REFERENCES PLAYERS(PLAYER_ID), "
                +" FOREIGN KEY(MATCH_ID) REFERENCES MATCHES(MATCH_ID) )";

        String tablePlayerProgress = "CREATE TABLE PLAYERS_PROGRESS"
                +" (PLAYER_PROGRESS_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                +" PLAYER_ID INTEGER, "
                +" TRAINING_ID INTEGER, "
                +" DATE_OF_TRAINING NUMERIC, "
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
        db.execSQL(tablePlayerStats);
        db.execSQL(tablePlayerProgress);
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




}
