package com.example.ashi.a1myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class Register extends Fragment {
    private OnFragmentInteractionListener mListener;
    Button submit;View view;
    EditText fullname,branch,sapid,phone,email;
    String[] sem={"Choose your semester","1","2","3","4","5","6","7","8"};
    String[] eve={"Choose the Event","Event1","Event2"};
    String str,str2;
    RadioGroup radioGroup;
    int c;
    int d;
    String acm;
    Spinner semester,events;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_register, container, false);
        // Inflate the layout for this fragment
        if (mListener != null) {
            mListener.onFragmentInteraction("Register");
        }
        fullname=view.findViewById(R.id.name);
        branch=view.findViewById(R.id.branch);
        sapid=view.findViewById(R.id.sapid);
        phone=view.findViewById(R.id.phone);
        email=view.findViewById(R.id.email);
        semester=view.findViewById(R.id.semester);
        events=view.findViewById(R.id.event);
        radioGroup=view.findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton=view.findViewById(checkedId);
                acm=radioButton.getText().toString();
            }
        });
        ArrayAdapter<String> aA = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, sem);
        semester.setAdapter(aA);
        semester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str = adapterView.getItemAtPosition(i).toString();
                c = i;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<String> aa = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, eve);
        events.setAdapter(aa);
        events.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str2 = adapterView.getItemAtPosition(i).toString();
                d= i;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        submit=view.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fullname.getText().toString().equals("")||branch.getText().toString().equals("")||sapid.getText().toString().equals("")||phone.getText().toString().equals("")||email.getText().toString().equals("")||c==0||d==0)
                {
                    Toast.makeText(getContext(), "Please fill the Details Correctly", Toast.LENGTH_LONG).show();
                }
                else
                {
                Intent intent=new Intent(getActivity(),AfterRegistration.class);
                Bundle b=new Bundle();
                b.putString("name",fullname.getText().toString());
                b.putString("branch",branch.getText().toString());
                b.putString("sapid",sapid.getText().toString());
                b.putString("phone",phone.getText().toString());
                b.putString("email",email.getText().toString());
                b.putString("sem",str);
                b.putString("eve",str2);
                b.putString("acm",acm);
                intent.putExtras(b);
                startActivity(intent);
                }
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
