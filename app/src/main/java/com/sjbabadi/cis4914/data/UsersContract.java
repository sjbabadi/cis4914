package com.sjbabadi.cis4914.data;

import android.net.Uri;
import android.provider.BaseColumns;

public class UsersContract {
    public static final String TABLE_NAME = "users";
    public static final String CONTENT_AUTHORITY = "com.sjbabadi.cis4914";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_USERS = "users";

    public static final class UserEntry implements BaseColumns {
        public static final String _ID = BaseColumns._ID;
        public static final String USER_NAME = "name";
        public static final String EMAIL = "email";
        public static final String ADMIN = "admin";

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_USERS);

        private UserEntry() {
            //private constructor to prevent instantiation
        }

    }

}