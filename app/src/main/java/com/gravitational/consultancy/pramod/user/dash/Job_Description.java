package com.gravitational.consultancy.pramod.user.dash;

import android.content.Intent;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gravitational.consultancy.pramod.user.R;
import com.gravitational.consultancy.pramod.user.adapter.DowonloadAdapter;
import com.gravitational.consultancy.pramod.user.adapter.InterviewAdapter;
import com.gravitational.consultancy.pramod.user.model.DownloadItem;
import com.gravitational.consultancy.pramod.user.model.ListItem;
import com.gravitational.consultancy.pramod.user.model.SharedPrefManager;
import com.gravitational.consultancy.pramod.user.model.User;

import java.util.ArrayList;
import java.util.List;


public class Job_Description extends AppCompatActivity implements View.OnClickListener {
    private TextView contract_name1;
    private TextView  jobtitle;
    private TextView company;
    private TextView postdate;
    private TextView contract_mob;
    private TextView  salary;
    private TextView  address;
    private TextView  experience_emplyee;
    private TextView  comment;
    private TextView  description;
    private Button  track_button;
    private DowonloadAdapter dowonloadAdapter;
    private RecyclerView recyclerView;
    private List<DownloadItem> listItems;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job__description);
        getSupportActionBar().setTitle("Job Description");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerView =findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        listItems = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            DownloadItem d =new DownloadItem("Download");

            listItems.add(d);
        }

        dowonloadAdapter =new DowonloadAdapter(listItems,this);
        recyclerView.setAdapter(dowonloadAdapter);





        jobtitle = findViewById(R.id.Job_tile);
        company = findViewById(R.id.company);
        postdate = findViewById(R.id.post_date);
        contract_mob = findViewById(R.id.contract_mobile);
        salary = findViewById(R.id.salary);
        address = findViewById(R.id.address);
        //comment = findViewById(R.id.interview_coment);
        contract_name1 = findViewById(R.id.contract_name);
        experience_emplyee = findViewById(R.id.experience);
        description = findViewById(R.id.post_date);
        track_button = findViewById(R.id.track_b);
        track_button.setOnClickListener(this);

           Intent i = this.getIntent();
           String com = i.getExtras().getString("COMPANY_KEY");
           String job = i.getExtras().getString("JOBTITLE_KEY");
           String Date = i.getExtras().getString("DATE_KEY");
           String add = i.getExtras().getString("ADDRESS_KEY");
           String experience = i.getExtras().getString("EXIPERENCE_KEY");
           String sal = i.getExtras().getString("SALARY_KEY");
           String contract = i.getExtras().getString("CONTRACT_NAME");
           String comment_msg = i.getExtras().getString("COMMENT_KEY");
           String tat = i.getExtras().getString("SALARY_KEY");
           String contr_mob = i.getExtras().getString("C");




          // comment.setText(comment_msg);
           salary.setText(sal);
        contract_mob.setText(contr_mob);
           contract_name1.setText(contract);
           experience_emplyee.setText(experience);
           address.setText(add);
           postdate.setText(Date);
           jobtitle.setText(job);
           company.setText(com);





    }



    public boolean onOptionsItemSelected(MenuItem menuItem)
    {    int id = menuItem.getItemId();

        if(id== android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public void onClick(View v) {

    }



}

