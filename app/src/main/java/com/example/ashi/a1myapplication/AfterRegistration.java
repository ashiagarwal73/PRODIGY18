package com.example.ashi.a1myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AfterRegistration extends AppCompatActivity {
    String fullname,branch,sapid,phone,email,semester,events,acm;
    Button pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_registration);
        Intent intent=getIntent();
        Bundle b=intent.getExtras();
        fullname=b.getString("name");
        branch=b.getString("branch");
        sapid=b.getString("sapid");
        phone=b.getString("phone");
        email=b.getString("email");
        semester=b.getString("sem");
        events=b.getString("eve");
        acm=b.getString("acm");
        pay=findViewById(R.id.pay);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=net.one97.paytm&hl=en"));
                startActivity(i);
            }
        });


    }
}
