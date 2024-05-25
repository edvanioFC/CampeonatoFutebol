package Campeonato;
import java.time.LocalDate;
import java.util.Random;
import Enums.*;
import static java.lang.System.out;
import static utils.CentralizadorTextoUtil.centralizarTexto;

/**
 * Classe que representa um jogador em um campeonato.
 * Contém informações sobre o jogador, como id, nome, apelido, data de nascimento, número, posição, qualidade, cartões amarelos e vermelhos, suspensão e treinamento.
 */

public class Jogador {
    private int id;
    private String nome;
    private String apelido;
    private LocalDate dataNascimento;
    private int numero;
    private Posicao posicao;
    private int qualidade;
    private int cartoesAmarelos;
    private int cartoesVermelhos;
    private Suspenso suspenso;
    private Treinou treinou;

    /**
     * Construtor com parâmetros.
     *
     * @param id Identificador do jogador.
     * @param nome Nome do jogador.
     * @param apelido Apelido do jogador.
     * @param dataNascimento Data de nascimento do jogador.
     * @param numero Número do jogador.
     * @param posicao Posição do jogador.
     * @param qualidade Qualidade do jogador.
     */
    public Jogador(int id, String nome, String apelido, LocalDate dataNascimento, int numero, Posicao posicao, int qualidade) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.dataNascimento = dataNascimento;
        this.numero = numero;
        this.posicao = posicao;
        this.qualidade = qualidade;
        this.cartoesAmarelos = 0;
        this.cartoesVermelhos = 0;
        this.suspenso = Suspenso.NAO;
        this.treinou = Treinou.NAO;
    }

    /**
     * Exibe as informações do jogador.
     *
     * @return Uma string com as informações do jogador.
     */
    public String exibirJogador() {
         return " Nome: " + nome + " - (" + apelido + ")" +
        " Data de Nascimento: " + dataNascimento +
        " Número: " + numero +
        " Posição: " + posicao.getDescricao() +
        " Qualidade: " + qualidade +
        "Condição: " + condicao();
    }

    /**
     * Verifica se o jogador está suspenso.
     *
     * @return Verdadeiro se o jogador não está suspenso, falso caso contrário.
     */
    public boolean verificaCondicaoJogo() {
        return suspenso == Suspenso.NAO;
    }

    /**
     * Aplica um cartão ao jogador.
     * @param cartao O tipo de cartão a ser aplicado.
     * @param quantidade A quantidade de cartões a ser aplicada.
     * @note Se o jogador receber 2 cartões amarelos no jogo.
     * @note Jogador suspenso fica impedido para a partida seguinte
     */
    public void aplicarCartao(Cartao cartao, int quantidade) {

        switch (cartao){
            case AMARELO:
                cartoesAmarelos += quantidade;
                if (cartoesAmarelos >= 2) {
                    suspenso = Suspenso.SIM;
                }
                if(cartoesAmarelos >= 6) {
                    cartoesAmarelos = 6;
                }
                break;
            case VERMELHO:
                cartoesVermelhos += quantidade;
                if (cartoesVermelhos >= 1) {
                    suspenso = Suspenso.SIM;
                }
                break;
            default:
                break;
        }

    }

    /**
     * Faz o jogador cumprir a suspensão zerando todos os cartões.
     * @note A suspensão muda para NAO @enum Suspenso() .
     */
    public void cumprirSuspencao() {
        cartoesVermelhos = 0;
        cartoesAmarelos = 0;
        suspenso = Suspenso.NAO;
        centralizarTexto("O jogador " + nome + " (" + apelido + ") cumpriu a suspensão.");
    }

    /**
     * Faz o jogador sofrer uma lesão, o que diminui sua qualidade.
     * A qualidade diminui de acordo com a probabilidade de lesão.
     * @note A qualidade nunca é menor que 0.
     */
    public void sofrerLesao() {
        int qualidadeDecrementada = calcularQualidade();
        qualidade -= qualidadeDecrementada;
        if (qualidade < 0) {
            qualidade = 0;
        }
    }

    /**
     * Faz o jogador executar um treinamento, o que aumenta sua qualidade.
     * A qualidade aumenta de acordo com a probabilidade de treinamento.
     * @note A qualidade nunca ultrapassa 100.
     */
    public void executarTreinamento() {
        if (treinou == Treinou.NAO) {
            qualidade += calcularQualidade();
            if (qualidade > 100) {
                qualidade = 100;
            }
            treinou = Treinou.SIM;
        } else {
            out.println("Este jogador já treinou antes da partida.");
        }
    }

    /**
     * Calcula a probabilidade da qualidade do jogador.
     *
     * @return O valor da qualidade calculada.
     */
    private int calcularQualidade() {
        Random random = new Random();
        int probabilidade = random.nextInt(100);
        int valor;

        if (probabilidade < 5) {
            valor = (int) (0.15 * qualidade);
        } else if (probabilidade < 15) {
            valor = (int) (0.10 * qualidade);
        } else if (probabilidade < 30) {
            valor = (int) (0.05 * qualidade);
        } else if (probabilidade < 70) {
            valor = 2;
        } else {
            valor = 1;
        }

        return valor;
    }

    /**
     * Retorna a condição do jogador.
     *
     * @return Uma string indicando se o jogador está suspenso ou não.
     */
    public String condicao(){
        if(this.getSuspenso() == Suspenso.SIM) return "SUSPENSO";
        return "TÁ PRA JOGO";
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getApelido() {
        return apelido;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public int getNumero() {
        return numero;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public int getQualidade() {
        return qualidade;
    }

    public int getCartoesAmarelos() {
        return cartoesAmarelos;
    }

    public int getCartoesVermelhos() {
        return cartoesVermelhos;
    }

    public Suspenso getSuspenso() {
        return suspenso;
    }

    public void setSuspenso(Suspenso suspenso) {
        this.suspenso = suspenso;
    }

    public void setTreinou(Treinou treinou) {
        this.treinou = treinou;
    }

    public Treinou getTreinou() {
        return treinou;
    }
}


