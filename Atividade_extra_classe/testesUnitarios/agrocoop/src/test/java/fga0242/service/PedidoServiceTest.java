package fga0242.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import fga0242.agromart.categorias.TestesRapidos;
import fga0242.model.Cliente;
import fga0242.model.ItemPedido;
import fga0242.model.Pedido;
import fga0242.model.Produto;
import fga0242.model.TipoCliente;

public class PedidoServiceTest {

    private static final double DELTA = 0.0001;

    private Estoque estoque;
    private CalculadoraFrete calculadoraFrete;
    private AplicadorDesconto aplicadorDesconto;
    private PedidoService pedidoService;

    @Before
    public void setUp() {
        estoque = new Estoque();
        calculadoraFrete = new CalculadoraFrete();
        aplicadorDesconto = new AplicadorDesconto();
        pedidoService = new PedidoService(estoque, calculadoraFrete, aplicadorDesconto);
    }

    @Test
    @Category(TestesRapidos.class)
    public void deveProcessarPedidoComDescontoEFrete() {
        Produto tomate = new Produto("P001", "Tomate", "HORTIFRUTI", 4.50, 1.0);
        Produto milho = new Produto("P002", "Milho", "GRAOS", 5.0, 1.5);

        estoque.repor(tomate, 10);
        estoque.repor(milho, 10);

        Cliente cliente = new Cliente("Maria", TipoCliente.COOPERADO);
        Pedido pedido = new Pedido(cliente, Arrays.asList(
            new ItemPedido(tomate, 3),
            new ItemPedido(milho, 2)
        ), "DF");

        double valorProdutos = pedido.getValorTotalProdutos();
        double frete = calculadoraFrete.calcularFrete(pedido.getPesoTotal(), pedido.getRegiaoEntrega());
        double percentual = aplicadorDesconto.calcularPercentualDesconto(cliente.getTipo(), valorProdutos, "HORTIFRUTI");
        double valorEsperado = valorProdutos * (1 - percentual) + frete;

        double valorFinal = pedidoService.processar(pedido);

        assertEquals(valorEsperado, valorFinal, DELTA);
        assertEquals(7, estoque.consultarQuantidade(tomate));
        assertEquals(8, estoque.consultarQuantidade(milho));
    }
}
