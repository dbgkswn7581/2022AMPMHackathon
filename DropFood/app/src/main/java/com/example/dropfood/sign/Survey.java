package com.example.dropfood.sign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.dropfood.MainActivity;
import com.example.dropfood.R;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.util.Arrays;

public class Survey extends AppCompatActivity {

    Switch beef, pork, chicken, sheep, duck, seafood;
    public static Activity activity_Survey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        activity_Survey = Survey.this;

        String[] field = new String[7];

        field[0] = "username";
        field[1] = "beef";
        field[2] = "pork";
        field[3] = "chicken";
        field[4] = "sheep";
        field[5] = "duck";
        field[6] = "seafood";

        String[] data = new String[7];

        String saved_id = PreferenceManager.getString(getApplicationContext(), "id");
        data[0] = saved_id;
        data[1] = "y";
        data[2] = "y";
        data[3] = "y";
        data[4] = "y";
        data[5] = "y";
        data[6] = "y";

        beef = findViewById(R.id.beefSwitch);
        pork = findViewById(R.id.porkSwitch);
        chicken = findViewById(R.id.chickenSwitch);
        sheep = findViewById(R.id.sheepSwitch);
        duck = findViewById(R.id.duckSwitch);
        seafood = findViewById(R.id.seafoodSwitch);

        beef.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    data[1] = "n";
                }else{
                    data[1] = "y";
                }
            }
        });

        pork.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    data[2] = "n";
                }else{
                    data[2] = "y";
                }
            }
        });

        chicken.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    data[3] = "n";
                }else{
                    data[3] = "y";
                }
            }
        });

        sheep.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    data[4] = "n";
                }else{
                    data[4] = "y";
                }
            }
        });

        duck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    data[5] = "n";
                }else{
                    data[5] = "y";
                }
            }
        });

        seafood.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    data[6] = "n";
                }else{
                    data[6] = "y";
                }
            }
        });

        AppCompatButton setBtn = findViewById(R.id.setBtn);
        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PutData putData = new PutData("http://ubuntu-hanwn.p-e.kr/survey.php", "POST", field, data);

                if(putData.startPut()){
                    if(putData.onComplete()){
                        String result = putData.getResult();
                        if(result.equals("Survey Success")){
                            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(Survey.this, MainActivity.class);
                            startActivity(intent);

                            Survey survey = (Survey)Survey.activity_Survey;
                            survey.finish();
                        }else{
                            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });
    }
}