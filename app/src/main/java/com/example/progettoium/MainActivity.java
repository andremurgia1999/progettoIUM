package com.example.progettoium;

import static androidx.core.content.ContentProviderCompat.requireContext;

import static com.google.android.material.internal.ContextUtils.getActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextInputLayout textInputLayoutPartenza, textInputLayoutArrivo, textInputLayoutDataPartenza, textInputLayoutDataArrivo, textInputLayoutPasseggeri;
    TextInputEditText textInputEditTextPartenza, textInputEditTextArrivo, dataPartenzaText, dataArrivoText, passeggeriText;
    Button cercaVoli;

    Button piuAdulti, menoAdulti, piuBambini, menoBambini, piuNeonati, menoNeonati;

    RadioButton soloAndata, andataRitorno;

    TextView numeroAdulti, numeroBambini, numeroNeonati, textNumeroAdulti, textNumeroBambini, textNumeroNeonati;

    int valoreAdulti=0, valoreBambini=0, valoreNeonati=0, valoreMinimo=0, valoreMassimo=20;

    Long time1, time2;
    Calendar date1 = Calendar.getInstance();
    Calendar date2 = Calendar.getInstance();

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);

        dataPartenzaText = findViewById(R.id.textInputEditTextDataPartenza);
        dataArrivoText = findViewById(R.id.textInputEditTextDataArrivo);
        passeggeriText = findViewById(R.id.textInputEditTextNumeroPasseggeri);

        dataPartenzaText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    dataPartenzaText.setRawInputType(InputType.TYPE_NULL); //per non fare uscire la tastiera

                    DatePicker datePicker = new DatePicker(MainActivity.this);
                    AlertDialog.Builder datePickerDialog = new AlertDialog.Builder(MainActivity.this);

                    datePicker.setMinDate(System.currentTimeMillis() - 1000);
                    datePickerDialog.setView(datePicker);
                    datePickerDialog.setMessage("Data di partenza");
                    datePickerDialog.setPositiveButton("ok", (dialog, which) -> {
                        //se premo ok
                        date1.set(Calendar.YEAR, datePicker.getYear());
                        date1.set(Calendar.MONTH, datePicker.getMonth());
                        date1.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());
                        time1=date1.getTimeInMillis();
                        doPositiveClick(date1);
                    });
                    datePickerDialog.setNegativeButton("annulla", (dialog, wich)-> {
                        datePicker.setMinDate(System.currentTimeMillis() - 1000);
                        doNegativeClick();
                    });
                    datePickerDialog.show();
                }
                dataPartenzaText.clearFocus();
            }
        });

        dataArrivoText.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    dataArrivoText.setRawInputType(InputType.TYPE_NULL); //per non fare uscire la tastiera

                    DatePicker datePicker = new DatePicker(MainActivity.this);
                    AlertDialog.Builder datePickerDialog = new AlertDialog.Builder(MainActivity.this);

                    datePicker.setMinDate(date1.getTimeInMillis() + 86400000);
                    datePickerDialog.setView(datePicker);
                    datePickerDialog.setMessage("Data di partenza");
                    datePickerDialog.setPositiveButton("ok", (dialog, which) -> {
                        //se premo ok
                        date2.set(Calendar.YEAR, datePicker.getYear());
                        date2.set(Calendar.MONTH, datePicker.getMonth());
                        date2.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());
                        time2=date2.getTimeInMillis();
                        doPositiveClick2(date2);
                    });
                    datePickerDialog.setNegativeButton("annulla", (dialog, wich)-> {
                        datePicker.setMinDate(System.currentTimeMillis() + 86400000);
                        doNegativeClick2();
                    });
                    datePickerDialog.show();
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
                       if(valoreAdulti==0 && valoreBambini==0 &&valoreNeonati==0){
                           passeggeriText.setText(null);
                           textInputLayoutPasseggeri.setError("Selezionare almeno un passeggero");
                       }
                       else {
                           textInputLayoutPasseggeri.setErrorEnabled(false);
                       }
                    });

                    alert.setNegativeButton("annulla", (dialog, which) -> {
                        passeggeriText.setText(null);
                    });

                    alert.show();
                }
                passeggeriText.clearFocus();
            }
        });

        cercaVoli = findViewById(R.id.ButtonCercaVoli);
        textInputEditTextPartenza = findViewById(R.id.textInputEditTextPartenza);
        textInputEditTextArrivo = findViewById(R.id.textInputEditTextArrivo);
        textInputLayoutPartenza = findViewById(R.id.textInputLayoutPartenza);
        textInputLayoutArrivo = findViewById(R.id.textInputLayoutArrivo);
        soloAndata = findViewById(R.id.soloAndata);
        andataRitorno = findViewById(R.id.andataRitorno);
        textInputLayoutDataPartenza = findViewById(R.id.textInputLayoutDataPartenza);
        textInputLayoutDataArrivo = findViewById(R.id.textInputLayoutDataArrivo);
        textInputLayoutPasseggeri = findViewById(R.id.textInputLayoutNumeroPasseggeri);

        textInputEditTextPartenza.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==0){
                    textInputLayoutPartenza.setError("Inserire aereoporto di partenza");
                }
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()!=0){
                    textInputLayoutPartenza.setErrorEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()!=0){
                    textInputLayoutPartenza.setErrorEnabled(false);
                }
                else{
                    textInputLayoutPartenza.setError("Inserire aereoporto di partenza");
                }
            }
        });

        textInputEditTextArrivo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==0){
                    textInputLayoutArrivo.setError("Inserire aereoporto di arrivo");
                }
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()!=0){
                    textInputLayoutArrivo.setErrorEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()!=0){
                    textInputLayoutArrivo.setErrorEnabled(false);
                }
                else{
                    textInputLayoutArrivo.setError("Inserire aereoporto di arrivo");
                }
            }
        });

        cercaVoli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textInputEditTextPartenza.getText().toString().length() == 0){
                    textInputLayoutPartenza.setError("Inserire aereoporto di partenza");
                }
                if(textInputEditTextArrivo.getText().toString().length() == 0){
                    textInputLayoutArrivo.setError("Inserire aereoporto di arrivo");
                }
                if(dataPartenzaText.getText().toString().length() == 0){
                    textInputLayoutDataPartenza.setError("Inserire data di partenza");

                }
                if(dataArrivoText.getText().toString().length() == 0){
                    textInputLayoutDataArrivo.setError("Inserire data di arrivo");
                }
                if(passeggeriText.getText().toString().length() == 0){
                    textInputLayoutPasseggeri.setError("Selezionare almeno un passeggero");
                }
                if(time1>time2){
                    textInputLayoutDataPartenza.setError("La data di partenza deve essere precedente rispetto all'arrivo");
                    textInputLayoutDataArrivo.setError("La data di arrivo deve essere successiva rispetto alla partenza");
                }
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.soloAndata:
                if (checked)
                    dataArrivoText.setVisibility(View.GONE);
                    textInputLayoutDataArrivo.setVisibility(View.GONE);
                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)textInputLayoutDataPartenza.getLayoutParams();
                    params.setMarginEnd(65);
                    textInputLayoutDataPartenza.setLayoutParams(params);
                break;
            case R.id.andataRitorno:
                if (checked)
                    dataArrivoText.setVisibility(View.VISIBLE);
                    textInputLayoutDataArrivo.setVisibility(View.VISIBLE);
                    LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams)textInputLayoutDataPartenza.getLayoutParams();
                    params2.setMarginEnd(16);
                    textInputLayoutDataPartenza.setLayoutParams(params2);
                break;
        }
    }

    public void doPositiveClick(Calendar date){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        dataPartenzaText.setText(format.format(date.getTime()));
        textInputLayoutDataPartenza.setErrorEnabled(false);
    }

    public void doNegativeClick(){
        textInputLayoutDataPartenza.setErrorEnabled(false);
        dataPartenzaText.setText(null);
    }

    public void doPositiveClick2(Calendar date){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        dataArrivoText.setText(format.format(date.getTime()));
        textInputLayoutDataArrivo.setErrorEnabled(false);
    }

    public void doNegativeClick2(){
        textInputLayoutDataArrivo.setErrorEnabled(false);
        dataArrivoText.setText(null);
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
        textNumeroNeonati.setText(this.valoreNeonati+" neonati");
    }

    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    private void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    private void closeDrawer(DrawerLayout drawerLayout){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickMenu2(View view){
        openDrawer2(drawerLayout);
    }

    private void openDrawer2(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.END);
    }

    private void closeDrawer2(DrawerLayout drawerLayout){
        if(drawerLayout.isDrawerOpen(GravityCompat.END)){
            drawerLayout.closeDrawer(GravityCompat.END);
        }
    }

    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        closeDrawer(drawerLayout);
    }

    public void ClickLogin(View view){
        closeDrawer2(drawerLayout);
        redirectActivity(this, LoginActivity.class);
    }

    public void ClickRegistrati(View view){
        closeDrawer2(drawerLayout);
        redirectActivity(this, RegistrationActivity.class);
    }

    private void redirectActivity(Activity old_activity, Class new_activity) {
        Intent intent = new Intent(old_activity, new_activity);
        old_activity.startActivity(intent);
    }
}