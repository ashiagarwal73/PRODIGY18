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

public class Full_department_info extends AppCompatActivity {
    String[] department={"Events","Promotions","App Development","Web Development"};
    int[] images_department={R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};
    ViewPager mViewPager;
    List<Details> mDetails = new ArrayList<>();
    Details[] details=new Details[200];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_department_info);
        Intent intent=getIntent();
        int position=intent.getIntExtra("position",0);

        mViewPager=(ViewPager)findViewById(R.id.viewpager);
        for(int j=position;j<department.length;j++) {
            details[j] = new Details();
            details[j].set_id_Image(images_department[j]);
            details[j].setImage_name(department[j]);
            mDetails.add(details[j]);
        }
        for(int j=0;j<position;j++) {
            details[j] = new Details();
            details[j].set_id_Image(images_department[j]);
            details[j].setImage_name(department[j]);
            mDetails.add(details[j]);
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Details details3= mDetails.get(position);
                return SwipeFragment2.getImage(details3.get_id_Image(),details3.getImage_name());
            }
            @Override
            public int getCount() {
                return mDetails.size();
            }
        });
    }
}
