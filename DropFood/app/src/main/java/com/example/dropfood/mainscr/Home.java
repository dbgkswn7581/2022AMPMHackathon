package com.example.dropfood.mainscr;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.dropfood.R;
import com.example.dropfood.functionpage.Dropmenu;
import com.example.dropfood.functionpage.LocationSetting;
import com.example.dropfood.functionpage.Record;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends Fragment implements View.OnClickListener{

    public Home(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.activity_home, container, false);

        RelativeLayout dropmenu_btn = root.findViewById(R.id.dropmenubtn_layout);
        RelativeLayout mylocation_btn = root.findViewById(R.id.mylocationbtn_layout);
        RelativeLayout ranking_btn = root.findViewById(R.id.rankingbtn_layout);
        RelativeLayout record_btn = root.findViewById(R.id.recordbtn_layout);
        dropmenu_btn.setOnClickListener(this);
        mylocation_btn.setOnClickListener(this);
        ranking_btn.setOnClickListener(this);
        record_btn.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v){
        RelativeLayout b = (RelativeLayout) v;

        Ranking ranking = new Ranking();

        switch (b.getId()) {
            case R.id.dropmenubtn_layout:
                getActivity().startActivity(new Intent(getActivity(), Dropmenu.class));
                break;
            case R.id.mylocationbtn_layout:
                getActivity().startActivity(new Intent(getActivity(), LocationSetting.class));
                break;
            case R.id.rankingbtn_layout:
                ChangeBottomNavigation();
                getParentFragmentManager().beginTransaction().replace(R.id.flFragment, ranking).commit();
                break;
            case R.id.recordbtn_layout:
                getActivity().startActivity(new Intent(getActivity(), Record.class));
                break;
        }
    }

    public void ChangeBottomNavigation() {
        BottomNavigationView bottomNavigation = getActivity().findViewById(R.id.bottomNavigationView);
        bottomNavigation.setSelectedItemId(R.id.ranking);
    }


}