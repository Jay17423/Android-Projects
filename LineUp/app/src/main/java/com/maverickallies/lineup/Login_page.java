package com.maverickallies.lineup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login_page extends AppCompatActivity {
    TextView welcom,newuser;
    EditText username , password;      //DECLARING ALL TEXTVIEW , EDITTEXT , BUTTON
    Button loginbtn;

    @SuppressLint("MissingInflateId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        welcom = findViewById(R.id.welcome);
        newuser = findViewById(R.id.newUser);
        username = findViewById(R.id.username);    //  LINKING ALL THE TEXTVIEW , EDITTEXT, BUTTON
        password = findViewById(R.id.password);
        loginbtn = findViewById(R.id.loginbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);              //CREATED SET ON CLICK LISTNER ON LOGINBTN
                finish();
            }
        });

        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), registrationg_page.class);
                startActivity(intent);                //CREATED SET ON CLICK LISTNER ON NEW USER ? SIGN UP.
                finish();
            }
        });

    }

}