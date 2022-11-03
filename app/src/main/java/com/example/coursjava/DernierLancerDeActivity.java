package com.example.coursjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class DernierLancerDeActivity extends AppCompatActivity {

    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dernier_lancer_de);

        layout = (ConstraintLayout) findViewById(R.id.dernierLancerLayout);

        SharedPreferences sharedPreferences = getSharedPreferences("SHARED_PREF", 0);

        String colorSelected = sharedPreferences.getString("color", "White");

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


    }

}