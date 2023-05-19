package com.example.progettoium;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RisultatiActivity extends AppCompatActivity {

    LinearLayout expended, lista_filtri, spazio;
    RelativeLayout expand;

    ImageView su, giu;

    TextView piu, meno;

    Button ordina, filtra;
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

        ordina = findViewById(R.id.ordina);
        lista_filtri = findViewById(R.id.lista_filtri);
        spazio = findViewById(R.id.spazio);
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

        ordina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lista_filtri.getVisibility() == View.GONE) {
                    lista_filtri.setVisibility(View.VISIBLE);
                    ordina.setBackgroundColor(getResources().getColor(R.color.back_grey));
                    ordina.setTextColor(getResources().getColor(R.color.border_grey));
                    spazio.setVisibility(View.VISIBLE);
                }
                else{
                    lista_filtri.setVisibility(View.GONE);
                    ordina.setBackgroundColor(getResources().getColor(R.color.turchese));
                    ordina.setTextColor(getResources().getColor(R.color.white));
                    spazio.setVisibility(View.GONE);
                }
            }
        });


    }
}