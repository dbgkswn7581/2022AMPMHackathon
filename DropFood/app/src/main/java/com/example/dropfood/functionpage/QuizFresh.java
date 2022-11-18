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

public class QuizFresh extends AppCompatActivity {

    Switch k;
    AppCompatButton nextbtn;
    public String[] data;

    public static Context context_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_fresh);

        context_main = this;

        data = new String[1];

        k = findViewById(R.id.freshSwitch);


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

        nextbtn = findViewById(R.id.setBtn);
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizFresh.this, ResultFood.class);
                startActivity(intent);

                finish();
            }
        });


    }
}