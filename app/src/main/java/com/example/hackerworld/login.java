package com.example.hackerworld;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;




public class login extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonSignin;
    private TextView text_Signup;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignin = findViewById(R.id.buttonSignin);
        text_Signup = findViewById(R.id.text_Signup);
        firebaseAuth = FirebaseAuth.getInstance();

        buttonSignin.setOnClickListener(this);
        text_Signup.setOnClickListener(this);


    }

    public void userlogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(login.this, "Please enter email", Toast.LENGTH_SHORT).show();

        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(login.this, "Please enter Password", Toast.LENGTH_SHORT).show();

        } else if (password.length() < 6) {
            Toast.makeText(login.this, "Password too Short", Toast.LENGTH_SHORT).show();


        } else {
            firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(login.this,"Hey Welcome Back",Toast.LENGTH_SHORT).show();

                                startActivity(new Intent(getApplicationContext(), Homeactivity.class));



                            }

                            else {
                                Toast.makeText(login.this,"Failed to login",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


        }
    }


    @Override
    public void onClick(View view) {
        if (view == buttonSignin) {
            userlogin();
        }
        if (view == text_Signup) {

            startActivity(new Intent(this, signup1.class));
        }

    }
}