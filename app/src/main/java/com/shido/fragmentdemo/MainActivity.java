package com.shido.fragmentdemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MAINACTIVITY_TAG";
    FragmentManager manager;

    public Button btnAddFragA;
    public Button btnRemoveFragA;
    public Button btnAddFragB;
    public Button btnRemoveFragB;
    public Button btnReplaceA;
    public Button btnReplaceB;
    public Button btnAttachA;
    public Button btnAttachB;
    public Button btnDetachA;
    public Button btnDetachB;
    public Button btnSendData;
    public EditText number1;
    public EditText number2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* btnAddFragA = (Button) findViewById(R.id.btnAddFragA);
         btnRemoveFragA = (Button) findViewById(R.id.btnremoveFragA);
       btnAddFragB = (Button) findViewById(R.id.btnAddFragB);
        btnRemoveFragB= (Button) findViewById(R.id.btnRemoveFragB);
        btnReplaceA = (Button) findViewById(R.id.btnReplaceA);
        btnReplaceB= (Button) findViewById(R.id.btnReplaceB);
        btnAttachA = (Button) findViewById(R.id.btnAttachA);
        btnDetachA = (Button) findViewById(R.id.btnDetachA);
        btnAttachB = (Button) findViewById(R.id.btnAttachB);
        btnDetachB = (Button) findViewById(R.id.btnDetachB);*/
        btnSendData = (Button) findViewById(R.id.btnSendData);
        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);
        manager = getFragmentManager();

        /*Ordem dos Metodos de execução da activity com o fragment:
        * 1)Activity onCreate()
        * 2)Fragment onAttach() - Api 23 em diante
        * 3)Activity onAttachFragment()
        * 4)Fragment onCreate()
        * 5)Fragment onCreateView()
        * 6)Fragment onActivityCreated()
        * 7)Activity onStart()
        * 8)Fragment onStart()
        * 9)Activity onResume()
        * 10)Fragment onResume()
        *
        * ************Quando o user aperta o Back***********************
        * 1)Fragment onPause()
        * 2)Activity onPause()
        * 3)Fragment onStop()
        * 4)Activity onStop()
        * 5)Fragment onDestroyView()
        * 6)Fragment onDestroy()
        * 7)Fragment onDetach()
        * 8)Activity onDestroy()
        * */



        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataToFragmentA(btnSendData);
            }
        });






    }

    public void setupFragmentTransactionButtons(){
     /*
        //Há sempre apenas uma instancia do FragmentManager por activity
        FragmentA helloFragment = new FragmentA();
        FragmentManager manager  = getFragmentManager();
        //API para fazer transações com fragment
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container,helloFragment, "FragmentA");
        //Onde será colocado o Fragment, Qual o Fragment, Tag opcional;
        transaction.commit();
            */


        btnAddFragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.container, new FragmentA(), "FragA");
                transaction.commit();
            }
        });

        btnAddFragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.container, new FragmentB(), "FragB");
                transaction.commit();
            }
        });

        btnRemoveFragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Utilizando a tag para pegar a referencia do Fragment.
                FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("FragB");
                FragmentTransaction transaction = manager.beginTransaction();
                if(fragmentA !=null) {
                    transaction.remove(fragmentA);
                    transaction.commit();
                }else{
                    Toast.makeText(MainActivity.this, "Fragment A Not Found", Toast.LENGTH_SHORT);
                }
            }
        });

        btnRemoveFragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Utilizando a tag para pegar a referencia do Fragment.
                FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("FragA");
                FragmentTransaction transaction = manager.beginTransaction();
                if(fragmentB !=null) {
                    transaction.remove(fragmentB);
                    transaction.commit();
                }else{
                    Toast.makeText(MainActivity.this, "Fragment B  Not Found", Toast.LENGTH_SHORT);
                }
            }
        });

        btnReplaceA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentA fragmentA = new FragmentA();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.container, fragmentA, "FragA");
                transaction.commit();
            }
        });

        btnReplaceB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentB fragmentB = new FragmentB();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.container, fragmentB, "FragB");
                transaction.commit();
            }
        });


        btnAttachA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentA fragmentA=(FragmentA) manager.findFragmentByTag("FragA");
                FragmentTransaction transaction = manager.beginTransaction();

                if(fragmentA != null) {

                    //Remove a visibilidade do Fragment para o user
                    transaction.attach(fragmentA);
                    transaction.commit();

                }
            }
        });
        btnAttachB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentB fragmentB=(FragmentB) manager.findFragmentByTag("FragB");
                FragmentTransaction transaction = manager.beginTransaction();
                if(fragmentB !=null) {
                    transaction.attach(fragmentB);
                    transaction.commit();
                }
            }
        });
        btnDetachA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentA fragmentA=(FragmentA) manager.findFragmentByTag("FragA");
                FragmentTransaction transaction = manager.beginTransaction();
                if(fragmentA != null) {
                    //Remove a visibilidade do Fragment para o user porém a view do fragment é destruida
                    //Attach retorna essa view e a visibilidade
                    transaction.detach(fragmentA);
                    transaction.commit();

                }

            }
        });
        btnDetachB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentB fragmentB=(FragmentB) manager.findFragmentByTag("FragB");
                FragmentTransaction transaction = manager.beginTransaction();
                if(fragmentB !=null) {
                    transaction.detach(fragmentB);
                    transaction.commit();
                }
            }
        });


    }


    public void showFragmentA(View v){
        FragmentA fragmentA=(FragmentA) manager.findFragmentByTag("FragA");
        FragmentTransaction transaction = manager.beginTransaction();

        if(fragmentA != null) {

            transaction.show(fragmentA);
            transaction.commit();

        }
    }

    public void hideFragmentA(View v){
        FragmentA fragmentA=(FragmentA) manager.findFragmentByTag("FragA");
        FragmentTransaction transaction = manager.beginTransaction();

        if(fragmentA != null) {
            //Esconde o Fragment mas  o mesmo permanece no onResume state
            transaction.hide(fragmentA);
            transaction.commit();

        }
    }

    public void sendDataToFragmentA(View v){
        int firstNumber = Integer.valueOf(number1.getText().toString());
        int secondNumber = Integer.valueOf(number2.getText().toString());

       /* Bundle bundle = new Bundle();
        bundle.putInt("First_Number", firstNumber);
        bundle.putInt("Second_Number", secondNumber);
            */
        FragmentA fragmentA = new FragmentA();
       // fragmentA.setArguments(bundle);

        fragmentA.setData(firstNumber, secondNumber);
        //Custom Method - Com isso pode-se passar qualquer objeto nesses metodos customizados
        //Melhor para passar Non-Primitive

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentA, "FragA");
         transaction.commit();

     }



}
