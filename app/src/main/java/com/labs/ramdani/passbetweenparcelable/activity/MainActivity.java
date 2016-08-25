package com.labs.ramdani.passbetweenparcelable.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.labs.ramdani.passbetweenparcelable.R;
import com.labs.ramdani.passbetweenparcelable.parcelable.User;

/**
 * Created by ramdani on 8/23/16.
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "debug";

    private EditText txtYourName;
    private Button btnSubmit;
    private String getTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //casting object
        txtYourName = (EditText) findViewById(R.id.txt_name);
        btnSubmit = (Button) findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // get text from input name
                getTextName = txtYourName.getText().toString();

                // loging get text from input name
                Log.d(TAG, "onClick: "+getTextName);

                //setter name
                User usr = new User();
                usr.setmName(getTextName);

                //passing data with intent
                Intent in = new Intent(getApplicationContext(), DisplayActivity.class);
                //in.putExtra("your_name",getTextName);
                in.putExtra("your_name",usr);

                //call next activity
                startActivity(in);
            }
        });


    }
}
