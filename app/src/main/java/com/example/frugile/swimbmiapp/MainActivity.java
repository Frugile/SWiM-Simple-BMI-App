package com.example.frugile.swimbmiapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String SAVE = "com.example.myfirstapp.SAVE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restoreInputs();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.save_input:
                saveInputs();
                return true;
            case R.id.author:
                Intent intent = new Intent(this, FullscreenAboutActivity.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendMessage(View view) {

        EditText massText = findViewById(R.id.editTextMass);
        String massString = massText.getText().toString();

        EditText heightText = findViewById(R.id.editTextHeight);
        String heightString = heightText.getText().toString();

        if(massString.length() == 0 || heightString.length() == 0){
            Toast.makeText(getApplicationContext(),"Wrong data",Toast.LENGTH_SHORT).show();
        }
        else {
            double mass = Double.parseDouble(massString);
            double height = (Double.parseDouble(heightString));
            double bmi;

            Switch unitSwitch = (Switch) findViewById(R.id.switchUnit);
            if (!unitSwitch.isChecked()){
                BMI bmiCounter = new BMIforKgM(mass,height);
                bmi = bmiCounter.calculateBmi();
            }
            else {
                BMI bmiCounter = new BMIforLbIn(mass,height);
                bmi = bmiCounter.calculateBmi();
            }
            Intent intent = new Intent(this, DisplayBMIActivity.class);

            intent.putExtra(EXTRA_MESSAGE, bmi);
            startActivity(intent);
        }
    }

    private void saveInputs()
    {
        EditText mass = findViewById(R.id.editTextMass);
        EditText height = findViewById(R.id.editTextHeight);

        SharedPreferences settings = getApplicationContext().getSharedPreferences(SAVE,0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("mass", mass.getText().toString());
        editor.putString("height", height.getText().toString());

        Toast.makeText(getApplicationContext(), R.string.save, Toast.LENGTH_SHORT).show();
        editor.apply();
    }

    private void restoreInputs()
    {
        SharedPreferences settings = getApplicationContext().getSharedPreferences(SAVE, 0);
        String mass_text = settings.getString("mass", null);
        String height_text = settings.getString("height", null);

        if (mass_text != null) {
            EditText mass = findViewById(R.id.editTextMass);
            mass.setText(mass_text);
        }
        if (height_text != null) {
            EditText height = findViewById(R.id.editTextHeight);
            height.setText(height_text);
        }
    }
}
