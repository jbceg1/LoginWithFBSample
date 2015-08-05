package com.jb.myfirstandroidfbloginapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.facebook.Profile;
import com.facebook.login.widget.ProfilePictureView;


public class WelcomeActivity extends ActionBarActivity {

    private TextView mTextDetails;
    private ProfilePictureView profilePictureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Profile profile = Profile.getCurrentProfile();

        if (profile != null) {
            mTextDetails = (TextView) findViewById(R.id.welcome_textview);
            mTextDetails.setText("Welcome " + profile.getName());
            profilePictureView = (ProfilePictureView) findViewById(R.id.image);
            profilePictureView.setProfileId(profile.getId());
            profilePictureView.setCropped(true);

        } else {
            mTextDetails = (TextView) findViewById(R.id.welcome_textview);
            mTextDetails.setText("Welcome guest");
            profilePictureView = (ProfilePictureView) findViewById(R.id.image);
            profilePictureView.setProfileId(null);
        }

        profilePictureView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
