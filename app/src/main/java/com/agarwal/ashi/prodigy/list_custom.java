package com.agarwal.ashi.prodigy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Nakul on 16-01-2018.
 */

public class list_custom extends BaseAdapter {
    LayoutInflater layoutInflater;
    Context context;
    String[] names;
    TextView textView;
  //  String[] images;
  //  ImageView imageView;
    String crop;
    public list_custom(Context context, String[] names)
    {
        this.context=context;
   //     this.images=images;
        this.names=names;
    //    this.crop=crop;
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return names.length;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=layoutInflater.inflate(R.layout.custom_live,null);
        textView=view.findViewById(R.id.text);
        textView.setText(names[i]);
//        imageView=convertview.findViewById(R.id.adapterimage);
//        if(crop.equals("gallery"))
//        {
//            Picasso.with(context)
//                    .load(images[i])
//                    .resize(200,200)
//                    .centerCrop()
//                    .placeholder(R.drawable.galleryicon)
//                    .noFade()
//                    .into(imageView);}
//        else
//        {
//            Picasso.with(context)
//                    .load(images[i])
//                    //.resize(200,200)
//                    //.centerCrop()
//                    .placeholder(R.drawable.galleryicon)
//                    .noFade()
//                    .into(imageView);
//        }
        return view;
    }
}

