package com.example.dropfood.functionpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dropfood.R;

public class Dropmenu extends AppCompatActivity {

    AppCompatButton start_btn, return_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dropmenu);

        ImageView random_food_gif = findViewById(R.id.imgGifRandom);
        Glide.with(this).load(R.raw.randomfoodmenu).into(random_food_gif);

        start_btn = findViewById(R.id.start_btn);
        return_btn = findViewById(R.id.return_btn);

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dropmenu.this, QuizCondition.class);
                startActivity(intent);
                finish();
            }
        });

        return_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}