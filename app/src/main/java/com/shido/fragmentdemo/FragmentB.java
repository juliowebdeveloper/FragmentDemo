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
import android.widget.EditText;
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

public class FragmentB extends Fragment {

    public static final String TAG = "HELLOFRAGMENT_TAG";

    EditText edtNumber1;
    EditText edtNumber2;
    Button btnSendData;



    @Override
    public void onAttach(Context context) {
        Log.e(TAG, "ON ATTACH");
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "ON CREATE");
        //Iniciar Variaveis e componentes
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e(TAG, "ON CREATEVIEW");

        View v =  inflater.inflate(R.layout.fragment_b, container, false);// Attach to view = false;

        edtNumber1 = (EditText) v.findViewById(R.id.fragnumber1);
        edtNumber2 = (EditText) v.findViewById(R.id.fragnumber2);
        btnSendData = (Button) v.findViewById(R.id.btnFragSendData);

        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData(view);
            }
        });

        return v;
    }

    public void sendData(View v){
            int firstNum = Integer.valueOf(edtNumber1.getText().toString());
            int secondNum = Integer.valueOf(edtNumber2.getText().toString());
            SecondActivity parentActivity = (SecondActivity) getActivity();
            MyListener myListener = (MyListener)getActivity();//Fazendo uma referencia à interface a pontando para a activity pai
                myListener.addTwoNumber(firstNum, secondNum); //Chamando o metodo e será executada a implementação dele na Activity
        //parentActivity.addTwoNumber(firstNum, secondNum);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.e(TAG, "On activity created");

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.e(TAG, "ON start");

        super.onStart();
    }

    @Override
    public void onResume() {
        Log.e(TAG, "ON resume");

        super.onResume();
    }

    @Override
    public void onPause() {
        Log.e(TAG, "ON pause");
         //User não mais interage com o Fragment, mas ainda está visivel, ideal salvar o state dele.
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.e(TAG, "ON stop");

        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.e(TAG, "ON destroy view");

        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "ON destroy");

        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.e(TAG, "ON detach");

        super.onDetach();
    }
}
