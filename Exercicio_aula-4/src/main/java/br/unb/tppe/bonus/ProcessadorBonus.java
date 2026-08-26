package br.unb.tppe.bonus;

import br.unb.tppe.funcionarios.Funcionario;

public abstract class ProcessadorBonus {
    protected final Funcionario funcionario;

    protected ProcessadorBonus(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public final double processarPagamento() {
        verificarPresenca();
        double valorBase = calcularValorBase();
        return aplicarImposto(valorBase);
    }

    protected void verificarPresenca() {
        if (!funcionario.isMetaAtingida()) {
            throw new IllegalStateException("A meta não foi atingida");
        }
    }

    protected abstract double calcularValorBase();

    protected abstract double aplicarImposto(double valorBase);
}