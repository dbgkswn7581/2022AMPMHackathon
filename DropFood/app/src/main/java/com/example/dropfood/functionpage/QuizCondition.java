package com.example.dropfood.functionpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.dropfood.R;
import com.example.dropfood.sign.PreferenceManager;

import java.util.Arrays;

public class QuizCondition extends AppCompatActivity {

    Switch k, f, c, j, b;
    AppCompatButton nextbtn;

    public static Context context_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_condition);

        context_main = this;

        String[] data = new String[5];

        k = findViewById(R.id.koreanSwitch);
        f = findViewById(R.id.foreignSwitch);
        c = findViewById(R.id.chinaSwitch);
        j = findViewById(R.id.japanSwitch);
        b = findViewById(R.id.fastSwitch);

        k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    data[0] = "y";
                }else{
                    data[0] = "n";
                }
            }
        });

        f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    data[1] = "y";
                }else{
                    data[1] = "n";
                }
            }
        });

        c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    data[2] = "y";
                }else{
                    data[2] = "n";
                }
            }
        });

        j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    data[3] = "y";
                }else{
                    data[3] = "n";
                }
            }
        });

        b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    data[4] = "y";
                }else{
                    data[4] = "n";
                }
            }
        });

        nextbtn = findViewById(R.id.setBtn);
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizCondition.this, QuizPreference.class);
                startActivity(intent);

                finish();
            }
        });


    }
}