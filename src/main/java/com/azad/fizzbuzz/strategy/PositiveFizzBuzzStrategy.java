package com.azad.fizzbuzz.strategy;

public class PositiveFizzBuzzStrategy implements IFizzBuzzStrategy {
    private static final int STARTING_NUMBER = 1;
    private static volatile PositiveFizzBuzzStrategy instance = null;

    private PositiveFizzBuzzStrategy() {}

    public static PositiveFizzBuzzStrategy getInstance() {
        PositiveFizzBuzzStrategy result = instance;
        if (result == null) {
            synchronized (PositiveFizzBuzzStrategy.class) {
                if (result == null) {
                    result = instance = new PositiveFizzBuzzStrategy();
                }
            }
        }
        return result;
    }

    @Override
    public String getResult(int limit) {
        StringBuilder fizzBuzzStringBuilder = new StringBuilder();
        for (int i = STARTING_NUMBER; i < limit; i++) {
            fizzBuzzStringBuilder.append(FizzBuzzUtil.getFizzBuzzValue(i));
            fizzBuzzStringBuilder.append(", ");
        }
        fizzBuzzStringBuilder.append(FizzBuzzUtil.getFizzBuzzValue(limit));
        return fizzBuzzStringBuilder.toString();
    }
}
