package com.example.coursjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class LancerDeDeActivity extends AppCompatActivity {

    private Button lancerDe;
    private TextView texteLancer;
    private ImageView imageDe;
    private ImageView imageDeTurn;
    private Switch swithTextImage;
    private TextView result1;
    private TextView result2;
    private TextView result3;
    private TextView result4;
    private TextView result5;

    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancer_de_de);

        lancerDe = (Button) findViewById(R.id.lancerButton);
        texteLancer = (TextView) findViewById(R.id.texteLancer);
        imageDe = (ImageView) findViewById(R.id.imageDe);
        imageDeTurn = (ImageView) findViewById(R.id.imageTurn);
        swithTextImage = (Switch) findViewById(R.id.SwitchTextImage);
        result1 = (TextView) findViewById(R.id.result1);
        result2 = (TextView) findViewById(R.id.result2);
        result3 = (TextView) findViewById(R.id.result3);
        result4 = (TextView) findViewById(R.id.result4);
        result5 = (TextView) findViewById(R.id.result5);

        layout = (ConstraintLayout) findViewById(R.id.lanceDeLayout);

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


        swithTextImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               boolean checked = swithTextImage.isChecked();
               if (checked) {
                   texteLancer.setVisibility(view.VISIBLE);
                   imageDe.setVisibility(view.INVISIBLE);
               }
               else {
                   texteLancer.setVisibility(view.INVISIBLE);
                   imageDe.setVisibility(view.VISIBLE);
               }
            }
        });

        lancerDe.setOnClickListener(new View.OnClickListener() {

            public void turnDe(int time) {
                new android.os.Handler().postDelayed(
                        new Runnable() {

                            @Override
                            public void run() {
                                int test = (int) (Math.random() * (6 - 1 + 1) + 1);

                                if (test == 1) {
                                    imageDeTurn.setImageResource(R.drawable.d1);
                                } else if (test == 2) {
                                    imageDeTurn.setImageResource(R.drawable.d2);
                                } else if (test == 3) {
                                    imageDeTurn.setImageResource(R.drawable.d3);
                                } else if (test == 4) {
                                    imageDeTurn.setImageResource(R.drawable.d4);
                                } else if (test == 5) {
                                    imageDeTurn.setImageResource(R.drawable.d5);
                                } else if (test == 6) {
                                    imageDeTurn.setImageResource(R.drawable.d6);
                                }
                            }
                        }, time);
            }

            public void setResult(int lastResult) {

                CharSequence getResult2 = result1.getText();
                CharSequence getResult3 = result2.getText();
                CharSequence getResult4 = result3.getText();
                CharSequence getResult5 = result4.getText();

                result1.setText(String.valueOf(lastResult) );
                result2.setText(String.valueOf(getResult2));
                result3.setText(String.valueOf(getResult3));
                result4.setText(String.valueOf(getResult4));
                result5.setText(String.valueOf(getResult5));

            }

            @Override
            public void onClick(View view) {
                int b = (int) (Math.random() * (6 - 1 + 1) + 1);
                String s = String.valueOf(b);
                texteLancer.setText(s);

                if (b == 1) {
                    imageDe.setImageResource(R.drawable.d1);
                } else if (b == 2) {
                    imageDe.setImageResource(R.drawable.d2);
                } else if (b == 3) {
                    imageDe.setImageResource(R.drawable.d3);
                } else if (b == 4) {
                    imageDe.setImageResource(R.drawable.d4);
                } else if (b == 5) {
                    imageDe.setImageResource(R.drawable.d5);
                } else if (b == 6) {
                    imageDe.setImageResource(R.drawable.d6);
                }

                setResult(b);

                for(int i = 0; i < 10; i++) {
                    turnDe(i*300);

                }


            }
        });


    }
}