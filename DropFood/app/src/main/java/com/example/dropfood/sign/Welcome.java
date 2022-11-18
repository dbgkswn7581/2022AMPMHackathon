package com.example.dropfood.sign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dropfood.MainActivity;
import com.example.dropfood.R;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Welcome extends AppCompatActivity {

    AppCompatButton signup_btn, login_btn;

    public static Activity activity_Welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        activity_Welcome = Welcome.this;

        String saved_id = PreferenceManager.getString(getApplicationContext(), "id");
        String saved_pw = PreferenceManager.getString(getApplicationContext(), "pw");
        String[] field = new String[2];
        field[0] = "username";
        field[1] = "password";
        String[] data = new String[2];
        data[0] = saved_id;
        data[1] = saved_pw;
        PutData putData = new PutData("http://1.250.219.68/login.php", "POST", field, data);

        if(putData.startPut()){
            if(putData.onComplete()){
                String result = putData.getResult();
                if(result.equals("Login Success")){
                    Intent intent = new Intent(Welcome.this, MainActivity.class);
                    startActivity(intent);

                    Welcome welcome = (Welcome)Welcome.activity_Welcome;
                    welcome.finish();
                }
            }
        }

        signup_btn = findViewById(R.id.signup_btn);
        login_btn = findViewById(R.id.login_btn);

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Welcome.this, SignUp.class);
                startActivity(intent);
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Welcome.this, Login.class);
                startActivity(intent);
            }
        });
    }
}