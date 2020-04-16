package com.sjbabadi.cis4914.data;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// only class that should access this is the ContentProvider
class AppDatabase  extends SQLiteOpenHelper {
    public static final String TAG = "AppDatabase";

    public static final String DB_NAME = "Mindfulness.db";
    public static final int DATABASE_VERSION = 1;

    // data field for the singleton helper object
    private static AppDatabase instance = null;

    public AppDatabase(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    //get an instance of the app's singleton DB helper object -- return SQLite DB Helper
    static AppDatabase getInstance(Context context) {
        if(instance == null) {
            instance = new AppDatabase(context);
        }

        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sSQL;
        sSQL = "CREATE TABLE " + VideosContract.TABLE_NAME + " (" +
                VideosContract.Columns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                VideosContract.Columns.VIDEO_NAME + " TEXT, " +
                VideosContract.Columns.LINK + " TEXT NOT NULL, " +
                VideosContract.Columns.TRACK_ID + " INTEGER NOT NULL, " +
                "FOREIGN KEY (track_id)\n" +
                "\t\tREFERENCES tracks (_id)\n" +
                ");";
        db.execSQL(sSQL);
        sSQL = "CREATE TABLE tracks (\n" +
                "\t_id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\tname TEXT\n" +
                ");";
        db.execSQL(sSQL);
        sSQL = "CREATE TABLE users (\n" +
                "\t_id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\tname TEXT,\n" +
                "\temail TEXT\n" +
                ")";
        db.execSQL(sSQL);
        sSQL = "CREATE TABLE users_tracks(\n" +
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
