package com.example.harapekoyuki.hello;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity {
    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TAG", "onCreateが実行されました");
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button);
        btn.setText("harapekoyuki");
        mPlayer = MediaPlayer.create(this, R.raw.test);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Button b = (Button) arg0;
                b.setText("Hello,harapekoyuki");
                mPlayer.start();
            }
        });

        Button btn2 = (Button) findViewById(R.id.button2);
        btn2. setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Uri uri = Uri.parse("View v");
                Intent intent = new Intent(MainActivity.this, MyActivity.class);
                intent.putExtra("vx", 10);
                intent.putExtra("vy", 0);
                startActivity(intent);
            }
        });

        Button btn3 = (Button) findViewById(R.id.button3);
        btn3. setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Uri uri = Uri.parse("View v");
                Intent intent = new Intent(MainActivity.this, MyActivity.class);

                RelativeLayout layout = (RelativeLayout)findViewById(R.id.main);
                int mx = layout.getWidth() / 2;
                int my = layout.getHeight() / 2;

                intent.putExtra("mx", mx);
                intent.putExtra("my", my);
                startActivity(intent);
            }
        });

        Button btn4 = (Button) findViewById(R.id.button4);
        btn4. setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Uri uri = Uri.parse("View v");
                Intent intent = new Intent(MainActivity.this, MyActivity.class);
                intent.putExtra("vx", 0);
                intent.putExtra("vy", 10);
                startActivity(intent);
            }
        });
    }
}