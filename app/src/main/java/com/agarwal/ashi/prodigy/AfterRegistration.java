package com.agarwal.ashi.prodigy;

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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AfterRegistration extends AppCompatActivity {
    String fullname,branch,sapid,phone,email,semester,events,acm;
    Button pay,submit;
    String event_name;
    TextView amount;
    int sum=0;
    int counter;
    ArrayList<String> arrayofevents=new ArrayList<>();
    EditText transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_registration);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent=getIntent();
        Bundle b=intent.getExtras();
        fullname=b.getString("name");
        branch=b.getString("branch");
        sapid=b.getString("sapid");
        phone=b.getString("phone");
        email=b.getString("email");
        semester=b.getString("sem");
        events=b.getString("eve");
        String amountacm=b.getString("amounta");
        String amountnacm=b.getString("amountn");
        acm=b.getString("acm");
        pay=findViewById(R.id.pay);
        amount=findViewById(R.id.amount);
        submit=findViewById(R.id.submit);
        transaction=findViewById(R.id.transaction);
        if(isOnline())
        {
            event_name=events.replaceAll(" ","%20");
            if(acm.equals("ACM Member"))
            {
                amount.setText(amountacm);
            }
            else
            {
                amount.setText(amountnacm);
//                MyAsync2 my=new MyAsync2(AfterRegistration.this,null,null,null,amount);
//                my.execute("http://upesacm.org/ACM_App/Event_cost_nacm.php?name="+event_name);

            }
            pay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=net.one97.paytm&hl=en"));
                    startActivity(i);
                }
            });
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(transaction.getText().toString().equals(""))
                    {
                        Toast.makeText(AfterRegistration.this, "Enter Transaction Number", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        AlertDialog.Builder ad=new AlertDialog.Builder(AfterRegistration.this);
                        ad.setTitle("Submit All Details");
                        ad.setMessage("Are you sure you want to submit ?");
                        ad.setNegativeButton(android.R.string.cancel, null);
                        ad.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        //Toast.makeText(AfterRegistration.this, "All Details Submitted Successfully", Toast.LENGTH_LONG).show();
                                        Sending_data sending_data=new Sending_data(AfterRegistration.this,"false");
                                        String url="http://upesacm.org/ACM_App/Register_details.php?name="+fullname+"&branch="+branch+"&sapid="+sapid+"&phone="+phone+"&email="+email+"&semester="+semester+"&event="+events+"&acm="+acm+"&transaction="+transaction.getText().toString();
                                        sending_data.execute(url.replaceAll(" ","+"));
                                        Intent intent1=new Intent(AfterRegistration.this,MainActivity.class);
                                        startActivity(intent1);
                                    }
                                }
                        ).create().show();
                    }
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
    public boolean onSupportNavigateUp() {
        this.finish();
        return true;
    }
}