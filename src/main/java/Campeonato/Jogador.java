package Campeonato;
import java.time.LocalDate;
import java.util.Random;

import Enums.Cartao;
import Enums.Posicao;
import Enums.Suspenso;
import Enums.Treinou;

import static java.lang.System.out;
import static utils.TextoUtil.centralizarTexto;


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

    public void cadastrar() {
        centralizarTexto("Jogador cadastrado: " + nome + " (" + apelido + ")");
    }

    public String exibirJogador() {
        return ( " Nome: " + nome + " - (" + apelido + ")" +
        " Data de Nascimento: " + dataNascimento +
        " Número: " + numero +
        " Posição: " + posicao.getDescricao() +
        " Qualidade: " + qualidade
        );
    }

//    " Suspenso: " + suspenso.getDescricao()+
//    " Treinou: " + treinou.getDescricao()

    public boolean verificaCondicaoJogo() {
        return suspenso == Suspenso.NAO;
    }

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

    public void cumprirSuspencao() {
        cartoesVermelhos = 0;
        cartoesAmarelos = 0;
        suspenso = Suspenso.NAO;
        centralizarTexto("O jogador " + this.nome + " (" + this.apelido + ") cumpriu a suspensão.");
    }

    public void sofrerLesao() {
        int qualidadeDecrementada = calcularQualidade();
        qualidade -= qualidadeDecrementada;
        if (qualidade < 0) {
            qualidade = 0;
        }
    }

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
