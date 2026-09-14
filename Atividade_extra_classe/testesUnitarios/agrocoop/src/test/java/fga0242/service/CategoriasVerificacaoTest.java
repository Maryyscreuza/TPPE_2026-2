package fga0242.service;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import fga0242.agromart.categorias.TestesLentos;
import fga0242.agromart.categorias.TestesRapidos;

public class CategoriasVerificacaoTest {

    @Test
    @Category(TestesRapidos.class)
    public void deveExecutarTesteRapido() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4);

        assertTrue(numeros.size() == 4);
    }

    @Test
    @Category(TestesLentos.class)
    public void deveExecutarTesteLento() {
        CalculadoraFrete calculadora = new CalculadoraFrete();
        List<String> pontos = Arrays.asList("A", "B", "C", "D", "E", "F", "G");
        double[][] distancias = new double[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i != j) {
                    distancias[i][j] = 1.0 + ((i + j) % 5);
                }
            }
        }

        assertTrue(calculadora.calcularRotaMaisEconomica(pontos, distancias) > 0.0);
    }
}
