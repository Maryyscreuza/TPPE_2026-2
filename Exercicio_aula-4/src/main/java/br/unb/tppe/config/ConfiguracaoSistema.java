package br.unb.tppe.config;

public final class ConfiguracaoSistema {
    private static final ConfiguracaoSistema INSTANCIA = new ConfiguracaoSistema();
    private double taxaBonusGlobal = 1.0;

    private ConfiguracaoSistema() {
    }

    public static ConfiguracaoSistema getInstancia() {
        return INSTANCIA;
    }

    public double getTaxaBonusGlobal() {
        return taxaBonusGlobal;
    }

    public void setTaxaBonusGlobal(double taxaBonusGlobal) {
        if (taxaBonusGlobal < 0) {
            throw new IllegalArgumentException("A taxa de bônus global não pode ser negativa");
        }
        this.taxaBonusGlobal = taxaBonusGlobal;
    }
}