package com.sjbabadi.cis4914;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class UserDashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dash);
    }

    public void startPlayer(View view) {
        Intent i = new Intent(this, MediaPlayerActivity.class);
        startActivity(i);
    }
}
