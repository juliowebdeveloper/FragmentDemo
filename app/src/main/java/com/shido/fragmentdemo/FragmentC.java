package com.shido.fragmentdemo;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FragmentC extends Fragment {

    EditText edtNumber1;
    EditText edtNumber2;
    Button btnSendData;

    public FragmentC() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_fragment_c, container, false);
        edtNumber1 = (EditText) v.findViewById(R.id.fragCnumber1);
        edtNumber2 = (EditText) v.findViewById(R.id.fragCnumber2);
        btnSendData = (Button) v.findViewById(R.id.btnFragCSendDataToParentActivity);

        //Primeiro envia a informação pra activity Pai
        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataToParentActivity();
            }
        });

        return v;
    }

    public void sendDataToParentActivity(){
        int firstNum = Integer.valueOf(edtNumber1.getText().toString());
        int secondNum = Integer.valueOf(edtNumber2.getText().toString());
        MyListener listener = (MyListener) getActivity();
        listener.addTwoNumber(firstNum, secondNum);
    }

}
