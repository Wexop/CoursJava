package com.example.coursjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button lancer;
    private Button anciens;
    private TextView depsi;
    private Button infini;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lancer = (Button) findViewById(R.id.lancerDe);
        anciens = (Button) findViewById(R.id.dernierLancer);
        depsi = (TextView) findViewById(R.id.depsiTitle);
        infini = (Button) findViewById(R.id.Infini);

        depsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent depsiActivity = new Intent(MainActivity.this, DepsiActivity.class);
                startActivity(depsiActivity);
            }
        });

        lancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lancerActivity = new Intent(MainActivity.this, LancerDeDeActivity.class);
                startActivity(lancerActivity);
            }
        });

        anciens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dernierLancerActivity = new Intent(MainActivity.this, DernierLancerDeActivity.class);
                startActivity(dernierLancerActivity);
            }
        });

        infini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent infiniActivity = new Intent(MainActivity.this, InfinyActivity.class);
                startActivity(infiniActivity);
            }
        });



    }



}

