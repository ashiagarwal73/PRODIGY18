package com.example.ashi.a1myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Gallery_images extends AppCompatActivity {
    String image;
    String[] images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_images);
        Intent intent=getIntent();
        String album_name=intent.getStringExtra("album");
        album_name=album_name.replaceAll(" ","%20");
        GridView gridView=findViewById(R.id.gridview1);
        ProgressBar progressBar=findViewById(R.id.progress);
        if(isOnline()){
        MyAsync2 my = new MyAsync2(Gallery_images.this, progressBar,gridView);
        my.execute("http://upesacm.org/ACM_App/images.php?name="+album_name);
////        try {
////            image=my.get();
////            images=image.split("#111#");
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        } catch (ExecutionException e) {
////            e.printStackTrace();
////        }
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle(album_name);
//        GridView gridView=findViewById(R.id.gridview1);
//        Customadapter2 customadapter2=new Customadapter2(getBaseContext(),images);
//        gridView.setAdapter(customadapter2);
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent=new Intent(Gallery_images.this,Full_screen_image.class);
//                Bundle b=new Bundle();
//                b.putStringArray("images",images);
//                b.putInt("position",i);
//                intent.putExtras(b);
//                startActivity(intent);
//            }
//        });
    }}
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
