package com.agarwal.ashi.prodigy;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class LiveUpdates extends Fragment {
    private OnFragmentInteractionListener mListener;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view=inflater.inflate(R.layout.fragment_live_updates,container,false);
        if (mListener != null) {
            mListener.onFragmentInteraction("Live Updates");
        }
        ImageView imageView=view.findViewById(R.id.imageView5);
        ListView list=view.findViewById(R.id.list);
        if(isOnline()){
            live_async my=new live_async(getContext(),list,"updates");
            my.execute("http://upesacm.org/ACM_App/live.php");
        }
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String title);
    }
}
