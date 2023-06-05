package com.example.progettoium;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

public class InfoActivity extends AppCompatActivity {

    CardView andata, ritorno;
    ScrollView scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        scroll = findViewById(R.id.scroll);
        andata = findViewById(R.id.andata);
        ritorno = findViewById(R.id.ritorno);

        ritorno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scroll.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });

        andata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scroll.fullScroll(ScrollView.FOCUS_UP);
            }
        });
    }

    public void ClickDisdici(View view){
        redirectActivity(this, DisdiciActivity.class);
    }

    public void ClickBack(View view){
        finish();
    }

    private void redirectActivity(Activity old_activity, Class new_activity) {
        Intent intent = new Intent(old_activity, new_activity);
        old_activity.startActivity(intent);
    }
}