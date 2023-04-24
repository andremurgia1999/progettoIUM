package com.example.progettoium;

import static androidx.core.content.ContentProviderCompat.requireContext;

import static com.google.android.material.internal.ContextUtils.getActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextInputEditText dataPartenzaText, dataArrivoText, passeggeriText;
    Button cercaVoli;


    Button piuAdulti, menoAdulti, piuBambini, menoBambini, piuNeonati, menoNeonati;

    TextView numeroAdulti, numeroBambini, numeroNeonati, textNumeroAdulti, textNumeroBambini, textNumeroNeonati;

    int valoreAdulti=0, valoreBambini=0, valoreNeonati=0, valoreMinimo=0, valoreMassimo=20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataPartenzaText = findViewById(R.id.textInputEditTextDataPartenza);
        dataArrivoText = findViewById(R.id.textInputEditTextDataArrivo);
        passeggeriText = findViewById(R.id.textInputEditTextNumeroPasseggeri);

        cercaVoli = findViewById(R.id.ButtonCercaVoli);
        dataPartenzaText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    dataPartenzaText.setRawInputType(InputType.TYPE_NULL); //per non fare uscire la tastiera
                    new DatePickerFragment().show(
                            getSupportFragmentManager(), DatePickerFragment.TAG);
                }
                dataPartenzaText.clearFocus();
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
                dataArrivoText.clearFocus();
            }
        });

        passeggeriText.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    passeggeriText.setRawInputType(InputType.TYPE_NULL); //per non fare uscire la tastiera

                    LayoutInflater linf = LayoutInflater.from(MainActivity.this);
                    final View inflator = linf.inflate(R.layout.numero_passeggeri, null);
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

                    alert.setView(inflator);

                    piuAdulti = (Button) inflator.findViewById(R.id.piuAdulti);
                    menoAdulti = (Button) inflator.findViewById(R.id.menoAdulti);
                    numeroAdulti = (TextView) inflator.findViewById(R.id.numeroAdulti);
                    numeroAdulti.setText(""+valoreAdulti);
                    textNumeroAdulti = (TextView) inflator.findViewById(R.id.textNumeroAdulti);
                    textNumeroAdulti.setText(valoreAdulti+" adulti");

                    piuAdulti.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            updateAdulti(++valoreAdulti);
                        }
                    });

                    menoAdulti.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            updateAdulti(--valoreAdulti);
                        }
                    });

                    piuBambini = (Button) inflator.findViewById(R.id.piuBambini);
                    menoBambini = (Button) inflator.findViewById(R.id.menoBambini);
                    numeroBambini = (TextView) inflator.findViewById(R.id.numeroBambini);
                    textNumeroBambini = (TextView) inflator.findViewById(R.id.textNumeroBambini);
                    numeroBambini.setText(""+valoreBambini);
                    textNumeroBambini = (TextView) inflator.findViewById(R.id.textNumeroBambini);
                    textNumeroBambini.setText(valoreBambini+" bambini");

                    piuBambini.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            updateBambini(++valoreBambini);
                        }
                    });

                    menoBambini.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            updateBambini(--valoreBambini);
                        }
                    });

                    piuNeonati = (Button) inflator.findViewById(R.id.piuNeonati);
                    menoNeonati = (Button) inflator.findViewById(R.id.menoNeonati);
                    numeroNeonati = (TextView) inflator.findViewById(R.id.numeroNeonati);
                    numeroNeonati.setText(""+valoreNeonati);
                    textNumeroNeonati = (TextView) inflator.findViewById(R.id.textNumeroNeonati);
                    textNumeroNeonati.setText(valoreNeonati+" neonati");
                    piuNeonati.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            updateNeonati(++valoreNeonati);
                        }

                    });

                    menoNeonati.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            updateNeonati(--valoreNeonati);
                        }
                    });

                    alert.setPositiveButton("ok", (dialog, which) -> {
                       passeggeriText.setText(valoreAdulti+" Adulti, "+valoreBambini+" Bambini, "+valoreNeonati+" Neonati");
                    });

                    alert.setNegativeButton("annulla", (dialog, which) -> {
                        passeggeriText.setText(null);
                        valoreAdulti=0;
                        valoreBambini=0;
                        valoreNeonati=0;
                    });

                    alert.show();
                }
                passeggeriText.clearFocus();
            }
        });
    }

    public void doPositiveClick(Calendar date){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        dataPartenzaText.setText(format.format(date.getTime()));
    }
    public void doNegativeClick(){
        dataPartenzaText.setText(null);
    }
    public void doNegativeClick2(){
        dataArrivoText.setText(null);
    }

    public void doPositiveClick2(Calendar date){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        dataArrivoText.setText(format.format(date.getTime()));
    }

    public void cambiaPasseggeri(){
        passeggeriText.setText("Ciao");
    }

    protected void updateAdulti(int nuovoValore){
        nuovoValore = nuovoValore>valoreMassimo ? valoreMassimo : nuovoValore;
        nuovoValore = nuovoValore<valoreMinimo ? valoreMinimo : nuovoValore;
        this.valoreAdulti = nuovoValore;
        numeroAdulti.setText(""+this.valoreAdulti);
        textNumeroAdulti.setText(this.valoreAdulti+" adulti");
    }

    protected void updateBambini(int nuovoValore){
        nuovoValore = nuovoValore>valoreMassimo ? valoreMassimo : nuovoValore;
        nuovoValore = nuovoValore<valoreMinimo ? valoreMinimo : nuovoValore;
        this.valoreBambini = nuovoValore;
        numeroBambini.setText(""+this.valoreBambini);
        textNumeroBambini.setText(this.valoreBambini+" bambini");
    }

    protected void updateNeonati(int nuovoValore){
        nuovoValore = nuovoValore>valoreMassimo ? valoreMassimo : nuovoValore;
        nuovoValore = nuovoValore<valoreMinimo ? valoreMinimo : nuovoValore;
        this.valoreNeonati = nuovoValore;
        numeroNeonati.setText(""+this.valoreNeonati);
        textNumeroNeonati.setText(this.valoreAdulti+" neonati");
    }
}