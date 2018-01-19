package com.agarwal.ashi.prodigy;

import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Nakul on 16-01-2018.
 */

public class get_number extends AsyncTask<String,Void,String> {
    Context context;
    TextView textView;
    private static int uniqueId=40111;
    String result2="";
    String output1[]=null;
    String string;
    String output2[]=null;
    String output3[]=null;
   // String url1="http://upesacm.org/ACM_App/number.php";

    public get_number(Context context){
        this.context=context;
    }

    @Override
    protected String doInBackground(String... strings) {
        String result=null;
        String url=strings[0];
        String url2=strings[1];

        OkHttpClient client=new OkHttpClient();
        Request request1=new Request.Builder().url(url).build();
        Request request2=new Request.Builder().url(url2).build();

        Response response1=null;
        Response response2=null;
        try{
            response1=client.newCall(request1).execute();
            response2=client.newCall(request2).execute();
        }catch (IOException e){
            e.printStackTrace();
        }

        try{
            if(response1!=null) {
                result = response1.body().string();
            if(response2!=null)
                result2= response2.body().string();
            } }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }
    @Override
    protected void onPostExecute(String s){
        try{
            output1=s.split("#111#");
            output2=result2.split("#111#");
            Uri soundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            SharedPreferences preferences=context.getSharedPreferences("counters",context.MODE_PRIVATE);
            int foo=Integer.parseInt(output1[0]);
            int counter=preferences.getInt("counter",foo);
            if(counter<=foo)
            {
                NotificationCompat.Builder notification;
                //  private static final int unique=40111;
                CharSequence a;
                notification=new NotificationCompat.Builder(context);
                notification.setAutoCancel(true);
                notification.setSmallIcon(R.drawable.technical_img);
                notification.setTicker(output2[counter-1]);
                notification.setWhen(System.currentTimeMillis());
                notification.setContentText("text");
                notification.setContentTitle("Title");
                notification.setSound(soundUri);
                NotificationManager nm;
                nm = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
                nm.notify(uniqueId,notification.build());
                preferences.edit().putInt("counter",counter+1).apply();
            }
            //Toast.makeText(context,output1[0]+"",Toast.LENGTH_LONG).show();}
        }catch(NullPointerException e)
        {

        }
    }
}


