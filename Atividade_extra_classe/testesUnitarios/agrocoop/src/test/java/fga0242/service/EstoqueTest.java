package fga0242.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import fga0242.agromart.categorias.TestesRapidos;
import fga0242.model.Produto;

public class EstoqueTest {

    private Estoque estoque;
    private Produto produto;

    @Before
    public void setUp() {
        estoque = new Estoque();
        produto = new Produto("P001", "Tomate", "HORTIFRUTI", 4.50, 1.0);
    }

    @Test
    @Category(TestesRapidos.class)
    public void deveReporEConsultarQuantidadeDoProduto() {
        estoque.repor(produto, 10);

        int quantidade = estoque.consultarQuantidade(produto);

        assertEquals(10, quantidade);
    }

    @Test
    @Category(TestesRapidos.class)
    public void deveReservarQuantidadeDisponivel() {
        estoque.repor(produto, 15);

        estoque.reservar(produto, 5);

        assertEquals(10, estoque.consultarQuantidade(produto));
    }
}
