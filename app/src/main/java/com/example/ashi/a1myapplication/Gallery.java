package com.example.ashi.a1myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.concurrent.ExecutionException;

public class Gallery extends Fragment {
    private OnFragmentInteractionListener mListener;
    //String[] images={"Prodigy","Idiot Box","Membership","Event 1","Event 2","Event 3","Event 4","Event 5","Event 6","Event 7","Event 8","Event 9","Event 10","Event 11","Event 12","Event 13","Event 14"};
    String[] albums_name;
    String[] albums_images;
    String Albums;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_gallery, container, false);
        if (mListener != null) {
            mListener.onFragmentInteraction("Gallery");
        }
        GridView gridView=view.findViewById(R.id.gridview);
        MyAsync my = new MyAsync(getContext()/*, progressBar2*/,gridView);
        my.execute("http://upesacm.org/ACM_App/Album_name.php","http://upesacm.org/ACM_App/Album_image.php");
//        MyAsync my2 = new MyAsync(getContext()/*, progressBar2*/,gridView);
//        my2.execute("http://upesacm.org/ACM_App/Album_image.php");
//        try {
//            Albums=my.get();
//            albums_name=Albums.split("#111#");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        try {
//            Albums=my2.get();
//            albums_images=Albums.split("#111#");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//        CustomAdapter customAdapter=new CustomAdapter(getContext(),albums_name,albums_images);
//        gridView.setAdapter(customAdapter);
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent=new Intent(getContext(),Gallery_images.class);
//                intent.putExtra("album",albums_name[i]);
//                startActivity(intent);
//            }
//        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String title);
    }
}
