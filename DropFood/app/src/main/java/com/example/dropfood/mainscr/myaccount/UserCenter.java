package com.example.dropfood.mainscr.myaccount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dropfood.R;

public class UserCenter extends AppCompatActivity {

    AppCompatButton sendemail_btn, backscreen_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_center);

        sendemail_btn = findViewById(R.id.sendemail_btn);
        backscreen_btn = findViewById(R.id.backscreen_btn);

        sendemail_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "sendEmail", Toast.LENGTH_SHORT).show();
            }
        });

        backscreen_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}