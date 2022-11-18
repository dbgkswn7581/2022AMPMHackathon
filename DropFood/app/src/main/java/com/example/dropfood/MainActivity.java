package com.example.dropfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.dropfood.mainscr.Commnuity;
import com.example.dropfood.mainscr.Home;
import com.example.dropfood.mainscr.MyAccount;
import com.example.dropfood.mainscr.Ranking;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomNavigationView;

    public static Activity activity_MainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.person);

        activity_MainActivity = MainActivity.this;
    }

    Home home = new Home();
    Commnuity commnuity = new Commnuity();
    Ranking ranking = new Ranking();
    MyAccount myaccount = new MyAccount();


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.person:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, home).commit();
                return true;
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, commnuity).commit();
                return true;
            case R.id.ranking:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, ranking).commit();
                return true;
            case R.id.settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, myaccount).commit();
                return true;
        }
        return false;
    }

}