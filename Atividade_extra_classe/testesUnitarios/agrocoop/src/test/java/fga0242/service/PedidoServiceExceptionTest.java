package fga0242.service;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import fga0242.agromart.categorias.TestesRapidos;
import fga0242.model.Cliente;
import fga0242.model.ItemPedido;
import fga0242.model.Pedido;
import fga0242.model.Produto;
import fga0242.model.TipoCliente;

public class PedidoServiceExceptionTest {

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

    @Test(expected = EstoqueInsuficienteException.class)
    @Category(TestesRapidos.class)
    public void deveLancarExcecaoQuandoQuantidadeSolicitadaExcedeEstoque() {
        Produto produto = new Produto("P010", "Arroz", "GRAOS", 15.0, 2.0);
        estoque.repor(produto, 3);

        pedidoService.processar(new Pedido(
            new Cliente("Joao", TipoCliente.COOPERADO),
            Collections.singletonList(new ItemPedido(produto, 4)),
            "DF"));
    }

    @Test(expected = PedidoInvalidoException.class)
    @Category(TestesRapidos.class)
    public void deveLancarExcecaoQuandoPedidoNaoTemItens() {
        new Pedido(new Cliente("Maria", TipoCliente.VAREJO), Collections.emptyList(), "GO");
        pedidoService.processar(new Pedido(new Cliente("Maria", TipoCliente.VAREJO), Collections.emptyList(), "GO"));
    }

    @Test(expected = PedidoInvalidoException.class)
    @Category(TestesRapidos.class)
    public void deveLancarExcecaoQuandoPedidoNaoTemCliente() {
        Produto produto = new Produto("P011", "Leite", "LATICINIOS", 12.0, 1.0);
        pedidoService.processar(new Pedido(null, Collections.singletonList(new ItemPedido(produto, 1)), "DF"));
    }
}
