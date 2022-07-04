package com.example.edutrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private  static int SPLASH_SCREEN=3000;

    Animation bottomAim,topAim;
    TextView logo,slogan;
    ImageView applogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        topAim=AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //Hooks

        applogo=findViewById(R.id.applogo);
        logo=findViewById(R.id.textView);
        slogan=findViewById(R.id.textView2);

        applogo.setAnimation(topAim);
        logo.setAnimation(bottomAim);
        slogan.setAnimation(bottomAim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);


    }
}