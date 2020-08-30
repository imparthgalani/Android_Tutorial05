package com.rku.tutorial05;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {


    private EditText edtUsername,edtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = (EditText)findViewById(R.id.edtUsername);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        btnLogin    = (Button)findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ValUsername = edtUsername.getText().toString();
                String ValPassword = edtPassword.getText().toString();
                Log.i("Login Screen","In Onclick");

                /*------------------- Validation Start ---------------------*/

                if (!Patterns.EMAIL_ADDRESS.matcher(ValUsername).matches()){
                    Toast.makeText(Login.this,"Email address format is not valid", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (ValUsername.equals("admin@gmail.com") && ValPassword.equals("123456")) {
                    Log.i("Login Screen", "in onClick if");

                /*------------------- Validation End ---------------------*/

                    Intent intent = new Intent(Login.this,Welcome.class);
                    intent.putExtra("userdata",ValUsername);
                    startActivity(intent);
                    finish();

                    Toast.makeText(Login.this,"Login Successfully", Toast.LENGTH_SHORT).show();
                }else {

                    Toast.makeText(Login.this,"Username or Password is wrong.", Toast.LENGTH_SHORT).show();
                    Log.i("Login Screen","In Onclick");
                }
            }
        });
    }
}