package com.example.harapekoyuki.uibasic1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        String name = "";
        String mail = "";
        String tel = "";
        String pass = "";
        String sei = "";
        String mobile = "";

        Bundle extras = getIntent(). getExtras();
        if(extras != null){
            name = extras.getString("name", "");
            mail = extras.getString("mail", "");
            tel = extras.getString("tel", "");
            pass = extras.getString("pass", "");
            sei = extras.getString("sei", "");
            mobile = extras.getString("mobile", "");
        }

        TextView tv = (TextView)findViewById(R.id.name);
        tv.setText(name);
        tv = (TextView)findViewById(R.id.mail);
        tv.setText(mail);
        tv = (TextView)findViewById(R.id.tel);
        tv.setText(tel);
        tv = (TextView)findViewById(R.id.pass);
        tv.setText(pass);
        tv = (TextView)findViewById(R.id.sei);
        tv.setText(sei);
        tv = (TextView)findViewById(R.id.mobile);
        tv.setText(mobile);


    }
}
