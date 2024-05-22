package Enums;

public enum Treinou {
    SIM("Sim", true),
    NAO("Nao", false);

    private String descricao;
    private boolean treinou;

    Treinou(String descricao, boolean treinou) {
        this.descricao = descricao;
        this.treinou = treinou;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isTreinou() {
        return treinou;
    }
}

