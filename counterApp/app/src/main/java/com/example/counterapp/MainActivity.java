package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView welcome_text ,counter_text;
    Button btn,btn1,btn2;
    int counter =0;
    int  countet1=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        counter_text = findViewById(R.id.counter_text);
        welcome_text = findViewById(R.id.welcome_text);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);


        //Adding the Function
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter_text.setText(""+increaseCounter());

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter_text.setText(""+refreshCounter());
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter_text.setText(""+decreaseCounter());
            }
        });
    }

    public int increaseCounter(){
        return  ++counter;

    }
    public  int decreaseCounter(){
        return --counter;
    }
    public  int refreshCounter(){
        return countet1;
    }

}