package com.sjbabadi.cis4914;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
//import com.sjbabadi.cis4914.data.AppDatabase;

public class MainActivity extends AppCompatActivity {

    public static final int RC_SIGN_IN = 1;

    private TextInputLayout textUsernameLayout;
    private TextInputLayout textPasswordInput;
    private Button loginButton;
    private ProgressBar progressBar;
    private FirebaseAuth mFireBaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //AppDatabase appDatabase = AppDatabase.getInstance(this);
        //final SQLiteDatabase db = appDatabase.getReadableDatabase();

        // initialize Firebase components
        mFireBaseAuth = FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // user is signed in
                    onSignedInInitialize();
                } else {
                    // user is signed out
                    onSignedOutCleanup();
                    startActivityForResult(
                            // Get an instance of AuthUI based on the default app
                            AuthUI.getInstance().createSignInIntentBuilder()
                                    .setTheme(R.style.AppTheme)
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };
    }

    private void startUserActivity() {
        Intent i = new Intent(this, UserDashActivity.class);
        startActivity(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mFireBaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mFireBaseAuth.removeAuthStateListener(mAuthStateListener);
    }

    private void onSignedInInitialize() {
        startUserActivity();

    }

    private void onSignedOutCleanup() {

    }
}
