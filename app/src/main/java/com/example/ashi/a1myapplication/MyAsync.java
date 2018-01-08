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

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Ashi on 30-08-2017.
 */
public class MyAsync extends AsyncTask<String,Void,String> {
    Context context;
    GridView gridView;
    String result2,result3="";
    String output1[]=null;
    ProgressBar progressBar;
    String string;
    String output2[]=null;
    String output3[]=null;
    //TextView textView;
    public MyAsync(Context context, ProgressBar progressBar, GridView gridView,String string)
    {
        this.context=context;
        this.gridView=gridView;
        this.progressBar=progressBar;
        this.string=string;
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
        String url2=strings[1];
        String url3=strings[2];
        OkHttpClient client = new OkHttpClient();
        Request request1 = new Request.Builder().url(url).build();
        Request request2 = new Request.Builder().url(url2).build();
        Response response1 = null;
        Response response2 = null;

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
        try {
            response2 = client.newCall(request2).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            result2= response2.body().string();

        } catch (IOException e) {
            e.printStackTrace();
        }
       // if(strings.equals("prodigy")){
            Request request3 = new Request.Builder().url(url3).build();
            Response response3 = null;
        try {
            response3 = client.newCall(request3).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            result3= response3.body().string();

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
            output2=result2.split("#111#");
            output3=result3.split("#111#");
            CustomAdapter customAdapter=new CustomAdapter(context,output1,output2,string);
            gridView.setAdapter(customAdapter);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    if(string.equals("gallery")){
                    Intent intent=new Intent(context,Gallery_images.class);
                    intent.putExtra("album",output1[i]);
                    context.startActivity(intent);}
                    if(string.equals("prodigy"))
                    {

                        Intent intent=new Intent(context,Events_Details.class);
                        Bundle b = new Bundle();
                        b.putStringArray("images", output2);
                        b.putStringArray("poster_desc", output3);
                        b.putInt("position", i);
                        intent.putExtras(b);
                        context.startActivity(intent);
                    }
                }
            });
        }catch (NullPointerException e)
        {
            Toast.makeText(context, "Slow Internet", Toast.LENGTH_SHORT).show();
        }

    }
}
