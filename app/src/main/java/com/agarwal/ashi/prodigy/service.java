package com.agarwal.ashi.prodigy;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Nakul on 16-01-2018.
 */

public class service extends Service {

    @Nullable

    Runnable runnable;
    Handler handler;
    String body;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent , int flags , int startID)
    {
        handler=new Handler();
        runnable= new Runnable() {
            @Override
            public void run() {
                get_number url=new get_number(getApplicationContext());
                url.execute("http://upesacm.org/ACM_App/number.php","http://upesacm.org/ACM_App/content.php");
                // Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT);
                handler.postDelayed(this,1000);
            }
        };
        handler.postDelayed(runnable,1000);
        return START_STICKY;

    }

}