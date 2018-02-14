package com.jiteshmohite619.jacocoandroidsample;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.jiteshmohite619.jacocoandroidsample.R;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 *
 * @author jiteshmohite
 */
public class LoginActivity extends AppCompatActivity {

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private TextView mLoginStatusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mLoginStatusView = (TextView) findViewById(R.id.login_status_text);
        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }


    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        mLoginStatusView.setVisibility(View.VISIBLE);
        if (!isEmailValid(mEmailView.getText().toString())) {
            mLoginStatusView.setText(R.string.error_invalid_email);
            return;
        }

        if (!isPasswordValid(mPasswordView.getText().toString())) {
            mLoginStatusView.setText(R.string.error_invalid_password);
            return;
        }

        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra(HomeActivity.LOGIN_SUCCESSFUL, true);
        startActivity(intent);

    }

    /**
     * Verify given email id based on the precondition.
     *
     * @param email Email Id of user
     * @return True- Valid email id, False otherwise.
     */
    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    /**
     * Verify given password based on the precondition.
     *
     * @param password Password of the user
     * @return True- Valid password, False otherwise
     */
    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }
}

