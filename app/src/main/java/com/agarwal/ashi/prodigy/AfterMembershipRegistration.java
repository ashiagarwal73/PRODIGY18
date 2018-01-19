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
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AfterMembershipRegistration extends AppCompatActivity {

    String name,branch,sapId,contact,email,semester,acm;
    Button pay,submit;
    TextView amount;
    EditText transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_membership_registration);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Intent intent=getIntent();
        Bundle bun=intent.getExtras();
        name=bun.getString("name");
        branch=bun.getString("branch");
        semester=bun.getString("sem");
        sapId=bun.getString("sapId");
        contact=bun.getString("contact");
        email=bun.getString("email");
        acm=bun.getString("acm");
        pay=findViewById(R.id.pay);
        amount=findViewById(R.id.amount);
        submit=findViewById(R.id.submit);
        transaction=findViewById(R.id.transaction);
        if(isOnline())
        {
            if(acm.equals("4 years Premium Membership (₹1200/-)"))
            {
                String s=amount.getText().toString();
                amount.setText(s+"₹1200");
            }
            else
            {
                String s=amount.getText().toString();
                amount.setText(s+"₹400");
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
                        Toast.makeText(AfterMembershipRegistration
                                .this, "Enter Transaction Number", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        AlertDialog.Builder ad=new AlertDialog.Builder(AfterMembershipRegistration.this);
                        ad.setTitle("Submit All Details");
                        ad.setMessage("Are you sure you want to submit ?");
                        ad.setNegativeButton(android.R.string.cancel, null);
                        ad.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Sending_data sending_data = new Sending_data(AfterMembershipRegistration.this, "false");
                                        sending_data.execute("http://upesacm.org/ACM_App/MembershipDetails.php?name=" + name + "&branch=" + branch + "&semester=" + semester + "&sapId=" + sapId + "&contact=" + contact + "&email=" + email+"&time="+acm.replaceAll(" ","+")+"&transaction="+transaction.getText().toString());
                                        Intent intent1=new Intent(AfterMembershipRegistration.this,MainActivity.class);
                                        intent1.putExtra("your_condition", "o");
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

    @Override
    public boolean onSupportNavigateUp() {
        this.finish();
        return true;
    }
}

