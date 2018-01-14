package com.agarwal.ashi.prodigy;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
    Spinner spinner;
    TextView textView;
    String result2;
    String output1[]=null;
    String output2="Choose the event#111#";
    ProgressBar progressBar;
    //TextView textView;
    public MyAsync2(Context context, ProgressBar progressBar, GridView gridView, Spinner spinner, TextView textView)
    {
        this.context=context;
        if(gridView!=null)
        {
        this.gridView=gridView;}
        if(progressBar!=null)
        {this.progressBar=progressBar;}
        if(spinner!=null)
        {
        this.spinner=spinner;}
        //this.textView=textView;
        if(textView!=null)
        {
            this.textView=textView;
        }
    }
    @Override
    protected void onPreExecute() {
        if(progressBar!=null)
        { progressBar.setProgress(0);}
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
        if(progressBar!=null)
        {progressBar.setProgress(50);}
    }

    @Override
    protected void  onPostExecute(String s) {
        if(progressBar!=null)
        {progressBar.setProgress(100);
        progressBar.setVisibility(View.INVISIBLE);}
        if(gridView!=null) {
            try {
                output1 = s.split("#111#");
                Customadapter2 customAdapter = new Customadapter2(context, output1);
                gridView.setAdapter(customAdapter);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(context, Full_screen_image.class);
                        Bundle b = new Bundle();
                        b.putStringArray("images", output1);
                        b.putInt("position", i);
                        intent.putExtras(b);
                        context.startActivity(intent);
                    }
                });
            } catch (NullPointerException e) {
                Toast.makeText(context, "Slow Internet", Toast.LENGTH_SHORT).show();
            }
        }
        if(spinner!=null) {
            output2=output2.concat(s);
            output1 = output2.split("#111#");
            ArrayAdapter<String> aa = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, output1);
            spinner.setAdapter(aa);
        }
        if(textView!=null)
        {
            String str=textView.getText().toString();
            str=str.concat(s);
            textView.setText(str);
        }
    }
}