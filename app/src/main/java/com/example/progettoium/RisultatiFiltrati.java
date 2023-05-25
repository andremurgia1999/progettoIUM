package com.example.progettoium;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class RisultatiFiltrati extends AppCompatActivity {

    TextView progress_prezzo, progress_durata, progress_partenza, progress_arrivo;
    ProgressBar progressBar;
    SeekBar seekBar_prezzo, seekBar_durata, seekBar_partenza, seekBar_arrivo;

    LinearLayout lista_filtri;

    RelativeLayout click_compagnie_aeree;

    ImageView su, su2, giu, giu2;

    TextView qualsiasi;

    Switch easy_switch;

    Button buttonFiltra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risultati_filtrati);

        progress_prezzo = findViewById(R.id.progress);
        progressBar = findViewById(R.id.progressBar);
        seekBar_prezzo = findViewById(R.id.seekBar);

        lista_filtri = findViewById(R.id.lista_filtri);
        click_compagnie_aeree = findViewById(R.id.click_compagnie_aeree);

        easy_switch = findViewById(R.id.easy_switch);

        su = findViewById(R.id.su);
        su2 = findViewById(R.id.su2);
        giu = findViewById(R.id.giu);
        giu2 = findViewById(R.id.giu2);

        qualsiasi = findViewById(R.id.qualsiasi);

        seekBar_durata = findViewById(R.id.seekBar3);
        progress_durata = findViewById(R.id.progress3);

        seekBar_partenza = findViewById(R.id.seekBar1);
        progress_partenza = findViewById(R.id.progress1);

        seekBar_arrivo = findViewById(R.id.seekBar2);
        progress_arrivo = findViewById(R.id.progress2);

        buttonFiltra = findViewById(R.id.ButtonFiltra);

        seekBar_prezzo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progressBar.setProgress(i);
                progress_prezzo.setText("€ "+i);

                if(progress_prezzo.getText().toString().compareTo("€ 0")==0){
                    progress_durata.setText("Qualsiasi");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar_durata.setMax(24 * 2); //24 hours and 4 step in one hour.
        seekBar_durata.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int hours = i / 2; // it will return hours.
                int minutes = (i % 2) * 30; // here will be minutes.

                progress_durata.setText(hours + "h " + minutes + "m");

                if(progress_durata.getText().toString().compareTo("0h 0m")==0){
                    progress_durata.setText("Qualsiasi");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar_partenza.setMax(24 * 2); //24 hours and 4 step in one hour.
        seekBar_partenza.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int hours = i / 2; // it will return hours.
                int minutes = (i % 2) * 30; // here will be minutes.

                if(hours<10){
                    if(minutes==30)
                        progress_partenza.setText("dopo le ore: 0"+hours + ":" + minutes);
                    else
                        progress_partenza.setText("dopo le ore: 0"+hours + ":00");
                }
                else {
                    if(minutes==30)
                        progress_partenza.setText("dopo le ore: " + hours + ":" + minutes);
                    else
                        progress_partenza.setText("dopo le ore: " + hours + ":00");
                }

                if(progress_partenza.getText().toString().compareTo("dopo le ore: 00:00")==0){
                    progress_partenza.setText("dopo le ore: Qualsiasi");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar_arrivo.setMax(24 * 2); //24 hours and 4 step in one hour.
        seekBar_arrivo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int hours = i / 2; // it will return hours.
                int minutes = (i % 2) * 30; // here will be minutes.

                if(hours<10){
                    if(minutes==30)
                        progress_arrivo.setText("dopo le ore: 0"+hours + ":" + minutes);
                    else
                        progress_arrivo.setText("dopo le ore: 0"+hours + ":00");
                }
                else {
                    if(minutes==30)
                        progress_arrivo.setText("dopo le ore: " + hours + ":" + minutes);
                    else
                        progress_arrivo.setText("dopo le ore: " + hours + ":00");
                }

                if(progress_arrivo.getText().toString().compareTo("dopo le ore: 00:00")==0){
                    progress_arrivo.setText("dopo le ore: Qualsiasi");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        click_compagnie_aeree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lista_filtri.setVisibility(View.VISIBLE);
                giu.setVisibility(View.GONE);
                su.setVisibility(View.VISIBLE);
            }
        });

        easy_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(!b){
                    qualsiasi.setText("ITA Airways, Ryanair, AirItaly");
                    su2.setVisibility(View.VISIBLE);
                }
            }
        });

        su.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lista_filtri.setVisibility(View.GONE);
                giu.setVisibility(View.VISIBLE);
                su.setVisibility(View.GONE);
            }
        });

        su2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lista_filtri.setVisibility(View.GONE);
                giu2.setVisibility(View.VISIBLE);
                su2.setVisibility(View.GONE);
            }
        });

        giu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lista_filtri.setVisibility(View.VISIBLE);
                giu2.setVisibility(View.GONE);
                su2.setVisibility(View.VISIBLE);
            }
        });

        buttonFiltra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    public void ClickBack(View view){
        finish();
    }

    private void redirectActivity(Activity old_activity, Class new_activity) {
        Intent intent = new Intent(old_activity, new_activity);
        old_activity.startActivity(intent);
    }
}