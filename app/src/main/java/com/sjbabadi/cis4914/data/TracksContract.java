package com.sjbabadi.cis4914.data;

import android.net.Uri;
import android.provider.BaseColumns;

public class TracksContract {
    public static final String TABLE_NAME = "tracks";
    public static final String CONTENT_AUTHORITY = "com.sjbabadi.cis4914";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_TRACKS = "tracks";

    public static final class TrackEntry implements BaseColumns {
        public static final String _ID = BaseColumns._ID;
        public static final String TRACK_NAME = "name";

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_TRACKS);

        private TrackEntry() {
            //private constructor to prevent instantiation
        }
    }
}