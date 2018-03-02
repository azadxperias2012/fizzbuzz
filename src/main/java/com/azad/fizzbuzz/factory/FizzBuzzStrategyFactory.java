package com.azad.fizzbuzz.factory;

import com.azad.fizzbuzz.strategy.IFizzBuzzStrategy;
import com.azad.fizzbuzz.strategy.NegativeFizzBuzzStrategy;
import com.azad.fizzbuzz.strategy.PositiveFizzBuzzStrategy;

public class FizzBuzzStrategyFactory {

    public static IFizzBuzzStrategy getFizzBuzzStrategy(int limt) {
        IFizzBuzzStrategy fizzBuzzStrategy = null;
        if (limt > 0) {
            fizzBuzzStrategy = PositiveFizzBuzzStrategy.getInstance();
        } else {
            fizzBuzzStrategy = NegativeFizzBuzzStrategy.getInstance();
        }
        return fizzBuzzStrategy;
    }

}
