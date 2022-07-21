package com.example.edutrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    Button callSignUp , loginBtn;
    TextInputLayout email, password;
    FirebaseAuth firebaseAuth;
    TextView logoname;
    Animation topAim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        firebaseAuth=firebaseAuth.getInstance();
        topAim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        logoname=findViewById(R.id.logo_name);
        logoname.setAnimation(topAim);
        callSignUp =(Button) findViewById(R.id.signup_screen);
        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });

        email=findViewById(R.id.sig_email);
        password=findViewById(R.id.sig_password);
        loginBtn=(Button) findViewById(R.id.goto_home);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Extract
                //validate
                if(email.getEditText().toString().isEmpty()){
                    email.setError("Email is missing");
                    return;
                }

                if(password.getEditText().toString().isEmpty()){
                    password.setError("Password is missing");
                    return;
                }

                //Data is valid
                //login

                firebaseAuth.signInWithEmailAndPassword(email.getEditText().getText().toString().trim(),password.getEditText().getText().toString().trim()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(Login.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),UserHome.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });




    }

    @Override
    protected void onStart() {
        super.onStart();
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), UserHome.class));
            finish();
        }
    }
}