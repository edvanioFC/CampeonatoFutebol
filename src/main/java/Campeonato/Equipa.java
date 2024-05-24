
/*
public class Equipa {
    private String nome;
    private String apelido;
    private int fundacao;
    private ArrayList<Jogador> plantel;
    private ArrayList<Jogador> relacionados;

    public Equipa(String nome, String apelido, int fundacao, ArrayList<Jogador> plantel) {
        this.nome = nome;
        this.apelido = apelido;
        this.fundacao = fundacao;
        this.plantel = plantel;
        this.relacionados = new ArrayList<>();
    }

    public List<Jogador> relacionarJogadoresPorPosicao() {
        List<Jogador> titulares = new ArrayList<>();
        List<Jogador> reservas = new ArrayList<>();

        for (Posicao posicao : Posicao.values()) {
            List<Jogador> jogadoresPorPosicao = plantel.stream()
                    .filter(jogador -> jogador.getPosicao() == posicao && jogador.verificaCondicaoJogo())
                    .sorted(Comparator.comparingInt(Jogador::getQualidade).reversed())
                    .toList();

            jogadoresPorPosicao.stream()
                    .limit(11)
                    .forEach(titulares::add);


            jogadoresPorPosicao.stream()
                    .skip(11)
                    .limit(6)
                    .forEach(reservas::add);
        }

        return Stream.concat(titulares.stream(), reservas.stream()).toList();
    }

    public List<Jogador> relacionarMelhoresJogadores() {
        return plantel.stream()
                .filter(Jogador::verificaCondicaoJogo)
                .sorted(Comparator.comparingInt(Jogador::getQualidade).reversed())
                .limit(11)
                .collect(Collectors.toList());
    }

    public void imprimirEscalacao(List<Jogador> titulares, List<Jogador> reservas) {
        System.out.println("Escalação da equipe " + nome + " " + apelido);
        System.out.println("Titulares:");
        titulares.forEach(jogador ->
                System.out.println(jogador.getPosicao() + ": " + jogador.getNumero() + " - " + jogador.getNome() + " (" + jogador.getApelido() + ") - Qualidade: " + jogador.getQualidade())
        );
        System.out.println("Reservas:");
        reservas.forEach(jogador ->
                System.out.println(jogador.getPosicao() + ": " + jogador.getNumero() + " - " + jogador.getNome() + " (" + jogador.getApelido() + ") - Qualidade: " + jogador.getQualidade())
        );
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public int getFundacao() {
        return fundacao;
    }

    public void setFundacao(int fundacao) {
        this.fundacao = fundacao;
    }

    public ArrayList<Jogador> getPlantel() {
        return plantel;
    }

    public void setPlantel(ArrayList<Jogador> plantel) {
        this.plantel = plantel;
    }
}
*/

package Campeonato;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Enums.Posicao;

public class Equipa {
    private String nome;
    private String apelido;
    private int fundacao;
    private final ArrayList<Jogador> plantel;
    private ArrayList<Jogador> relacionados;
    private final ArrayList<Jogador> jogadoresSuspensos;


    public Equipa() {
        this.plantel = new ArrayList<>();
        this.relacionados = new ArrayList<>();
        this.jogadoresSuspensos = new ArrayList<>();
    }


    public Equipa(String nome, String apelido, int fundacao, ArrayList<Jogador> plantel) {
        this.nome = nome;
        this.apelido = apelido;
        this.fundacao = fundacao;
        this.plantel = plantel;
        this.relacionados = new ArrayList<>();
        this.jogadoresSuspensos = new ArrayList<>();
    }


    public List<Jogador> relacionarJogadores() {
        List<Jogador> titulares = new ArrayList<>();
        List<Jogador> reservas = new ArrayList<>();
        List<Jogador> jogadoresFiltrados = plantel.stream()
                .filter(Jogador::verificaCondicaoJogo)
                .toList();

        for (Posicao posicao : Posicao.values()) {
            List<Jogador> jogadoresPorPosicao = jogadoresFiltrados.stream()
                    .filter(jogador -> jogador.getPosicao() == posicao)
                    .sorted(Comparator.comparingInt(Jogador::getQualidade).reversed())
                    .toList();

            jogadoresPorPosicao.stream()
                    .limit(1)
                    .forEach(titulares::add);

            jogadoresPorPosicao.stream()
                    .skip(1)
                    .limit(1)
                    .forEach(reservas::add);
        }

        while (titulares.size() < 11) {
            jogadoresFiltrados.stream()
                    .filter(jogador -> !titulares.contains(jogador))
                    .max(Comparator.comparingInt(Jogador::getQualidade)).ifPresent(titulares::add);
        }

        while (reservas.size() < 7) {
            jogadoresFiltrados.stream()
                    .filter(jogador -> !titulares.contains(jogador) && !reservas.contains(jogador))
                    .max(Comparator.comparingInt(Jogador::getQualidade)).ifPresent(reservas::add);
        }

        relacionados = Stream.concat(titulares.stream(), reservas.stream()).collect(Collectors.toCollection(ArrayList::new));
        return relacionados;
    }

    public List<Jogador> relacionarMelhoresJogadores() {
        return plantel.stream()
                .filter(Jogador::verificaCondicaoJogo)
                .sorted(Comparator.comparingInt(Jogador::getQualidade).reversed())
                .limit(11)
                .collect(Collectors.toList());
    }

    public void adicionarJogador(Jogador jogador) {
        plantel.add(jogador);
    }

    public void imprimirEscalacao() {
        List<Jogador> titulares = relacionados.subList(0, 11);
        List<Jogador> reservas = relacionados.subList(11,18);

        System.out.println(STR."Escalação da equipe \{nome} \{apelido}");
        System.out.println("Titulares:");
        titulares.forEach(jogador ->
                System.out.println(STR."\{jogador.getPosicao()}: \{jogador.getNumero()} - \{jogador.getNome()} (\{jogador.getApelido()}) - Qualidade: \{jogador.getQualidade()}")
        );
        System.out.println("Reservas:");
        reservas.forEach(jogador ->
                System.out.println(STR."\{jogador.getPosicao()}: \{jogador.getNumero()} - \{jogador.getNome()} (\{jogador.getApelido()}) - Qualidade: \{jogador.getQualidade()}")
        );
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public int getFundacao() {
        return fundacao;
    }

    public void setFundacao(int fundacao) {
        this.fundacao = fundacao;
    }

    public ArrayList<Jogador> getPlantel() {
        return plantel;
    }

    public ArrayList<Jogador> getJogadoresSuspensos() {
        return jogadoresSuspensos;
    }

    public void setJogadoresSuspensos(Jogador jogador) {
        this.jogadoresSuspensos.add(jogador);
    }

    public ArrayList<Jogador> getRelacionados() {
        return relacionados;
    }
}
