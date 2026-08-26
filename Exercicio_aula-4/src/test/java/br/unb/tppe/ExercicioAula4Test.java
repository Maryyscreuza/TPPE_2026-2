package br.unb.tppe;

import br.unb.tppe.bonus.BonusCLT;
import br.unb.tppe.bonus.BonusEstag;
import br.unb.tppe.bonus.BonusPJ;
import br.unb.tppe.config.ConfiguracaoSistema;
import br.unb.tppe.factory.FuncionarioFactory;
import br.unb.tppe.funcionarios.FuncionarioCLT;
import br.unb.tppe.funcionarios.FuncionarioEstag;
import br.unb.tppe.funcionarios.FuncionarioPJ;
import br.unb.tppe.organizacao.Departamento;
import br.unb.tppe.organizacao.Funcionario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExercicioAula4Test {
    @Test
    void departamentoSomaTresFuncionarios() {
        Departamento departamento = new Departamento("Tecnologia");
        departamento.adicionarMembro(new Funcionario("Ana", 1000));
        departamento.adicionarMembro(new Funcionario("Bia", 2000));
        departamento.adicionarMembro(new Funcionario("Caio", 3000));

        assertEquals(6000, departamento.getSalario());
    }

    @Test
    void departamentoSomaSubdepartamento() {
        Departamento matriz = new Departamento("Matriz");
        Departamento filial = new Departamento("Filial");
        filial.adicionarMembro(new Funcionario("Ana", 1500));
        matriz.adicionarMembro(new Funcionario("Bia", 2500));
        matriz.adicionarMembro(filial);

        assertEquals(4000, matriz.getSalario());
    }

    @Test
    void bonusFalhaQuandoMetaNaoFoiAtingida() {
        FuncionarioCLT funcionario = new FuncionarioCLT("Ana", 3000, 2, false);

        assertThrows(IllegalStateException.class, () -> new BonusCLT(funcionario).processarPagamento());
    }

    @Test
    void calculaBonusCLTComLimiteDeDezAnosEIRRF() {
        FuncionarioCLT funcionario = new FuncionarioCLT("Ana", 3000, 12, true);

        assertEquals(3262.5, new BonusCLT(funcionario).processarPagamento());
    }

    @Test
    void calculaBonusPJComISS() {
        FuncionarioPJ funcionario = new FuncionarioPJ("Bia", 4000, 1.2, true);

        assertEquals(5700, new BonusPJ(funcionario).processarPagamento());
    }

    @Test
    void calculaBonusEstagioPelaMedia() {
        FuncionarioEstag funcionario = new FuncionarioEstag("Caio", 1000, 8, true);

        assertEquals(500, new BonusEstag(funcionario).processarPagamento());
    }

    @Test
    void factoryCriaTipoSolicitado() {
        FuncionarioFactory factory = new FuncionarioFactory();

        assertInstanceOf(FuncionarioCLT.class, factory.criarFuncionario("clt"));
        assertInstanceOf(FuncionarioPJ.class, factory.criarFuncionario("PJ"));
        assertInstanceOf(FuncionarioEstag.class, factory.criarFuncionario("estagiario"));
    }

    @Test
    void singletonMantemIdentidadeEEstado() {
        ConfiguracaoSistema primeira = ConfiguracaoSistema.getInstancia();
        ConfiguracaoSistema segunda = ConfiguracaoSistema.getInstancia();
        primeira.setTaxaBonusGlobal(1.25);

        assertSame(primeira, segunda);
        assertEquals(1.25, segunda.getTaxaBonusGlobal());
    }
}