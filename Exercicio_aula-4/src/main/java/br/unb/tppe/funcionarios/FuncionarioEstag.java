package br.unb.tppe.funcionarios;

public class FuncionarioEstag extends Funcionario {
    private final double mediaFaculdade;

    public FuncionarioEstag(String nome, double salario, double mediaFaculdade, boolean metaAtingida) {
        super(nome, salario, metaAtingida);
        if (mediaFaculdade < 0 || mediaFaculdade > 10) {
            throw new IllegalArgumentException("A média da faculdade deve estar entre 0 e 10");
        }
        this.mediaFaculdade = mediaFaculdade;
    }

    public double getMediaFaculdade() {
        return mediaFaculdade;
    }
}