package com.agarwal.ashi.prodigy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ashi on 04-01-2018.
 */
/**
 * Created by Ashi on 24-11-2017.
 */

public class Customadapter3 extends BaseAdapter {
    LayoutInflater layoutInflater;
    Context context;
    String[] names;
    TextView textView;
    int[] images;
    ImageView imageView;
    public Customadapter3(Context context, String[] names, int[] images)
    {
        this.context=context;
        this.images=images;
        this.names=names;
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
    public View getView(int i, View convertview, ViewGroup viewGroup) {
        convertview=layoutInflater.inflate(R.layout.customadapter3,null);
        textView=convertview.findViewById(R.id.adaptertext);
        textView.setText(names[i]);
        imageView=convertview.findViewById(R.id.adapterimage);
        imageView.setImageResource(images[i]);
        return convertview;
    }
}