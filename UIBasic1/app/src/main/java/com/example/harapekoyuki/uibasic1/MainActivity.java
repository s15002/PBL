package com.example.harapekoyuki.uibasic1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Log.d("MainActivity", "OnClick");

                Intent it = new Intent(MainActivity.this, ConfirmActivity.class);

                EditText editname = (EditText)findViewById(R.id.editname);
                String name = editname.getText().toString();
                Log.d("name", name);
                it.putExtra("name", name);

                EditText editemail = (EditText)findViewById(R.id.editemail);
                String mail = editemail.getText().toString();
                Log.d("email", mail);
                it.putExtra("mail", mail);

                EditText editphone = (EditText)findViewById(R.id.editphone);
                String tel = editphone.getText().toString();
                Log.d("tel", tel);
                it.putExtra("tel", tel);

                EditText editpassword = (EditText)findViewById(R.id.editpassword);
                String pass = editpassword.getText().toString();
                Log.d("pass", pass);
                it.putExtra("pass", pass);

                RadioButton male = (RadioButton)findViewById(R.id.male);
                RadioButton female = (RadioButton)findViewById(R.id.female);
                RadioButton neither = (RadioButton)findViewById(R.id.neither);
                String sei = "";
                if (male.isChecked()){
                    Log.d("seibetu", "male");
                    sei = "男性";
                }else if(female.isChecked()){
                    Log.d("seibetu", "female");
                    sei = "女性";
                }else if(neither.isChecked()){
                    Log.d("seibetu", "neither");
                    sei = "どちらでもない";
                }
                it.putExtra("sei", sei);



                ArrayList<String> mobile = new ArrayList<String>();
                CheckBox iphone = (CheckBox)findViewById(R.id.iphone);
                CheckBox android = (CheckBox)findViewById(R.id.android);
                CheckBox other = (CheckBox)findViewById(R.id.other);

                if(iphone.isChecked()){
                    mobile.add("iphone");
                }
                if(android.isChecked()){
                    mobile.add("android");
                }
                if(other.isChecked()){
                    mobile.add("other");
                }
                Log.d("mobile", mobile.toString());
                it.putExtra("mobile", mobile.toString());

                startActivity(it);
            }
        });
    }
}
