package com.example.ashi.a1myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class Gallery extends Fragment {
    private OnFragmentInteractionListener mListener;
    //String[] images={"Prodigy","Idiot Box","Membership","Event 1","Event 2","Event 3","Event 4","Event 5","Event 6","Event 7","Event 8","Event 9","Event 10","Event 11","Event 12","Event 13","Event 14"};
//    String[] albums_name;
//    String[] albums_images;
//    String Albums;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_gallery, container, false);
        if (mListener != null) {
            mListener.onFragmentInteraction("Gallery");
        }
        GridView gridView = view.findViewById(R.id.gridview);
        ProgressBar progressBar = view.findViewById(R.id.progress);
        if (isOnline()) {
            MyAsync my = new MyAsync(getContext(), progressBar, gridView,"gallery");
            my.execute("http://upesacm.org/ACM_App/Album_name.php", "http://upesacm.org/ACM_App/Album_image.php","http://upesacm.org/ACM_App/Album_name.php");
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
        }
            return view;
        }

    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();
        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            Toast.makeText(getContext(), "No Internet connection!", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder ad=new AlertDialog.Builder(getContext());
            ad.setTitle("No Internet!");
            ad.setMessage("Check your Internet connection and restart the app");
            ad.setNegativeButton(android.R.string.cancel, null);
            ad.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                           getActivity().finish();
                        }
                    }
            ).create().show();

            return false;
        }
        return true;
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
