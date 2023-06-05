package com.example.progettoium;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MiePrenotazioni extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mie_prenotazioni);
    }

    public void ClickInfo(View view){
        redirectActivity(this, InfoActivity.class);
    }

    public void ClickBack(View view){
        finish();
    }

    private void redirectActivity(Activity old_activity, Class new_activity) {
        Intent intent = new Intent(old_activity, new_activity);
        old_activity.startActivity(intent);
    }
}