package com.daniloarantes.horas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.util.Calendar;

public class Activity_EntradaSaida extends AppCompatActivity {

    TimePickerDialog timePickerDialog;
    TextView eTEntrada;
    Calendar calendar;
    int currentHour;
    int currentMinute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__entrada_saida);

        eTEntrada = findViewById(R.id.eTEntrada);

        eTEntrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(Activity_EntradaSaida.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        eTEntrada.setText(hourOfDay + ":" + minute);
                    }
                }, currentHour, currentMinute, true);
                timePickerDialog.show();

            }
        });

    }
}
