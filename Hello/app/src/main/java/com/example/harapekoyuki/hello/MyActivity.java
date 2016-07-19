package com.example.harapekoyuki.hello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by harapekoyuki on 2016/07/13.
 */
public class MyActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView v = new MyView(this);
        Intent intent = getIntent();
        int vx = intent.getIntExtra("vx", 0);
        int vy = intent.getIntExtra("vy", 0);
        int mx = intent.getIntExtra("mx", 1 / 2);
        int my = intent.getIntExtra("my", 1 / 2);
        v.mVX = vx;
        v.mVY = vy;
        v.mX = mx;
        v.mY = my;

        setContentView(v);
    }
}
