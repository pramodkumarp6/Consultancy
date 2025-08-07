package com.gravitational.consultancy.pramod.user;

import android.content.Intent;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.gravitational.consultancy.pramod.user.activities.Login;
import com.gravitational.consultancy.pramod.user.databinding.ActivityHomeBinding;


public class HomeActivity extends AppCompatActivity {
  //private ActivityHomeBinding  binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        //changeStatusBarColor(ContextCompat.getColor(this, R.color.cardview_dark_background));


        Thread t=new Thread() {
            public void run() {

                try {

                    sleep(1000);


                    Intent intent=new Intent(HomeActivity.this,Login.class);
                    // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                    finish();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };


        t.start();
    }


}
