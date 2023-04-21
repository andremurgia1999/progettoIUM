package com.example.progettoium;

import android.app.Dialog;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment2 extends DialogFragment {
    private Calendar date;

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        DatePicker datePicker = new DatePicker(getActivity());
        date = Calendar.getInstance();

        return new AlertDialog.Builder(requireContext())
                .setMessage("Data di arrivo")
                .setView(datePicker)
                .setPositiveButton("ok", (dialog, which) -> {
                    //se premo ok
                    date.set(Calendar.YEAR, datePicker.getYear());
                    date.set(Calendar.MONTH, datePicker.getMonth());
                    date.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());

                    ((MainActivity)getActivity()).doPositiveClick2(date);
                } )
                .create();
    }
    public static String TAG = "DatePickerDialog2";
}
