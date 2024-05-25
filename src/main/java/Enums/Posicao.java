package Enums;
/**
 * Enum representando as posições em um jogo de futebol.
 */
public enum Posicao {
    /**
     * Representa a posição de goleiro.
     */
    GOLEIRO("Goleiro", "GK"),

    /**
     * Representa a posição de lateral direito.
     */
    LATERAL_DIREITO("Lateral Direito", "LD"),

    /**
     * Representa a posição de lateral esquerdo.
     */
    LATERAL_ESQUERDO("Lateral Esquerdo", "LE"),

    /**
     * Representa a posição de zagueiro esquerdo.
     */
    ZAGUEIRO_ESQUERDO("Zagueiro Esquerdo", "ZE"),

    /**
     * Representa a posição de zagueiro direito.
     */
    ZAGUEIRO_DIREITO("Zagueiro Direito", "ZD"),

    /**
     * Representa a posição de médio defensivo.
     */
    MEDIO_DEFENSIVO("Médio Defensivo", "MDF"),

    /**
     * Representa a posição de médio esquerdo.
     */
    MEDIO_ESQUERDO("Médio Esquerdo", "ME"),

    /**
     * Representa a posição de médio direito.
     */
    MEDIO_DIREITO("Médio Direito", "MD"),

    /**
     * Representa a posição de atacante esquerdo.
     */
    ATACANTE_ESQUERDO("Atacante Esquerdo", "AE"),

    /**
     * Representa a posição de atacante direito.
     */
    ATACANTE_DIREITO("Atacante Direito", "AD"),

    /**
     * Representa a posição de centro avante.
     */
    CENTRO_AVANTE("Centro Avante", "CA");

    /**
     * Descrição da posição.
     */
    private final String descricao;

    /**
     * Abreviação da posição.
     */
    private final String posicao;

    /**
     * Construtor para o enum.
     * @param descricao A descrição da posição.
     * @param posicao A abreviação da posição.
     */
    Posicao(String descricao, String posicao) {
        this.descricao = descricao;
        this.posicao = posicao;
    }

    /**
     * Getter para a descrição da posição.
     * @return A descrição da posição.
     */
    public String getDescricao() {
        return descricao;
    }
    /**
     * Getter para a abreviação da posição.
     * @return A abreviação da posição.
     */
    public String getPosicao() {
        return posicao;
    }
}