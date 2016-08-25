package com.labs.ramdani.passbetweenparcelable.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.labs.ramdani.passbetweenparcelable.R;
import com.labs.ramdani.passbetweenparcelable.parcelable.User;

/**
 * Created by ramdani on 8/23/16.
 */

public class DisplayActivity extends AppCompatActivity {

    private static final String TAG = "debug";
    private TextView displayName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        //enable icon back navigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //get data from previous activity
        Intent in = this.getIntent();

        //get data from object user parceable
        User usr = (User) in.getParcelableExtra("your_name");
        //String getName = in.getStringExtra("your_name");

        Log.d(TAG, "onCreate: "+usr.getmName());

        displayName = (TextView) findViewById(R.id.display_name);

        // display name from input name
        displayName.setText(usr.getmName());


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // this takes the user 'back', as if they pressed the left-facing triangle icon on the main android toolbar.
                // if this doesn't work as desired, another possibility is to call `finish()` here.
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
