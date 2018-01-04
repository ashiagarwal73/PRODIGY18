package com.example.ashi.a1myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SwipeFragment2 extends Fragment {
        String name ;
//    String title;
    Context mContext;
    int id;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.swipefragment2,null);
       TextView textView = (TextView)view.findViewById(R.id.department_name);
//        TextView textView1 =(TextView)view.findViewById(R.id.txtTitle);
        ImageView imageView=view.findViewById(R.id.department_image);
          name = getArguments().getString("desc");
//        title = getArguments().getString("desc");
//        textView.setText(name);
//        textView1.setText(title);
        id=getArguments().getInt("img");
        imageView.setImageResource(id);
        textView.setText(name);
        return view;
    }
    //    public static SwipeFragment getName(String name)
//    {
//        Bundle args = new Bundle();
////        args.putString("id",title);
//        args.putString("desc",name);
//        SwipeFragment swipeFragment = new SwipeFragment();
//        swipeFragment.setArguments(args);
//        return swipeFragment;
//    }
    public static SwipeFragment2 getImage(int id,String name) {
        Bundle args = new Bundle();
        args.putInt("img",id);
        args.putString("desc",name);
        SwipeFragment2 swipeFragment = new SwipeFragment2();
        swipeFragment.setArguments(args);
        return swipeFragment;
    }
}
