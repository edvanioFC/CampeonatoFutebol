package Enums;

/**
 * Enum representando os tipos de cartões em um jogo de futebol.
 */
public enum Cartao {
    /**
     * Representa um cartão amarelo.
     */
    AMARELO("Amarelo"),

    /**
     * Representa um cartão vermelho.
     */
    VERMELHO("Vermelho");

    /**
     * Descrição do cartão.
     */
    private final String descricao;

    /**
     * Construtor para o enum.
     *
     * @param descricao A descrição do cartão.
     */
    Cartao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Getter para a descrição do cartão.
     * @return A descrição do cartão.
     */
    public String getDescricao() {
        return descricao;
    }
}
