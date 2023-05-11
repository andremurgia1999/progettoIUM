package com.example.progettoium;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout textInputLayoutUsername, textInputLayoutPassword;
    TextInputEditText textInputEditTextUsername, textInputEditTextPassword;
    Button buttonLogin;

    TextView errorLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputLayoutUsername = findViewById(R.id.textInputLayoutUsername);
        textInputEditTextUsername = findViewById(R.id.textInputEditTextUsername);
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);
        textInputEditTextPassword = findViewById(R.id.textInputEditTextPassword);
        buttonLogin = findViewById(R.id.ButtonLogin);
        errorLogin = findViewById(R.id.errorLogin);

        textInputEditTextUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==0){
                    textInputLayoutUsername.setError("Inserire username");
                }
                else{
                    textInputLayoutUsername.setErrorEnabled(false);
                }
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==0){
                    textInputLayoutUsername.setError("Inserire username");
                }
                else{
                    textInputLayoutUsername.setErrorEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()==0){
                    textInputLayoutUsername.setError("Inserire username");
                }
                else{
                    textInputLayoutUsername.setErrorEnabled(false);
                }
            }
        });

        textInputEditTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==0){
                    textInputLayoutPassword.setError("Inserire password");
                }
                else{
                    textInputLayoutPassword.setErrorEnabled(false);
                }
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==0){
                    textInputLayoutPassword.setError("Inserire password");
                }
                else{
                    textInputLayoutPassword.setErrorEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()==0){
                    textInputLayoutPassword.setError("Inserire password");
                }
                else{
                    textInputLayoutPassword.setErrorEnabled(false);
                }
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkInput()) {
                    if (textInputEditTextUsername.getText().toString().compareTo("IUM2023") != 0
                     || textInputEditTextPassword.getText().toString().compareTo("#Ium2023") != 0) {
                        errorLogin.setVisibility(View.VISIBLE);
                    }else {
                        errorLogin.setVisibility(View.GONE);
                        finish();
                        MainActivity.isLogged(getApplicationContext());
                    }
                }
            }
        });
    }

    public boolean checkInput(){
        int errors = 0;

        if(textInputEditTextUsername.getText().toString().length() == 0) {
            textInputLayoutUsername.setError("Inserire username");
            errors++;
        }
        if(textInputEditTextPassword.getText().toString().length() == 0){
            textInputLayoutPassword.setError("Inserire password");
            errors++;
        }
        return errors == 0;
    }

    public void ClickBack(View view){
        finish();
    }

    public void ClickRegistrati2(View view){
        redirectActivity(this, RegistrationActivity.class);
    }

    private void redirectActivity(Activity old_activity, Class new_activity) {
        Intent intent = new Intent(old_activity, new_activity);
        old_activity.startActivity(intent);
    }
}