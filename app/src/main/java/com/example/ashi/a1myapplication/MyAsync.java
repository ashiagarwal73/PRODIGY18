package com.example.ashi.a1myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Ashi on 30-08-2017.
 */
public class MyAsync extends AsyncTask<String,Void,String> {
    Context context;
    //ProgressBar progressBar;
    //TextView textView;
    public MyAsync(Context context/*, ProgressBar progressBar*/)
    {
        this.context=context;
        /*this.progressBar=progressBar;*/
        //this.textView=textView;
    }

    @Override
    protected void onPreExecute() {
//        progressBar.setProgress(0);
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        String result=null;
        String url=strings[0];
        OkHttpClient client = new OkHttpClient();
        Request request1 = new Request.Builder().url(url).build();
        Response response1 = null;
        try {
            response1 = client.newCall(request1).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            result= response1.body().string();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void  onPostExecute(String s) {

        /*progressBar.setVisibility(View.INVISIBLE);*/
        String output1[]=null;
        try {
            output1 = s.split("#123#");
        }catch (NullPointerException e)
        {
            Toast.makeText(context, "Slow Internet", Toast.LENGTH_SHORT).show();
        }

    }
}
