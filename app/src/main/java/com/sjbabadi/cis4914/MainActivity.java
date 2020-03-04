package com.sjbabadi.cis4914;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startUserDash(View v) {
        Intent i = new Intent(this, UserDashActivity.class);
        startActivity(i);
    }
}
