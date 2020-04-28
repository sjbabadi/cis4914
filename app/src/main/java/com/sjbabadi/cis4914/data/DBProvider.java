package com.sjbabadi.cis4914.data;


import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBProvider extends ContentProvider {
    public static final String TAG = "DBProvider";

    // database helper object
    private AppDatabase mDBHelper;

    static final String CONTENT_AUTHORITY = "com.sjbabadi.cis4914.provider";
    public static final Uri CONTENT_AUTHORITY_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    // URI Matcher Data Setup
    private static final android.content.UriMatcher sUriMatcher = new UriMatcher(android.content.UriMatcher.NO_MATCH);
    private static final int VIDEOS = 1000;
    private static final int VIDEOS_ID = 1001;
    private static final int TRACKS = 2000;
    private static final int TRACKS_ID = 2001;
    private static final int USERS = 3000;
    private static final int USERS_ID = 3001;
    private static final int USERS_TRACKS = 4000;
    private static final int USERS_TRACKS_ID = 4001;

    static {
        sUriMatcher.addURI(CONTENT_AUTHORITY, VideosContract.PATH_VIDEOS, VIDEOS);
        sUriMatcher.addURI(CONTENT_AUTHORITY, VideosContract.PATH_VIDEOS + "/#", VIDEOS_ID);

        sUriMatcher.addURI(CONTENT_AUTHORITY, TracksContract.PATH_TRACKS, TRACKS);
        sUriMatcher.addURI(CONTENT_AUTHORITY, TracksContract.PATH_TRACKS + "/#", TRACKS_ID);

        sUriMatcher.addURI(CONTENT_AUTHORITY, UsersContract.PATH_USERS, USERS);
        sUriMatcher.addURI(CONTENT_AUTHORITY, UsersContract.PATH_USERS + "/#", USERS_ID);
    }

    @Override
    public boolean onCreate() {
        mDBHelper = AppDatabase.getInstance(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase db = mDBHelper.getReadableDatabase();
        Cursor cursor;

        int match = sUriMatcher.match(uri);
        switch (match) {
            case VIDEOS:
                //perform db query on videos table
                cursor = db.query(VideosContract.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case VIDEOS_ID:
                //perform db query on specific row in videos table
                selection = VideosContract.VideoEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
                cursor = db.query(VideosContract.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case TRACKS:
                //perform db query on videos table
                cursor = db.query(TracksContract.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case TRACKS_ID:
                //perform db query on specific row in videos table
                selection = TracksContract.TrackEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
                cursor = db.query(TracksContract.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case USERS:
                //perform db query on videos table
                cursor = db.query(VideosContract.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case USERS_ID:
                //perform db query on specific row in videos table
                selection = UsersContract.UserEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
                cursor = db.query(UsersContract.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
