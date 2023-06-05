package com.example.progettoium;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ConfermaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conferma);
    }

    public void ClickBack(View view){
        finish();
    }

    public void ClickChiudi(View view){
        redirectActivity(this, MainActivity.class);
    }

    private void redirectActivity(Activity old_activity, Class new_activity) {
        Intent intent = new Intent(old_activity, new_activity);
        old_activity.startActivity(intent);
    }
}