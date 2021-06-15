package com.example.easyfix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.time.Clock;

public class SignUp extends AppCompatActivity {

    AppCompatEditText textInputEditTextFullname, textInputEditTextUsername, textInputEditTextPassword, textInputEditTextEmail;
    Button buttonSignUp;
    TextView textViewLogin;
    ProgressBar progressBar;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        textInputEditTextFullname = findViewById(R.id.fullname);
        textInputEditTextUsername = findViewById(R.id.username);
        textInputEditTextPassword = findViewById(R.id.password);
        textInputEditTextEmail = findViewById(R.id.email);

        buttonSignUp = findViewById(R.id.buttonSignup);
        textViewLogin = findViewById(R.id.LoginText);
        progressBar = findViewById(R.id.progress);



        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
            }
        });

        buttonSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String fullname, username, password, email;
                fullname = String.valueOf(textInputEditTextFullname.getText());
                username = String.valueOf(textInputEditTextUsername.getText());
                password = String.valueOf(textInputEditTextPassword.getText());
                email = String.valueOf(textInputEditTextEmail.getText());
                Intent Login = new Intent(SignUp.this, Login.class);
                startActivity(Login);
                System.out.println("fullname: " + fullname + "email: " + email);

                DbHandler dbHandler = new DbHandler( SignUp.this);

                if (!fullname.equals("") && !username.equals("") && !password.equals("") && !email.equals("")) {
                    dbHandler.insertUserDetails(fullname,username,password,email);
                    progressBar.setVisibility(View.VISIBLE);


                    Handler handler = new Handler();
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            String[] field = new String[4];
//                            field[0] = "fullname";
//                            field[1] = "username";
//                            field[2] = "password";
//                            field[3] = "email";
//                            System.out.println();
//                            String[] data = new String[4];
//                            data[0] = "fullname";
//                            data[1] = "username";
//                            data[2] = "password";
//                            data[3] = "email";
//                            PutData putData = new PutData("https://192.168.178.39/LoginRegister/signup.php", "POST", field, data);
//                            if (putData.startPut()) {
//                                if (putData.onComplete()) {
//                                    progressBar.setVisibility(View.GONE);
//                                    String result = putData.getResult();
//                                    if(result.equals("Sign Up Success")){
//                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
//                                        Intent intent = new Intent(getApplicationContext(), Login.class);
//                                        startActivity(intent);
//                                        finish();
//
//                                    }
//
//                                    else {
//                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//                            }
//                        }
//                    });
                }

                else {
                    Toast.makeText(getApplicationContext(),"All fields required", Toast.LENGTH_SHORT).show();
                }
            }
        });








    }
}