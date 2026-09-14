package fga0242.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.experimental.categories.Category;

import fga0242.agromart.categorias.TestesRapidos;
import fga0242.model.TipoCliente;

@RunWith(Parameterized.class)
public class AplicadorDescontoParameterizedTest {

    private static final double DELTA = 0.0001;

    private final TipoCliente tipoCliente;
    private final double valorTotalPedido;
    private final String categoriaProduto;
    private final double percentualEsperado;
    private final boolean elegivelEsperado;

    private final AplicadorDesconto aplicador = new AplicadorDesconto();

    public AplicadorDescontoParameterizedTest(TipoCliente tipoCliente, double valorTotalPedido, String categoriaProduto,
            double percentualEsperado, boolean elegivelEsperado) {
        this.tipoCliente = tipoCliente;
        this.valorTotalPedido = valorTotalPedido;
        this.categoriaProduto = categoriaProduto;
        this.percentualEsperado = percentualEsperado;
        this.elegivelEsperado = elegivelEsperado;
    }

    @Parameters(name = "{index}: {0}, valor={1}, categoria={2}, percentual={3}, elegivel={4}")
    public static Collection<Object[]> parametros() {
        return Arrays.asList(new Object[][] {
            { TipoCliente.COOPERADO, 90.0, "HORTIFRUTI", 0.0, false },
            { TipoCliente.COOPERADO, 150.0, "HORTIFRUTI", 0.10, true },
            { TipoCliente.ATACADO, 90.0, "GRAOS", 0.0, false },
            { TipoCliente.ATACADO, 300.0, "GRAOS", 0.05, true },
            { TipoCliente.ATACADO, 600.0, "GRAOS", 0.15, true },
            { TipoCliente.VAREJO, 250.0, "HORTIFRUTI", 0.05, true },
            { TipoCliente.VAREJO, 150.0, "HORTIFRUTI", 0.0, false },
            { TipoCliente.VAREJO, 250.0, "INSUMOS", 0.0, false }
        });
    }

    @Test
    @Category(TestesRapidos.class)
    public void deveCalcularPercentualDescontoCorretamente() {
        assertEquals(percentualEsperado, aplicador.calcularPercentualDesconto(tipoCliente, valorTotalPedido, categoriaProduto), DELTA);
    }

    @Test
    @Category(TestesRapidos.class)
    public void deveIdentificarElegibilidadeCorretamente() {
        assertEquals(elegivelEsperado, aplicador.isElegivelParaDesconto(tipoCliente, valorTotalPedido, categoriaProduto));
    }

    @Test
    @Category(TestesRapidos.class)
    public void deveCalcularValorFinalComDescontoCorretamente() {
        double valorComDesconto = aplicador.calcularValorComDesconto(tipoCliente, valorTotalPedido, categoriaProduto);
        double valorEsperado = valorTotalPedido * (1 - percentualEsperado);

        assertEquals(valorEsperado, valorComDesconto, DELTA);
    }
}
