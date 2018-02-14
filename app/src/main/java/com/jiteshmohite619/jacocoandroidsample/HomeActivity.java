package com.jiteshmohite619.jacocoandroidsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * This class will be responsible for showing whether user is loged in or not.
 *
 * @author jiteshmohite
 */
public class HomeActivity extends AppCompatActivity {

    public static final String LOGIN_SUCCESSFUL = "LOGIN";
    private TextView mLoginStatusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mLoginStatusView = (TextView) findViewById(R.id.login_status_text);
        if (getIntent().getExtras().getBoolean(LOGIN_SUCCESSFUL)) {
            mLoginStatusView.setText(R.string.login_successfuk);
        }
    }
}
