package com.jiajia.proxy;

public class SuperMan implements Human {
    @Override
    public String getBelief() {
        return "I belive I can fly";
    }

    @Override
    public void eat(String foot) {
        System.out.println("I like eat beef ");
    }
}
