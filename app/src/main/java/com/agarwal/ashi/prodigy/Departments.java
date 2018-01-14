package com.agarwal.ashi.prodigy;

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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Departments extends Fragment {
    private OnFragmentInteractionListener mListener;
    TextView textView;
    String heads;
    String[] department = {"Editorial", "Design", "Public Relations", "Sponsorship", "Events", "Technical", "App Development", "Web Development", "VFX", "Corporate Social Responsibility", "Membership"};
    int[] department_images = {R.drawable.editorial_img, R.drawable.design_img, R.drawable.pr_img, R.drawable.sponsorship_img, R.drawable.events_img,
            R.drawable.technical_img, R.drawable.app_img, R.drawable.web_img, R.drawable.vfx_img, R.drawable.csr_img, R.drawable.member};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (mListener != null) {
            mListener.onFragmentInteraction("Departments");
        }

        View view = inflater.inflate(R.layout.fragment_departments, container, false);
        if (isOnline()) {
            textView = view.findViewById(R.id.heads);
            MyAsync2 my = new MyAsync2(getContext(), null, null, null, textView);
            my.execute("http://upesacm.org/ACM_App/heads.php");
            ListView listView = view.findViewById(R.id.departments);
            Customadapter3 customadapter3 = new Customadapter3(getContext(), department, department_images);
            listView.setAdapter(customadapter3);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getContext(), Full_department_info.class);
                    Bundle b = new Bundle();
                    b.putInt("position", position);
                    heads = textView.getText().toString();
                    b.putString("heads", heads);
                    intent.putExtras(b);
                    startActivity(intent);
                }
            });

        }return view;
    }
    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if (netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()) {
            Toast.makeText(getContext(), "No Internet connection!", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder ad = new AlertDialog.Builder(getContext());
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

