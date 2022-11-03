package com.example.coursjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InfinyActivity extends AppCompatActivity {

    private EditText input1;
    private EditText input2;
    private Button button;
    private TextView result;
    private ConstraintLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infiny);

        input1 = (EditText) findViewById(R.id.infiniInput1);
        input2 = (EditText) findViewById(R.id.infiniInput2);
        button = (Button) findViewById(R.id.inifinyLancerButton);
        result = (TextView) findViewById(R.id.infinyResult);

        layout = (ConstraintLayout) findViewById(R.id.infiniLayout);

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

        button.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                boolean isInputEmpty1 = input1.getText().toString().matches("");
                boolean isInput2Empty = input2.getText().toString().matches("");

                if (!isInput2Empty && !isInputEmpty1) {
                    int max = Integer.parseInt(input2.getText().toString());
                    int min = Integer.parseInt(input1.getText().toString());



                    int b = (int) (Math.random() * (max - min + 1) + min);
                    String s = String.valueOf(b);

                    result.setText(s);
                }

                else {
                    Toast.makeText(getApplicationContext(), "Tous les champs ne sont pas remplis", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }


}