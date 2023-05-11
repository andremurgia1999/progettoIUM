package com.example.progettoium;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationActivity extends AppCompatActivity {

    TextInputLayout textInputLayoutNome, textInputLayoutCognome, textInputLayoutData, textInputLayoutCF, textInputLayoutCellulare,
                    textInputLayoutEmail, textInputLayoutUsernameReg, textInputLayoutPasswordReg, textInputLayoutPasswordRepeat;

    TextInputEditText textInputEditTextNome, textInputEditTextCognome, textInputEditTextData, textInputEditTextCF, textInputEditTextCellulare,
                      textInputEditTextEmail, textInputEditTextUsernameReg, textInputEditTextPasswordReg, textInputEditTextPasswordRepeat;

    Button buttonRegistrati;

    Calendar date = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        textInputLayoutNome = findViewById(R.id.textInputLayoutNome);
        textInputLayoutCognome = findViewById(R.id.textInputLayoutCognome);
        textInputLayoutData = findViewById(R.id.textInputLayoutData);
        textInputLayoutCF = findViewById(R.id.textInputLayoutCF);
        textInputLayoutCellulare = findViewById(R.id.textInputLayoutCellulare);
        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        textInputLayoutUsernameReg = findViewById(R.id.textInputLayoutUsernameReg);
        textInputLayoutPasswordReg = findViewById(R.id.textInputLayoutPasswordReg);
        textInputLayoutPasswordRepeat = findViewById(R.id.textInputLayoutPasswordRepeat);

        textInputEditTextNome = findViewById(R.id.textInputEditTextNome);
        textInputEditTextCognome = findViewById(R.id.textInputEditTextCognome);
        textInputEditTextData = findViewById(R.id.textInputEditTextData);
        textInputEditTextCF = findViewById(R.id.textInputEditTextCF);
        textInputEditTextCellulare = findViewById(R.id.textInputEditTextCellulare);
        textInputEditTextEmail = findViewById(R.id.textInputEditTextEmail);
        textInputEditTextUsernameReg = findViewById(R.id.textInputEditTextUsernameReg);
        textInputEditTextPasswordReg = findViewById(R.id.textInputEditTextPasswordReg);
        textInputEditTextPasswordRepeat = findViewById(R.id.textInputEditTextPasswordRepeat);

        buttonRegistrati = findViewById(R.id.ButtonRegistrati);

        textInputEditTextNome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==0){
                    textInputLayoutNome.setError("Inserire nome");
                }
                else {
                    textInputLayoutNome.setErrorEnabled(false);
                    buttonRegistrati.setEnabled(true);
                }
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==0){
                    textInputLayoutNome.setError("Inserire nome");
                }
                else {
                    textInputLayoutNome.setErrorEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()==0){
                    textInputLayoutNome.setError("Inserire nome");
                }
                else {
                    textInputLayoutNome.setErrorEnabled(false);
                }
            }
        });

        textInputEditTextCognome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==0){
                    textInputLayoutCognome.setError("Inserire cognome");
                }
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()!=0){
                    textInputLayoutCognome.setErrorEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()!=0){
                    textInputLayoutCognome.setErrorEnabled(false);
                }
                else{
                    textInputLayoutCognome.setError("Inserire cognome");
                }
            }
        });

        textInputEditTextData.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    textInputEditTextData.setRawInputType(InputType.TYPE_NULL); //per non fare uscire la tastiera

                    //DatePicker datePicker = new DatePicker(RegistrationActivity.this);
                    AlertDialog.Builder datePickerDialog = new AlertDialog.Builder(RegistrationActivity.this);

                    LayoutInflater inflater = LayoutInflater.from(RegistrationActivity.this);
                    DatePicker datePicker = (DatePicker)inflater.inflate(R.layout.date_spinner,null);;

                    datePicker.setMaxDate(System.currentTimeMillis() - 1000);
                    datePickerDialog.setView(datePicker);
                    datePickerDialog.setMessage("Data di nascita");
                    datePickerDialog.setPositiveButton("ok", (dialog, which) -> {
                        //se premo ok
                        date.set(Calendar.YEAR, datePicker.getYear());
                        date.set(Calendar.MONTH, datePicker.getMonth());
                        date.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());
                        doPositiveClick(date);
                    });
                    datePickerDialog.setNegativeButton("annulla", (dialog, wich)-> {
                        datePicker.setMaxDate(System.currentTimeMillis() - 1000);
                        doNegativeClick();
                    });
                    datePickerDialog.show();
                }
                textInputEditTextData.clearFocus();
            }
        });

        textInputEditTextCF.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==0){
                    textInputLayoutCF.setError("Inserire codice fiscale");
                }
                else{
                    textInputLayoutCF.setErrorEnabled(false);
                }
                if(!isValidCF(charSequence.toString())){
                    textInputLayoutCF.setError("Codice fiscale non valido");
                }
                else{
                    textInputLayoutCF.setErrorEnabled(false);
                }
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==0){
                    textInputLayoutCF.setError("Inserire codice fiscale");
                }
                else{
                    textInputLayoutCF.setErrorEnabled(false);
                }
                if(!isValidCF(charSequence.toString())){
                    textInputLayoutCF.setError("Codice fiscale non valido");
                }
                else{
                    textInputLayoutCF.setErrorEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()==0){
                    textInputLayoutCF.setError("Inserire codice fiscale");
                }
                else{
                    textInputLayoutCF.setErrorEnabled(false);
                }
                if(!isValidCF(editable.toString())){
                    textInputLayoutCF.setError("Codice fiscale non valido");
                }
                else{
                    textInputLayoutCF.setErrorEnabled(false);
                }
            }
        });

        textInputEditTextCellulare.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==0){
                    textInputLayoutCellulare.setError("Inserire numero di telefono");
                }
                else{
                    textInputLayoutCellulare.setErrorEnabled(false);
                }
                if(!isValidCell(charSequence.toString())){
                    textInputLayoutCellulare.setError("Numero di telefono non valido");
                }
                else{
                    textInputLayoutCellulare.setErrorEnabled(false);
                }
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==0){
                    textInputLayoutCellulare.setError("Inserire numero di telefono");
                }
                else{
                    textInputLayoutCellulare.setErrorEnabled(false);
                }
                if(!isValidCell(charSequence.toString())){
                    textInputLayoutCellulare.setError("Numero di telefono non valido");
                }
                else{
                    textInputLayoutCellulare.setErrorEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()==0){
                    textInputLayoutCellulare.setError("Inserire numero di telefono");
                }
                else{
                    textInputLayoutCellulare.setErrorEnabled(false);
                }
                if(!isValidCell(editable.toString())){
                    textInputLayoutCellulare.setError("Numero di telefono non valido");
                }
                else{
                    textInputLayoutCellulare.setErrorEnabled(false);
                }
            }
        });

        textInputEditTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==0){
                    textInputLayoutEmail.setError("Inserire email");
                }
                else{
                    textInputLayoutEmail.setErrorEnabled(false);
                }
                if(!isValidEmail(charSequence.toString())){
                    textInputLayoutEmail.setError("Email non valida");
                }
                else{
                    textInputLayoutEmail.setErrorEnabled(false);
                }
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==0){
                    textInputLayoutEmail.setError("Inserire email");
                }
                else{
                    textInputLayoutEmail.setErrorEnabled(false);
                }
                if(!isValidEmail(charSequence.toString())){
                    textInputLayoutEmail.setError("Email non valida");
                }
                else{
                    textInputLayoutEmail.setErrorEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()==0){
                    textInputLayoutEmail.setError("Inserire email");
                }
                else{
                    textInputLayoutEmail.setErrorEnabled(false);
                }
                if(!isValidEmail(editable.toString())){
                    textInputLayoutEmail.setError("Email non valida");
                }
                else{
                    textInputLayoutEmail.setErrorEnabled(false);
                }
            }
        });

        textInputEditTextUsernameReg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==0){
                    textInputLayoutUsernameReg.setError("Inserire username");
                }
                else{
                    textInputLayoutUsernameReg.setErrorEnabled(false);
                }
                if(charSequence.toString().length()<3){
                    textInputLayoutUsernameReg.setError("Username non valido");
                }
                else{
                    textInputLayoutUsernameReg.setErrorEnabled(false);
                }
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==0){
                    textInputLayoutUsernameReg.setError("Inserire username");
                }
                else{
                    textInputLayoutUsernameReg.setErrorEnabled(false);
                }
                if(charSequence.toString().length()<3){
                    textInputLayoutUsernameReg.setError("Username non valido");
                }
                else{
                    textInputLayoutUsernameReg.setErrorEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()==0){
                    textInputLayoutUsernameReg.setError("Inserire email");
                }
                else{
                    textInputLayoutUsernameReg.setErrorEnabled(false);
                }
                if(editable.toString().length()<3){
                    textInputLayoutUsernameReg.setError("Email non valida");
                }
                else{
                    textInputLayoutUsernameReg.setErrorEnabled(false);
                }
            }
        });

        textInputEditTextPasswordReg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==0){
                    textInputLayoutPasswordReg.setError("Inserire password");
                }
                else{
                    textInputLayoutPasswordReg.setErrorEnabled(false);
                }
                if(!isValidPassword(charSequence.toString())){
                    textInputLayoutPasswordReg.setError("La password deve contenere:\n-Almeno 5 caratteri\n" +
                            "-Almeno 1 lettera maiuscola\n-Almeno 1 lettera minuscola\n-Almeno un carattere speciale (@#$%^.,:&+=)");
                }
                else{
                    textInputLayoutPasswordReg.setErrorEnabled(false);
                }
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==0){
                    textInputLayoutPasswordReg.setError("Inserire password");
                }
                else{
                    textInputLayoutPasswordReg.setErrorEnabled(false);
                }
                if(!isValidPassword(charSequence.toString())){
                    textInputLayoutPasswordReg.setError("La password deve contenere:\n-Almeno 5 caratteri\n" +
                            "-Almeno 1 lettera maiuscola\n-Almeno 1 lettera minuscola\n-Almeno un carattere speciale (@#$%^.,:&+=)");
                }
                else{
                    textInputLayoutPasswordReg.setErrorEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()==0){
                    textInputLayoutPasswordReg.setError("Inserire password");
                }
                else{
                    textInputLayoutPasswordReg.setErrorEnabled(false);
                }
                if(!isValidPassword(editable.toString())){
                    textInputLayoutPasswordReg.setError("La password deve contenere:\n-Almeno 5 caratteri\n" +
                            "-Almeno 1 lettera maiuscola\n-Almeno 1 lettera minuscola\n-Almeno un carattere speciale (@#$%^.,:&+=)");
                }
                else{
                    textInputLayoutPasswordReg.setErrorEnabled(false);
                }
            }
        });

        textInputEditTextPasswordRepeat.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==0){
                    textInputLayoutPasswordRepeat.setError("Reinserire password");
                }
                else{
                    textInputLayoutPasswordRepeat.setErrorEnabled(false);
                }
                if(charSequence.toString().compareTo(textInputEditTextPasswordReg.getText().toString()) != 0){
                    textInputLayoutPasswordRepeat.setError("Le due password non corrispondono");
                }
                else{
                    textInputLayoutPasswordRepeat.setErrorEnabled(false);
                }
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==0){
                    textInputLayoutPasswordRepeat.setError("Reinserire password");
                }
                else{
                    textInputLayoutPasswordRepeat.setErrorEnabled(false);
                }
                if(charSequence.toString().compareTo(textInputEditTextPasswordReg.getText().toString()) != 0){
                    textInputLayoutPasswordRepeat.setError("Le due password non corrispondono");
                }
                else{
                    textInputLayoutPasswordRepeat.setErrorEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()==0){
                    textInputLayoutPasswordRepeat.setError("Reinserire password");
                }
                else{
                    textInputLayoutPasswordRepeat.setErrorEnabled(false);
                }
                if(editable.toString().compareTo(textInputEditTextPasswordReg.getText().toString()) != 0){
                    textInputLayoutPasswordRepeat.setError("Le due password non corrispondono");
                }
                else{
                    textInputLayoutPasswordRepeat.setErrorEnabled(false);
                }
            }
        });

        buttonRegistrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkInput()) {
                    finish();
                    Toast.makeText(getApplicationContext(), "Registrazione effettuata, " + textInputEditTextUsernameReg.getText().toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public boolean checkInput(){
        int errors = 0;
        if(textInputEditTextNome.getText().toString().length()==0){
            textInputLayoutNome.setError("Inserire nome");
            errors++;
        }
        if(textInputEditTextCognome.getText().toString().length()==0){
            textInputLayoutCognome.setError("Inserire cognome");
            errors++;
        }
        if(textInputEditTextData.getText().toString().length() == 0){
            textInputLayoutData.setError("Inserire data di nascita");
            errors++;
        }
        if(textInputEditTextCF.getText().toString().length() == 0){
            textInputLayoutCF.setError("Inserire codice fiscale");
            errors++;
        }
        if(!isValidCF(textInputEditTextCF.getText().toString())){
            textInputLayoutCF.setError("Codice fiscale non valido");
            errors++;
        }
        if(textInputEditTextCellulare.getText().toString().length() == 0){
            textInputLayoutCellulare.setError("Inserire numero di telefono");
            errors++;
        }
        if(!isValidCell(textInputEditTextCellulare.getText().toString())){
            textInputLayoutCellulare.setError("Numero di telefono non valido");
            errors++;
        }
        if(textInputEditTextEmail.getText().toString().length() == 0){
            textInputLayoutEmail.setError("Inserire email");
            errors++;
        }
        if(!isValidEmail(textInputEditTextEmail.getText().toString())){
            textInputLayoutEmail.setError("Email non valida");
            errors++;
        }
        if(textInputEditTextUsernameReg.getText().toString().length() == 0){
            textInputLayoutUsernameReg.setError("Inserire username");
            errors++;
        }
        if(textInputEditTextUsernameReg.getText().toString().length() < 3){
            textInputLayoutUsernameReg.setError("Username non valido");
            errors++;
        }
        if(textInputEditTextPasswordReg.getText().toString().length() == 0){
            textInputLayoutPasswordReg.setError("Inserire password");
            errors++;
        }
        if(!isValidPassword(textInputEditTextPasswordReg.getText().toString())){
            textInputLayoutPasswordReg.setError("La password deve contenere:\n-Almeno 5 caratteri\n" +
                    "-Almeno 1 lettera maiuscola\n-Almeno 1 lettera minuscola\n-Almeno un carattere speciale (@#$%^.,:&+=)");
            errors++;
        }
        if(textInputEditTextPasswordRepeat.getText().toString().length() == 0){
            textInputLayoutPasswordRepeat.setError("Reinserire password");
            errors++;
        }
        if(textInputEditTextPasswordRepeat.getText().toString().compareTo(textInputEditTextPasswordReg.getText().toString()) != 0){
            textInputLayoutPasswordRepeat.setError("Le due password non corrispondono");
            errors++;
        }

        return errors == 0;
    }

    public void doPositiveClick(Calendar date){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        textInputEditTextData.setText(format.format(date.getTime()));
        textInputLayoutData.setErrorEnabled(false);
    }

    public void doNegativeClick(){
        textInputLayoutData.setErrorEnabled(false);
        textInputEditTextData.setText(null);
    }

    public void ClickBack(View view){
        finish();
    }

    public static boolean isValidCF(final String cf) {

        Pattern pattern;
        Matcher matcher;
        final String CF_PATTERN = "^([A-Z]{6}[0-9LMNPQRSTUV]{2}[ABCDEHLMPRST]{1}[0-9LMNPQRSTUV]{2}[A-Z]{1}[0-9LMNPQRSTUV]{3}[A-Z]{1})$|([0-9]{11})$";
        pattern = Pattern.compile(CF_PATTERN);
        matcher = pattern.matcher(cf);

        return matcher.matches();
    }

    public static boolean isValidCell(final String cell) {

        Pattern pattern;
        Matcher matcher;
        final String CELL_PATTERN = "[0-9]{9,10}";
        pattern = Pattern.compile(CELL_PATTERN);
        matcher = pattern.matcher(cell);

        return matcher.matches();
    }

    public static boolean isValidEmail(final String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%.,^&+=])(?=\\S+$).{5,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();
    }

}