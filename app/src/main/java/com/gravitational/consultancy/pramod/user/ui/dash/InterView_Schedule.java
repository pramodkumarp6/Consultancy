package com.gravitational.consultancy.pramod.user.ui.dash;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gravitational.consultancy.pramod.user.R;
import com.gravitational.consultancy.pramod.user.ui.adapter.InterviewAdapter;
import com.gravitational.consultancy.pramod.user.data.RetrofitClient;
import com.gravitational.consultancy.pramod.user.data.model.ListItem;
import com.gravitational.consultancy.pramod.user.data.model.SharedPrefManager;
import com.gravitational.consultancy.pramod.user.data.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class InterView_Schedule extends AppCompatActivity {

    private RecyclerView recyclerView;

    // adapter = new MessageAdapter(response.body().getMessages(), getActivity());
    private InterviewAdapter interviewAdapter ;
    private List<ListItem> listItems;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private String TAG;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter_view__schedule);
        getSupportActionBar().setTitle("InterView Schedule");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().getHeight();
        progressDialog = new ProgressDialog(this);



        recyclerView =findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        listItems = new ArrayList<>();


        for (int i = 1; i <= 10; i++) {
            ListItem listitem =new ListItem("Gravitational Tech Pvt Ltd noida","Android Developer","Noida/ NCR delhi","15 May,1983","0-3 years","Posted 10","3Lac","dev kumar","data is import","9717194480");

            listItems.add(listitem);
        }


       interviewAdapter =new InterviewAdapter(listItems,this);
        recyclerView.setAdapter(interviewAdapter);




        // loadRecyclerView();


    }




















         public void loadRecyclerView()
            {
                progressDialog.setMessage("wait...");
                progressDialog.show();
                User user = SharedPrefManager.getInstance(this).getUser();
                Call<ListItem> call = RetrofitClient.getInstance().getApi().document_view(user.getId());


                call.enqueue(new Callback<ListItem>() {
                    @Override
                    public void onResponse(Call<ListItem> call, Response<ListItem> response)

                    {

                        //interviewAdapter =new InterviewAdapter(ListItem,this);
                        recyclerView.setAdapter(interviewAdapter);



                    }

                    @Override
                    public void onFailure(Call<ListItem> call, Throwable t) {

                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

            }

















/*public  void onSwiped(RecyclerView.ViewHolder viewHolder,int direction,int position)
{
    String name = listItems.get(viewHolder.getAdapterPosition()).getCompany();
    ListItem deletedItem =listItems.get(viewHolder.getAdapterPosition());
    int deleteindex = viewHolder.getAdapterPosition();
    interviewAdapter.removeItem(viewHolder.getAdapterPosition());

}*/




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.interviewtips, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        switch (item.getItemId()) {
            case R.id.nav_setting:
                Intent Notification = new Intent(this, InterViewTips.class);
                startActivity(Notification);
                break;
        }

            return super.onOptionsItemSelected(item);
        }
    }








