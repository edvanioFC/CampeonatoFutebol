package Campeonato;

import Enums.*;
import java.time.LocalDate;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jogo {
    private Equipa mandante;
    private Equipa visitante;
    private LocalDate dataDoJogo;
    private String estadio;
    private String cidade;
    private int placarMandante;
    private int placarVisitante;
    private final List<String> eventos;


    public Jogo(){
        this.eventos = new ArrayList<>();
    }

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

    public void gerarCartoes() {
        Random random = new Random();
        int cartoesMandante = random.nextInt(11);
        int cartoesVisitante = random.nextInt(11);

        List<Jogador> mandanteTitulares = mandante.getRelacionados();
        List<Jogador> visitanteTitulares = visitante.getRelacionados();

        aplicarCartoes(mandanteTitulares, cartoesMandante, mandante);
        aplicarCartoes(visitanteTitulares, cartoesVisitante, visitante);
    }

    public void aplicarCartoes(List<Jogador> jogadores, int numeroDeCartoes, Equipa equipa) {
        Random random = new Random();

        IntStream.range(0, numeroDeCartoes).forEach(_ -> {
            int index = random.nextInt(11);
            Jogador jogador = jogadores.get(index);
            jogador.aplicarCartao(Cartao.AMARELO,1);
            eventos.add("Cartao" + Cartao.AMARELO.getDescricao() + " para o " + jogador.getNome() + "do " + equipa.getNome());
            if (jogador.getSuspenso() == Suspenso.SIM) {
                eventos.add("Cartao vermelho para " + jogador.getNome() + "do " +equipa.getNome());
                List<Jogador> titulares = equipa.getRelacionados().subList(0, 11);
                if(titulares.contains(jogador)){
                    titulares.remove(jogador);
                    equipa.setJogadoresSuspensos(jogador);
                }
            }
        });
    }


    private int calcularTotalQualidadeJogadores(List<Jogador> jogadores) {
        return jogadores.stream().mapToInt(Jogador::getQualidade).sum();
    }

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

    public void exibirResultado() {
        System.out.println("Resultado do Jogo:");
        eventos.forEach(System.out::println);
        System.out.println(mandante.getNome() + " " + placarMandante + "X" + placarVisitante + " " +  visitante.getNome());
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

    public int getPlacarVisitante() {
        return placarVisitante;
    }

    @Override
    public String toString(){
        return "Jogo|" +
                "mandante=" + mandante +'\''+
                ", visitante=" + visitante +'\'' +
                ", dataDoJogo=" + dataDoJogo +'\'' +
                ", estadio='" + estadio +'\''+
                ", cidade='" + cidade + '\'' +
                ", placarMandante=" + placarMandante +'\'' +
                ", placarVisitante=" + placarVisitante  +'\''+
                ", eventos=" + eventos +'\''+
                '|';
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

