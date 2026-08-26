package br.unb.tppe.bonus;

import br.unb.tppe.funcionarios.FuncionarioEstag;

public class BonusEstag extends ProcessadorBonus {
    public BonusEstag(FuncionarioEstag funcionario) {
        super(funcionario);
    }

    @Override
    protected double calcularValorBase() {
        return ((FuncionarioEstag) funcionario).getMediaFaculdade() > 7.0 ? 500 : 0;
    }

    @Override
    protected double aplicarImposto(double valorBase) {
        return valorBase;
    }
}