package com.example.frugile.swimbmiapp;

/**
 * Created by Frugile on 2018-03-15.
 */

public class BMIforKgM extends BMI {

    public BMIforKgM(double m, double h) {
        super(m, h);
    }

    public double calculateBmi(){
        if (dataAreValid()) {
            return getMass()/((getHeight()/100)*(getHeight()/100));

        }
        else {
            throw new IllegalArgumentException("Invalid data");
        }
    }
}

