package br.unb.tppe.funcionarios;

public class FuncionarioPJ extends Funcionario {
    private final double fatorDesempenho;

    public FuncionarioPJ(String nome, double salario, double fatorDesempenho, boolean metaAtingida) {
        super(nome, salario, metaAtingida);
        if (fatorDesempenho < 0 || fatorDesempenho > 1.5) {
            throw new IllegalArgumentException("O fator de desempenho deve estar entre 0 e 1,5");
        }
        this.fatorDesempenho = fatorDesempenho;
    }

    public double getFatorDesempenho() {
        return fatorDesempenho;
    }
}