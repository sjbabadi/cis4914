package com.sjbabadi.cis4914;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.sjbabadi.cis4914.data.AppDatabase;
import com.sjbabadi.cis4914.data.VideosContract;

public class TrackDetailActivity extends AppCompatActivity implements View.OnClickListener {
    ContentResolver contentResolver;
    String[] projection = {VideosContract.VideoEntry.LINK};
    AppDatabase dbHelper = AppDatabase.getInstance(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_detail);
        contentResolver = getContentResolver();

        //set click listeners
        findViewById(R.id.guided_imagery).setOnClickListener(this);
        findViewById(R.id.deep_breathing).setOnClickListener(this);
        findViewById(R.id.body_scan).setOnClickListener(this);
        findViewById(R.id.mindfulness).setOnClickListener(this);
        findViewById(R.id.guided_meditation).setOnClickListener(this);
        findViewById(R.id.progressive_muscle_relaxation).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Cursor findLink;

        switch(v.getId()) {
            case R.id.guided_imagery:
                findLink = contentResolver.query(VideosContract.VideoEntry.CONTENT_URI,
                        projection, "name=?",  new String[] {"Guided Imagery"}, null, null);
                if(findLink.moveToFirst()) {
                    String link = findLink.getString(2);
                    startVideoPlayer(link);
                }
                findLink.close();

            case R.id.guided_meditation:
                findLink = contentResolver.query(VideosContract.VideoEntry.CONTENT_URI,
                        projection, "name=?",  new String[] {"Guided Mindfulness Meditation"}, null, null);
                if(findLink.moveToFirst()) {
                    String link = findLink.getString(2);
                    startVideoPlayer(link);
                }
                findLink.close();
            case R.id.body_scan:
                findLink = contentResolver.query(VideosContract.VideoEntry.CONTENT_URI,
                        projection, "name=?",  new String[] {"Body Scan Meditation"}, null, null);
                if(findLink.moveToFirst()) {
                    String link = findLink.getString(2);
                    startVideoPlayer(link);
                }
                findLink.close();
            case R.id.deep_breathing:
                findLink = contentResolver.query(VideosContract.VideoEntry.CONTENT_URI,
                        projection, "name=?",  new String[] {"Deep Breathing"}, null, null);
                if(findLink.moveToFirst()) {
                    String link = findLink.getString(2);
                    startVideoPlayer(link);
                }
                findLink.close();
            case R.id.progressive_muscle_relaxation:
                findLink = contentResolver.query(VideosContract.VideoEntry.CONTENT_URI,
                        projection, "name=?",  new String[] {"Progressive Muscle Relaxation"}, null, null);
                if(findLink.moveToFirst()) {
                    String link = findLink.getString(2);
                    startVideoPlayer(link);
                }
                findLink.close();
            case R.id.mindfulness:
                findLink = contentResolver.query(VideosContract.VideoEntry.CONTENT_URI,
                        projection, "name=?",  new String[] {"Mindfulness"}, null, null);
                if(findLink.moveToFirst()) {
                    String link = findLink.getString(2);
                    startVideoPlayer(link);
                }
                findLink.close();
            default:
                return;
        }
    }

    public void startVideoPlayer(String videoLink) {
        Intent i = new Intent(this, MediaPlayerActivity.class);
        i.putExtra("vid_link", videoLink);
        startActivity(i);
    }
}