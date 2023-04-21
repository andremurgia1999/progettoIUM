package com.example.progettoium;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.InputType;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextInputEditText dataPartenzaText, dataArrivoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataPartenzaText = findViewById(R.id.textInputEditTextDataPartenza);
        dataArrivoText = findViewById(R.id.textInputEditTextDataArrivo);

        dataPartenzaText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    dataPartenzaText.setRawInputType(InputType.TYPE_NULL); //per non fare uscire la tastiera
                    new DatePickerFragment().show(
                            getSupportFragmentManager(), DatePickerFragment.TAG);
                }
            }
        });

        dataArrivoText.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    dataArrivoText.setRawInputType(InputType.TYPE_NULL); //per non fare uscire la tastiera
                    new DatePickerFragment2().show(
                            getSupportFragmentManager(), DatePickerFragment2.TAG);
                }
            }
        });
    }

    public void doPositiveClick(Calendar date){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        dataPartenzaText.setText(format.format(date.getTime()));
    }

    public void doPositiveClick2(Calendar date){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        dataArrivoText.setText(format.format(date.getTime()));
    }
}