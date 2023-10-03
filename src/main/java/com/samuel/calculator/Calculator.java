package com.samuel.calculator;

import java.util.HashSet;
import java.util.Set;

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

    public Set<Integer> ensembleChiffres(int pNombre) {
        Set<Integer> chiffres = new HashSet<>();

        pNombre = Math.abs(pNombre);

        while (pNombre > 0) {
            int chiffre = pNombre % 10;
            chiffres.add(chiffre);
            pNombre /= 10;
        }

        return chiffres;
    }

}
