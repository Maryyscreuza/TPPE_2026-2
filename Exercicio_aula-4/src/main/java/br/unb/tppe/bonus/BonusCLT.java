package br.unb.tppe.bonus;

import br.unb.tppe.funcionarios.FuncionarioCLT;

public class BonusCLT extends ProcessadorBonus {
    public BonusCLT(FuncionarioCLT funcionario) {
        super(funcionario);
    }

    @Override
    protected double calcularValorBase() {
        FuncionarioCLT funcionarioCLT = (FuncionarioCLT) funcionario;
        int anosConsiderados = Math.min(funcionarioCLT.getAnosDeEmpresa(), 10);
        return funcionarioCLT.getSalario() * 0.15 * anosConsiderados;
    }

    @Override
    protected double aplicarImposto(double valorBase) {
        return valorBase < 2000 ? valorBase : valorBase * 0.725;
    }
}