package com.example.progettoium;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class NumeroPasseggeri extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(requireContext())
                .setMessage("Numero di passeggeri")
                .setView(R.layout.numero_passeggeri)
                .setPositiveButton("ok", (dialog, which) -> {
                    //se premo ok
                    ((MainActivity)getActivity()).cambiaPasseggeri();
                } )
                .create();
    }

    public static String TAG = "NumeroPasseggeri";
}
