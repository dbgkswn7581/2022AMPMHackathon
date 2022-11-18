package com.example.dropfood.mainscr.myaccount;

import android.app.Activity;
import android.content.Intent;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.dropfood.MainActivity;
import com.example.dropfood.R;
import com.example.dropfood.sign.PreferenceManager;
import com.example.dropfood.sign.Welcome;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class AccountSetting extends PreferenceActivity {

    Preference logoutPreference;
    Preference delaccountPreference;

    EditTextPreference mModifyFullname;
    Preference mModifyPassword;

    public static Activity activity_AccountSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        activity_AccountSetting = AccountSetting.this;


        delaccountPreference = findPreference("delete_account");

        logoutPreference = (Preference) findPreference("logout");
        logoutPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                PreferenceManager.clear(getApplicationContext());
                Toast.makeText(getApplicationContext(), "로그아웃되었습니다.", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(AccountSetting.this, Welcome.class);
                MainActivity mainActivity = (MainActivity)MainActivity.activity_MainActivity;
                AccountSetting accountSetting = (AccountSetting)AccountSetting.activity_AccountSetting;

                startActivity(intent);
                mainActivity.finish();
                accountSetting.finish();

                return true;
            }
        });


        mModifyFullname = (EditTextPreference) findPreference("modify_fullname");

        mModifyFullname.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                String value = o.toString();

                String saved_id = PreferenceManager.getString(getApplicationContext(), "id");

                String[] field = new String[2];
                field[0] = "username";
                field[1] = "modfullname";
                String[] data = new String[2];
                data[0] = saved_id;
                data[1] = value;

                PutData putData = new PutData("http://ubuntu-hanwn.p-e.kr/modfullname.php", "POST", field, data);

                if (putData.startPut()) {
                    if (putData.onComplete()) {
                        String result = putData.getResult();
                        if (result.equals("Modify Fullname Success")) {
                            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                return false;
            }
        });

        mModifyPassword = (Preference) findPreference("modify_password");
        mModifyPassword.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                PreferenceManager.clear(getApplicationContext());
//                Toast.makeText(getApplicationContext(), "로그아웃되었습니다.", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(AccountSetting.this, ModifyPassword.class);
                startActivity(intent);

                return true;
            }
        });
    }
}