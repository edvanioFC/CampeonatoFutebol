package Campeonato;

import Enums.*;
import utils.CentralizadorTextoUtil;
import java.time.LocalDate;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static utils.CentralizadorTextoUtil.centralizarTexto;

/**
 * Classe que representa um jogo em um campeonato.
 * Contém informações sobre o jogo, como equipes, data, estádio, cidade, placar e eventos.
 */
public class Jogo {
    private Equipa mandante;
    private Equipa visitante;
    private LocalDate dataDoJogo;
    private String estadio;
    private String cidade;
    private int placarMandante;
    private int placarVisitante;
    private final List<String> eventos;

    /**
     * Construtor padrão.
     * Inicializa a lista de eventos.
     */
    public Jogo(){
        this.eventos = new ArrayList<>();
    }

    /**
     * Construtor com parâmetros.
     *
     * @param mandante A equipe mandante.
     * @param visitante A equipe visitante.
     * @param dataDoJogo A data do jogo.
     * @param estadio O estádio onde o jogo será realizado.
     * @param cidade A cidade onde o jogo será realizado.
     */
    public Jogo(Equipa mandante, Equipa visitante, LocalDate dataDoJogo, String estadio, String cidade) {
        this.mandante = mandante;
        this.visitante = visitante;
        this.dataDoJogo = dataDoJogo;
        this.estadio = estadio;
        this.cidade = cidade;
        this.placarMandante = 0;
        this.placarVisitante = 0;
        this.eventos = new ArrayList<>();
    }

    /**
     * Gera o resultado do jogo.
     * Calcula a qualidade dos jogadores titulares de cada equipe e sorteia um resultado.
     * O resultado é um número entre 0 e 2, onde:
     * 0 - Empate
     * 1 - Vitória do mandante
     * 2 - Vitória do visitante
     * O resultado é influenciado por eventos como cartões vermelhos.
     */
    public void gerarResultado() {
        int totalQualidadeMandante = calcularTotalQualidadeJogadores(mandante.relacionarMelhoresJogadores());
        int totalQualidadeVisitante = calcularTotalQualidadeJogadores(visitante.relacionarMelhoresJogadores());
        Random random = new Random();

        int probabilidade = random.nextInt(100);

        int resultado;

        if (totalQualidadeMandante == totalQualidadeVisitante) {
            resultado = 0;
        } else if (totalQualidadeMandante < totalQualidadeVisitante) {
            resultado = 1;
        } else {
            resultado = 2;
        }

        if (eventos.contains("Cartao vermelho para mandante")) {
            resultado = 2;
        } else if (eventos.contains("Cartao vermelho para visitante")) {
            resultado = 1;
        }

        switch (resultado) {
            case 0:
                if (probabilidade < 20) {
                    placarMandante++;
                    eventos.add("Gol do mandante!");
                } else if (probabilidade < 40) {
                    placarVisitante++;
                    eventos.add("Gol do visitante!");
                }
                break;
            case 1:
                if (probabilidade < 50) {
                    placarVisitante++;
                    eventos.add("Gol do visitante!");
                } else if (probabilidade < 80) {
                    placarMandante++;
                    eventos.add("Gol do mandante!");
                }
                break;
            case 2:
                if (probabilidade < 50) {
                    placarMandante++;
                    eventos.add("Gol do mandante!");
                } else if (probabilidade < 80) {
                    placarVisitante++;
                    eventos.add("Gol do visitante!");
                }
                break;
        }
    }


    /**
     * Gera cartões para os jogadores.
     * Sorteia um número de cartões amarelos para cada equipe.
     */
    public void gerarCartoes() {
        Random random = new Random();
        int cartoesMandante = random.nextInt(11);
        int cartoesVisitante = random.nextInt(11);

        List<Jogador> mandanteTitulares = mandante.relacionarJogadores();
        List<Jogador> visitanteTitulares = visitante.relacionarJogadores();

        aplicarCartoes(mandanteTitulares, cartoesMandante, mandante);
        aplicarCartoes(visitanteTitulares, cartoesVisitante, visitante);
    }

    /**
     * Aplica cartões aos jogadores.
     * Sorteia um número de cartões amarelos e aplica os cartões randomicamente.
     *
     * @param jogadores A lista de jogadores que podem receber cartões.
     * @param numeroDeCartoes O número de cartões a ser aplicado.
     * @param equipa A equipe que está recebendo os cartões.
     *@note auxilia o @method gerarCartoes()
     */
    public void aplicarCartoes(List<Jogador> jogadores, int numeroDeCartoes, Equipa equipa) {
        Random random = new Random();

        IntStream.range(0, numeroDeCartoes).forEach(_ -> {
            int index = random.nextInt(11);
            Jogador jogador = jogadores.get(index);
            jogador.aplicarCartao(Cartao.AMARELO,1);
            eventos.add("Cartao " + Cartao.AMARELO.getDescricao() + " para " + jogador.getNome() + " do " + equipa.getNome());
            if (jogador.getSuspenso() == Suspenso.SIM) {
                eventos.add("Cartao vermelho para " + jogador.getNome() + " do " +equipa.getNome());
                List<Jogador> titulares = equipa.getRelacionados().subList(0, 11);
                if(titulares.contains(jogador)){
                    titulares.remove(jogador);
                    equipa.setJogadoresSuspensos(jogador);
                }
            }
        });
    }

    /**
     * Calcula a qualidade total dos jogadores de uma equipe.
     *
     * @param jogadores A lista de jogadores da equipe.
     * @return  a soma das qualidades dos jogadores.
     */
    private int calcularTotalQualidadeJogadores(List<Jogador> jogadores) {
        return jogadores.stream().mapToInt(Jogador::getQualidade).sum();
    }

    /**
     * Gera lesões para os jogadores.
     * Sorteia um número de lesões para cada equipe (máximo 2 lesões).
     */
    public void gerarLesao(){
        List<Jogador> mandanteEmCampo = mandante.relacionarJogadores();
        List<Jogador> visitantesEmCampo = visitante.relacionarJogadores();
        Random random = new Random();

        int lesaoMandante = random.nextInt(3);
        int lesaoVisitante = random.nextInt(3);

        IntStream.range(0, lesaoMandante).forEach(_ -> {
            int index = random.nextInt(mandanteEmCampo.size());
            Jogador jogador = mandanteEmCampo.get(index);
            jogador.sofrerLesao();
            eventos.add("Lesão do " + jogador.getNome() + "do mandante!");
            substituirJogador(jogador, mandante.relacionarJogadores().get(11), mandante);
        });

        IntStream.range(0, lesaoVisitante).forEach(_ -> {
            int index = random.nextInt(visitantesEmCampo.size());
            Jogador jogador = visitantesEmCampo.get(index);
            jogador.sofrerLesao();
            eventos.add("Lesão do " + jogador.getNome()  + "do visitante!");
            substituirJogador(jogador, visitante.relacionarJogadores().get(11), visitante);
        });

    }

    /**
     * Substitui um jogador por outro.
     * O jogador que está saindo é removido da lista de titulares e o jogador que está entrando é adicionado.
     *
     * @param jogadorSaindo O jogador que está saindo.
     * @param jogadorEntrando O jogador que está entrando.
     * @param equipe A equipe que está realizando a substituição.
     */
    public void substituirJogador(Jogador jogadorSaindo, Jogador jogadorEntrando, Equipa equipe) {
        List<Jogador> titulares = equipe.relacionarJogadores().subList(0, 11);
        List<Jogador> reservas = equipe.relacionarJogadores().subList(11, equipe.relacionarJogadores().size());

        if (titulares.contains(jogadorSaindo) && reservas.contains(jogadorEntrando)) {
            titulares.remove(jogadorSaindo);
            reservas.remove(jogadorEntrando);
            titulares.add(jogadorEntrando);
            reservas.add(jogadorSaindo);

            eventos.add("Substituição: Sai " + jogadorSaindo.getNome() + " e entra"+ jogadorEntrando.getNome() + " no " + equipe.getNome());
        }
    }

    /**
     * Exibe o resultado do jogo.
     * Exibe os eventos e o placar final do jogo.
     *
     * @throws InterruptedException se a thread for interrompida.
     */
    public void exibirResultado() throws InterruptedException {
        Thread.sleep(1000);
        eventos.forEach(CentralizadorTextoUtil::centralizarTexto);
        centralizarTexto("Fim do Jogo");
        Thread.sleep(1000);
        centralizarTexto(mandante.getNome() + " " + placarMandante + "X" + placarVisitante + " " +  visitante.getNome());
    }

    /**
     * Permite que os jogadores treinem.
     */
    public void permitirTreinamento() {
        mandante.relacionarMelhoresJogadores().forEach(Jogador::executarTreinamento);
        visitante.relacionarMelhoresJogadores().forEach(Jogador::executarTreinamento);
    }

    /**
     * Exibe as informações do jogo.
     */
    public void dadosJogo(){
        centralizarTexto("Jogo:\n|" + "Mandante=" + mandante.getNome() + ", Visitante=" + visitante.getNome() + ", dataDoJogo=" + dataDoJogo + ", estadio='" + estadio + ", cidade='" + cidade + ", placarMandante=" + placarMandante + ", placarVisitante=" + placarVisitante + ", eventos=" + eventos + '|');
    }

    public Equipa getMandante() {
        return mandante;
    }

    public void setMandante(Equipa mandante) {
        this.mandante = mandante;
    }

    public Equipa getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipa visitante) {
        this.visitante = visitante;
    }

    public LocalDate getDataDoJogo() {
        return dataDoJogo;
    }

    public void setDataDoJogo(LocalDate dataDoJogo) {
        this.dataDoJogo = dataDoJogo;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getPlacarMandante() {
        return placarMandante;
    }

    public int getPlacarVisitante() {
        return placarVisitante;
    }


}



