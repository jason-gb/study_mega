package com.ahastudio.api.rest.demo;

public class NewtonMethod {
    private static final double epsilon = Math.pow(0.1, 5);

    public double sqrtIter(double guess, double x) {
        if (goodEnough(guess, x)) {
            return guess;
        }

        return sqrtIter(improve(guess, x), x);
    }

    public boolean goodEnough(double guess, double x) {
        //Math.pow = guess의 x제곱
        return Math.abs(Math.pow(guess, 2) - x) < epsilon;
    }


    public double improve(double guess, double x) {
        return ((x / guess) + guess) / 2;
    }

    public double average(double x, double y) {
        return (x + y) / 2;
    }

    public double sqrt(double x) {
        return sqrtIter(1, x);
    }
}
