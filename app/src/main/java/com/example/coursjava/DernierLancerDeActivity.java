package com.example.coursjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DernierLancerDeActivity extends AppCompatActivity {

    private ConstraintLayout layout;

    private TextView result1;
    private TextView result2;
    private TextView result3;
    private TextView result4;
    private TextView result5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dernier_lancer_de);

        result1 = (TextView) findViewById(R.id.dernierLancerR1);
        result2 = (TextView) findViewById(R.id.dernierLancerR2);
        result3 = (TextView) findViewById(R.id.dernierLancerR3);
        result4= (TextView) findViewById(R.id.dernierLancerR4);
        result5 = (TextView) findViewById(R.id.dernierLancerR5);

        layout = (ConstraintLayout) findViewById(R.id.dernierLancerLayout);

        SharedPreferences sharedPreferences = getSharedPreferences("SHARED_PREF", 0);

        SharedPreferences derniersLancer = getSharedPreferences("DERNIER_DE", 0);

        result1.setText(String.valueOf(derniersLancer.getString("result1", "-")));
        result2.setText(String.valueOf(derniersLancer.getString("result2", "-")));
        result3.setText(String.valueOf(derniersLancer.getString("result3", "-")));
        result4.setText(String.valueOf(derniersLancer.getString("result4", "-")));
        result5.setText(String.valueOf(derniersLancer.getString("result5", "-")));



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