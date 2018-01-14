package com.example.ashi.a1myapplication;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.squareup.okhttp.internal.spdy.FrameReader;

import java.util.logging.Handler;

public class Loader extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);

        new android.os.Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent(Loader.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

    }
}
