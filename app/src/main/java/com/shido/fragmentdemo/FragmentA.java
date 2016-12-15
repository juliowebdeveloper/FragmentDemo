package com.shido.fragmentdemo;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentA extends Fragment {

    public static final String TAG = "HELLOFRAGMENT_TAG";

    //onAttach é o primeiro metodo a ser executado (Apenas para API 23 em diante)
    //onCreate é o segundo metodo a ser executado
    //onCreateView é o terceiro metodo a ser executado - cria-se a view do fragment
    //onActivityCreated é o quarto metodo
    //onStart é o quinto metodo a ser executado  - O user pode ver o fragment.
    //onResume = FragmentRunning = User interact
    //Se o usuario apertar o back:
    //OnPause
    //OnStop - Fragment fica invisivel
    //OnDestroyView - A hierarquia da view do fragment é destruida.
    //onDestroy - Limpa o Fragment e seus componentes e libera o espaço de memoria.
    //onDetach - Fragment é removido da MainActivity  e chega no fim do ciclo.

    public TextView resultTxt;
    public Button btnMakeSum;

    private int firstNumber = 0;
    private int secondNumber = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "ON CREATEVIEW");

        View v =  inflater.inflate(R.layout.fragment_a, container, false);// Attach to view = false;
        btnMakeSum = (Button) v.findViewById(R.id.btnAddNumbers);
        resultTxt = (TextView)v.findViewById(R.id.resultTxt);

       /* Bundle bundle = getArguments();
        final int firstNumber = bundle.getInt("First_Number",0);
        final int secondNumber = bundle.getInt("Second_Number",0); */


        btnMakeSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTxt.setText(String.valueOf(firstNumber+secondNumber));
            }
        });

        return v;
    }



    @Override
    public void onAttach(Context context) {
        Log.i(TAG, "ON ATTACH");
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "ON CREATE");
        //Iniciar Variaveis e componentes
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i(TAG, "On activity created");

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i(TAG, "ON start");

        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i(TAG, "ON resume");

        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i(TAG, "ON pause");
         //User não mais interage com o Fragment, mas ainda está visivel, ideal salvar o state dele.
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(TAG, "ON stop");

        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, "ON destroy view");

        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "ON destroy");

        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i(TAG, "ON detach");

        super.onDetach();
    }

    public void setData(int firstNumber, int SecondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = SecondNumber;

    }
}
