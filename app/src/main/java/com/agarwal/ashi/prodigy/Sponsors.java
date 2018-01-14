package com.agarwal.ashi.prodigy;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ProgressBar;

public class Sponsors extends Fragment {
    private OnFragmentInteractionListener mListener;
    GridView listView;
    ProgressBar progressBar;
    String[] images={"http://upesacm.org/ACM_App/redwolf.png","http://upesacm.org/ACM_App/redwolf.png"};
    String[] names={"RedWolf.in","RedWolf.in"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sponsors, container, false);
        if (mListener != null) {
            mListener.onFragmentInteraction("Sponsors");
        }
        listView=view.findViewById(R.id.listview);
        progressBar=view.findViewById(R.id.progress);
//        CustomAdapter4 customadapter4=new CustomAdapter4(getContext(),names,images);
//        listView.setAdapter(customadapter4);
        MyAsync my = new MyAsync(getContext(), progressBar,listView,"Sponsors");
        my.execute("http://upesacm.org/ACM_App/Sponsor_name.php", "http://upesacm.org/ACM_App/Sponsor_image.php","http://upesacm.org/ACM_App/Album_name.php");
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
