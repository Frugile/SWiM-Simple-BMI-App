package com.example.frugile.swimbmiapp;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayBMIActivity extends AppCompatActivity {

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_display_bmi);

            Intent intent = getIntent();
            Double bmi = intent.getDoubleExtra(MainActivity.EXTRA_MESSAGE,0);

            ConstraintLayout root = findViewById(R.id.resultBMI);
            if (bmi<18.5) root.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBMILightGreen));
            else if (18.5 <= bmi && bmi <= 24.9) root.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBMIGreen));
            else if (25 <= bmi && bmi <= 29.9) root.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBMIOrange));
            else root.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBMIRed));

            TextView textView = findViewById(R.id.textView2);
            textView.setText(String.format("%.2f",bmi));

        }
}
