package Enums;

public enum Suspenso {
    SIM("Sim", true),
    NAO("Não", false);

    private String descricao;
    private boolean suspenso;

    Suspenso(String descricao, boolean suspenso) {
        this.descricao = descricao;
        this.suspenso = suspenso;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isSuspenso() {
        return suspenso;
    }
}
