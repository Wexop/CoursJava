package com.example.coursjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.madrapps.pikolo.HSLColorPicker;
import com.madrapps.pikolo.listeners.SimpleColorSelectionListener;

import java.util.ArrayList;
import java.util.List;

public class ParametrageActivity extends AppCompatActivity {

    private Spinner ColorsSpinner;
    private ConstraintLayout layout;
    private HSLColorPicker colorPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametrage);

        SharedPreferences sharedPreferences = getSharedPreferences("SHARED_PREF", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        ColorsSpinner = (Spinner) findViewById(R.id.ColorSpinner);
        layout = (ConstraintLayout)  findViewById(R.id.parametreLayout);
        colorPicker = (HSLColorPicker) findViewById(R.id.colorPicker);

        List colorList = new ArrayList();
        colorList.add("White");
        colorList.add("Red");
        colorList.add("Blue");
        colorList.add("Black");
        colorList.add("Orange");

        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                colorList
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ColorsSpinner.setAdapter(adapter);

        colorPicker.setColorSelectionListener(new SimpleColorSelectionListener() {
            @Override
            public void onColorSelected(int color) {
                layout.setBackgroundColor(color);
                editor.putString("color", String.valueOf(color));
                editor.commit();
            }
        });

        ColorsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String colorSelected = String.valueOf(ColorsSpinner.getSelectedItem()) ;

                if (colorSelected == "White") {
                    layout.setBackgroundColor(getResources().getColor(R.color.white));
                }
                else if (colorSelected == "Blue") {
                    layout.setBackgroundColor(getResources().getColor(R.color.blue));
                }
                else if (colorSelected == "Red") {
                    layout.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else if (colorSelected == "Black") {
                    layout.setBackgroundColor(getResources().getColor(R.color.black));
                }
                else if (colorSelected == "Orange") {
                    layout.setBackgroundColor(getResources().getColor(R.color.orange));
                }
                else {
                    layout.setBackgroundColor(Integer.parseInt(colorSelected));
                }

                editor.putString("color", colorSelected);
                editor.commit();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}