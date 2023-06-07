package com.example.progettoium;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PrenotazioneActivity extends AppCompatActivity {

    TextInputLayout textInputLayoutData;

    TextInputEditText textInputEditTextData;

    Calendar date = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prenotazione);

        textInputLayoutData = findViewById(R.id.textInputLayoutData);
        textInputEditTextData = findViewById(R.id.textInputEditTextData);

        textInputEditTextData.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    textInputEditTextData.setRawInputType(InputType.TYPE_NULL); //per non fare uscire la tastiera

                    //DatePicker datePicker = new DatePicker(RegistrationActivity.this);
                    AlertDialog.Builder datePickerDialog = new AlertDialog.Builder(PrenotazioneActivity.this);

                    LayoutInflater inflater = LayoutInflater.from(PrenotazioneActivity.this);
                    DatePicker datePicker = (DatePicker)inflater.inflate(R.layout.date_spinner,null);

                    datePicker.setMaxDate(System.currentTimeMillis() - 1000);
                    datePickerDialog.setView(datePicker);
                    datePickerDialog.setMessage("Data di nascita");
                    datePickerDialog.setPositiveButton("ok", (dialog, which) -> {
                        //se premo ok
                        date.set(Calendar.YEAR, datePicker.getYear());
                        date.set(Calendar.MONTH, datePicker.getMonth());
                        date.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());
                        doPositiveClick(date);
                    });
                    datePickerDialog.setNegativeButton("annulla", (dialog, wich)-> {
                        datePicker.setMaxDate(System.currentTimeMillis() - 1000);
                        doNegativeClick();
                    });
                    datePickerDialog.show();
                }
                textInputEditTextData.clearFocus();
            }
        });
    }

    public void ClickPosti(View view){
        redirectActivity(this, PostiActivity.class);
    }

    public void ClickPaga(View view){
        redirectActivity(this, ConfermaActivity.class);
    }

    public void ClickBack(View view){
        finish();
    }

    private void redirectActivity(Activity old_activity, Class new_activity) {
        Intent intent = new Intent(old_activity, new_activity);
        old_activity.startActivity(intent);
    }

    public void doPositiveClick(Calendar date){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        textInputEditTextData.setText(format.format(date.getTime()));
        textInputLayoutData.setErrorEnabled(false);
    }

    public void doNegativeClick(){
        textInputLayoutData.setErrorEnabled(false);
        textInputEditTextData.setText(null);
    }

}

