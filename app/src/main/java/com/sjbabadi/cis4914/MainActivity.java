package com.sjbabadi.cis4914;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout textUsernameLayout;
    private TextInputLayout textPasswordInput;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get references to login form components
        textUsernameLayout = findViewById(R.id.textUsernameLayout);
        textPasswordInput = findViewById(R.id.textPasswordInput);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.onLoginClicked();
            }
        });

        textUsernameLayout.getEditText()
                .addTextChangedListener(createTextWatcher(textUsernameLayout));

        textPasswordInput.getEditText()
                .addTextChangedListener(createTextWatcher(textPasswordInput));
    }

    private void showErrorDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Login Failed")
                .setMessage("Incorrect username or password. Please try again.")
                .setPositiveButton("OK", new Dialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    private void onLoginClicked() {
        String username = textUsernameLayout.getEditText().getText().toString();
        String password = textPasswordInput.getEditText().getText().toString();
        if (username.isEmpty()) {
            textUsernameLayout.setError("Please enter a Username");
        }
        if (password.isEmpty()) {
            textPasswordInput.setError("Please enter a password");
        } else if (!isValidCredential(username, password)) {
            showErrorDialog();
        }
    }

    private boolean isValidCredential(String user, String pwd) {
        if (user.equals("admin") && pwd.equals("admin")) {
            return true;
        }
        return false;
    }

    private TextWatcher createTextWatcher(final TextInputLayout textPwdInput) {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s,
                                          int start, int count, int after) {
                // not needed
            }

            @Override
            public void onTextChanged(CharSequence s,
                                      int start, int before, int count) {
                textPwdInput.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // not needed
            }
        };
    }

}
