package com.example.hackerworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class signup1 extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextEmail;
    private EditText editTextPassword;

    private Button buttonRegister;
    private TextView text_login;
    private FirebaseAuth firebaseAuth;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1);


        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        buttonRegister = findViewById(R.id.buttonRegister);
        text_login = findViewById(R.id.text_login);
        firebaseAuth = FirebaseAuth.getInstance();
        buttonRegister.setOnClickListener(this);
        text_login.setOnClickListener(this);


    }

    public void registerUser() {

        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();


        if (TextUtils.isEmpty(email)) {
            Toast.makeText(signup1.this, "Please enter email", Toast.LENGTH_SHORT).show();

        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(signup1.this, "Please enter Password", Toast.LENGTH_SHORT).show();

        } else if (password.length() < 6) {
            Toast.makeText(signup1.this, "Password too Short", Toast.LENGTH_SHORT).show();


        } else {
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(signup1.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                Toast.makeText(signup1.this, "Registration Success", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), Homeactivity.class));
                            } else {
                                Toast.makeText(signup1.this, "Failed to Register", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

        }
    }

    @Override
    public void onClick(View view) {
        if (view == buttonRegister) {
            registerUser();
        }

        if (view == text_login) {

            startActivity(new Intent(this, login.class));

        }

    }
}




