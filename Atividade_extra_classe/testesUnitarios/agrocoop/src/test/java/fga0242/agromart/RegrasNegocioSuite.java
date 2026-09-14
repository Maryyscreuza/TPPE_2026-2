package fga0242.agromart;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fga0242.service.AplicadorDescontoParameterizedTest;
import fga0242.service.AplicadorDescontoTest;
import fga0242.service.CalculadoraFreteTest;
import fga0242.service.CalculadoraFreteTimeoutTest;
import fga0242.service.EstoqueTest;
import fga0242.service.PedidoServiceExceptionTest;
import fga0242.service.PedidoServiceFreteGratisAtacadoTest;
import fga0242.service.PedidoServiceTest;

@RunWith(Suite.class)
@SuiteClasses({
    EstoqueTest.class,
    CalculadoraFreteTest.class,
    CalculadoraFreteTimeoutTest.class,
    AplicadorDescontoTest.class,
    AplicadorDescontoParameterizedTest.class,
    PedidoServiceTest.class,
    PedidoServiceExceptionTest.class,
    PedidoServiceFreteGratisAtacadoTest.class
})
public class RegrasNegocioSuite {
}
