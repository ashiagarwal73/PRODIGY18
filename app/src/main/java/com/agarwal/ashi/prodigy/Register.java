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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class Register extends Fragment {
    private OnFragmentInteractionListener mListener;
    Button submit;View view;
    EditText fullname,branch,sapid,phone,email;
    String[] sem={"Choose your semester","2","4","6","8"};
    //String[] eve={"Choose the Event","Event1","Event2"};
    ArrayList<String> events=new ArrayList<>();
    String str,str2;
    RadioGroup radioGroup;
    int c;
    int d;
    String acm;
    Spinner semester;
    CheckBox icl,enngage,ctf,frameofreference,glitch,tunningfork,travellingsalesman,braillecode,echo,googleworkshop,intelworkshop;
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
       // events=view.findViewById(R.id.event);
        icl=view.findViewById(R.id.icl);
        enngage=view.findViewById(R.id.enggage);
        ctf=view.findViewById(R.id.ctf);
        frameofreference=view.findViewById(R.id.frameofreference);
        glitch=view.findViewById(R.id.glitch);
        tunningfork=view.findViewById(R.id.tunningfork);
        travellingsalesman=view.findViewById(R.id.travellingsalesman);
        braillecode=view.findViewById(R.id.braillecode);
        echo=view.findViewById(R.id.echo);
        googleworkshop=view.findViewById(R.id.googleworkshop);
        intelworkshop=view.findViewById(R.id.intelworkshop);
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
//        icl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//            if(icl.isChecked())
//            {
//                events.add(icl.getText().toString());
//            }
//            }
//        });
//        enngage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(enngage.isChecked()){
//                events.add(enngage.getText().toString());}
//            }
//        });
//        ctf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(ctf.isChecked()){
//                events.add(ctf.getText().toString());
//            }}
//        });
//        frameofreference.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(frameofreference.isChecked())
//                {
//                    events.add(frameofreference.getText().toString());
//                }
//            }
//        });
//        glitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(glitch.isChecked())
//                {
//                    events.add(glitch.getText().toString());
//                }
//            }
//        });
//        tunningfork.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(tunningfork.isChecked())
//                {
//                    events.add(tunningfork.getText().toString());
//                }
//            }
//        });
//        travellingsalesman.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(travellingsalesman.isChecked()){
//                    events.add(travellingsalesman.getText().toString());
//                }
//            }
//        });
//        braillecode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(braillecode.isChecked()){
//                    events.add(braillecode.getText().toString());
//                }
//            }
//        });
//        echo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(echo.isChecked()){
//                    events.add(echo.getText().toString());
//                }
//            }
//        });
//        googleworkshop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(googleworkshop.isChecked())
//                {
//                    events.add(googleworkshop.getText().toString());
//                }
//            }
//        });
//        intelworkshop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(intelworkshop.isChecked())
//                {
//                    events.add(intelworkshop.getText().toString());
//                }
//            }
//        });
//        MyAsync2 my=new MyAsync2(getContext(),null,null,events,null);
//        my.execute("http://upesacm.org/ACM_App/Event_name.php");
//        int length=listVOs.size();
//        String string[]=new String[length];
//        for (int i=0;i<length;i++)
//        {
//            if(listVOs.get(i).isSelected())
//            {
//                string[i]=listVOs.get(i).getTitle();
//                Toast.makeText(getContext(), string[0], Toast.LENGTH_SHORT).show();
//            }
//        }
        //Toast.makeText(getContext(), string[0], Toast.LENGTH_SHORT).show();
//        events.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                str2 = adapterView.getItemAtPosition(i).toString();
//                d= i;
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
        submit=view.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fullname.getText().toString().equals("")||branch.getText().toString().equals("")||sapid.getText().toString().equals("")||phone.getText().toString().equals("")||email.getText().toString().equals("")||c==0)
                {
                    Toast.makeText(getContext(), "Please fill the Details Correctly", Toast.LENGTH_LONG).show();
                }
                else if(!isEmailValid(email.getText().toString()))
                {
                    Toast.makeText(getContext(), "Enter valid email", Toast.LENGTH_SHORT).show();
                    email.setText("");
                }
                else if(phone.getText().toString().length()!=10)
                {
                    Toast.makeText(getContext(), "Enter Valid phone number without using Country code", Toast.LENGTH_SHORT).show();
                    phone.setText("");
                }
                else if(sapid.getText().toString().length()!=9||sapid.getText().toString().substring(0,3).equals("5000"))
                {
                    Toast.makeText(getContext(), "Enter valid Sap Id ", Toast.LENGTH_SHORT).show();
                    sapid.setText("");
                }
                else
                {
                    int amountacm=0;
                    int amountnacm=0;
                    int B=0;
                    if(icl.isChecked()){
                        events.add(icl.getText().toString());
                        amountacm=amountacm+80;
                        amountnacm=amountnacm+100;
                    }
                    if(enngage.isChecked())
                    {
                        events.add(enngage.getText().toString());
                        amountacm=amountacm+80;
                        amountnacm=amountnacm+100;
                    }
                    if(ctf.isChecked())
                    {
                        events.add(ctf.getText().toString());
                        amountacm=amountacm+80;
                        amountnacm=amountnacm+100;
                    }
                    if(frameofreference.isChecked())
                    {
                        events.add(frameofreference.getText().toString());
                        amountacm=amountacm+80;
                        amountnacm=amountnacm+100;
                    }
                    if(glitch.isChecked())
                    {
                        events.add(glitch.getText().toString());
                        amountacm=amountacm+40;
                        amountnacm=amountnacm+50;
                        B++;
                    }
                    if(tunningfork.isChecked())
                    {
                        events.add(tunningfork.getText().toString());
                        amountacm=amountacm+40;
                        amountnacm=amountnacm+50;B++;
                    }
                    if(braillecode.isChecked())
                    {
                        events.add(braillecode.getText().toString());
                        amountacm=amountacm+40;
                        amountnacm=amountnacm+50;B++;
                    }
                    if(travellingsalesman.isChecked())
                    {
                        events.add(travellingsalesman.getText().toString());
                        amountacm=amountacm+40;
                        amountnacm=amountnacm+50;B++;
                    }
                    if(echo.isChecked())
                    {
                        events.add(echo.getText().toString());
                        amountacm=amountacm+40;
                        amountnacm=amountnacm+50;
                        B++;
                    }
                    if(googleworkshop.isChecked())
                    {
                        events.add(googleworkshop.getText().toString());
                        amountacm=amountacm+100;
                        amountnacm=amountnacm+100;
                    }
                    if(intelworkshop.isChecked())
                    {
                        events.add(intelworkshop.getText().toString());
                        amountacm=amountacm+300;
                        amountnacm=amountnacm+300;
                    }
                    if(B>=3)
                    {
                        amountnacm=amountnacm-B*10;
                        amountacm=amountacm-B*10+10;
                    }
                Intent intent=new Intent(getActivity(),AfterRegistration.class);
                Bundle b=new Bundle();
                b.putString("name",fullname.getText().toString());
                b.putString("branch",branch.getText().toString());
                b.putString("sapid",sapid.getText().toString());
                b.putString("phone",phone.getText().toString());
                b.putString("email",email.getText().toString());
                b.putString("sem",str);
                //b.putString("eve",str2);
                b.putString("acm",acm);
                    String listString = "";

                    for (String s : events)
                    {
                        listString += s + ",";
                    }
                b.putString("eve",listString);
                b.putInt("counter",events.size());

                //b.putStringArrayList("events",events);
                b.putString("amounta",String.valueOf(amountacm));
                b.putString("amountn",String.valueOf(amountnacm));
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
    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                .matches();}
}
