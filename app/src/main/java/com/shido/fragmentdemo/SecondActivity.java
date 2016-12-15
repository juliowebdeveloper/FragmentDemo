package com.shido.fragmentdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements MyListener {


        TextView txtResult;
        FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txtResult = (TextView) findViewById(R.id.resultTxtActivity);
        fragmentManager = getFragmentManager();
        addFragmentB();
    }

    public void addFragmentB(){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.containerSecond, new FragmentB(), "FragB" );
        fragmentTransaction.commit();

    }


    //Metodo da Interface que foi implementada
    @Override
    public void addTwoNumber(int num1, int num2) {
        txtResult.setText(String.valueOf(num1 +num2));
    }
}
