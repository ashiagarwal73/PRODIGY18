package com.example.ashi.a1myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Events_Details extends AppCompatActivity {
    private static final String TAG = "DemoActivity";
    ViewPager mViewPager;
    List<Details> mDetails = new ArrayList<>();
    Details[] details=new Details[200];
    private SlidingUpPanelLayout mLayout;
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events__details);
        mViewPager=(ViewPager)findViewById(R.id.poster);
        Intent in=getIntent();
        Bundle b= in.getExtras();
        final String[] images=b.getStringArray("images");
        String[] poster_desc=b.getStringArray("poster_desc");
         pos=b.getInt("position");
        for(int j=pos;j<images.length;j++) {
            details[j] = new Details();
            details[j].setImage(images[j]);
            details[j].setImage_name(poster_desc[j]);
            mDetails.add(details[j]);
        }
        for(int j=0;j<pos;j++) {
            details[j] = new Details();
            details[j].setImage(images[j]);
            details[j].setImage_name(poster_desc[j]);
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
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int x=mViewPager.getCurrentItem();
                String[] y={mDetails.get(x).getImage_name()};
                ListView listView=findViewById(R.id.list);
                ArrayAdapter<String> aa=new ArrayAdapter<String>(Events_Details.this,android.R.layout.simple_list_item_1,y);
                listView.setAdapter(aa);
            }

            @Override
            public void onPageSelected(int position) {
                int x=mViewPager.getCurrentItem();
                String[] y={mDetails.get(x).getImage_name()};
                ListView listView=findViewById(R.id.list);
                ArrayAdapter<String> aa=new ArrayAdapter<String>(Events_Details.this,android.R.layout.simple_list_item_1,y);
                listView.setAdapter(aa);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                int x=mViewPager.getCurrentItem();
                String[] y={mDetails.get(x).getImage_name()};
                ListView listView=findViewById(R.id.list);
                ArrayAdapter<String> aa=new ArrayAdapter<String>(Events_Details.this,android.R.layout.simple_list_item_1,y);
                listView.setAdapter(aa);
            }
        });
        mLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        mLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                Log.i(TAG, "onPanelSlide, offset " + slideOffset);
            }
            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {
                Log.i(TAG, "onPanelStateChanged " + newState);


            }
        });
        mLayout.setFadeOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

            }
        });
        TextView t = (TextView) findViewById(R.id.name);
        t.setText("Slide up to View more Details");
        mLayout.setAnchorPoint(0.5f);
        mLayout.setPanelHeight(70);

    }
}