package com.example.edutrack;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

import java.util.ArrayList;

public class Sgpa extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private Spinner spinner, SpnrBrnch;
    ArrayAdapter<CharSequence> adapter;
    String BRANCH,SEM,caseB0,caseS0;
    String marks[] = new String[10];
    String brnch[] = {"Branch","CSE", "ISE", "ECE", "CV", "ME"};
    String cc1[] = {"", "18MAT11/21", "18PHY12/22", "18ELE13/23", "18CIV14/24", "18GDL15/25", "18PHYL16/26", "18ELEL17/27", "18EGH18/28","SGPA:","Percentage:"};
    String cc2[] = {"", "18MAT11/21", "18CHE12/22", "18CPS13/23", "18ELN14/24", "18ME15/25", "18CHEL16/26", "18CPL17/27", "18EGH18/28","SGPA:","Percentage:"};
    String cc3[] = {"", "18**31", "18**32", "18**33", "18**34", "18**35", "18**36", "18**37", "18**38", "18**39","SGPA:","Percentage:"};
    String cc4[] = {"", "18**41", "18**42", "18**43", "18**44", "18**45", "18**46", "18**47", "18**48", "18**49","SGPA:","Percentage:"};
    String cc5[] = {"", "18**51", "18**52", "18**53", "18**54", "18**55", "18**56", "18**57", "18**58", "18**59","SGPA:","Percentage:"};
    String cc6[] = {"", "18**61", "18**62", "18**63", "18**64", "18**65", "18**66", "18**67", "18**68","SGPA:","Percentage:"};
    String cc7[] = {"", "18**71", "18**72", "18**73", "18**74", "18**75", "18**76", "18**77", "18**78","SGPA:","Percentage:"};
    String cc8[] = {"", "18**81", "18**82", "18**83", "18**84", "Internship","SGPA:","Percentage:"};
    String item,sem,temp,cursem,curbrnch,marks1;
    int c1=0,c2=0,c3=0,c4=0,c5=0,c6=0,c7=0,c8=0,c9=0;
    int ce1,ce2,ce3,ce4,ce5,ce6,ce7,ce8,ce9;
    int O=10,S=9,A=8,B=7,C=6,D=5,E=4,F=0;

    int m1;
    int m2;
    int m3;
    int m4;
    int m5;
    int m6;
    int m7;
    int m8;
    int m9;

    ArrayList<String> list =new ArrayList();
    EditText etm1,etm2,etm3,etm4,etm5,etm6,etm7,etm8,etm9;
    EditText sgpa,per;
    TextView tc1, tc2, tc3, tc4, tc5, tc6, tc7, tc8, tc9,tcsgpa,tcper;
    Button bcal,btnper;
    int j,k,flag=0,l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sgpa);
        spinner = findViewById(R.id.SpinnerSem);
        getSupportActionBar().hide();
        SpnrBrnch = findViewById(R.id.spinnerBranch);


        SEM = (String) spinner.getSelectedItem();
        BRANCH =(String) SpnrBrnch.getSelectedItem();

        SpnrBrnch.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,brnch));
        ArrayAdapter<CharSequence> adapterB = ArrayAdapter.createFromResource(this, R.array.branch, android.R.layout.simple_spinner_item);
        adapterB.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        SpnrBrnch.setOnItemSelectedListener(this);


        tc1 = (TextView) findViewById(R.id.Tvcc1);
        tc2 = (TextView) findViewById(R.id.Tvcc2);
        tc3 = (TextView) findViewById(R.id.Tvcc3);
        tc4 = (TextView) findViewById(R.id.Tvcc4);
        tc5 = (TextView) findViewById(R.id.Tvcc5);
        tc6 = (TextView) findViewById(R.id.Tvcc6);
        tc7 = (TextView) findViewById(R.id.Tvcc7);
        tc8 = (TextView) findViewById(R.id.Tvcc8);
        tc9 = (TextView) findViewById(R.id.Tvcc9);
        tcsgpa = (TextView) findViewById(R.id.textViewSgpa);
        tcper = (TextView) findViewById(R.id.textViewPer);

        etm1 = (EditText) findViewById(R.id.editText1);
        etm2 = (EditText) findViewById(R.id.editText2);
        etm3 = (EditText) findViewById(R.id.editTextSem3);
        etm4 = (EditText) findViewById(R.id.editText4);
        etm5 = (EditText) findViewById(R.id.editText5);
        etm6 = (EditText) findViewById(R.id.editText6);
        etm7 = (EditText) findViewById(R.id.editText7);
        etm8 = (EditText) findViewById(R.id.editText8);
        etm9 = (EditText) findViewById(R.id.editText9);
        sgpa = (EditText) findViewById(R.id.editTextSGPA);
        per = (EditText) findViewById(R.id.editTextPercent);

        bcal=findViewById(R.id.buttonSCal);
        btnper=findViewById(R.id.buttonReset);

//         marks[0] = etm1.getText().toString();
//         marks[1] = etm2.getText().toString();
//         marks[2] = etm3.getText().toString();
//         marks[3] = etm4.getText().toString();
//         marks[4] = etm5.getText().toString();
//         marks[5] = etm6.getText().toString();
//         marks[6] = etm7.getText().toString();
//         marks[7] = etm8.getText().toString();
//         marks[8] = etm9.getText().toString();

        etm1.setVisibility(View.INVISIBLE);
        etm2.setVisibility(View.INVISIBLE);
        etm3.setVisibility(View.INVISIBLE);
        etm4.setVisibility(View.INVISIBLE);
        etm5.setVisibility(View.INVISIBLE);
        etm6.setVisibility(View.INVISIBLE);
        etm7.setVisibility(View.INVISIBLE);
        etm8.setVisibility(View.INVISIBLE);
        etm9.setVisibility(View.INVISIBLE);
        sgpa.setVisibility(View.INVISIBLE);
        per.setVisibility(View.INVISIBLE);

        bcal.setVisibility(View.INVISIBLE);
        btnper.setVisibility(View.INVISIBLE);


        SpnrBrnch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> AdapterView, View view, int position, long id) {
                k=0;
                if (flag==1){
                    switch (position) {
                        case 0:

                            etm1.setVisibility(View.INVISIBLE);
                            etm2.setVisibility(View.INVISIBLE);
                            etm3.setVisibility(View.INVISIBLE);
                            etm4.setVisibility(View.INVISIBLE);
                            etm5.setVisibility(View.INVISIBLE);
                            etm6.setVisibility(View.INVISIBLE);
                            etm7.setVisibility(View.INVISIBLE);
                            etm8.setVisibility(View.INVISIBLE);
                            etm9.setVisibility(View.INVISIBLE);
                            sgpa.setVisibility(View.INVISIBLE);
                            per.setVisibility(View.INVISIBLE);

                            bcal.setVisibility(View.INVISIBLE);
                            btnper.setVisibility(View.INVISIBLE);

                            item = (String) AdapterView.getSelectedItem();
                            caseB0 = item;

                            break;
                        case 1:
                            item = (String) AdapterView.getSelectedItem();
                            if(caseS0!=null && caseS0.equals(sem))
                            {
                                Toast.makeText(getApplicationContext(),"Choose Semester", Toast.LENGTH_LONG).show();
                            }
                            if (temp!=null && temp.equals(sem)) {

                                tc1.setText("" + cc7[++k]);
                                tc2.setText("" + cc7[++k]);
                                tc3.setText("" + cc7[++k]);
                                tc4.setText("" + cc7[++k]);
                                tc5.setText("" + cc7[++k]);
                                tc6.setText("" + cc7[++k]);
                                tc7.setText("" + cc7[++k]);
                                tcsgpa.setText(""+ cc7[9]);
                                tcper.setText("" + cc7[10]);
                                tc8.setText("");
                                tc9.setText("");

                                etm1.setVisibility(View.VISIBLE);
                                etm2.setVisibility(View.VISIBLE);
                                etm3.setVisibility(View.VISIBLE);
                                etm4.setVisibility(View.VISIBLE);
                                etm5.setVisibility(View.VISIBLE);
                                etm6.setVisibility(View.VISIBLE);
                                etm7.setVisibility(View.VISIBLE);
                                etm8.setVisibility(View.INVISIBLE);
                                etm9.setVisibility(View.INVISIBLE);
                                sgpa.setVisibility(View.VISIBLE);
                                per.setVisibility(View.VISIBLE);

                                bcal.setVisibility(View.VISIBLE);
                                btnper.setVisibility(View.VISIBLE);
                            }
                            break;

                        case 2:
                            item = (String) AdapterView.getSelectedItem();
                            if(caseS0!=null && caseS0.equals(sem))
                            {
                                Toast.makeText(getApplicationContext(), "Choose Semester", Toast.LENGTH_LONG).show();
                            }
                            if (temp!=null && temp.equals(sem)) {

                                tc1.setText("" + cc7[++k]);
                                tc2.setText("" + cc7[++k]);
                                tc3.setText("" + cc7[++k]);
                                tc4.setText("" + cc7[++k]);
                                tc5.setText("" + cc7[++k]);
                                tc6.setText("" + cc7[++k]);
                                tc7.setText("" + cc7[++k]);
                                tcsgpa.setText(""+ cc7[9]);
                                tcper.setText("" + cc7[10]);
                                tc8.setText("");
                                tc9.setText("");

                                etm1.setVisibility(View.VISIBLE);
                                etm2.setVisibility(View.VISIBLE);
                                etm3.setVisibility(View.VISIBLE);
                                etm4.setVisibility(View.VISIBLE);
                                etm5.setVisibility(View.VISIBLE);
                                etm6.setVisibility(View.VISIBLE);
                                etm7.setVisibility(View.VISIBLE);
                                etm8.setVisibility(View.INVISIBLE);
                                etm9.setVisibility(View.INVISIBLE);
                                sgpa.setVisibility(View.VISIBLE);
                                per.setVisibility(View.VISIBLE);

                                bcal.setVisibility(View.VISIBLE);
                                btnper.setVisibility(View.VISIBLE);
                            }
                            break;
                        case 3:
                            item = (String) AdapterView.getSelectedItem();
                            if(caseS0.equals(sem))
                            {
                                Toast.makeText(getApplicationContext(), "Choose Semester", Toast.LENGTH_LONG).show();
                            }
                            if (temp!=null && temp.equals(sem)) {

                                tc1.setText("" + cc7[++k]);
                                tc2.setText("" + cc7[++k]);
                                tc3.setText("" + cc7[++k]);
                                tc4.setText("" + cc7[++k]);
                                tc5.setText("" + cc7[++k]);
                                tc6.setText("" + cc7[++k]);
                                tc7.setText("" + cc7[++k]);
                                tc8.setText("" + cc7[++k]);
                                tcsgpa.setText(""+ cc7[++k]);
                                tcper.setText("" + cc7[++k]);
                                tc9.setText("");

                                etm1.setVisibility(View.VISIBLE);
                                etm2.setVisibility(View.VISIBLE);
                                etm3.setVisibility(View.VISIBLE);
                                etm4.setVisibility(View.VISIBLE);
                                etm5.setVisibility(View.VISIBLE);
                                etm6.setVisibility(View.VISIBLE);
                                etm7.setVisibility(View.VISIBLE);
                                etm8.setVisibility(View.VISIBLE);
                                etm9.setVisibility(View.INVISIBLE);
                                sgpa.setVisibility(View.VISIBLE);
                                per.setVisibility(View.VISIBLE);

                                bcal.setVisibility(View.VISIBLE);
                                btnper.setVisibility(View.VISIBLE);
                            }
                            break;
                        case 4:
                            item = (String) AdapterView.getSelectedItem();
                            if(caseS0.equals(sem))
                            {
                                Toast.makeText(getApplicationContext(), "Choose Semester", Toast.LENGTH_LONG).show();
                            }
                        if (temp!=null && temp.equals(sem)) {

                                tc1.setText("" + cc7[++k]);
                                tc2.setText("" + cc7[++k]);
                                tc3.setText("" + cc7[++k]);
                                tc4.setText("" + cc7[++k]);
                                tc5.setText("" + cc7[++k]);
                                tc6.setText("" + cc7[++k]);
                                tc7.setText("" + cc7[++k]);
                                tc8.setText("" + cc7[++k]);
                                tcsgpa.setText(""+ cc7[++k]);
                                tcper.setText("" + cc7[++k]);
                                tc9.setText("");

                            etm1.setVisibility(View.VISIBLE);
                            etm2.setVisibility(View.VISIBLE);
                            etm3.setVisibility(View.VISIBLE);
                            etm4.setVisibility(View.VISIBLE);
                            etm5.setVisibility(View.VISIBLE);
                            etm6.setVisibility(View.VISIBLE);
                            etm7.setVisibility(View.VISIBLE);
                            etm8.setVisibility(View.VISIBLE);
                            etm9.setVisibility(View.INVISIBLE);
                            sgpa.setVisibility(View.VISIBLE);
                            per.setVisibility(View.VISIBLE);

                            bcal.setVisibility(View.VISIBLE);
                            btnper.setVisibility(View.VISIBLE);

                            }
                            break;
                        case 5:
                            item = (String) AdapterView.getSelectedItem();
                            if(caseS0.equals(sem))
                            {
                                Toast.makeText(getApplicationContext(), "Choose Semester", Toast.LENGTH_LONG).show();
                            }
                        if (temp!=null && temp.equals(sem)) {

                                tc1.setText("" + cc7[++k]);
                                tc2.setText("" + cc7[++k]);
                                tc3.setText("" + cc7[++k]);
                                tc4.setText("" + cc7[++k]);
                                tc5.setText("" + cc7[++k]);
                                tc6.setText("" + cc7[++k]);
                                tc7.setText("" + cc7[++k]);
                                tc8.setText("" + cc7[++k]);
                                tcsgpa.setText(""+ cc7[++k]);
                                tcper.setText("" + cc7[++k]);
                                tc9.setText("");

                            etm1.setVisibility(View.VISIBLE);
                            etm2.setVisibility(View.VISIBLE);
                            etm3.setVisibility(View.VISIBLE);
                            etm4.setVisibility(View.VISIBLE);
                            etm5.setVisibility(View.VISIBLE);
                            etm6.setVisibility(View.VISIBLE);
                            etm7.setVisibility(View.VISIBLE);
                            etm8.setVisibility(View.VISIBLE);
                            etm9.setVisibility(View.INVISIBLE);
                            sgpa.setVisibility(View.VISIBLE);
                            per.setVisibility(View.VISIBLE);

                            bcal.setVisibility(View.VISIBLE);
                            btnper.setVisibility(View.VISIBLE);
                            }
                            break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        adapter = ArrayAdapter.createFromResource(this, R.array.semester, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                j = 0;

                    switch (i) {
                        case 0:
                            sem = (String) parent.getSelectedItem();

                            caseS0 = sem;

                            break;
                        case 1:
                            sem = (String) parent.getSelectedItem();
                            if(flag==1 && caseB0.equals(item)) {
                                Toast.makeText(getApplicationContext(), "Choose Branch", Toast.LENGTH_LONG).show();
                            }

                            tc1.setText("" + cc1[++j]);
                            tc2.setText("" + cc1[++j]);
                            tc3.setText("" + cc1[++j]);
                            tc4.setText("" + cc1[++j]);
                            tc5.setText("" + cc1[++j]);
                            tc6.setText("" + cc1[++j]);
                            tc7.setText("" + cc1[++j]);
                            tc8.setText("" + cc1[++j]);
                            tcsgpa.setText(""+ cc1[++j]);
                            tcper.setText("" + cc1[++j]);
                            tc9.setText("");

                            etm1.setVisibility(View.VISIBLE);
                            etm2.setVisibility(View.VISIBLE);
                            etm3.setVisibility(View.VISIBLE);
                            etm4.setVisibility(View.VISIBLE);
                            etm5.setVisibility(View.VISIBLE);
                            etm6.setVisibility(View.VISIBLE);
                            etm7.setVisibility(View.VISIBLE);
                            etm8.setVisibility(View.VISIBLE);
                            etm9.setVisibility(View.INVISIBLE);
                            sgpa.setVisibility(View.VISIBLE);
                            per.setVisibility(View.VISIBLE);

                            bcal.setVisibility(View.VISIBLE);
                            btnper.setVisibility(View.VISIBLE);
                            break;
                        case 2:
                            sem = (String) parent.getSelectedItem();
                            if(flag==1 && caseB0.equals(item)) {
                                Toast.makeText(getApplicationContext(), "Choose Branch", Toast.LENGTH_LONG).show();
                            }

                            tc1.setText("" + cc2[++j]);
                            tc2.setText("" + cc2[++j]);
                            tc3.setText("" + cc2[++j]);
                            tc4.setText("" + cc2[++j]);
                            tc5.setText("" + cc2[++j]);
                            tc6.setText("" + cc2[++j]);
                            tc7.setText("" + cc2[++j]);
                            tc8.setText("" + cc2[++j]);
                            tcsgpa.setText(""+ cc2[++j]);
                            tcper.setText("" + cc2[++j]);
                            tc9.setText("");

                            etm1.setVisibility(View.VISIBLE);
                            etm2.setVisibility(View.VISIBLE);
                            etm3.setVisibility(View.VISIBLE);
                            etm4.setVisibility(View.VISIBLE);
                            etm5.setVisibility(View.VISIBLE);
                            etm6.setVisibility(View.VISIBLE);
                            etm7.setVisibility(View.VISIBLE);
                            etm8.setVisibility(View.VISIBLE);
                            etm9.setVisibility(View.INVISIBLE);
                            sgpa.setVisibility(View.VISIBLE);
                            per.setVisibility(View.VISIBLE);

                            bcal.setVisibility(View.VISIBLE);
                            btnper.setVisibility(View.VISIBLE);

                            break;
                        case 3:
                            sem = (String) parent.getSelectedItem();
                            if(flag==1 && caseB0.equals(item)) {
                                Toast.makeText(getApplicationContext(), "Choose Branch", Toast.LENGTH_LONG).show();
                            }

                            tc1.setText("" + cc3[++j]);
                            tc2.setText("" + cc3[++j]);
                            tc3.setText("" + cc3[++j]);
                            tc4.setText("" + cc3[++j]);
                            tc5.setText("" + cc3[++j]);
                            tc6.setText("" + cc3[++j]);
                            tc7.setText("" + cc3[++j]);
                            tc8.setText("" + cc3[++j]);
                            tc9.setText("" + cc3[++j]);
                            tcsgpa.setText(""+ cc3[++j]);
                            tcper.setText("" + cc3[++j]);

                            etm1.setVisibility(View.VISIBLE);
                            etm2.setVisibility(View.VISIBLE);
                            etm3.setVisibility(View.VISIBLE);
                            etm4.setVisibility(View.VISIBLE);
                            etm5.setVisibility(View.VISIBLE);
                            etm6.setVisibility(View.VISIBLE);
                            etm7.setVisibility(View.VISIBLE);
                            etm8.setVisibility(View.VISIBLE);
                            etm9.setVisibility(View.VISIBLE);
                            sgpa.setVisibility(View.VISIBLE);
                            per.setVisibility(View.VISIBLE);

                            bcal.setVisibility(View.VISIBLE);
                            btnper.setVisibility(View.VISIBLE);

                            break;
                        case 4:
                            sem = (String) parent.getSelectedItem();
                            if(flag==1 && caseB0.equals(item)) {
                                Toast.makeText(getApplicationContext(), "Choose Branch", Toast.LENGTH_LONG).show();
                            }

                            tc1.setText("" + cc4[++j]);
                            tc2.setText("" + cc4[++j]);
                            tc3.setText("" + cc4[++j]);
                            tc4.setText("" + cc4[++j]);
                            tc5.setText("" + cc4[++j]);
                            tc6.setText("" + cc4[++j]);
                            tc7.setText("" + cc4[++j]);
                            tc8.setText("" + cc4[++j]);
                            tc9.setText("" + cc4[++j]);
                            tcsgpa.setText(""+ cc4[++j]);
                            tcper.setText("" + cc4[++j]);

                            etm1.setVisibility(View.VISIBLE);
                            etm2.setVisibility(View.VISIBLE);
                            etm3.setVisibility(View.VISIBLE);
                            etm4.setVisibility(View.VISIBLE);
                            etm5.setVisibility(View.VISIBLE);
                            etm6.setVisibility(View.VISIBLE);
                            etm7.setVisibility(View.VISIBLE);
                            etm8.setVisibility(View.VISIBLE);
                            etm9.setVisibility(View.VISIBLE);
                            sgpa.setVisibility(View.VISIBLE);
                            per.setVisibility(View.VISIBLE);

                            bcal.setVisibility(View.VISIBLE);
                            btnper.setVisibility(View.VISIBLE);

                            break;
                        case 5:
                            sem = (String) parent.getSelectedItem();
                            if(flag==1 && caseB0.equals(item)) {
                                Toast.makeText(getApplicationContext(), "Choose Branch", Toast.LENGTH_LONG).show();
                            }

                            tc1.setText("" + cc5[++j]);
                            tc2.setText("" + cc5[++j]);
                            tc3.setText("" + cc5[++j]);
                            tc4.setText("" + cc5[++j]);
                            tc5.setText("" + cc5[++j]);
                            tc6.setText("" + cc5[++j]);
                            tc7.setText("" + cc5[++j]);
                            tc8.setText("" + cc5[++j]);
                            tc9.setText("" + cc5[++j]);
                            tcsgpa.setText(""+ cc5[++j]);
                            tcper.setText("" + cc5[++j]);

                            etm1.setVisibility(View.VISIBLE);
                            etm2.setVisibility(View.VISIBLE);
                            etm3.setVisibility(View.VISIBLE);
                            etm4.setVisibility(View.VISIBLE);
                            etm5.setVisibility(View.VISIBLE);
                            etm6.setVisibility(View.VISIBLE);
                            etm7.setVisibility(View.VISIBLE);
                            etm8.setVisibility(View.VISIBLE);
                            etm9.setVisibility(View.VISIBLE);
                            sgpa.setVisibility(View.VISIBLE);
                            per.setVisibility(View.VISIBLE);

                            bcal.setVisibility(View.VISIBLE);
                            btnper.setVisibility(View.VISIBLE);

                            break;
                        case 6:
                            sem = (String) parent.getSelectedItem();
                            if(flag==1 && caseB0.equals(item)) {
                                Toast.makeText(getApplicationContext(), "Choose Branch", Toast.LENGTH_LONG).show();
                            }

                            tc1.setText("" + cc6[++j]);
                            tc2.setText("" + cc6[++j]);
                            tc3.setText("" + cc6[++j]);
                            tc4.setText("" + cc6[++j]);
                            tc5.setText("" + cc6[++j]);
                            tc6.setText("" + cc6[++j]);
                            tc7.setText("" + cc6[++j]);
                            tc8.setText("" + cc6[++j]);
                            tcsgpa.setText(""+ cc6[++j]);
                            tcper.setText("" + cc6[++j]);
                            tc9.setText("");

                            etm1.setVisibility(View.VISIBLE);
                            etm2.setVisibility(View.VISIBLE);
                            etm3.setVisibility(View.VISIBLE);
                            etm4.setVisibility(View.VISIBLE);
                            etm5.setVisibility(View.VISIBLE);
                            etm6.setVisibility(View.VISIBLE);
                            etm7.setVisibility(View.VISIBLE);
                            etm8.setVisibility(View.VISIBLE);
                            etm9.setVisibility(View.INVISIBLE);
                            sgpa.setVisibility(View.VISIBLE);
                            per.setVisibility(View.VISIBLE);

                            bcal.setVisibility(View.VISIBLE);
                            btnper.setVisibility(View.VISIBLE);

                            break;
                        case 7:
                            sem = (String) parent.getSelectedItem();
                            if(flag==1 && caseB0.equals(item)) {
                                Toast.makeText(getApplicationContext(), "Choose Branch", Toast.LENGTH_LONG).show();
                            }
                            if (item.equals("ECE") || item.equals("CV") || item.equals("ME") && sem.equals("sem7")) {


                                tc1.setText("" + cc7[++j]);
                                tc2.setText("" + cc7[++j]);
                                tc3.setText("" + cc7[++j]);
                                tc4.setText("" + cc7[++j]);
                                tc5.setText("" + cc7[++j]);
                                tc6.setText("" + cc7[++j]);
                                tc7.setText("" + cc7[++j]);
                                tc8.setText("" + cc7[++j]);
                                tcsgpa.setText("" + cc7[++j]);
                                tcper.setText("" + cc7[++j]);
                                tc9.setText("");

                                etm1.setVisibility(View.VISIBLE);
                                etm2.setVisibility(View.VISIBLE);
                                etm3.setVisibility(View.VISIBLE);
                                etm4.setVisibility(View.VISIBLE);
                                etm5.setVisibility(View.VISIBLE);
                                etm6.setVisibility(View.VISIBLE);
                                etm7.setVisibility(View.VISIBLE);
                                etm8.setVisibility(View.VISIBLE);
                                etm9.setVisibility(View.INVISIBLE);
                                sgpa.setVisibility(View.VISIBLE);
                                per.setVisibility(View.VISIBLE);

                                bcal.setVisibility(View.VISIBLE);
                                btnper.setVisibility(View.VISIBLE);
                            }
                            if (item.equals("CSE") || item.equals("ISE") && sem.equals("sem7")) {

                                tc1.setText("" + cc7[++j]);
                                tc2.setText("" + cc7[++j]);
                                tc3.setText("" + cc7[++j]);
                                tc4.setText("" + cc7[++j]);
                                tc5.setText("" + cc7[++j]);
                                tc6.setText("" + cc7[++j]);
                                tc7.setText("" + cc7[++j]);
                                tcsgpa.setText("" + cc7[9]);
                                tcper.setText("" + cc7[10]);
                                tc8.setText("");
                                tc9.setText("");

                                etm1.setVisibility(View.VISIBLE);
                                etm2.setVisibility(View.VISIBLE);
                                etm3.setVisibility(View.VISIBLE);
                                etm4.setVisibility(View.VISIBLE);
                                etm5.setVisibility(View.VISIBLE);
                                etm6.setVisibility(View.VISIBLE);
                                etm7.setVisibility(View.VISIBLE);
                                etm8.setVisibility(View.INVISIBLE);
                                etm9.setVisibility(View.INVISIBLE);
                                sgpa.setVisibility(View.VISIBLE);
                                per.setVisibility(View.VISIBLE);

                                bcal.setVisibility(View.VISIBLE);
                                btnper.setVisibility(View.VISIBLE);
                            }
                            temp = sem;
                            break;

                        case 8:
                            sem = (String) parent.getSelectedItem();
                            if(flag==1 && caseB0.equals(item)) {
                                Toast.makeText(getApplicationContext(), "Choose Branch", Toast.LENGTH_LONG).show();
                            }

                            tc1.setText("" + cc8[++j]);
                            tc2.setText("" + cc8[++j]);
                            tc3.setText("" + cc8[++j]);
                            tc4.setText("" + cc8[++j]);
                            tc5.setText("" + cc8[++j]);
                            tcsgpa.setText("" + cc8[++j]);
                            tcper.setText("" + cc8[++j]);
                            tc6.setText("");
                            tc7.setText("");
                            tc8.setText("");
                            tc9.setText("");

                            etm1.setVisibility(View.VISIBLE);
                            etm2.setVisibility(View.VISIBLE);
                            etm3.setVisibility(View.VISIBLE);
                            etm4.setVisibility(View.VISIBLE);
                            etm5.setVisibility(View.VISIBLE);
                            etm6.setVisibility(View.INVISIBLE);
                            etm7.setVisibility(View.INVISIBLE);
                            etm8.setVisibility(View.INVISIBLE);
                            etm9.setVisibility(View.INVISIBLE);
                            sgpa.setVisibility(View.VISIBLE);
                            per.setVisibility(View.VISIBLE);

                            bcal.setVisibility(View.VISIBLE);
                            btnper.setVisibility(View.VISIBLE);

                            break;
                    }
                    flag = 1;
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String grade[] = new String[10];
                float sumofcredits = 0, SGPA, mulCG = 0,percent;
                ArrayList<String> grades = new ArrayList<>();
                ArrayList<String> crdtern = new ArrayList<>();

                list.add(0,etm1.getText().toString());
                list.add(1,etm2.getText().toString());
                list.add(2,etm3.getText().toString());
                list.add(3,etm4.getText().toString());
                list.add(4,etm5.getText().toString());
                list.add(5,etm6.getText().toString());
                list.add(6,etm7.getText().toString());
                list.add(7,etm8.getText().toString());
                list.add(8,etm9.getText().toString());

                if (sem != null && (sem.equals("Physics Cycle") || sem.equals("Chemistry Cycle"))) {
                    crdtern.add(0,String.valueOf(4));
                    crdtern.add(1,String.valueOf(4));
                    crdtern.add(2,String.valueOf(3));
                    crdtern.add(3,String.valueOf(3));
                    crdtern.add(4,String.valueOf(3));
                    crdtern.add(5,String.valueOf(1));
                    crdtern.add(6,String.valueOf(1));
                    crdtern.add(7,String.valueOf(1));
                    try {
                        for (l = 0; l<crdtern.size(); l++) {
                            Float mpc = Float.parseFloat(list.get(l));
                            if (mpc >= 90F) {
                                grades.add(l,String.valueOf(10));
                            }
                            else if (mpc < 90F && mpc >= 80F) {
                                grades.add(l,String.valueOf(9));
                            }
                            else if (mpc < 80F && mpc >= 70F) {
                                grades.add(l,String.valueOf(8));
                            }
                            else if (mpc < 70F && mpc >= 60F) {
                                grades.add(l,String.valueOf(7));
                            }
                            else if (mpc < 60F && mpc >= 50F) {
                                grades.add(l,String.valueOf(6));
                            }
                            else if (mpc < 50F && mpc >= 45F) {
                                grades.add(l,String.valueOf(5));
                            }
                            else if (mpc < 45F && mpc >= 40F) {
                                grades.add(l,String.valueOf(4));
                            }
                            else if (mpc < 40F) {
                                grades.add(l,String.valueOf(0));
                                crdtern.set(l,String.valueOf(0));
                            }
                            float cepc = Float.parseFloat(crdtern.get(l));
                            float gdpy = Float.parseFloat(grades.get(l));
                            sumofcredits = sumofcredits + cepc;
                            mulCG = mulCG + (cepc * gdpy);
                        }
                        SGPA = mulCG / sumofcredits;
                        percent = (float) ((SGPA * 10)-7.5);
//                        Toast.makeText(Sgpa.this,"hi " +percent, Toast.LENGTH_SHORT).show();
                        sgpa.setText(String.valueOf(SGPA));
                        per.setText(String.valueOf(percent));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                }

                if (sem != null && (sem.equals("sem3") || sem.equals("sem3"))) {
                        crdtern.add(0,String.valueOf(3));
                        crdtern.add(1,String.valueOf(4));
                        crdtern.add(2,String.valueOf(3));
                        crdtern.add(3,String.valueOf(3));
                        crdtern.add(4,String.valueOf(3));
                        crdtern.add(5,String.valueOf(3));
                        crdtern.add(6,String.valueOf(2));
                        crdtern.add(7,String.valueOf(2));
                        crdtern.add(8,String.valueOf(1));
                    try {
                        for (l = 0; l<crdtern.size(); l++) {
                            double mpc = Double.parseDouble(list.get(l));
                            if (mpc >= 90F) {
                                grades.add(l,String.valueOf(10));
                            }
                            else if (mpc < 90F && mpc >= 80F) {
                                grades.add(l,String.valueOf(9));
                            }
                            else if (mpc < 80F && mpc >= 70F) {
                                grades.add(l,String.valueOf(8));
                            }
                            else if (mpc < 70F && mpc >= 60F) {
                                grades.add(l,String.valueOf(7));
                            }
                            else if (mpc < 60F && mpc >= 50F) {
                                grades.add(l,String.valueOf(6));
                            }
                            else if (mpc < 50F && mpc >= 45F) {
                                grades.add(l,String.valueOf(5));
                            }
                            else if (mpc < 45F && mpc >= 40F) {
                                grades.add(l,String.valueOf(4));
                            }
                            else if (mpc < 40F) {
                                grades.add(l,String.valueOf(0));
                                crdtern.set(l,String.valueOf(0));
                            }
                            float cepc = Float.parseFloat(crdtern.get(l));
                            float gdpy = Float.parseFloat(grades.get(l));
                            sumofcredits = sumofcredits + cepc;
                            mulCG = mulCG + (cepc * gdpy);
                        }
                        SGPA = mulCG / sumofcredits;
                        percent = (float) ((SGPA * 10)-7.5);
//                        Toast.makeText(Sgpa.this,"hi " +sumofcredits, Toast.LENGTH_SHORT).show();
                        sgpa.setText(String.valueOf(SGPA));
                        per.setText(String.valueOf(percent));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                }

                if (sem != null && sem.equals("sem5")) {
                    crdtern.add(0,String.valueOf(3));
                    crdtern.add(1,String.valueOf(4));
                    crdtern.add(2,String.valueOf(4));
                    crdtern.add(3,String.valueOf(3));
                    crdtern.add(4,String.valueOf(3));
                    crdtern.add(5,String.valueOf(3));
                    crdtern.add(6,String.valueOf(2));
                    crdtern.add(7,String.valueOf(2));
                    crdtern.add(8,String.valueOf(1));
                    try {
                        for (l = 0; l<crdtern.size(); l++) {
                            double mpc = Double.parseDouble(list.get(l));
                            if (mpc >= 90F) {
                                grades.add(l,String.valueOf(10));
                            }
                            else if (mpc < 90F && mpc >= 80F) {
                                grades.add(l,String.valueOf(9));
                            }
                            else if (mpc < 80F && mpc >= 70F) {
                                grades.add(l,String.valueOf(8));
                            }
                            else if (mpc < 70F && mpc >= 60F) {
                                grades.add(l,String.valueOf(7));
                            }
                            else if (mpc < 60F && mpc >= 50F) {
                                grades.add(l,String.valueOf(6));
                            }
                            else if (mpc < 50F && mpc >= 45F) {
                                grades.add(l,String.valueOf(5));
                            }
                            else if (mpc < 45F && mpc >= 40F) {
                                grades.add(l,String.valueOf(4));
                            }
                            else if (mpc < 40F) {
                                grades.add(l,String.valueOf(0));
                                crdtern.set(l,String.valueOf(0));
                            }
                            float cepc = Float.parseFloat(crdtern.get(l));
                            float gdpy = Float.parseFloat(grades.get(l));
                            sumofcredits = sumofcredits + cepc;
                            mulCG = mulCG + (cepc * gdpy);
                        }
                        SGPA = mulCG / sumofcredits;
                        percent = (float) ((SGPA * 10)-7.5);
//                        Toast.makeText(Sgpa.this,"hi " +sumofcredits, Toast.LENGTH_SHORT).show();
                        sgpa.setText(String.valueOf(SGPA));
                        per.setText(String.valueOf(percent));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                }

                if (sem != null && sem.equals("sem6")) {
                    crdtern.add(0,String.valueOf(4));
                    crdtern.add(1,String.valueOf(4));
                    crdtern.add(2,String.valueOf(4));
                    crdtern.add(3,String.valueOf(3));
                    crdtern.add(4,String.valueOf(3));
                    crdtern.add(5,String.valueOf(2));
                    crdtern.add(6,String.valueOf(2));
                    crdtern.add(7,String.valueOf(2));
                    try {
                        for (l = 0; l<crdtern.size(); l++) {
                            double mpc = Double.parseDouble(list.get(l));
                            if (mpc >= 90F) {
                                grades.add(l,String.valueOf(10));
                            }
                            else if (mpc < 90F && mpc >= 80F) {
                                grades.add(l,String.valueOf(9));
                            }
                            else if (mpc < 80F && mpc >= 70F) {
                                grades.add(l,String.valueOf(8));
                            }
                            else if (mpc < 70F && mpc >= 60F) {
                                grades.add(l,String.valueOf(7));
                            }
                            else if (mpc < 60F && mpc >= 50F) {
                                grades.add(l,String.valueOf(6));
                            }
                            else if (mpc < 50F && mpc >= 45F) {
                                grades.add(l,String.valueOf(5));
                            }
                            else if (mpc < 45F && mpc >= 40F) {
                                grades.add(l,String.valueOf(4));
                            }
                            else if (mpc < 40F) {
                                grades.add(l,String.valueOf(0));
                                crdtern.set(l,String.valueOf(0));
                            }
                            float cepc = Float.parseFloat(crdtern.get(l));
                            float gdpy = Float.parseFloat(grades.get(l));
                            sumofcredits = sumofcredits + cepc;
                            mulCG = mulCG + (cepc * gdpy);
                        }
                        SGPA = mulCG / sumofcredits;
                        percent = (float) ((SGPA * 10)-7.5);
//                        Toast.makeText(Sgpa.this,"hi " +sumofcredits, Toast.LENGTH_SHORT).show();
                        sgpa.setText(String.valueOf(SGPA));
                        per.setText(String.valueOf(percent));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                }

                if (sem != null && sem.equals("sem7") && (item.equals("CSE") || item.equals("ISE"))){
                    crdtern.add(0,String.valueOf(4));
                    crdtern.add(1,String.valueOf(4));
                    crdtern.add(2,String.valueOf(3));
                    crdtern.add(3,String.valueOf(3));
                    crdtern.add(4,String.valueOf(3));
                    crdtern.add(5,String.valueOf(2));
                    crdtern.add(6,String.valueOf(1));
                    try {
                        for (l = 0; l<crdtern.size(); l++) {
                            double mpc = Double.parseDouble(list.get(l));
                            if (mpc >= 90F) {
                                grades.add(l,String.valueOf(10));
                            }
                            else if (mpc < 90F && mpc >= 80F) {
                                grades.add(l,String.valueOf(9));
                            }
                            else if (mpc < 80F && mpc >= 70F) {
                                grades.add(l,String.valueOf(8));
                            }
                            else if (mpc < 70F && mpc >= 60F) {
                                grades.add(l,String.valueOf(7));
                            }
                            else if (mpc < 60F && mpc >= 50F) {
                                grades.add(l,String.valueOf(6));
                            }
                            else if (mpc < 50F && mpc >= 45F) {
                                grades.add(l,String.valueOf(5));
                            }
                            else if (mpc < 45F && mpc >= 40F) {
                                grades.add(l,String.valueOf(4));
                            }
                            else if (mpc < 40F) {
                                grades.add(l,String.valueOf(0));
                                crdtern.set(l,String.valueOf(0));
                            }
                            float cepc = Float.parseFloat(crdtern.get(l));
                            float gdpy = Float.parseFloat(grades.get(l));
                            sumofcredits = sumofcredits + cepc;
                            mulCG = mulCG + (cepc * gdpy);
                        }
                        SGPA = mulCG / sumofcredits;
                        percent = (float) ((SGPA * 10)-7.5);
//                        Toast.makeText(Sgpa.this,"hi " +sumofcredits, Toast.LENGTH_SHORT).show();
                        sgpa.setText(String.valueOf(SGPA));
                        per.setText(String.valueOf(percent));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                }

                if (sem != null && sem.equals("sem7") && (item.equals("ECE") || item.equals("CV") || item.equals("ME"))){
                    crdtern.add(0,String.valueOf(3));
                    crdtern.add(1,String.valueOf(3));
                    crdtern.add(2,String.valueOf(3));
                    crdtern.add(3,String.valueOf(3));
                    crdtern.add(4,String.valueOf(3));
                    crdtern.add(5,String.valueOf(2));
                    crdtern.add(6,String.valueOf(2));
                    crdtern.add(7,String.valueOf(1));
                    try {
                        for (l = 0; l<crdtern.size(); l++) {
                            double mpc = Double.parseDouble(list.get(l));
                            if (mpc >= 90F) {
                                grades.add(l,String.valueOf(10));
                            }
                            else if (mpc < 90F && mpc >= 80F) {
                                grades.add(l,String.valueOf(9));
                            }
                            else if (mpc < 80F && mpc >= 70F) {
                                grades.add(l,String.valueOf(8));
                            }
                            else if (mpc < 70F && mpc >= 60F) {
                                grades.add(l,String.valueOf(7));
                            }
                            else if (mpc < 60F && mpc >= 50F) {
                                grades.add(l,String.valueOf(6));
                            }
                            else if (mpc < 50F && mpc >= 45F) {
                                grades.add(l,String.valueOf(5));
                            }
                            else if (mpc < 45F && mpc >= 40F) {
                                grades.add(l,String.valueOf(4));
                            }
                            else if (mpc < 40F) {
                                grades.add(l,String.valueOf(0));
                                crdtern.set(l,String.valueOf(0));
                            }
                            float cepc = Float.parseFloat(crdtern.get(l));
                            float gdpy = Float.parseFloat(grades.get(l));
                            sumofcredits = sumofcredits + cepc;
                            mulCG = mulCG + (cepc * gdpy);
                        }
                        SGPA = mulCG / sumofcredits;
                        percent = (float) ((SGPA * 10)-7.5);
//                        Toast.makeText(Sgpa.this,"hi " +sumofcredits, Toast.LENGTH_SHORT).show();
                        sgpa.setText(String.valueOf(SGPA));
                        per.setText(String.valueOf(percent));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                }

                if (sem != null && sem.equals("sem8")) {
                    crdtern.add(0,String.valueOf(3));
                    crdtern.add(1,String.valueOf(3));
                    crdtern.add(2,String.valueOf(8));
                    crdtern.add(3,String.valueOf(1));
                    crdtern.add(4,String.valueOf(3));
                    try {
                        for (l = 0; l<crdtern.size(); l++) {
                            double mpc = Double.parseDouble(list.get(l));
                            if (mpc >= 90F) {
                                grades.add(l,String.valueOf(10));
                            }
                            else if (mpc < 90F && mpc >= 80F) {
                                grades.add(l,String.valueOf(9));
                            }
                            else if (mpc < 80F && mpc >= 70F) {
                                grades.add(l,String.valueOf(8));
                            }
                            else if (mpc < 70F && mpc >= 60F) {
                                grades.add(l,String.valueOf(7));
                            }
                            else if (mpc < 60F && mpc >= 50F) {
                                grades.add(l,String.valueOf(6));
                            }
                            else if (mpc < 50F && mpc >= 45F) {
                                grades.add(l,String.valueOf(5));
                            }
                            else if (mpc < 45F && mpc >= 40F) {
                                grades.add(l,String.valueOf(4));
                            }
                            else if (mpc < 40F) {
                                grades.add(l,String.valueOf(0));
                                crdtern.set(l,String.valueOf(0));
                            }
                            float cepc = Float.parseFloat(crdtern.get(l));
                            float gdpy = Float.parseFloat(grades.get(l));
                            sumofcredits = sumofcredits + cepc;
                            mulCG = mulCG + (cepc * gdpy);
                        }
                        SGPA = mulCG / sumofcredits;
                        percent = (float) ((SGPA * 10)-7.5);
//                        Toast.makeText(Sgpa.this,"hi " +sumofcredits, Toast.LENGTH_SHORT).show();
                        sgpa.setText(String.valueOf(SGPA));
                        per.setText(String.valueOf(percent));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                }
            }
        });

        btnper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    etm1.setText("");
                    etm2.setText("");
                    etm3.setText("");
                    etm4.setText("");
                    etm5.setText("");
                    etm6.setText("");
                    etm7.setText("");
                    etm8.setText("");
                    etm9.setText("");
                    sgpa.setText("");
                    per.setText("");
                }catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(Sgpa.this, "Cannot reset", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
