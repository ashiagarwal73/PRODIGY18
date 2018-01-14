package com.agarwal.ashi.prodigy;

import android.content.Context;
import android.content.Intent;
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

public class Membership extends Fragment {
    private OnFragmentInteractionListener mListener;
    EditText name,branch,sapId,contact,email;
    Button btn;
    String n, b, se, s, c, e,acm,str;
    String[] sem={"Choose your semester","1","2","3","4","5","6","7","8"};
    RadioGroup radioGroup;
    int v;
    View view;
    Spinner semester;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mListener != null) {
            mListener.onFragmentInteraction("Membership");
        }
        view=inflater.inflate(R.layout.fragment_membership, container, false);
        btn= view.findViewById(R.id.btn);
        name= view.findViewById(R.id.name);
        branch= view.findViewById(R.id.branch);
        semester=view.findViewById(R.id.spinner1);
        sapId= view.findViewById(R.id.sapId);
        contact= view.findViewById(R.id.contact);
        email= view.findViewById(R.id.email);
        radioGroup=view.findViewById(R.id.radio);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton= view.findViewById(i);
                acm=radioButton.getText().toString();
            }
        });
        ArrayAdapter<String> aA = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, sem);
        semester.setAdapter(aA);
        semester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str = adapterView.getItemAtPosition(i).toString();
                v = i;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                se = str;
                n = name.getText().toString().replaceAll(" ","+");
                b = branch.getText().toString().replaceAll(" ","+");
                s=sapId.getText().toString();
                c = contact.getText().toString().replaceAll(" ","+");
                e = email.getText().toString().replaceAll(" ","+");
                if(n.equals("")||b.equals("")||s.equals("")||c.equals("")||e.equals("")||acm.equals("")||v==0) {
                    Toast.makeText(getContext(), "Please fill the Details Correctly", Toast.LENGTH_LONG).show();
                }

                else if(!isEmailValid(e)) {
                    Toast.makeText(getContext(), "Enter valid email", Toast.LENGTH_SHORT).show();
                    email.setText("");
                }
                else if(c.length()!=10)
                {
                    Toast.makeText(getContext(), "Enter Valid phone number without using Country code", Toast.LENGTH_SHORT).show();
                    contact.setText("");
                }
                else if(s.length()!=9&&s.substring(0,3).equals("5000")) {
                    Toast.makeText(getContext(), "Enter valid Sap Id ", Toast.LENGTH_SHORT).show();
                    sapId.setText("");
                }
                else {
                    Intent intent=new Intent(getActivity(),AfterMembershipRegistration.class);
                    Bundle bun=new Bundle();
                    bun.putString("name",n);
                    bun.putString("branch",b);
                    bun.putString("sem",str);
                    bun.putString("sapId",s);
                    bun.putString("contact",c);
                    bun.putString("email",e);
                    bun.putString("acm",acm);
                    intent.putExtras(bun);
                    startActivity(intent);
                }
            }});

        return view;
        //inflater.inflate(R.layout.fragment_membership, container, false);
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
    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                .matches();
    }
}
