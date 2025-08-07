package com.gravitational.consultancy.pramod.user.dash;

import android.content.Intent;
import android.os.Bundle;


import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationView;
import com.gravitational.consultancy.pramod.user.R;
import com.gravitational.consultancy.pramod.user.chat.Chat;
import com.gravitational.consultancy.pramod.user.location.MapsActivity;
import com.gravitational.consultancy.pramod.user.model.SharedPrefManager;
import com.gravitational.consultancy.pramod.user.model.User;

import de.hdodenhof.circleimageview.CircleImageView;

public class DashBoard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private NavigationView navigationView;
    private View navHeader;
    private ImageView imgNavHeaderBg, imgProfile;
    private TextView txtName;
    private TextView txtWebsite;
    private Button profile;
    private Button   doc;
    private Button   interview_Schedule;
    private Button   chat;
    private Button   location1;
    private Button   feedback;
    private CircleImageView profileImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        profile =findViewById(R.id.profile_user);
        doc =findViewById(R.id.document_view_user);
        interview_Schedule =findViewById(R.id.interview_user);
        chat =findViewById(R.id.chat_user);
        location1 =findViewById(R.id.location_user);
        feedback =findViewById(R.id.feedback_id);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent u = new Intent(getApplicationContext(), Account_Profile.class);
                startActivity(u);
            }
        });



        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Document_View.class);
                startActivity(i);
            }
        });



        interview_Schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), InterView_Schedule.class);
                startActivity(i);
            }
        });







        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Chat.class);
                startActivity(i);
            }
        });



        location1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(i);
            }
        });


        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), FeedBack.class);
                startActivity(i);
            }
        });




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setItemTextAppearance(R.style.MenuTextStyle);
        navigationView.setItemIconTintList(null);
        navHeader = navigationView.getHeaderView(0);
        profileImageView = (CircleImageView)navHeader.findViewById(R.id.img_nav_profile);



        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Account_Profile.class);
                startActivity(i);
            }
        });







        txtName = (TextView)navHeader.findViewById(R.id.name);

        txtWebsite = (TextView)navHeader.findViewById(R.id.website);
        setProfile();
    }

    public  void setProfile()
    {
        User user = SharedPrefManager.getInstance(this).getUser();

        //txtName.setText(String.valueOf(user.getId()));
        txtWebsite.setText(user.getEmail());
        txtName.setText(user.getName());


    }













    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.dash_board, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.menuLogout12:
                Intent Notification = new Intent(this,Notification.class);
                startActivity(Notification);
                break;
            case R.id.nav_setting:
                Intent intent1 = new Intent(this,Setting.class);
                startActivity(intent1);
                break;

            case R.id.menuLogout:
                SharedPrefManager.getInstance(getApplicationContext()).logout();
                finish();

                break;
        }

        return super.onOptionsItemSelected(item);
    }















    private void displaySelectedScreen(int itemId) {


        switch (itemId) {

           /* case R.id.home:
                Intent feed = new Intent(this,Account_Profile.class);
                startActivity(feed);
                break;*/



           // case R.id.profile:

               // break;
          /*  case R.id.password:
                //fragment = new Password();
                Intent pass = new Intent(this,Password_Change.class);
                startActivity(pass);
                break;*/
           /* case R.id.users:
                fragment = new Users();
                break;*/

            case R.id.document:
                Intent docu = new Intent(this,Document_View.class);
                startActivity(docu);
                break;

                /*case R.id.nav_setting:
                    Intent intent = new Intent(this,Setting.class);
                    startActivity(intent);
                        break;*/

           /* case R.id.nav_notification:
                Intent i1 = new Intent(this,Notification.class);
                startActivity(i1);
                break;*/

            case R.id.nav_interView:
                Intent i2 = new Intent(this,InterView_Schedule.class);
                startActivity(i2);
                break;

            case R.id.nav_massage:
                Intent i3 = new Intent(this,Chat.class);
                startActivity(i3);
                break;

            case R.id.nav_location:
                Intent i4 = new Intent(this, MapsActivity.class);
                startActivity(i4);
                break;
            case R.id.nav_feed:
                Intent feedb = new Intent(this,FeedBack.class);
                startActivity(feedb);
                break;

            case R.id.nav_share:
                Intent i5 = new Intent(this,About.class);
                startActivity(i5);
                break;


            case R.id.nav_about:
                Intent i6 = new Intent(this,Condition.class);
                startActivity(i6);
                break;



        }


















        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        displaySelectedScreen(item.getItemId());

        return true;
    }
}
