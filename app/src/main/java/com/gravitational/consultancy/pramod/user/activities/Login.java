package com.gravitational.consultancy.pramod.user.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gravitational.consultancy.pramod.user.model.Result;
import com.gravitational.consultancy.pramod.user.model.User;
import com.gravitational.consultancy.pramod.user.model.LoginResponse;
import com.gravitational.consultancy.pramod.user.app.RetrofitClient;
import com.gravitational.consultancy.pramod.user.dash.DashBoard;
import com.gravitational.consultancy.pramod.user.model.SharedPrefManager;
import com.gravitational.consultancy.pramod.user.R;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity implements View.OnClickListener {
    public static SharedPrefManager SharedPrefManager;
    private android.widget.Button userforget;
    private Button  Button;
    private EditText Temail;
    private EditText tpass;
    private Button textViewReg;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);






      /*  if(connection())
        {
            // Toast.makeText(getApplicationContext(),"Internet is Connected",Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(getApplicationContext(), " Internet is  not Avilable", Toast.LENGTH_SHORT).show();
        }*/

        getSupportActionBar().setTitle("LOGIN");
        Button = (Button) findViewById(R.id.buttonLogin);
        userforget = (Button) findViewById(R.id.textViewRegister2);


        Temail = (EditText)findViewById(R.id.editTextemail);
        tpass = (EditText)findViewById(R.id.editTextPassword);
        textViewReg = (Button) findViewById(R.id.textViewRegister1);
        progressDialog = new ProgressDialog(this);

        progressDialog.setMessage("Please wait...");




        textViewReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Registration.class);
                startActivity(i);
            }
        });




        userforget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Reset_password.class);
                startActivity(i);
            }
        });

        Button.setOnClickListener(this);
    }

    public void userlogin()
    {
        final String email = Temail.getText().toString().trim();

        final String password = tpass.getText().toString().trim();

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Temail.setError("Enter a valid email");
            Temail.requestFocus();
            return;
        }



        if (password.isEmpty()) {
            tpass.setError("Password is required");
            tpass.requestFocus();
            return;
        }

        Log.d("username",email);
        Log.d("password",password);
        progressDialog.show();

        Call<Result> call = RetrofitClient.getInstance().getApi().userLogin(email, password);

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
               // progressDialog.dismiss();
                Result loginResponse = response.body();
                progressDialog.dismiss();
                if (!loginResponse.getError()) {

                    finish();

                    SharedPrefManager.getInstance(Login.this).saveUser(loginResponse.getUser());

                    Intent intent = new Intent(Login.this, DashBoard.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    // mCtx.startActivity(new Intent(mCtx, Login.class));
                    startActivity(intent);
                    //finish();

                } else {
                    Toast.makeText(getApplicationContext(), "Invalid email or password", Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                // finish();
            }
        });


    }



    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Login.this,DashBoard.class);

         //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
       startActivity(intent);
        userlogin();

    }



  /*  private boolean connection()
    {
        ConnectivityManager connectivityManager =(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();



        return  activeNetwork != null  && activeNetwork.isConnected();
    }*/
}
