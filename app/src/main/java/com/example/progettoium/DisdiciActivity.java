package com.example.progettoium;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DisdiciActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disdici);
    }

    public void ClickBack(View view){
        finish();
    }

    public void ClickAnnulla(View view){
        finish();
    }

    public void ClickDisdetta(View view){
        redirectActivity(this,MiePrenotazioni.class);
        Toast.makeText(getApplicationContext(), "La sua prenotazione è stata cancellata, la ringraziamo.", Toast.LENGTH_LONG).show();
    }

    private void redirectActivity(Activity old_activity, Class new_activity) {
        Intent intent = new Intent(old_activity, new_activity);
        old_activity.startActivity(intent);
    }
}