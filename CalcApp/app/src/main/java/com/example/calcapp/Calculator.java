package com.example.calcapp;

import static java.lang.Math.sqrt;

public  class Calculator {

    static double summa(double a, double b){
        return a+b;
    }
    static double minus(double a, double b){
        return a - b;
    }
    static double mult(double a, double b){
        return a * b;
    }
    static double deMult(double a, double b){
        return a / b;
    }
    static double root(double a, double b){
        return Math.pow(a,1/b);
    }
    static double pow(double a, double b){
        return Math.pow(a,b);
    }
}