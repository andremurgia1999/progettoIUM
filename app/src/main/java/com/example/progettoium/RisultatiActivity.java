package com.example.progettoium;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RisultatiActivity extends AppCompatActivity {

    LinearLayout expended;
    RelativeLayout expand;

    ImageView su, giu;

    TextView piu, meno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risultati);

        expand = findViewById(R.id.expand);
        expended = findViewById(R.id.expended);
        piu = findViewById(R.id.piu);
        meno = findViewById(R.id.meno);
        su = findViewById(R.id.su);
        giu = findViewById(R.id.giu);

        piu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expended.setVisibility(View.VISIBLE);
                piu.setVisibility(View.GONE);
                giu.setVisibility(View.GONE);
            }
        });

        meno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expended.setVisibility(View.GONE);
                piu.setVisibility(View.VISIBLE);
                giu.setVisibility(View.VISIBLE);
            }
        });


    }
}