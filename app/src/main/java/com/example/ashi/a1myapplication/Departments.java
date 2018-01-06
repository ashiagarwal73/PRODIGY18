package com.example.ashi.a1myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class Departments extends Fragment {
    private OnFragmentInteractionListener mListener;
    TextView textView;
    String heads;
    String[] department={"Editorial","Design","Public Relations","Sponsorship","Events","Technical","App Development","Web Development","VFX","Corporate Social Responsibility","Membership"};
    int[] department_images={R.drawable.editorial_img,R.drawable.design_img,R.drawable.pr_img,R.drawable.sponsorship_img,R.drawable.events_img,
            R.drawable.technical_img,R.drawable.app_img,R.drawable.web_img,R.drawable.vfx_img,R.drawable.csr_img,R.drawable.member};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (mListener != null) {
            mListener.onFragmentInteraction("Departments");
        }

        View view=inflater.inflate(R.layout.fragment_departments, container, false);
        textView= view.findViewById(R.id.heads);
        MyAsync2 my=new MyAsync2(getContext(),null,null,null,textView);
        my.execute("http://upesacm.org/ACM_App/heads.php");
        ListView listView=view.findViewById(R.id.departments);
        Customadapter3 customadapter3=new Customadapter3(getContext(),department,department_images);
        listView.setAdapter(customadapter3);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getContext(),Full_department_info.class);
                Bundle b=new Bundle();
                b.putInt("position",position);
                heads=textView.getText().toString();
                b.putString("heads",heads);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
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
