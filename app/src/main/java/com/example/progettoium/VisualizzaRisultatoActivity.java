package com.example.progettoium;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

public class VisualizzaRisultatoActivity extends AppCompatActivity {

    CardView andata, ritorno;
    ScrollView scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizza_risultato);

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
}