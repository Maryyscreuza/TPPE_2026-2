package fga0242.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import fga0242.agromart.categorias.TestesRapidos;
import fga0242.model.TipoCliente;

public class AplicadorDescontoTest {

    private static final double DELTA = 0.0001;
    private AplicadorDesconto aplicador;

    @Before
    public void setUp() {
        aplicador = new AplicadorDesconto();
    }

    @Test
    @Category(TestesRapidos.class)
    public void deveAplicarDescontoParaCooperadoAcimaDoLimite() {
        double percentual = aplicador.calcularPercentualDesconto(TipoCliente.COOPERADO, 150.0, "HORTIFRUTI");

        assertEquals(0.10, percentual, DELTA);
        assertTrue(aplicador.isElegivelParaDesconto(TipoCliente.COOPERADO, 150.0, "HORTIFRUTI"));
        assertEquals(135.0, aplicador.calcularValorComDesconto(TipoCliente.COOPERADO, 150.0, "HORTIFRUTI"), DELTA);
    }

    @Test
    @Category(TestesRapidos.class)
    public void deveNaoAplicarDescontoParaCooperadoAbaixoDoLimite() {
        double percentual = aplicador.calcularPercentualDesconto(TipoCliente.COOPERADO, 90.0, "HORTIFRUTI");

        assertEquals(0.0, percentual, DELTA);
        assertFalse(aplicador.isElegivelParaDesconto(TipoCliente.COOPERADO, 90.0, "HORTIFRUTI"));
    }

    @Test
    @Category(TestesRapidos.class)
    public void deveAplicarDescontoParaAtacadoNasFaixasCorretas() {
        assertEquals(0.05, aplicador.calcularPercentualDesconto(TipoCliente.ATACADO, 300.0, "GRAOS"), DELTA);
        assertEquals(0.15, aplicador.calcularPercentualDesconto(TipoCliente.ATACADO, 750.0, "GRAOS"), DELTA);
    }

    @Test
    @Category(TestesRapidos.class)
    public void deveAplicarDescontoParaVarejoSomenteEmHortifruti() {
        assertEquals(0.05, aplicador.calcularPercentualDesconto(TipoCliente.VAREJO, 250.0, "HORTIFRUTI"), DELTA);
        assertEquals(0.0, aplicador.calcularPercentualDesconto(TipoCliente.VAREJO, 250.0, "INSUMOS"), DELTA);
        assertEquals(0.0, aplicador.calcularPercentualDesconto(TipoCliente.VAREJO, 150.0, "HORTIFRUTI"), DELTA);
    }
}
