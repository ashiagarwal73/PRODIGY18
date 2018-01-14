package com.example.ashi.a1myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ProgressBar;

public class Prodigy extends Fragment {


    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (mListener != null) {
            mListener.onFragmentInteraction("Prodigy 18");
        }
        View view1=inflater.inflate(R.layout.fragment_prodigy, container, false);
        GridView gridView = view1.findViewById(R.id.gridview);
        ProgressBar progressBar = view1.findViewById(R.id.progress);
            MyAsync my = new MyAsync(getContext(), progressBar, gridView,"prodigy");
            my.execute("http://upesacm.org/ACM_App/Event_name.php", "http://upesacm.org/ACM_App/poster.php","http://upesacm.org/ACM_App/Event_desc.php");
            return view1;
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
