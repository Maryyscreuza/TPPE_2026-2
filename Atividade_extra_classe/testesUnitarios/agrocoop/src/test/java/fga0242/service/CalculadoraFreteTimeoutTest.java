package fga0242.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import fga0242.agromart.categorias.TestesLentos;

public class CalculadoraFreteTimeoutTest {

    private final CalculadoraFrete calculadora = new CalculadoraFrete();

    @Test(timeout = 5000)
    @Category(TestesLentos.class)
    public void deveCalcularRotaMaisEconomicaEmTempoAceitavelParaSetePontos() {
        // Para 7 pontos, a complexidade O(n!) é grande, mas com uma rota pequena
        // e tamanho fixo de 7 está dentro do limite aceitável em tempo de execução
        // para validação de regressão de desempenho na cooperativa.
        List<String> pontos = Arrays.asList("A", "B", "C", "D", "E", "F", "G");
        double[][] distancias = new double[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i != j) {
                    distancias[i][j] = 1.0 + ((i + j) % 5);
                }
            }
        }

        long inicio = System.nanoTime();
        double menorDistancia = calculadora.calcularRotaMaisEconomica(pontos, distancias);
        long tempo = System.nanoTime() - inicio;

        assertTrue("Distância calculada deve ser positiva", menorDistancia > 0.0);
        assertTrue("Tempo de execução deve permanecer em limite aceitável", tempo < 5_000_000_000L);
    }
}
