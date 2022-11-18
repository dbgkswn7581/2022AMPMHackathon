package com.example.dropfood.functionpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dropfood.R;
import com.example.dropfood.sign.PreferenceManager;
import com.example.dropfood.sign.Survey;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.util.Arrays;

public class ResultFood extends AppCompatActivity {

    AppCompatButton map, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_food);

        map = findViewById(R.id.openmap);
        home = findViewById(R.id.returnhome);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%B2%BC%EB%9D%BD%20%EC%A0%84%EB%B6%81%EB%8C%80%EC%A0%90/place/1889987015?c=14151298.4917977,4279075.3704286,15,0,0,0,dh&isCorrectAnswer=true"));
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}