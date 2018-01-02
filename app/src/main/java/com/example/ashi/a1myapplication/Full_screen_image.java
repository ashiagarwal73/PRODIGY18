package com.example.ashi.a1myapplication;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Full_screen_image extends AppCompatActivity {
    ViewPager mViewPager;
    List<Details> mDetails = new ArrayList<>();
    Details[] details=new Details[200];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_image);mViewPager=(ViewPager)findViewById(R.id.viewpager);
        Intent in=getIntent();
        Bundle b= in.getExtras();
        String[] images=b.getStringArray("images");
        int pos=b.getInt("position");
        for(int j=pos;j<images.length;j++) {
            details[j] = new Details();
            details[j].setImage(images[j]);
            mDetails.add(details[j]);
        }
        for(int j=0;j<pos;j++) {
            details[j] = new Details();
            details[j].setImage(images[j]);
            mDetails.add(details[j]);
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Details details3= mDetails.get(position);
                return SwipeFragment.getImage(details3.getImage());
            }
            @Override
            public int getCount() {
                return mDetails.size();
            }
        });

    }
}
