package br.unb.tppe.bonus;

import br.unb.tppe.funcionarios.FuncionarioPJ;

public class BonusPJ extends ProcessadorBonus {
    public BonusPJ(FuncionarioPJ funcionario) {
        super(funcionario);
    }

    @Override
    protected double calcularValorBase() {
        return 5000 * ((FuncionarioPJ) funcionario).getFatorDesempenho();
    }

    @Override
    protected double aplicarImposto(double valorBase) {
        return valorBase * 0.95;
    }
}