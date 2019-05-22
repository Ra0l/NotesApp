package com.raul.notesapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.raul.notesapp.R;
import com.raul.notesapp.models.User;
import com.raul.notesapp.repositories.UserRepository;

public class LoginActivity extends AppCompatActivity {

    private EditText userInput;
    private EditText passwordInput;
    private Button loginButton;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userInput=findViewById(R.id.user_input_login);
        passwordInput=findViewById(R.id.password_input_login);

        loginButton=findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callLogin();
            }
        });


        registerButton = findViewById(R.id.register_button2);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRegister();
            }
        });
        verifySession();
    }

    private void showRegister(){
        startActivity(new Intent(this, RegisterActivity.class));
    }
    private void callLogin(){
        String username = userInput.getText().toString();
        String password = passwordInput.getText().toString();

        if (username.isEmpty()||password.isEmpty()){
            Toast.makeText(this, "Complete todo los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        //Login process

        User user= UserRepository.login(username,password);
        if(user == null){
            Toast.makeText(this,"Usuario and password invalido",Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        boolean success = sp.edit().putString("user",username).
                putLong("id",user.getId()).
                putBoolean("idlogged",true).
                commit();

        goMain();

        startActivity(new Intent(this, NotasActivity.class));
        finish();

    }
    private void verifySession(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        if(sp.getBoolean("islogged",false)){
            goMain();
        }
    }
    private void goMain(){
        startActivity(new Intent(this,NotasActivity.class));
        finish();
    }
}
