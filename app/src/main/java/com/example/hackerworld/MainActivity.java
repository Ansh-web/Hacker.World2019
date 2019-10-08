package com.example.hackerworld;

import android.content.Intent;
import android.os.Handler;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView splashscreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        splashscreen=findViewById(R.id.logo);
        Animation animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.myanim);;
        splashscreen.startAnimation(animation);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, signup1.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
