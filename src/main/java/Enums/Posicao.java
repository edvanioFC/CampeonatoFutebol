package Enums;

public enum Posicao {
    GOLEIRO("Goleiro", "GK"),
    LATERAL_DIREITO("Lateral Direito", "LD"),
    LATERAL_ESQUERDO("Lateral Esquerdo", "LE"),
    ZAGUEIRO_ESQUERDO("Zagueiro Esquerdo", "ZE"),
    ZAGUEIRO_DIREITO("Zagueiro Direito", "ZD"),
    MEDIO_DEFENSIVO("Médio Defensivo", "MDF"),
    MEDIO_ESQUERDO("Médio Esquerdo", "ME"),
    MEDIO_DIREITO("Médio Direito", "MD"),
    ATACANTE_ESQUERDO("Atacante Esquerdo", "AE"),
    ATACANTE_DIREITO("Atacante Direito", "AD"),
    CENTRO_AVANTE("Centro Avante", "CA");

    private final String descricao;
    private final String posicao;

    Posicao(String descricao, String posicao) {
        this.descricao = descricao;
        this.posicao = posicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPosicao() {
        return posicao;
    }

}
