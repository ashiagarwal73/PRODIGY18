package com.example.ashi.a1myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by shivam on 21/12/17.
 */

public class SwipeFragment extends Fragment {
   String desc ;
//    String title;
    Context mContext;
    String id;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.swipelayout,null);
//        TextView textView = (TextView)view.findViewById(R.id.txtHead);
//        TextView textView1 =(TextView)view.findViewById(R.id.txtTitle);
          ImageView imageView=view.findViewById(R.id.fullimage);
          //TextView lv =getActivity().findViewById(R.id.list);

//        name = getArguments().getString("id");
//        title = getArguments().getString("desc");
//        textView.setText(name);
//        textView1.setText(title);
          id=getArguments().getString("img");
          desc=getArguments().getString("desc");
        //lv.setText(desc);
        Picasso.with(getContext())
                .load(id)
                .placeholder(R.drawable.galleryicon)
                .noFade()
                .into(imageView);
//        PhotoViewAttacher pAttacher;
//        pAttacher = new PhotoViewAttacher(imageView);
//        pAttacher.update();
        //pAttacher.setScale(0);
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
    public static SwipeFragment getImage(String id/*,String desc*/) {
        Bundle args = new Bundle();
        args.putString("img",id);
        //args.putString("desc",desc);
        SwipeFragment swipeFragment = new SwipeFragment();
        swipeFragment.setArguments(args);
        return swipeFragment;
    }
}
