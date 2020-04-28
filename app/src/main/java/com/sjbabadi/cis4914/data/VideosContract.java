package com.sjbabadi.cis4914.data;

import android.net.Uri;
import android.provider.BaseColumns;

public class VideosContract {
    static final String TABLE_NAME = "videos";

    public static final String CONTENT_AUTHORITY = "com.sjbabadi.cis4914";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_VIDEOS = "videos";

    // fields for videos table
    public static final class VideoEntry implements BaseColumns {
        public static final String _ID = BaseColumns._ID;
        public static final String VIDEO_NAME = "name";
        public static final String LINK = "link";
        public static final String TRACK_ID = "track_id";

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_VIDEOS);

        private VideoEntry() {
            //private constructor to prevent instantiation
        }
    }
}

