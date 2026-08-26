package br.unb.tppe.funcionarios;

public class Funcionario extends br.unb.tppe.organizacao.Funcionario {
    private final boolean metaAtingida;

    protected Funcionario(String nome, double salario, boolean metaAtingida) {
        super(nome, salario);
        this.metaAtingida = metaAtingida;
    }

    public boolean isMetaAtingida() {
        return metaAtingida;
    }
}