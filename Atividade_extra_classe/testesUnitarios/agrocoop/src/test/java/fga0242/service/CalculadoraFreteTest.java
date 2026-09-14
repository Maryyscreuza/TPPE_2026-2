package fga0242.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import fga0242.agromart.categorias.TestesRapidos;

public class CalculadoraFreteTest {

    private static final double DELTA = 0.0001;
    private final CalculadoraFrete calculadora = new CalculadoraFrete();

    @Test
    @Category(TestesRapidos.class)
    public void deveCalcularFreteParaRegiaoDF() {
        double frete = calculadora.calcularFrete(10.0, "DF");

        assertEquals(13.0, frete, DELTA);
    }

    @Test
    @Category(TestesRapidos.class)
    public void deveCalcularFreteParaRegiaoGO() {
        double frete = calculadora.calcularFrete(10.0, "GO");

        assertEquals(20.0, frete, DELTA);
    }

    @Test
    @Category(TestesRapidos.class)
    public void deveCalcularFreteParaOutrasRegioes() {
        double frete = calculadora.calcularFrete(10.0, "SP");

        assertEquals(40.0, frete, DELTA);
    }
}
