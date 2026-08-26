package br.unb.tppe.funcionarios;

public class FuncionarioCLT extends Funcionario {
    private final int anosDeEmpresa;

    public FuncionarioCLT(String nome, double salario, int anosDeEmpresa, boolean metaAtingida) {
        super(nome, salario, metaAtingida);
        if (anosDeEmpresa < 0) {
            throw new IllegalArgumentException("Os anos de empresa não podem ser negativos");
        }
        this.anosDeEmpresa = anosDeEmpresa;
    }

    public int getAnosDeEmpresa() {
        return anosDeEmpresa;
    }
}