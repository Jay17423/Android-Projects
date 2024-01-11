package com.maverickallies.lineup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import kotlin.text.UStringsKt;

public class registrationg_page extends AppCompatActivity {
    TextView fullname ,mobilenumber,emailid,password,confirm_password;
    Button register,login;              //DECLARING ALL TEXTVIEW , EDITTEXT , BUTTON

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationg_page);
        fullname =findViewById(R.id.FullName);
        mobilenumber = findViewById(R.id.mobileno); //  LINKING ALL THE TEXTVIEW , EDITTEXT, BUTTON
        emailid = findViewById(R.id.emailid);
        password = findViewById(R.id.RegPassword);
        confirm_password = findViewById(R.id.RegConfPassword);
        register = findViewById(R.id.registerbtn);
        login = findViewById(R.id.Reglognbtn);

        register.setOnClickListener(v -> createAccount());


    }
//    Function to create account in fireBase.
    void createAccount(){
        String email = emailid.getText().toString();
        String pass = password.getText().toString();
        String confPass = confirm_password.getText().toString();
        boolean isValidated = validateData(email,pass,confPass);
        if(!isValidated){
            return;
        }
        createAccountInFirebase(email,pass);

    }
    void createAccountInFirebase(String email,String pass){
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(registrationg_page.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //Created account successfully
                    Toast.makeText(registrationg_page.this, "Successfully created account, check email to verify.", Toast.LENGTH_SHORT).show();
                    firebaseAuth.getCurrentUser().sendEmailVerification();
                    firebaseAuth.signOut();
                    finish();
                    //Failure
                    Toast.makeText(registrationg_page.this,task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

//    Function To validate the data given by the user.
    boolean validateData(String email,String pass,String confPass){
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailid.setError("Email is invalid.");
            return false;
        }
        if(pass.length()<8){
            password.setError("Password length should be greater than 8.");
            return false;
        }
        if(!pass.equals(confPass)){
            confirm_password.setError("Password did not matched");
            return false;
        }
        return true;

    }

}