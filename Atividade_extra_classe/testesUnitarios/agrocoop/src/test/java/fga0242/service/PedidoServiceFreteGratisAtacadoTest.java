package fga0242.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

import fga0242.model.Cliente;
import fga0242.model.ItemPedido;
import fga0242.model.Pedido;
import fga0242.model.Produto;
import fga0242.model.TipoCliente;

public class PedidoServiceFreteGratisAtacadoTest {

    @Ignore("Funcionalidade ainda não implementada em PedidoService.processarComFreteGratisAtacado; a regra será ativada quando a Sprint 5 incluir o frete grátis para atacado.")
    @Test
    public void deveAplicarFreteGratisParaAtacadoComPedidoAcimaDeMilReais() {
        Estoque estoque = new Estoque();
        Produto produto1 = new Produto("P100", "Soja", "GRAOS", 400.0, 10.0);
        Produto produto2 = new Produto("P101", "Trigo", "GRAOS", 700.0, 12.0);
        estoque.repor(produto1, 10);
        estoque.repor(produto2, 10);

        PedidoService pedidoService = new PedidoService(estoque, new CalculadoraFrete(), new AplicadorDesconto());
        Pedido pedido = new Pedido(
            new Cliente("Distribuidora", TipoCliente.ATACADO),
            Arrays.asList(new ItemPedido(produto1, 1), new ItemPedido(produto2, 1)),
            "DF");

        double valor = pedidoService.processarComFreteGratisAtacado(pedido);

        assertEquals(0.0, 0.0, 0.0001);
        assertEquals(0.0, valor, 0.0001);
    }
}
