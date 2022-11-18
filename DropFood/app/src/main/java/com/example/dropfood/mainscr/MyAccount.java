package com.example.dropfood.mainscr;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dropfood.R;
import com.example.dropfood.functionpage.Record;
import com.example.dropfood.mainscr.myaccount.AccountSetting;
import com.example.dropfood.mainscr.myaccount.ReAnswer;
import com.example.dropfood.mainscr.myaccount.SetProfileImage;
import com.example.dropfood.mainscr.myaccount.UserCenter;
import com.example.dropfood.sign.Survey;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAccount extends Fragment{
    private Context context;

    public MyAccount(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.activity_my_account, container, false);

        context = container.getContext();

        AppCompatButton copy_btn = root.findViewById(R.id.copy_btn);
        TextView usercode_text = root.findViewById(R.id.textUsercode);
        RelativeLayout account_setting_btn = root.findViewById(R.id.account_setting_btn_layout);
        RelativeLayout usercenter_btn = root.findViewById(R.id.usercenterbtn_layout);
        RelativeLayout record_btn = root.findViewById(R.id.recordbtn_layout);
        RelativeLayout reanswer_btn = root.findViewById(R.id.reanswerbtn_layout);

        copy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("userCode", usercode_text.getText());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(context, "클립보드에 복사되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        account_setting_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AccountSetting.class);
                startActivity(intent);
            }
        });

        usercenter_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UserCenter.class);
                startActivity(intent);
            }
        });

        record_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Record.class);
                startActivity(intent);
            }
        });

        reanswer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(context, ReAnswer.class);
                Intent intent = new Intent(context, Survey.class);
                startActivity(intent);
            }
        });

        CircleImageView userimg = root.findViewById(R.id.imgUserProfile);
        userimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SetProfileImage.class);
                startActivity(intent);
            }
        });



        return root;
    }
}