package com.example.easyfix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.annotation.SuppressLint;
import android.content.Context;
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

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {

    AppCompatEditText textInputEditTextUsername, textInputEditTextPassword;
    Button buttonLogin;
    TextView textViewSignup;
    ProgressBar progressBar;
    Button btnSave;
    Button xxx;
    TextView textVieweeSignup;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputEditTextUsername = findViewById (R.id.UsernameLogin);
        textInputEditTextPassword = findViewById(R.id.PasswordLogin);
        buttonLogin = findViewById(R.id.ButtonLogin);
        textViewSignup = findViewById(R.id.signUpText);
        progressBar = findViewById(R.id.progresslogin);

        textViewSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);
                finish();
            }
        });
        

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username, password;

                username = String.valueOf(textInputEditTextUsername.getText());
                password = String.valueOf(textInputEditTextPassword.getText());
                DbHandler dbHandler = new DbHandler( Login.this);

                    if(dbHandler.checkUserExist(username,password)) {
                        progressBar.setVisibility(View.VISIBLE);
                        Intent userDetails = new Intent(Login.this, UserDetails.class);

                        userDetails.putExtra("username",username);
                        Bundle bundle=new Bundle();
                        bundle.putString("username",username);
                        userDetails.putExtra("bundle",bundle);

                        startActivity(userDetails);

                    } else {
                        Toast.makeText(getApplicationContext(),"username or password is incorrect", Toast.LENGTH_SHORT).show();
                    }


//                    Handler handler = new Handler();
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            String[] field = new String[2];
//                            field[0] = "username";
//                            field[1] = "password";
//
//
//                            String[] data = new String[2];
//                            data[0] = "username";
//                            data[1] = "password";
//                            PutData putData = new PutData("https://192.168.178.39/LoginRegister/login.php", "POST", field, data);
//                            if (putData.startPut()) {
//                                if (putData.onComplete()) {
//                                    progressBar.setVisibility(View.GONE);
//                                    String result = putData.getResult();
//                                    if(result.equals("login Success")){
//                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
//                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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
//                    }
//                    );
                }
        });

    }
}