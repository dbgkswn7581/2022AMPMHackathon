package com.example.dropfood.sign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dropfood.MainActivity;
import com.example.dropfood.R;
import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Login extends AppCompatActivity {

    TextInputEditText textInputEdittextUsername, textInputEditTextPassword;
    Button buttonLogin;
    TextView textViewSignup;
    ProgressBar progressBar;
    CheckBox checkBox;

    public static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = this;

        textInputEdittextUsername = findViewById(R.id.username);
        textInputEditTextPassword = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewSignup = findViewById(R.id.signUpText);
        progressBar = findViewById(R.id.progress);

        textViewSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
                finish();
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username, password;
                username = String.valueOf(textInputEdittextUsername.getText());
                password = String.valueOf(textInputEditTextPassword.getText());

                if(!username.equals("") && !password.equals("")){
                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[2];
                            field[0] = "username";
                            field[1] = "password";
                            String[] data = new String[2];
                            data[0] = username;
                            data[1] = password;
                            PutData putData = new PutData("http://ubuntu-hanwn.p-e.kr/login.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if(result.equals("Login Success")){
                                        PreferenceManager.setString(mContext, "id", username);
                                        PreferenceManager.setString(mContext, "pw", password);

                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                                        String checkId = PreferenceManager.getString(mContext, "id");
                                        String checkPw = PreferenceManager.getString(mContext, "pw");

                                        if(TextUtils.isEmpty(checkId) || TextUtils.isEmpty(checkPw)){
                                            Toast.makeText(Login.this, "아이디/암호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                                        }else{
                                            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                            intent.putExtra("id", checkId);
                                            intent.putExtra("pw", checkPw);
                                            PreferenceManager.setString(mContext, "id", textInputEdittextUsername.getText().toString());
                                            PreferenceManager.setString(mContext, "pw", textInputEditTextPassword.getText().toString());
                                            startActivity(intent);
                                            finish();
                                        }
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(getApplicationContext(), "All fields required", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}