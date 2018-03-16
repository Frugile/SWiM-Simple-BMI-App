package com.example.frugile.swimbmiapp;

/**
 * Created by Frugile on 2018-03-15.
 */

abstract public class BMI {
    private double mass;
    private double height;

    public BMI(double m, double h){
        mass = m;
        height = h;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    abstract public double calculateBmi();

    public boolean dataAreValid() {
        return mass>0 && height>0;
    }
}
