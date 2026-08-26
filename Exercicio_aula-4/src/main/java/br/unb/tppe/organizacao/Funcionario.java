package br.unb.tppe.organizacao;

public class Funcionario implements ComponenteOrganizacional {
    private final String nome;
    private final double salario;

    public Funcionario(String nome, double salario) {
        if (salario < 0) {
            throw new IllegalArgumentException("O salário não pode ser negativo");
        }
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public double getSalario() {
        return salario;
    }
}