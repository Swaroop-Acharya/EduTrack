package com.example.edutrack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddMarks extends AppCompatActivity {
    TextInputLayout edu_class,edu_mark;
    Button saveBtn,backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_marks);
        edu_class =findViewById(R.id.edu_class);
        edu_mark=findViewById(R.id.edu_class_mark);
        saveBtn=findViewById(R.id.edu_class_save_mark);
        backBtn=findViewById(R.id.back_btn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SaveMarks.class));
//                finish();
            }
        });
    }
    private void insertData(){
        Map<String,Object> map =new HashMap<>();

        map.put("Title",edu_class.getEditText().getText().toString());
        map.put("Mark",edu_mark.getEditText().getText().toString());

        FirebaseDatabase.getInstance().getReference().child("SaveMarks").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddMarks.this, "Note saved successfully", Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddMarks.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });



    }


}