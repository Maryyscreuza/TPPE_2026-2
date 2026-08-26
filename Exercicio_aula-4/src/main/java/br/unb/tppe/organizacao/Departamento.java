package br.unb.tppe.organizacao;

import java.util.ArrayList;
import java.util.List;

public class Departamento implements ComponenteOrganizacional {
    private final String nome;
    private final List<ComponenteOrganizacional> membros = new ArrayList<>();

    public Departamento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarMembro(ComponenteOrganizacional membro) {
        membros.add(membro);
    }

    public void removerMembro(ComponenteOrganizacional membro) {
        membros.remove(membro);
    }

    @Override
    public double getSalario() {
        return membros.stream()
                .mapToDouble(ComponenteOrganizacional::getSalario)
                .sum();
    }
}