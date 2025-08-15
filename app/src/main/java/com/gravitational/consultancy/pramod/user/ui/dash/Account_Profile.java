package com.gravitational.consultancy.pramod.user.ui.dash;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.gravitational.consultancy.pramod.user.R;
import com.gravitational.consultancy.pramod.user.data.model.SharedPrefManager;
import com.gravitational.consultancy.pramod.user.data.model.User;

public class Account_Profile extends AppCompatActivity {
     private TextView   username;
     private TextView   user_profile_name;
     private TextView userAddress;
     private TextView userexperience;
     private TextView  usermail;
     private TextView  userphone;
     private TextView resume_button;
     private TextView user_profile_sumarry;
     private  TextView user_skill;
     private  TextView Emp;
     private  TextView project;
     private  TextView it_skill;
     private  TextView education;
     private  TextView certificate;
     private  TextView other_dtails;
     private  TextView Language;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account__profile);
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().getHeight();

        username= findViewById(R.id.user_name);
        user_profile_name= findViewById(R.id.user_profile);

        userAddress= findViewById(R.id.user_location);

        userexperience= findViewById(R.id.user_experience);

        usermail= findViewById(R.id.user_mail);

        userphone= findViewById(R.id.user_phone);
        resume_button= findViewById(R.id.user_resume);
        user_profile_sumarry = findViewById(R.id.user_profile_sumary);
        user_skill = findViewById(R.id.user_skill_add);

        Emp = findViewById(R.id.user_Emp);
        project = findViewById(R.id.user_project);
        it_skill = findViewById(R.id.user_itSkill);
        education = findViewById(R.id.user_education);
        certificate = findViewById(R.id.user_certificate);
        other_dtails = findViewById(R.id.other_details);
        Language = findViewById(R.id.Language_Known);



        resume_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Resume_hadline.class);
                startActivity(i);
            }
        });



        user_profile_sumarry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Profile_Sumarry.class);
                startActivity(i);
            }
        });




        user_skill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), KeySkills.class);
                startActivity(i);
            }
        });




        project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Project.class);
                startActivity(i);
            }
        });


        it_skill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), It_Skill.class);
                startActivity(i);
            }
        });



        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Education.class);
                startActivity(i);
            }
        });



        certificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Certification.class);
                startActivity(i);
            }
        });




        other_dtails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Other_Details.class);
                startActivity(i);
            }
        });




        Language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Language.class);
                startActivity(i);
            }
        });























        Emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Employment.class);
                startActivity(i);
            }
        });








        User user = SharedPrefManager.getInstance(this).getUser();

        username.setText(user.getName());
        user_profile_name.setText("Android Deveoper");

        userAddress.setText("Noida 63");
        userexperience.setText("0-3 year");
        usermail.setText("pramodkumarp6@gmail.com");
        userphone.setText("9717194480");





    }


    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}