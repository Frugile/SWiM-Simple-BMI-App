package com.example.frugile.swimbmiapp;

/**
 * Created by Frugile on 2018-03-15.
 */

public class BMIforLbIn extends BMI {


    public BMIforLbIn(double m, double h) {
        super(m, h);
    }

    public double calculateBmi(){
        if (dataAreValid()) {
            return getMass()/(getHeight()*getHeight())*703;
        }
        else {
            throw new IllegalArgumentException("Invalid data");
        }
    }
}