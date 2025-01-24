package com.sandun;

public class InputValidator {
    public void validateNumber(double value, double min, double max) {
        if(value < min || value > max)
            System.out.println("Please enter a number between " + min + " and " + max);
    }
}
