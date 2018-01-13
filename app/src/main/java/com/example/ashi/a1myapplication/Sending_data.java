package com.example.ashi.a1myapplication;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import java.net.HttpURLConnection;
import java.net.URL;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.net.URL;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
class Sending_data extends AsyncTask<String,TextView,String> {
    Context context;
    //TextView mText;
    String inserted;
    Sending_data(Context context,/*TextView Text,*/String inserted)
    {
        this.context=context;
        //mText=Text;
        this.inserted=inserted;
    }
    @Override
    protected String doInBackground(String...  strings) {
        String final_url=strings[0];
        try {
            URL preurl = new URL(final_url);
            HttpURLConnection con = (HttpURLConnection)preurl.openConnection();
            con.setRequestMethod("GET");
            int response = con.getResponseCode();
            if (response==200)
            {
                inserted="true";
                System.out.println("Data Loaded Successfully");
            }
        }catch (Exception ex)
        {
            Log.i("Exceptiion", ex.toString());
            //mText.setText("Unsuccesful Submission");
            //mText.setTextColor(0xFFEA0F0F);
            Toast.makeText(context, "Unsuccesful Submission Due to internet problem", Toast.LENGTH_SHORT).show();
        }
        return inserted;
    }
    @Override
    protected void onPostExecute(String s) {
        //Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
        if(s.equals("true"))
        {
            Toast.makeText(context, "Data Submitted Successfully", Toast.LENGTH_SHORT).show();
            //mText.setText("Succesful Submission!");
        }
    }
}
