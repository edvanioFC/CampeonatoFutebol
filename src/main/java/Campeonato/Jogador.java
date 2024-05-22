package Campeonato;
import java.time.LocalDate;
import java.util.Random;
import Enums.Posicao;
import Enums.Suspenso;
import Enums.Treinou;


public class Jogador {
    private int id;
    private String nome;
    private String apelido;
    private LocalDate dataNascimento;
    private int numero;
    private Posicao posicao;
    private int qualidade;
    private int cartoes;
    private Suspenso suspenso;
    private Treinou treinou;
    private int cartoesAmarelos;


    public Jogador(int id, String nome, String apelido, LocalDate dataNascimento, int numero, Posicao posicao, int qualidade) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.dataNascimento = dataNascimento;
        this.numero = numero;
        this.posicao = posicao;
        this.qualidade = qualidade;
        this.cartoes = 0;
        this.cartoesAmarelos = 0;
        this.suspenso = Suspenso.NAO;
        this.treinou = Treinou.NAO;
    }

    public void cadastrar() {
        System.out.println("Jogador cadastrado: " + nome + " - " + apelido);
    }

    public void exibirJogador() {
        System.out.println("Jogador: " + nome + " - " + apelido);
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("Número: " + numero);
        System.out.println("Posição: " + posicao.getDescricao());
        System.out.println("Qualidade: " + qualidade);
        System.out.println("Cartões: " + cartoes);
        System.out.println("Cartões Amarelos: " + cartoesAmarelos);
        System.out.println("Suspenso: " + suspenso.getDescricao());
        System.out.println("Treinou: " + treinou.getDescricao());
    }
    public boolean verificaCondicaoJogo() {
        return suspenso == Suspenso.NAO;
    }

    public void aplicarCartao(int quantidade) {
        cartoes += quantidade;
        cartoesAmarelos += quantidade;
        if(cartoesAmarelos >= 2) suspenso = Suspenso.SIM;

        if (cartoes >= 3) suspenso = Suspenso.SIM;

        if (cartoes >= 6) cartoes = 6;

    }

    public void cumprirSuspencao() {
        cartoes = 0;
        cartoesAmarelos = 0;
        suspenso = Suspenso.NAO;
    }

    public void sofrerLesao() {
        Random random = new Random();
        int probabilidade = random.nextInt(100);
        int qualidadeDecrementada = 0;

        if (probabilidade < 5) {
            qualidadeDecrementada = (int) (0.15 * qualidade);
        } else if (probabilidade < 15) {
            qualidadeDecrementada = (int) (0.10 * qualidade);
        } else if (probabilidade < 30) {
            qualidadeDecrementada = (int) (0.05 * qualidade);
        } else if (probabilidade < 70) {
            qualidadeDecrementada = 2;
        } else {
            qualidadeDecrementada = 1;
        }

        qualidade -= qualidadeDecrementada;
        if (qualidade < 0) {
            qualidade = 0;
        }
    }

    public void executarTreinamento() {
        if (treinou == Treinou.NAO) {
            Random random = new Random();
            int probabilidade = random.nextInt(100);
            int qualidadeIncrementada = 0;

            if (probabilidade < 5) {
                qualidadeIncrementada = 5;
            } else if (probabilidade < 15) {
                qualidadeIncrementada = 4;
            } else if (probabilidade < 30) {
                qualidadeIncrementada = 3;
            } else if (probabilidade < 70) {
                qualidadeIncrementada = 2;
            } else {
                qualidadeIncrementada = 1;
            }

            qualidade += qualidadeIncrementada;
            if (qualidade > 100) {
                qualidade = 100;
            }
            treinou = Treinou.SIM;
        } else {
            System.out.println("Este jogador já treinou antes da partida.");
        }
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

    public int getCartoes() {
        return cartoes;
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
