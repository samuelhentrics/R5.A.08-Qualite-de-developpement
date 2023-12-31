package com.samuel.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void test_ajout_positif() {
        int resultat = calculator.add(1, 1);
        assertEquals(2, resultat);
        
    }

    @Test
    void test_ajout_negatif() {
        int resultat = calculator.add(-1, -1);
        assertEquals(-2, resultat);
    }

    @Test
    void test_ajout_positif_negatif() {
        int resultat = calculator.add(1, -1);
        assertEquals(0, resultat);
    }

    @Test
    void test_ajout_max(){
        int a = Integer.MAX_VALUE;
        int b = 1;

        assertThrows(ArithmeticException.class, () -> calculator.add(a, b));
    }

    @Test
    void test_division_positif() {
        int resultat = calculator.divide(1, 1);
        assertEquals(1, resultat);
    }

    @Test
    void test_division_negatif() {
        int resultat = calculator.divide(-1, -1);
        assertEquals(1, resultat);
    }

    @Test
    void test_division_positif_negatif() {
        int resultat = calculator.divide(1, -1);
        assertEquals(-1, resultat);
    }

    @Test
    void test_division_par_zero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0, 1, 1",
            "1, 2, 3",
            "-2, 2, 0",
            "0, 0, 0",
            "-1, -2, -3"
    })
    void test_ajout(int a, int b, int resultatAttendu) {
        int resultatFinal = calculator.add(a, b);
        assertEquals(resultatAttendu, resultatFinal);
    }

    @Test
    void test_ensemble_chiffres_positif() {
        Set<Integer> resultat = calculator.ensembleChiffres(7679);
        Set<Integer> attendu = new HashSet<>();
        attendu.add(6);
        attendu.add(7);
        attendu.add(9);

        assertEquals(attendu, resultat);
    }

    @Test
    void test_ensemble_chiffres_negatif() {
        Set<Integer> resultat = calculator.ensembleChiffres(-11);
        Set<Integer> attendu = new HashSet<>();
        attendu.add(1);

        assertEquals(attendu, resultat);
    }

    @Test
    void test_ensemble_chiffres_zero() {
        Set<Integer> resultat = calculator.ensembleChiffres(0);
        Set<Integer> attendu = new HashSet<>();

        assertEquals(attendu, resultat);
    }


    @AfterEach
    void tearDown() {
        calculator = null;
    }
}