package com.sjbabadi.cis4914.data;

import android.provider.BaseColumns;

public class VideosContract {
    static final String TABLE_NAME = "videos";

    // fields for videos table
    public static class Columns {
        public static final String _ID = BaseColumns._ID;
        public static final String VIDEO_NAME = "name";
        public static final String LINK = "link";
        public static final String TRACK_ID = "track_id";

        private Columns() {
            //private constructor to prevent instantiation
        }
    }
}
