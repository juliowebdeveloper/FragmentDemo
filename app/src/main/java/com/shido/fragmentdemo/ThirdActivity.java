package com.shido.fragmentdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity implements MyListener {

    FragmentManager manager;
    Button btnSendDataToFragmentD;

    private int firstNum;
    private int secondNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        manager = getFragmentManager();
        btnSendDataToFragmentD = (Button) findViewById(R.id.btnsendDataToFragmentD);

        addFragmentC();
        addFragmentD();

        btnSendDataToFragmentD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataToFragmentD();
            }
        });

    }

    public void addFragmentC(){
        FragmentC fragmentC = new FragmentC();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.containerForFragmentC, fragmentC, "FragC");
        transaction.commit();

    }


    public void addFragmentD(){
        FragmentD fragmentD = new FragmentD();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.containerForFragmentD, fragmentD, "FragD");
        transaction.commit();

    }


    @Override
    //Recebeu a informação do Fragment C
    public void addTwoNumber(int num1, int num2) {
        firstNum = num1;
        secondNum = num2;
        Log.i("FIRSTNUM", String.valueOf(firstNum));
        Log.i("SecNUM", String.valueOf(secondNum));

        Toast.makeText(this, "informação recebida" , Toast.LENGTH_LONG );

    }



    //Depois de ter recebido a informação, envia para o FragmentD
    public void sendDataToFragmentD(){
        //Passará a informação dessa Activity para o Fragment D
        FragmentD fragmentD = (FragmentD) manager.findFragmentByTag("FragD");
        fragmentD.addTwoNumbersFromFragmentC(firstNum, secondNum);

    }
}
