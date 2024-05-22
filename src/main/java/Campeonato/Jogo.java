package Campeonato;
import Enums.Suspenso;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.IntStream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import Enums.Suspenso;

public class Jogo {
    private Equipa mandante;
    private Equipa visitante;
    private LocalDate dataDoJogo;
    private String estadio;
    private String cidade;
    private int placarMandante;
    private int placarVisitante;
    private List<String> eventos;

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

    public void gerarResultado() {
        int totalQualidadeMandante = calcularTotalQualidadeJogadores(mandante.relacionarMelhoresJogadores());
        int totalQualidadeVisitante = calcularTotalQualidadeJogadores(visitante.relacionarMelhoresJogadores());

        Random random = new Random();
        int probabilidadeMandante = totalQualidadeMandante + random.nextInt(30);
        int probabilidadeVisitante = totalQualidadeVisitante + random.nextInt(30);

        placarMandante = random.nextInt(5);
        placarVisitante = random.nextInt(5);

        while (placarMandante == placarVisitante) {
            placarMandante = random.nextInt(5);
            placarVisitante = random.nextInt(5);
        }

        if (probabilidadeMandante > probabilidadeVisitante) {
            placarMandante++;
        } else if (probabilidadeVisitante > probabilidadeMandante) {
            placarVisitante++;
        }
    }

    private int calcularTotalQualidadeJogadores(List<Jogador> jogadores) {
        return jogadores.stream().mapToInt(Jogador::getQualidade).sum();
    }

    public void registrarEventos() {
        Random random = new Random();
        mandante.relacionarMelhoresJogadores().forEach(jogador -> {
            if (random.nextInt(100) < 5) {
                eventos.add(jogador.getNome() + " sofreu uma lesão.");
                jogador.sofrerLesao();
            }
            if (random.nextInt(100) < 5) {
                eventos.add(jogador.getNome() + " recebeu um cartão amarelo.");
                jogador.aplicarCartao(1);
            }
        });
        visitante.relacionarMelhoresJogadores().forEach(jogador -> {
            if (random.nextInt(100) < 5) {
                eventos.add(jogador.getNome() + " sofreu uma lesão.");
                jogador.sofrerLesao();
            }
            if (random.nextInt(100) < 5) {
                eventos.add(jogador.getNome() + " recebeu um cartão amarelo.");
                jogador.aplicarCartao(1);
            }
        });
    }

    public void exibirResultado() {
        System.out.println("Resultado do Jogo:");
        System.out.println(mandante.getNome() + " " + placarMandante + " x " + placarVisitante + " " + visitante.getNome());
        eventos.forEach(System.out::println);
    }

    public void permitirTreinamento() {
        mandante.relacionarMelhoresJogadores().forEach(Jogador::executarTreinamento);
        visitante.relacionarMelhoresJogadores().forEach(Jogador::executarTreinamento);
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

    public void setPlacarMandante(int placarMandante) {
        this.placarMandante = placarMandante;
    }

    public int getPlacarVisitante() {
        return placarVisitante;
    }

    public void setPlacarVisitante(int placarVisitante) {
        this.placarVisitante = placarVisitante;
    }



}




/*
public class Jogo {
    private Equipa mandante;
    private Equipa visitante;
    private LocalDate dataDoJogo;
    private String estadio;
    private String cidade;
    private int placarMandante;
    private int placarVisitante;
    List <Jogador> jogadoresEmCampoMandante;
    List <Jogador> jogadoresEmCampoVisitante;
    private List<String> eventos;


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

    public void gerarResultado(){
        int totalQualidadeMandante = calcularTotalQualidadeJogadores(mandante.relacionarMelhoresJogadores());
        int totalQualidadeVisitante = calcularTotalQualidadeJogadores(visitante.relacionarMelhoresJogadores());

        Random random = new Random();
        int probabilidade = random.nextInt(100);

        int resultado;

        if(totalQualidadeMandante == totalQualidadeVisitante){
            resultado = 0;
        } else if (totalQualidadeMandante < totalQualidadeVisitante){
            resultado = 1;
        } else {
            resultado = 2;
        }


        if (eventos.contains("Cartao vermelho para mandante")) {
            resultado = 1;
        } else if (eventos.contains("Cartao vermelho para visitante")) {
            resultado = 2;
        }

        switch (resultado){
            case 0:
                if(probabilidade < 20){
                    placarMandante++;
                    eventos.add("Gol do mandante!");
                } else if (probabilidade < 40){
                    placarVisitante++;
                    eventos.add("Gol do visitante!");
                }
                break;
            case 1:
                if(probabilidade < 50){
                    placarVisitante++;
                    eventos.add("Gol do visitante!");
                } else if (probabilidade < 80){
                    placarMandante++;
                    eventos.add("Go do mandante!");
                }
                break;
            case 2:
                if(probabilidade < 50){
                    placarMandante++;
                    eventos.add("Gol do mandante!");
                } else if (probabilidade < 80){
                    placarVisitante++;
                    eventos.add("Gol do visitante!");
                }
                break;
        }


    }

    public void gerarLesoes() {
        Random random = new Random();
        int lesaoMandante = random.nextInt(3);
        int lesaoVisitante = random.nextInt(3);

        List<Jogador> mandanteTitulares = mandante.relacionarJogadoresPorPosicao();
        List<Jogador> visitanteTitulares = visitante.relacionarJogadoresPorPosicao();



        IntStream.range(0, lesaoMandante).forEach(i -> {
            int index = random.nextInt(mandanteTitulares.size());
            Jogador jogador = mandanteTitulares.get(index);
            jogador.sofrerLesao();
            eventos.add("Lesão do " + jogador.getNome() + " do mandante!");
        });

        IntStream.range(0, lesaoVisitante).forEach(i -> {
            int index = random.nextInt(visitanteTitulares.size());
            Jogador jogador = visitanteTitulares.get(index);
            jogador.sofrerLesao();
            eventos.add("Lesão do " + jogador.getNome() + " do visitante!");
        });
    }

    public void gerarCartoes() {
        Random random = new Random();
        int cartoesMandante = random.nextInt(11);
        int cartoesVisitante = random.nextInt(11);

        List<Jogador> mandanteTitulares = mandante.relacionarJogadoresPorPosicao();
        List<Jogador> visitanteTitular = visitante.relacionarJogadoresPorPosicao();

//        for (int i = 0; i < cartoesMandante; i++) {
//            int index = random.nextInt(mandanteTitulares.size());
//            Jogador jogador = mandanteTitulares.get(index);
//            jogador.aplicarCartao(1);
//        }
//
//        for (int i = 0; i < cartoesVisitante; i++) {
//            int index = random.nextInt(visitanteTitular.size());
//            Jogador jogador = visitanteTitular.get(index);
//            jogador.aplicarCartao(1);
//        }

        IntStream.range(0, cartoesMandante).forEach(i -> {
            int index = random.nextInt(mandanteTitulares.size());
            Jogador jogador = mandanteTitulares.get(index);
            jogador.aplicarCartao(1);
            eventos.add("Cartao amarelo para " + jogador.getNome() + " do mandante.");
            if (jogador.getSuspenso() == Suspenso.SIM){
                eventos.add("Cartao vermelho para "+jogador.getNome() + " do mandante.");
            } else {
                eventos.add("Cartao amarelo para "+jogador.getNome() + " do mandante.");
            }
        });

        IntStream.range(0, cartoesVisitante).forEach(i -> {
            int index = random.nextInt(visitanteTitular.size());
            Jogador jogador = visitanteTitular.get(index);
            jogador.aplicarCartao(1);
            eventos.add("Cartao amarelo para "+jogador.getNome() + " do visitante.");
            if (jogador.getSuspenso() == Suspenso.SIM){
                eventos.add("Cartao vermelho para "+jogador.getNome() + " do visitante.");
            }
        });
    }

    public void permitirTreinamento() {
        List<Jogador> mandanteTitulares = mandante.relacionarJogadoresPorPosicao();
        List<Jogador> visitanteTitulares = visitante.relacionarJogadoresPorPosicao();

        mandanteTitulares.forEach(Jogador::executarTreinamento);
        visitanteTitulares.forEach(Jogador::executarTreinamento);
    }

    private int calcularTotalQualidadeJogadores(List<Jogador> jogadores) {
        return jogadores.stream()
                .mapToInt(Jogador::getQualidade)
                .sum();
    }

    public void imprimirPlantel(Equipa equipa) {
        System.out.println("Plantel da equipe " + equipa.getNome() + " " + equipa.getApelido());
        equipa.relacionarJogadoresPorPosicao().forEach(jogador -> {
            String condicao = jogador.getSuspenso() == Suspenso.SIM ? "SUSPENSO" : "TA PRA JOGO";
            System.out.println(jogador.getNome() + " (" + jogador.getApelido() + ") - Qualidade: " + jogador.getQualidade() + " - " + jogador.getDataNascimento()+ "  - Condição: " + condicao);
        });
    }

    public void imprimirPlanteis(){
        imprimirPlantel(mandante);
        imprimirPlantel(visitante);
    }


    public void imprimirEventos() {
        System.out.println("Eventos do jogo:");
        for (String evento : eventos) {
            System.out.println(evento);
        }
    }

    public void imprimirResultado() {
        System.out.println("Placar final:");
        System.out.println(mandante.getNome() + " " + placarMandante + " x " + placarVisitante + " " + visitante.getNome());
    }

    public void selecaoJogadores(){
        jogadoresEmCampoMandante = mandante.relacionarMelhoresJogadores();
        jogadoresEmCampoVisitante = visitante.relacionarMelhoresJogadores();
    }

    public void removerJogadoresSuspensos() {
        jogadoresEmCampoMandante.removeIf(jogador -> jogador.getSuspenso() == Suspenso.SIM);
        jogadoresEmCampoVisitante.removeIf(jogador -> jogador.getSuspenso() == Suspenso.SIM);
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

    public void setPlacarMandante(int placarMandante) {
        this.placarMandante = placarMandante;
    }

    public int getPlacarVisitante() {
        return placarVisitante;
    }

    public void setPlacarVisitante(int placarVisitante) {
        this.placarVisitante = placarVisitante;
    }

}
*/

