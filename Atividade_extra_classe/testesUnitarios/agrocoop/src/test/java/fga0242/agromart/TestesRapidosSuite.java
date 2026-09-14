package fga0242.agromart;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import fga0242.agromart.categorias.TestesRapidos;
import fga0242.service.AplicadorDescontoParameterizedTest;
import fga0242.service.AplicadorDescontoTest;
import fga0242.service.CalculadoraFreteTest;
import fga0242.service.EstoqueTest;
import fga0242.service.PedidoServiceExceptionTest;
import fga0242.service.PedidoServiceTest;

@RunWith(Categories.class)
@Categories.IncludeCategory(TestesRapidos.class)
@SuiteClasses({
    EstoqueTest.class,
    CalculadoraFreteTest.class,
    AplicadorDescontoTest.class,
    AplicadorDescontoParameterizedTest.class,
    PedidoServiceTest.class,
    PedidoServiceExceptionTest.class
})
public class TestesRapidosSuite {
}
