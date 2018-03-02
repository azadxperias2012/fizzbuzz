package com.azad.fizzbuzz.service;

import com.azad.fizzbuzz.factory.FizzBuzzStrategyFactory;
import com.azad.fizzbuzz.strategy.IFizzBuzzStrategy;

public class FizzBuzzService {

    public String getResult(int limit) {
        if (limit == 0) {
            return "0";
        }
        IFizzBuzzStrategy fizzBuzzStrategy = FizzBuzzStrategyFactory.getFizzBuzzStrategy(limit);
        return fizzBuzzStrategy.getResult(limit);
    }
}
