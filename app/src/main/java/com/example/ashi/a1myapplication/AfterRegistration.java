package com.example.ashi.a1myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AfterRegistration extends AppCompatActivity {
    String fullname,branch,sapid,phone,email,semester,events,acm;
    Button pay;
    String event_name;
    TextView amount;
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
        amount=findViewById(R.id.amount);
        if(isOnline())
        {
            event_name=events.replaceAll(" ","%20");
            if(acm.equals("ACM Member"))
            {
                MyAsync2 my=new MyAsync2(AfterRegistration.this,null,null,null,amount);
                my.execute("http://upesacm.org/ACM_App/Event_cost_acm.php?name="+event_name);

            }
            else
            {
                MyAsync2 my=new MyAsync2(AfterRegistration.this,null,null,null,amount);
                my.execute("http://upesacm.org/ACM_App/Event_cost_nacm.php?name="+event_name);

            }
            pay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=net.one97.paytm&hl=en"));
                    startActivity(i);
                }
            });

        }
    }
    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            Toast.makeText(this, "No Internet connection!", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder ad=new AlertDialog.Builder(this);
            ad.setTitle("No Internet!");
            ad.setMessage("Check your Internet connection and restart the app");
            ad.setNegativeButton(android.R.string.cancel, null);
            ad.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    }
            ).create().show();

            return false;
        }
        return true;
    }
}
