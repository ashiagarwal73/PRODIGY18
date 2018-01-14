package com.agarwal.ashi.prodigy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Loader extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loader);
        new android.os.Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent(Loader.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);

    }
}
