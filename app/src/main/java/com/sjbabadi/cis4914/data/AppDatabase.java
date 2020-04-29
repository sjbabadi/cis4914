package com.sjbabadi.cis4914.data;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AppDatabase  extends SQLiteOpenHelper {
    public static final String TAG = "AppDatabase";

    public static final String DB_NAME = "Mindfulness.db";
    public static final int DATABASE_VERSION = 1;

    // data field for the singleton helper object
    private static AppDatabase instance = null;

    public AppDatabase(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    //get an instance of the app's singleton DB helper object -- return SQLite DB Helper
    public static AppDatabase getInstance(Context context) {
        if(instance == null) {
            instance = new AppDatabase(context);
        }

        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sSQL;
        sSQL = "CREATE TABLE IF NOT EXISTS " + VideosContract.TABLE_NAME + " (" +
                VideosContract.VideoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                VideosContract.VideoEntry.VIDEO_NAME + " TEXT, " +
                VideosContract.VideoEntry.LINK + " TEXT NOT NULL, " +
                VideosContract.VideoEntry.TRACK_ID + " INTEGER NOT NULL, " +
                "FOREIGN KEY (track_id)\n" +
                "\t\tREFERENCES tracks (_id)\n" +
                ");";
        db.execSQL(sSQL);

        sSQL = "CREATE TABLE IF NOT EXISTS tracks (" +
                TracksContract.TrackEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TracksContract.TrackEntry.TRACK_NAME + " TEXT" +
                ");";
        db.execSQL(sSQL);

        sSQL = "CREATE TABLE IF NOT EXISTS users (\n" +
                UsersContract.UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                UsersContract.UserEntry.USER_NAME + " TEXT, " +
                UsersContract.UserEntry.EMAIL + " TEXT, " +
                UsersContract.UserEntry.ADMIN + " INTEGER" +
                ");";
        db.execSQL(sSQL);

        sSQL = "CREATE TABLE IF NOT EXISTS users_tracks(\n" +
                "\ttrack_id INTEGER NOT NULL,\n" +
                "\tuser_id INTEGER NOT NULL,\n" +
                "\tFOREIGN KEY (track_id)\n" +
                "\t\tREFERENCES tracks (_id),\n" +
                "\tFOREIGN KEY (user_id)\n" +
                "\t\tREFERENCES users (_id)\n" +
                ");";
        db.execSQL(sSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
