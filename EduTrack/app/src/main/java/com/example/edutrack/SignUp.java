package com.example.edutrack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    TextInputLayout regName, regEmail, regPhone, regPassword;
    Button regBtn, regToLoginBtn;
    FirebaseAuth fAuth;
    TextView welcome,welcome_slogan;
    Animation topAim;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();
        regName = findViewById(R.id.reg_name);
        regEmail = findViewById(R.id.reg_email);
        regPassword = findViewById(R.id.reg_password);
        regPhone = findViewById(R.id.reg_phone);
        regBtn = findViewById(R.id.reg_btn);
        regToLoginBtn = findViewById(R.id.reg_login_btn);

        topAim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        welcome=findViewById(R.id.welcome);
        welcome_slogan=findViewById(R.id.welcome_slogan);

        welcome.setAnimation(topAim);
        welcome_slogan.setAnimation(topAim);


        regToLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
            }
        });


        fAuth=FirebaseAuth.getInstance();

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                registerUser(v);

            }
        });
    }

// Save data in firebase on button click
    public void registerUser(View view) {


        String name = regName.getEditText().getText().toString();
        String email = regEmail.getEditText().getText().toString();
        String phone = regPhone.getEditText().getText().toString();
        String password = regPassword.getEditText().getText().toString();


        if(name.isEmpty()){
            regName.setError("Full name is required");
            return;
        }

        if(email.isEmpty()){
            regEmail.setError("Email is required");
            return;
        }

        if(phone.isEmpty()){
            regPhone.setError("Phone no is required");
            return;
        }
        if(password.isEmpty()){
            regPassword.setError("Password is required");
            return;
        }
        Toast.makeText(this, "Data is validated", Toast.LENGTH_SHORT).show();

        fAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                startActivity(new Intent(getApplicationContext(),UserHome.class));
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignUp.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        UserHelperClass helperClass = new UserHelperClass(name, phone, email, password);


        reference.child(phone).setValue(helperClass);
    }
}