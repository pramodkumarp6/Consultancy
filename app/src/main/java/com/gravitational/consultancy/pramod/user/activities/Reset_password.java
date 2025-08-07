package com.gravitational.consultancy.pramod.user.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.gravitational.consultancy.pramod.user.R;

public class Reset_password extends AppCompatActivity {

    private EditText reset_pass;
    private Button restbutton;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);


        reset_pass = (EditText)findViewById(R.id.forgetuser);
        restbutton =(Button)findViewById(R.id.rest_Button);
        progressDialog = new ProgressDialog(this);

        progressDialog.setMessage("Please wait...");


        restbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restpassword();
            }
        });




    }

    private void restpassword() {
    }
}
