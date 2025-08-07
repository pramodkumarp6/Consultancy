package com.gravitational.consultancy.pramod.user.dash;


import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.gravitational.consultancy.pramod.user.R;

public class FeedBack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_feed_back);
        getSupportActionBar().setTitle("FeedBack");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    public boolean onOptionsItemSelected(MenuItem menuItem)
    {    int id = menuItem.getItemId();

        if(id== android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
