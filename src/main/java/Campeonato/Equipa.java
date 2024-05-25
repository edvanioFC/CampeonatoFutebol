package Campeonato;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import Enums.Posicao;
import static utils.CentralizadorTextoUtil.centralizarTexto;

/**
 * Classe que representa uma equipe em um campeonato.
 * Contém informações sobre a equipe, como nome, apelido, ano de fundação e lista de jogadores.
 */
public class Equipa {
    private String nome;
    private String apelido;
    private int fundacao;
    private final ArrayList<Jogador> plantel;
    private ArrayList<Jogador> relacionados;
    private final ArrayList<Jogador> jogadoresSuspensos;

    /**
     * Construtor padrão.
     * Inicializa as listas de jogadores.
     */
    public Equipa() {
        this.plantel = new ArrayList<>();
        this.relacionados = new ArrayList<>();
        this.jogadoresSuspensos = new ArrayList<>();
    }

    /**
     * Construtor com parâmetros.
     *
     * @param nome Nome da equipe.
     * @param apelido Apelido da equipe.
     * @param fundacao Ano de fundação da equipe.
     * @param plantel Lista de jogadores da equipe.
     *
     * @note A lista de jogadores é inicializada com uma lista vazia.
     * @note A lista de jogadores relacionados é inicializada com uma lista vazia.
     */
    public Equipa(String nome, String apelido, int fundacao, ArrayList<Jogador> plantel) {
        this.nome = nome;
        this.apelido = apelido;
        this.fundacao = fundacao;
        this.plantel = plantel;
        this.relacionados = new ArrayList<>();
        this.jogadoresSuspensos = new ArrayList<>();
    }

    /**
     * Relaciona os jogadores para um jogo.
     * Os jogadores são selecionados com base em sua posição e qualidade.
     * A seleção é feita da seguinte forma:
     * Posição titular: 1 jogador por posição com a maior qualidade.
     * Posição reserva: 1 jogador por posição com a segunda maior qualidade.
     * @note Depende se a quantidade de titulares e reservas for atingida
     *
     * @return A lista de jogadores relacionados para o jogo.
     */
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

    /**
     * Relaciona os melhores jogadores da equipe.
     * Os jogadores são selecionados com base em sua posição na lista dos relacionados que vem do @method relacionarJogadores().
     *
     * @return A lista dos melhores jogadores da equipe.
     */
    public List<Jogador> relacionarMelhoresJogadores() {
        return plantel.stream()
                .filter(Jogador::verificaCondicaoJogo)
                .sorted(Comparator.comparingInt(Jogador::getQualidade).reversed())
                .limit(11)
                .collect(Collectors.toList());
    }

    /**
     * Adiciona um jogador ao plantel da equipe.
     *
     * @param jogador O jogador a ser adicionado.
     */
    public void adicionarJogador(Jogador jogador) {
        plantel.add(jogador);
    }


    /**
     * Imprime as informações do plantel da equipe.
     */
    public void imprimirPlantel(){
        centralizarTexto("-----------------------------------------------");
        centralizarTexto("PLANTEL DA  " + nome + "- ("+apelido+")");
        centralizarTexto("-----------------------------------------------");
        plantel.forEach(jogador ->
                centralizarTexto(jogador.getPosicao() + " " + jogador.getNumero() + " " + jogador.getNome() + " (" + jogador.getApelido() + ") - " + jogador.getDataNascimento() + " - Condição: " + jogador.condicao() )
        );
    }

    /**
     * Imprime a escalação da equipe para um jogo 18 jogadores, 11 titulares e 7 reservas.
     */
    public void imprimirEscalacao() {
        List<Jogador> titulares = relacionados.subList(0, 11);
        List<Jogador> reservas = relacionados.subList(11,18);

        centralizarTexto("--------------------------------------------------------------------------------");
        centralizarTexto("ESCALAÇÃO DA  " + nome + "-("+apelido+")");
        centralizarTexto("TITULARES:");
        titulares.forEach(jogador -> {
                    centralizarTexto("--------------------------------------------------------------------------------");
                    centralizarTexto(jogador.getPosicao() + " " + jogador.getNumero() + " " + jogador.getNome() + " " + jogador.getApelido() + "- Qualidade: " + jogador.getQualidade());
                }
        );
        centralizarTexto( "--------------------------------------------------------------------------------");
        centralizarTexto("RESERVAS:");
        reservas.forEach(jogador -> {

            centralizarTexto( "--------------------------------------------------------------------------------");
            centralizarTexto(jogador.getPosicao() + " " + jogador.getNumero() + " " + jogador.getNome() + " " + jogador.getApelido() + " -Qualidade: " + jogador.getQualidade());
                }
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
