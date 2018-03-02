package com.azad.fizzbuzz.strategy;

public class FizzBuzzUtil {

    private FizzBuzzUtil() {}

    public static String getFizzBuzzValue(int number) {
        StringBuilder fizzBuzzValueBuilder = new StringBuilder();
        if (number % 3 == 0) {
            fizzBuzzValueBuilder.append("Fizz");
        }
        if (number % 5 == 0) {
            fizzBuzzValueBuilder.append("Buzz");
        }
        if (fizzBuzzValueBuilder.length() == 0) {
            fizzBuzzValueBuilder.append(number);
        }
        return fizzBuzzValueBuilder.toString();
    }
}
