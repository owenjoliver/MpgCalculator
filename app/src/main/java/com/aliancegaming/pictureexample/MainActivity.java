package com.aliancegaming.pictureexample;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements Buttons {

    private double fuelUsed, distanceTraveled, part1, mpg, calc1, costprice, fuelused1, calc0;
    EditText distance, fuel, total, pricePerLitre, pounds;

    private static final String TAG = "MainActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pricePerLitre = (EditText) findViewById(R.id.etPricePerLitre);
        pounds = (EditText) findViewById(R.id.etPounds);
        Button calculateCost = (Button) findViewById(R.id.btCalc2);

        distance = (EditText) findViewById(R.id.etDistance);
        fuel = (EditText) findViewById(R.id.etFuel);
        Button calculate = (Button) findViewById(R.id.btCalc);
        total = (EditText) findViewById(R.id.etMPG);

        calculateCost.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.CUPCAKE)
            @Override
            public void onClick(View v) {

                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

                assert inputManager != null;
                inputManager.hideSoftInputFromWindow(Objects.requireNonNull(getCurrentFocus()).getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                if (pricePerLitre.getText().toString().length() > 0) {
                    fuelused1 = Double.parseDouble(pricePerLitre.getText().toString());
                } else {
                    fuelused1 = 0;
                }
                if (pounds.getText().toString().length() > 0) {
                    costprice = Double.parseDouble(pounds.getText().toString());
                } else {
                    costprice = 0;
                }
                calc0 = costprice * 100;
                calc1 = calc0 / fuelused1;
                fuel.setText(String.format(Locale.getDefault(), "%.2f", calc1));
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.CUPCAKE)
            @Override
            public void onClick(View v) {

                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                assert inputManager != null;
                inputManager.hideSoftInputFromWindow(Objects.requireNonNull(getCurrentFocus()).getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                if (distance.getText().toString().length() > 0) {
                    distanceTraveled = Double.parseDouble(distance.getText().toString());
                } else {
                    distanceTraveled = 0;
                }
                if (fuel.getText().toString().length() > 0) {
                    fuelUsed = Double.parseDouble(fuel.getText().toString());
                } else {
                    fuelUsed = 1;
                }
                part1 = fuelUsed / 4.55;
                mpg = distanceTraveled / part1;
                total.setText(String.format(Locale.getDefault(), "%.2f", mpg));
            }
        });
    }
}
