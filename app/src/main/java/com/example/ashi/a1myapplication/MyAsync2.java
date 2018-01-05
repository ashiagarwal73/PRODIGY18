package com.example.ashi.a1myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ashi.a1myapplication.CustomAdapter;
import com.example.ashi.a1myapplication.Customadapter2;
import com.example.ashi.a1myapplication.Full_screen_image;
import com.example.ashi.a1myapplication.Gallery_images;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

/**
 * Created by Ashi on 04-01-2018.
 */

public class MyAsync2 extends AsyncTask<String,Void,String> {
    Context context;
    GridView gridView;
    String result2;
    String output1[]=null;
    ProgressBar progressBar;
    //TextView textView;
    public MyAsync2(Context context, ProgressBar progressBar, GridView gridView)
    {
        this.context=context;
        this.gridView=gridView;
        this.progressBar=progressBar;
        //this.textView=textView;
    }
    @Override
    protected void onPreExecute() {
        progressBar.setProgress(0);
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
    protected void onProgressUpdate(Void... values) {
        progressBar.setProgress(50);
    }

    @Override
    protected void  onPostExecute(String s) {
        progressBar.setProgress(100);
        progressBar.setVisibility(View.INVISIBLE);
        try {
            output1=s.split("#111#");
            Customadapter2 customAdapter=new Customadapter2(context,output1);
            gridView.setAdapter(customAdapter);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(context,Full_screen_image.class);
                Bundle b=new Bundle();
                b.putStringArray("images",output1);
                b.putInt("position",i);
                intent.putExtras(b);
                context.startActivity(intent);
            }
        });

        }catch (NullPointerException e)
        {
            Toast.makeText(context, "Slow Internet", Toast.LENGTH_SHORT).show();
        }

    }
}