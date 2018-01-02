package com.example.ashi.a1myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Ashi on 24-11-2017.
 */

public class Customadapter2 extends BaseAdapter {
    LayoutInflater layoutInflater;
    Context context;
//    String[] names;
//    TextView textView;
      String[] images;
      ImageView imageView;
    public Customadapter2(Context context/*, /*String[] names*/, String[] images)
    {
        this.context=context;
        this.images=images;
        //this.names=names;
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return images.length;
    }
    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {
        convertview=layoutInflater.inflate(R.layout.customadapter2,null);
     //   textView=convertview.findViewById(R.id.adaptertext);
     //   textView.setText(names[i]);
       imageView=convertview.findViewById(R.id.adapterimage2);
        Picasso.with(context)
                .load(images[i])
                .resize(200,200)
                .centerCrop()
                .placeholder(R.drawable.galleryicon)
                .noFade()
                .into(imageView);
      //imageView.setImageResource(images[i]);
        return convertview;
    }
}
