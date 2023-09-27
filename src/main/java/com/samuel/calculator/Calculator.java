package com.samuel.calculator;

public class Calculator {
    public int add(int opG, int opD) {
        try{
            return Math.addExact(opG, opD);
        } catch (ArithmeticException e){
            throw new ArithmeticException("Dépassement de capacité");
        }
    };
    public int divide(int opG, int opD){
        try{
            return opG / opD;
        } catch (ArithmeticException e){
            throw new ArithmeticException("Division par zéro impossible");
        }
    };

}
