package com.rku.tutorial05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class RegistrationForm extends AppCompatActivity {
    EditText edtFirstname,edtLastname,edtUsername,edtPassword;
    Switch branch;
    Spinner city;
    CheckBox agree;
    Button btnRegister;
    RadioGroup rdb_group;
    RadioButton rdb_select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationform);
        this.setTitle("Registration Form");

        edtFirstname = findViewById(R.id.edtFirstname);
        edtLastname  = findViewById(R.id.edtLastname);
        edtUsername  = findViewById(R.id.edtUsername);
        edtPassword  = findViewById(R.id.edtPassword);
        branch       = findViewById(R.id.branch);
        rdb_group    = findViewById(R.id.rdb_group);
        city         = findViewById(R.id.city);
        agree        = findViewById(R.id.agree);
        btnRegister  = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ValFirstname,ValLastname,ValUsername,ValPassword,Valbranch,ValGender,Valcity,Valagree;

                ValFirstname = edtFirstname.getText().toString();
                ValLastname  = edtLastname.getText().toString();
                ValUsername  = edtUsername.getText().toString();
                ValPassword  = edtPassword.getText().toString();
                Valbranch    = branch.getText().toString();
                int id       = rdb_group.getCheckedRadioButtonId();
                rdb_select   = findViewById(id);
                ValGender    = rdb_select.getText().toString();
                Valcity      = city.getSelectedItem().toString();

                /*------------------- Validation Start ---------------------*/

                if (TextUtils.isEmpty(ValFirstname)) {
                    edtFirstname.setError("Please Enter FirstName");
                    return;
                }

                if (TextUtils.isEmpty(ValLastname)) {
                    edtLastname.setError("Please Enter LastName");
                    return;
                }

                if (TextUtils.isEmpty(ValUsername)) {
                    edtUsername.setError("Please Enter Email Address");
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(ValUsername).matches()){
                    Toast.makeText(RegistrationForm.this,"Email address format is not valid", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(ValPassword)){
                    edtPassword.setError("Password is Required.");
                    return;
                }

                if (ValPassword.length() <6){
                    edtPassword.setError("Password Must be >= 6 Characters");
                    return;
                }

                if(Valcity.equals("Select City"))
                {
                    Toast.makeText(RegistrationForm.this, "Please Select City", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(branch.isChecked()) {
                    Valbranch = "IT";
                }else{
                    Valbranch = "CE";
                }

                if(agree.isChecked()) {
                    Valagree = "Active";
                }else{
                    Valagree = "Inactive";
                }

                /*------------------- Validation End ---------------------*/

                Intent intent=new Intent(RegistrationForm.this,Welcome.class);
                intent.putExtra("first_name",ValFirstname);
                intent.putExtra("last_name",ValLastname);
                intent.putExtra("val_username",ValUsername);
                intent.putExtra("val_password",ValPassword);
                intent.putExtra("val_branch",Valbranch);
                intent.putExtra("val_gender",ValGender);
                intent.putExtra("val_city",Valcity);
                intent.putExtra("val_agree",Valagree);
                startActivity(intent);
            }
        });
    }
}