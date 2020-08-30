package com.rku.tutorial05;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {

    TextView fname,lname,username,password,city,gender,sts,branch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        this.setTitle("Register About");

        fname=findViewById(R.id.fname_set);
        lname=findViewById(R.id.lname_set);
        username=findViewById(R.id.username_set);
        password=findViewById(R.id.password_set);
        city=findViewById(R.id.city_set);
        gender=findViewById(R.id.gender_set);
        sts=findViewById(R.id.status);
        branch1=findViewById(R.id.branch1);

        Intent intent=getIntent();
        String firstname_set=intent.getStringExtra("first_name");
        String lastname_set=intent.getStringExtra("last_name");
        String uname_set=intent.getStringExtra("val_username");
        String psw_set=intent.getStringExtra("val_password");
        String cy_set=intent.getStringExtra("val_city");
        String gn_set=intent.getStringExtra("val_gender");
        String sts_set=intent.getStringExtra("val_agree");
       String br_set=intent.getStringExtra("val_branch");

        fname.setText("First Name: "+firstname_set);
        lname.setText("Last Name: "+lastname_set);
        username.setText("Username: "+uname_set);
        password.setText("Password: "+psw_set);
        city.setText("City: "+cy_set);
        gender.setText("Gender: "+gn_set);
        sts.setText("Status: "+sts_set);
        branch1.setText("branch: "+br_set);
    }
}