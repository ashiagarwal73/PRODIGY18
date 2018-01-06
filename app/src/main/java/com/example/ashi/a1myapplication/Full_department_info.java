package com.example.ashi.a1myapplication;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Full_department_info extends AppCompatActivity {
    String[] department={"The Editorial Team provides expert advice on content and encouraging submissions.It focuses not only on the writing part but also plays a major role in increasing technical awareness through their blogs and articles.They play a major role in identifyimg trending technical topics and making people aware of it through their attractive writing skills.",
            "The Design Team are responsible for choosing and ordering elements like images,colors,symbols and typography,to express  a message to people.Whatever be the event ,it is the design team that provides it an appearance. The team makes posters ,designs videos and a lot such things to make the event more and more productive.",
            "The Public Relations team is mainly concerned about advertisements of the events , gathering sponsors and all that.It is through their public speaking skills along with the talent of convincing people makes all of it go possible .",
            "The Events Team is responsible for managing the entire contributors and is able to make everyone work together. It is they who set goals for all others to fulfill . They are the ones who comes up with new ideas ans the skills of handling those and even making them a success",
            "The Technical Team has a major role to play in enhancing coding skills. The team trains people on how to improvize on their technical skills as well as handles the technical part of an event, be it an app or a web development.",
            "this ia about vfx team"};
    String[] title={"Editorial","Design","Public Relations","Events","Technical","VFX"};
    int[] images_department={R.drawable.editorial_img,R.drawable.design_img,R.drawable.pr_img,R.drawable.ic_launcher_background,R.drawable.technical_img,R.drawable.vfx_img};
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
            details[j].setTitle(title[j]);
            mDetails.add(details[j]);
        }
        for(int j=0;j<position;j++) {
            details[j] = new Details();
            details[j].set_id_Image(images_department[j]);
            details[j].setImage_name(department[j]);
            details[j].setTitle(title[j]);
            mDetails.add(details[j]);
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Details details3 = mDetails.get(position);
                ActionBar actionBar = getSupportActionBar();
                actionBar.setTitle("Departments");
                return SwipeFragment2.getImage(details3.get_id_Image(), details3.getImage_name(),details3.getTitle());
            }
            @Override
            public int getCount() {
                return mDetails.size();
            }


        });
    }
}
