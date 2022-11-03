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

import java.util.ArrayList;
import java.util.List;

public class ParametrageActivity extends AppCompatActivity {

    private Spinner ColorsSpinner;
    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametrage);

        SharedPreferences sharedPreferences = getSharedPreferences("SHARED_PREF", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        ColorsSpinner = (Spinner) findViewById(R.id.ColorSpinner);
        layout = (ConstraintLayout)  findViewById(R.id.parametreLayout);

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

        ColorsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String colorSelected = String.valueOf(ColorsSpinner.getSelectedItem()) ;

                if (colorSelected == "White") {
                    layout.setBackgroundColor(getResources().getColor(R.color.white));
                }
                if (colorSelected == "Blue") {
                    layout.setBackgroundColor(getResources().getColor(R.color.blue));
                }
                if (colorSelected == "Red") {
                    layout.setBackgroundColor(getResources().getColor(R.color.red));
                }
                if (colorSelected == "Black") {
                    layout.setBackgroundColor(getResources().getColor(R.color.black));
                }
                if (colorSelected == "Orange") {
                    layout.setBackgroundColor(getResources().getColor(R.color.orange));
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