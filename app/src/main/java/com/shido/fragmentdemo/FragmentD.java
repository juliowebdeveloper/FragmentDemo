package com.shido.fragmentdemo;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;



public class FragmentD extends Fragment {


    public FragmentD() {
        // Required empty public constructor
    }
    
    TextView txtResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_d, container, false);
        txtResult = (TextView) v.findViewById(R.id.txtfragDResult);

        return v;
    }




    //Exibe o Resultado no fragment C
    public void addTwoNumbersFromFragmentC(int a, int b){
        int result = a + b;
        Log.i("RESULT ", String.valueOf(result));
        txtResult.setText(String.valueOf(result));
    }


}
