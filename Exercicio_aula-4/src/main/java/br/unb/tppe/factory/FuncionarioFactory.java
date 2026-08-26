package br.unb.tppe.factory;

import br.unb.tppe.funcionarios.Funcionario;
import br.unb.tppe.funcionarios.FuncionarioCLT;
import br.unb.tppe.funcionarios.FuncionarioEstag;
import br.unb.tppe.funcionarios.FuncionarioPJ;

public class FuncionarioFactory {
    public Funcionario criarFuncionario(String tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("O tipo do funcionário é obrigatório");
        }

        return switch (tipo.trim().toUpperCase()) {
            case "CLT" -> new FuncionarioCLT("Funcionário CLT", 0, 0, true);
            case "PJ" -> new FuncionarioPJ("Funcionário PJ", 0, 0, true);
            case "ESTAG", "ESTAGIARIO" ->
                    new FuncionarioEstag("Funcionário estagiário", 0, 0, true);
            default -> throw new IllegalArgumentException("Tipo de funcionário inválido: " + tipo);
        };
    }
}