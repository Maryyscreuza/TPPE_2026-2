package br.unb.tppe.funcionarios;

import br.unb.tppe.organizacao.ComponenteOrganizacional;

public class Funcionario implements ComponenteOrganizacional {
    private final String nome;
    private final double salario;
    private final boolean metaAtingida;

    protected Funcionario(String nome, double salario, boolean metaAtingida) {
        if (salario < 0) {
            throw new IllegalArgumentException("O salário não pode ser negativo");
        }
        this.nome = nome;
        this.salario = salario;
        this.metaAtingida = metaAtingida;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public double getSalario() {
        return salario;
    }

    public boolean isMetaAtingida() {
        return metaAtingida;
    }
}