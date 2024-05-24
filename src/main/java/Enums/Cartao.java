package Enums;

public enum Cartao {
    AMARELO("Amarelo", 1),
    VERMELHO("Vermelho", 2);

    private final String descricao;
    private final int valor;

    Cartao(String descricao, int valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getValor() {
        return valor;
    }

    public Cartao getCartao(int valor) {
        if (valor == 1) {
            return AMARELO;
        } else if (valor == 2) {
            return VERMELHO;
        } else {
            return null;
        }
    }
}
