package com.azad.fizzbuzz.strategy;

public class NegativeFizzBuzzStrategy implements IFizzBuzzStrategy {
    private static final int ENDING_NUMBER = -1;
    private static volatile NegativeFizzBuzzStrategy instance = null;

    private NegativeFizzBuzzStrategy() {}

    public static NegativeFizzBuzzStrategy getInstance() {
        NegativeFizzBuzzStrategy result = instance;
        if (result == null) {
            synchronized (NegativeFizzBuzzStrategy.class) {
                if (result == null) {
                    result = instance = new NegativeFizzBuzzStrategy();
                }
            }
        }
        return result;
    }

    @Override
    public String getResult(int limit) {
        StringBuilder fizzBuzzStringBuilder = new StringBuilder();
        for (int i = limit; i < ENDING_NUMBER; i++) {
            fizzBuzzStringBuilder.append(FizzBuzzUtil.getFizzBuzzValue(i));
            fizzBuzzStringBuilder.append(", ");
        }
        fizzBuzzStringBuilder.append(FizzBuzzUtil.getFizzBuzzValue(ENDING_NUMBER));
        return fizzBuzzStringBuilder.toString();
    }
}
