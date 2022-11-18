package com.example.dropfood.mainscr.myaccount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dropfood.R;
import com.example.dropfood.sign.PreferenceManager;
import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.util.Objects;

public class ModifyPassword extends AppCompatActivity {

    TextInputEditText arg1, arg2;
    AppCompatButton update_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_password);

        arg1 = findViewById(R.id.arg1);
        arg2 = findViewById(R.id.arg2);
        update_btn = findViewById(R.id.update_btn);

        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String before = String.valueOf(arg1.getText());
                String after = String.valueOf(arg2.getText());

                String saved_id = PreferenceManager.getString(getApplicationContext(), "id");
                String saved_pw = PreferenceManager.getString(getApplicationContext(), "pw");

                if(saved_pw.equals(before)){
                    String[] field = new String[2];
                    field[0] = "username";
                    field[1] = "modpassword";

                    String[] data = new String[2];
                    data[0] = saved_id;
                    data[1] = after;

                    PutData putData = new PutData("http://ubuntu-hanwn.p-e.kr/modpassword.php", "POST", field, data);

                    if (putData.startPut()) {
                        if (putData.onComplete()) {
                            String result = putData.getResult();
                            if (result.equals("Modify Password Success")) {
                                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
                else{
                    Toast.makeText(
                            getApplicationContext(),
                            "saved_pw : " + saved_pw + " before : " + before,
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
    }
}