package com.example.edutrack;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Cgpa extends AppCompatActivity implements View.OnClickListener{
    Button btnCal,btnRst;
    EditText EtSem1,EtSem2,EtSem3,EtSem4,EtSem5,EtSem6,EtSem7,EtSem8,EtCgpa,EtPer;
    int count,i;
    ArrayList<String> sem= new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa);
        getSupportActionBar().hide();
        btnCal=(Button) findViewById(R.id.buttonCgpa);
        btnRst=(Button) findViewById(R.id.buttonRst);
        EtSem1=(EditText)findViewById(R.id.editTextSem1);
        EtSem2=(EditText)findViewById(R.id.editTextSem2);
        EtSem3=(EditText)findViewById(R.id.editTextSem3);
        EtSem4=(EditText)findViewById(R.id.editTextSem4);
        EtSem5=(EditText)findViewById(R.id.editTextSem5);
        EtSem6=(EditText)findViewById(R.id.editTextSem6);
        EtSem7=(EditText)findViewById(R.id.editTextSem7);
        EtSem8=(EditText)findViewById(R.id.editTextSem8);
        EtCgpa=(EditText)findViewById(R.id.editTextCgpa);
        EtPer=(EditText)findViewById(R.id.editTextPer);
        btnRst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    EtSem1.setText("");
                    EtSem2.setText("");
                    EtSem3.setText("");
                    EtSem4.setText("");
                    EtSem5.setText("");
                    EtSem6.setText("");
                    EtSem7.setText("");
                    EtSem8.setText("");
                    EtCgpa.setText("");
                    EtPer.setText("");
                }catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(Cgpa.this, "Cannot reset", Toast.LENGTH_SHORT).show();
                }
            }
        });

       btnCal.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               float sum=0,semf=0,avg,per;

//               try {
//
//               } catch (NumberFormatException e) {
//                   e.printStackTrace();
//                   Toast.makeText(Cgpa.this, "cannot covert to float", Toast.LENGTH_SHORT).show();
//               }

                sem.add(0,EtSem1.getText().toString());
                sem.add(1,EtSem2.getText().toString());
                sem.add(2,EtSem3.getText().toString());
                sem.add(3,EtSem4.getText().toString());
                sem.add(4,EtSem5.getText().toString());
                sem.add(5,EtSem6.getText().toString());
                sem.add(6,EtSem7.getText().toString());
                sem.add(7,EtSem8.getText().toString());

               count=0;
               try{
                i=0;
                while((i!=sem.size()) && (!sem.get(i).equals("")))
                {

                    semf = Float.parseFloat(sem.get(i));
                    sum=sum+semf;
                    count++;
                    i++;
                }
//                Toast.makeText(Cgpa.this, "hi "+sum, Toast.LENGTH_SHORT).show();
                avg=(float)(sum/count);
                EtCgpa.setText(String.valueOf(avg));
                per= (float) ((avg-0.75)*10);
                EtPer.setText(String.valueOf(per));
               } catch (NumberFormatException e) {
                   e.printStackTrace();
               }
           }
       });
    }

    @Override
    public void onClick(View v) {

    }
}