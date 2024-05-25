package org.example;
import Campeonato.*;
import Enums.*;
import utils.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;
import static utils.CentralizadorTextoUtil.centralizarTexto;

/**
 * Classe principal para a aplicação IG11CampGest.
 * Esta classe contém métodos para criar equipes, registrar jogadores, simular jogos e muito mais.
 */
public class Ig11CampGest {

    /**
     * Scanner para entrada do usuário.
     */
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * Lista de equipes no campeonato.
     */
    public static final ArrayList<Equipa> equipas = new ArrayList<>();

    /**
     * Utilitário para verificar a entrada do usuário.
     */
    public static final VerificadorInputUtil inputChecker = new VerificadorInputUtil();

    /**
     * O jogo atual sendo jogado.
     */
    public static Jogo jogo;

    /**
     * Flag para controlar o loop principal da aplicação.
     */
    public static boolean flag = true;

    /**
     * Lida com a escolha do menu do usuário.
     *
     * @throws InterruptedException Se a thread for interrompida.
     */
    public static void opcoes() throws InterruptedException {
        int opcao = inputChecker.checkInt();
        switch (opcao) {
            case 1:
                criarEquipa();
                break;
            case 2:
                if (equipas.isEmpty()) {
                    centralizarTexto("Primeiro, crie pelo menos uma equipa.\n");
                } else {
                    cadastrarJogador();
                }

                break;
            case 3:
                padrao();
                break;
            case 4:
                if (equipas.size() < 2) {
                    centralizarTexto("Você precisa ter as equipas criadas para imprimir os planteis.\n");
                } else {
                    imprimirPlanteis();
                }
                break;
            case 5:
                if (equipas.size() < 2) {
                    centralizarTexto("Você precisa ter as equipas criadas para imprimir os convocados.\n");
                } else {
                    imprimirEscalacao();
                }
                break;
            case 6:
                if (equipas.size() < 2) {
                    centralizarTexto("É necessário ter pelo menos 2 equipas para simular um jogo.\n");
                } else {
                    simularJogo();
                }
                break;
            case 7:
                if (equipas.size() < 2) {
                    centralizarTexto("Treinamento só depois do jogo.\n");
                } else {
                    permitirTreinamento();
                }
                break;
            case 8:
                if (equipas.size() < 2) {
                    centralizarTexto("Precisamos ter equipas para aplicar cartão aos seus jogadores");
                } else {
                    aplicarCartao();
                }
                break;
            case 9:
                if (equipas.size() < 2) {
                    centralizarTexto("Precisamos ter equipas para aplicar suspensão aos seus jogadores");
                } else {
                    aplicarSuspensao();
                }
                break;
            case 10:
                if (equipas.size() < 2) {
                    centralizarTexto("Precisamos ter equipas para cumprir suspensão dos seus jogadores");
                } else {
                    cumpritSuspensao();
                }
                break;
            case 11:
                centralizarTexto("SAINDO");
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < i; j++) {
                        centralizarTexto(".");
                        Thread.sleep(1000);
                    }
                }
                centralizarTexto("Obrigado por usar o IG11CampGest!");
                flag = false;
                break;
            default:
                centralizarTexto("Opção inválida. Tente novamente.\n");
        }
    }

    /**
     * Exibe as instruções para a aplicação.
     */
    static void instrucao() {
        centralizarTexto("------------------------------------------------");
        centralizarTexto("BEM-VINDO AO IG11CAMPGEST");
        centralizarTexto("------------------------------------------------");
        centralizarTexto("Um Sistema de Gestão de Campeonato de Futebol");
        centralizarTexto("------------------------------------------------");
        centralizarTexto("Instruções de Utilização");
        centralizarTexto("------------------------------------------------");
        centralizarTexto("Crie pelo menos duas equipas para poder simular um jogo, as equipas devem ter um plantel de até 26 jogadores");
        centralizarTexto("Cadastre jogadores para as equipas, veja os planteis das equipas com os jogadores cadrastrados e simule um jogo entre as equipas");
        centralizarTexto("Os 18 melhores jogadores baseando em posição e qualidade serão convocados para o jogo");
        centralizarTexto("Ou simplemente carrege equipas já predefinidas, reveja os planteis e vá direto pra simulação");
    }

    /**
     * Exibe o menu principal da aplicação.
     */
    public static void menu() {
        centralizarTexto("-------------------------------------------");
        centralizarTexto("Menu");
        centralizarTexto("-------------------------------------------");
        centralizarTexto("------------1. Criar Equipas---------------");
        centralizarTexto("------------2. Cadastrar Jogador-----------");
        centralizarTexto("------------3. Carregar 2 Equipas prontas--");
        centralizarTexto("------------4. Imprimir Planteis-----------");
        centralizarTexto("------------5. Imprimir Convocados---------");
        centralizarTexto("------------6. Simular Jogo----------------");
        centralizarTexto("------------7. Permitir Treinamento--------");
        centralizarTexto("------------8. Aplicar Cartão--------------");
        centralizarTexto("------------9. aplicar Suspensão----------");
        centralizarTexto("------------10. Cumpri Suspensão-----------");
        centralizarTexto("------------11. Sair-----------------------");
        centralizarTexto("---------------Escolha uma opção_________: ");
    }

    /**
     * Lida com a opção de menu "Aplicar Cartão".
     */
    public static void aplicarCartao() {
        exibirEquipas();
        int equipaEscolhida = getValidarEquipa();
        Equipa equipa = equipas.get(equipaEscolhida);
        exibirJogadores(equipa);
        int jogadorEscolhido = getValidJogador(equipa);
        aplicarCartaoJogador(equipa, jogadorEscolhido);
    }

    /**
     * Aplica um cartão amarelo a um jogador.
     *
     * @param equipa A equipe do jogador.
     * @param jogadorIndex O índice do jogador na lista de jogadores da equipe.
     */
    public static void aplicarCartaoJogador(Equipa equipa, int jogadorIndex) {
        Jogador jogador = equipa.getRelacionados().get(jogadorIndex);
        jogador.aplicarCartao(Cartao.AMARELO, 1);
        CentralizadorTextoUtil.centralizarTexto("Jogador " + jogador.getNome() + " recebeu um cartão amarelo");
    }

    /**
     * Aplica uma suspensão a um jogador.
     */
    public static void aplicarSuspensao() {
        exibirEquipas();
        int equipaEscolhida = getValidarEquipa();
        Equipa equipa = equipas.get(equipaEscolhida);
        exibirJogadores(equipa);
        int jogadorEscolhido = getValidJogador(equipa);
        suspenderJogador(equipa, jogadorEscolhido);
    }

    /**
     * Permitir um jogador cumprir a suspensão.
     */
    public static void cumpritSuspensao() {
        exibirEquipas();
        int equipaEscolhida = getValidarEquipa();
        Equipa equipa = equipas.get(equipaEscolhida);
        exibirJogadores(equipa);
        int jogadorEscolhido = getValidJogador(equipa);
        Jogador jogador = equipa.getRelacionados().get(jogadorEscolhido);
        if (jogador.getSuspenso() == Suspenso.SIM) {
            jogador.cumprirSuspencao();
        } else {
            centralizarTexto("Jogador não está suspenso");
        }
    }

    /**
     * Mostra as equipes disponíveis.
     */
    public static void exibirEquipas() {
        IntStream.range(0, equipas.size())
                .forEach(i -> centralizarTexto((i + 1) + ". " + equipas.get(i).getNome()));
    }

    /**
     * Obtém um índice de equipe válido do usuário.
     * O método solicita ao usuário que insira um número inteiro. Se o número inteiro inserido for menor que 0 ou maior que o tamanho da lista de equipes,
     * o método solicita ao usuário que insira outro número inteiro. Isso continua até que o usuário insira um número inteiro válido.
     *
     * @return O índice da equipe escolhida.
     */
    public static int getValidarEquipa() {
        int index = inputChecker.checkInt();
        while (index < 0 || index > equipas.size()) {
            centralizarTexto("Equipa não encontrada. Tente novamente.");
            index = inputChecker.checkInt();
        }
        return index;
    }

    public static void exibirJogadores(Equipa equipa) {
        IntStream.range(0, equipa.getRelacionados().size())
                .forEach(i -> centralizarTexto((i + 1) + ". " + equipa.getRelacionados().get(i).exibirJogador()));
    }

    /**
     * Obtém um índice de jogador válido do usuário.
     * O método solicita ao usuário que insira um número inteiro. Se o número inteiro inserido for menor que 0 ou maior que o tamanho da lista de jogadores,
     * o método solicita ao usuário que insira outro número inteiro. Isso continua até que o usuário insira um número inteiro válido.
     *
     * @return O índice do jogador escolhida.
     */
    public static int getValidJogador(Equipa equipa) {
        int index = inputChecker.checkInt() - 1;
        while (index < 0 || index > equipa.getPlantel().size()) {
            centralizarTexto("Jogador não encontrado. Tente novamente.");
            index = inputChecker.checkInt() - 1;
        }

        return index;
    }

    /**
     * Suspende um jogador.
     * Este método obtém um jogador de uma equipe com base no índice fornecido e define seu status como suspenso.
     * Em seguida, exibe uma mensagem informando que o jogador foi suspenso.
     *
     * @param equipa A equipe do jogador.
     * @param jogadorIndex O índice do jogador na lista de jogadores da equipe.
     */
    public static void suspenderJogador(Equipa equipa, int jogadorIndex) {
        Jogador jogador = equipa.getRelacionados().get(jogadorIndex);
        jogador.setSuspenso(Suspenso.SIM);
        CentralizadorTextoUtil.centralizarTexto("Jogador " + jogador.getNome() + "foi suspenso");
    }

    /**
     * Permite que um jogador treine
     */
    public static void permitirTreinamento() {
        if (jogo != null) {
            jogo.permitirTreinamento();
        } else {
            centralizarTexto("Simule um jogo e depois execute o treinamento");
        }
    }

    /**
     * Cria uma nova equipe.
     * Este método solicita ao usuário que insira a quantidade de equipes que deseja criar.
     * Enquanto a quantidade for menor que 0, o método solicita ao usuário que insira outro número.
     * Em seguida, para cada equipe a ser criada, o método solicita ao usuário que insira o nome, o apelido e o ano de fundação da equipe.
     * Uma nova equipe é criada com esses dados e adicionada à lista de equipes.
     * Finalmente, uma mensagem é exibida informando que a equipe foi criada com sucesso.
     */
    public static void criarEquipa() {
        centralizarTexto("Quantidade de Equipas que pretende criar: ");
        int quantidade = inputChecker.checkInt();
        while (quantidade < 0) {
            centralizarTexto("Quantidade não pode ser negativa");
            quantidade = inputChecker.checkInt();
        }
        while (equipas.size() < quantidade) {
            centralizarTexto("Nome da Equipa: ");
            String nome = inputChecker.checkName();

            centralizarTexto("Apelido da Equipa: ");
            String apelido = inputChecker.checkName();

            centralizarTexto("Ano de Fundação: ");
            int fundacao = inputChecker.checkInt();

            Equipa equipa = new Equipa(nome, apelido, fundacao, new ArrayList<>());
            equipas.add(equipa);

            centralizarTexto("Equipa criada com sucesso!");
        }

        centralizarTexto("Equipas criadas com sucesso!");
    }

    /**
     * Cadastra um novo jogador.
     * Este método solicita ao usuário que insira o ID, o nome, o apelido, a data de nascimento, o número, a posição, a qualidade e a equipe do jogador.
     * Em seguida, o jogador é criado com esses dados e adicionado à equipe escolhida.
     * Finalmente, uma mensagem é exibida informando que o jogador foi cadastrado com sucesso.
     */
    public static void cadastrarJogador() {
        centralizarTexto("ID: ");
        int id = inputChecker.checkInt();

        centralizarTexto("Nome: ");
        String nome = inputChecker.checkName();

        centralizarTexto("Apelido: ");
        String apelido = inputChecker.checkName();

        centralizarTexto("Data de Nascimento (AAAA-MM-DD): ");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());

        centralizarTexto("Número: ");
        int numero = inputChecker.checkInt();

        centralizarTexto("Posição:");
        for (Posicao posicao : Posicao.values()) {
            centralizarTexto(posicao.ordinal() + 1 + ". " + posicao.getDescricao());
        }
        centralizarTexto("Escolha uma posição: ");
        int posicaoEscolhida = inputChecker.checkInt() - 1;
        while (posicaoEscolhida < 0 || posicaoEscolhida >= Posicao.values().length) {
            centralizarTexto("Posição inválida. Tente novamente.");
            posicaoEscolhida = inputChecker.checkInt() - 1;
        }

        Posicao posicao = Posicao.values()[posicaoEscolhida];

        centralizarTexto("Qualidade (0-100): ");
        int qualidade = inputChecker.checkInt();
        while (qualidade < 0 || qualidade > 100) {
            centralizarTexto("Qualidade deve ser um valor entre 0 e 100.");
            qualidade = inputChecker.checkInt();
        }

        centralizarTexto("Escolha a equipa do jogador:");
        for (int i = 0; i < equipas.size(); i++) {
            centralizarTexto((i + 1) + ". " + equipas.get(i).getNome());
        }
        int equipaEscolhida = inputChecker.checkInt() - 1;
        while (equipaEscolhida < 0 || equipaEscolhida > equipas.size()) {
            centralizarTexto("equipa não encontrada. Tente novamente.");
            equipaEscolhida = inputChecker.checkInt() - 1;
        }

        Equipa equipa = equipas.get(equipaEscolhida);

        Jogador jogador = new Jogador(id, nome, apelido, dataNascimento, numero, posicao, qualidade);
        equipa.adicionarJogador(jogador);

        centralizarTexto("Jogador cadastrado com sucesso na equipa " + equipa.getNome() + "!");
    }

    /**
     * Carrega as equipes padrão.
     * Este método verifica se existem menos de duas equipes na lista de equipes.
     * Se houver menos de duas equipes, ele cria duas equipes padrão e as adiciona à lista de equipes.
     * Uma mensagem é então exibida indicando que as equipes padrão foram carregadas com sucesso.
     * Se já existirem duas ou mais equipes na lista, uma mensagem é exibida indicando que não é possível carregar as equipes padrão.
     */
    public static void padrao() {
        if (equipas.size() < 2) {
            Equipa equipaMandante = criarEquipaPadrao();
            Equipa equipaVisitante = criarEquipaPadrao();
            equipas.add(equipaMandante);
            equipas.add(equipaVisitante);
            centralizarTexto("Equipas padrão carregadas com sucesso!");
        } else {
            centralizarTexto("Já existem equipas cadastradas. Não é possível carregar as equipas padrão.");
        }
    }

    /**
     * Cria uma equipe padrão.
     * Este método cria uma lista de jogadores e, para cada jogador de 1 a 26, adiciona um novo jogador à lista.
     * O novo jogador é criado com um ID igual ao índice do loop, um nome e apelido gerados aleatoriamente, uma data de nascimento gerada aleatoriamente,
     * um número igual ao índice do loop, uma posição obtida a partir do índice do loop e uma qualidade gerada a partir do índice do loop.
     * Finalmente, uma nova equipe é criada com um nome e apelido gerados aleatoriamente, o ano de fundação definido como 1900 e a lista de jogadores criada.
     * A nova equipe é então retornada.
     *
     * @return A equipe padrão criada.
     */
    private static Equipa criarEquipaPadrao() {
        ArrayList<Jogador> jogadores = new ArrayList<>();
        for (int i = 1; i <= 26; i++) {
            jogadores.add(new Jogador(
                    i,
                    GeradorNomesUtil.gerarNome(),
                    GeradorNomesUtil.gerarApelido(),
                    GeradorDataUtil.gerarDataAleatoria(),
                    i,
                    obterPosicao(i),
                    gerarQualidade(i)
            ));
        }
        return new Equipa(GeradorNomesUtil.gerarNome(), GeradorNomesUtil.gerarApelido(), 1900, jogadores);
    }

    /**
     * Obtém uma posição baseada em um número.
     * Este método retorna uma posição do enum Posicao baseada no resto da divisão do número fornecido por 11.
     * Isso garante que o valor retornado esteja sempre dentro do intervalo de índices válidos para o array de valores do enum Posicao.
     *
     * @param numero O número usado para calcular a posição.
     * @return A posição calculada.
     */
    private static Posicao obterPosicao(int numero) {
        return Posicao.values()[numero % 11];
    }

    /**
     * Gera um valor de qualidade para um jogador.
     * Este método calcula um valor de qualidade baseado em um número fornecido.
     * O valor de qualidade é calculado adicionando 75 ao produto do resto da divisão do número por 11 e 2.
     * Isso garante que o valor de qualidade gerado esteja sempre entre 75 e 95.
     *
     * @param numero O número usado para calcular a qualidade.
     * @return A qualidade calculada.
     */
    private static int gerarQualidade(int numero) {
        return 75 + (numero % 11) * 2;
    }

    /**
     * Imprime a escalação das equipes.
     * Este método percorre a lista de equipes e, para cada equipe, chama o método relacionarJogadores() para definir os jogadores relacionados para o jogo.
     * Em seguida, chama o método imprimirEscalacao() para imprimir a escalação da equipe.
     */
    public static void imprimirEscalacao() {
        for (Equipa equipa : equipas) equipa.relacionarJogadores();
        /* centralizarTexto("Convocações das Equipas:"); */
        for (Equipa equipa : equipas) equipa.imprimirEscalacao();
        centralizarTexto(" \n \n");
    }

    /**
     * Imprime os planteis das equipes.
     * Este método percorre a lista de equipes e, para cada equipe, chama o método imprimirPlantel() para imprimir o plantel da equipe..
     */
    public static void imprimirPlanteis() {
        centralizarTexto("--------------------------------------------");
        centralizarTexto("Planteis das Equipas:");
        centralizarTexto("--------------------------------------------");
        for (Equipa equipa : equipas) equipa.imprimirPlantel();
        centralizarTexto(" \n \n \n");
    }

    /**
     * Simula um jogo.
     * Este método solicita ao usuário que escolha as equipes mandante e visitante a partir de uma lista de equipes disponíveis.
     * Em seguida, verifica se ambas as equipes têm pelo menos 23 jogadores. Se não tiverem, o método retorna e o jogo não é simulado.
     * Se ambas as equipes tiverem pelo menos 23 jogadores, o método prossegue para gerar uma data aleatória para o jogo e solicita ao usuário que insira o nome do estádio e da cidade.
     * Em seguida, um novo jogo é criado com as equipes escolhidas, a data gerada, o estádio e a cidade inseridos pelo usuário.
     * O método então exibe os dados do jogo e inicia o jogo.
     * Durante o jogo, o resultado é gerado, os cartões são distribuídos, as lesões são geradas e o resultado é exibido.
     * @throws InterruptedException Se a thread for interrompida.
     */
    public static void simularJogo() throws InterruptedException {
        centralizarTexto("Escolha a equipa mandante:");
        for (int i = 0; i < equipas.size(); i++) {
            centralizarTexto(String.format("%d. %s", i + 1, equipas.get(i).getNome()));
        }

        int mandanteIndex = inputChecker.checkInt() - 1;
        while (mandanteIndex < 0 || mandanteIndex >= equipas.size()) {
            centralizarTexto("Equipa não encontrada. Tente novamente.");
            mandanteIndex = inputChecker.checkInt() - 1;
        }

        centralizarTexto("Escolha a equipa visitante:");
        for (int i = 0; i < equipas.size(); i++) {
            if (i != mandanteIndex) {
                centralizarTexto((i + 1) + " " + equipas.get(i).getNome());
            }
        }

        int visitanteIndex = inputChecker.checkInt() - 1;
        while (visitanteIndex < 0 || visitanteIndex >= equipas.size() || visitanteIndex == mandanteIndex) {
            centralizarTexto("Equipa não encontrada Ou já selecionada. Tente novamente.");
            visitanteIndex = inputChecker.checkInt() - 1;
        }

        Equipa mandante = equipas.get(mandanteIndex);
        Equipa visitante = equipas.get(visitanteIndex);

        if (mandante.getPlantel().size() < 23 || visitante.getPlantel().size() < 26) {
            centralizarTexto("Ambas as equipas precisam ter 23 jogadores no mínimo.");
            return;
        }

        centralizarTexto("Gerando Data do Jogo (AAAA-MM-DD)...");
        LocalDate dataDoJogo = GeradorDataUtil.gerarDataAleatoria();
        centralizarTexto("A data do jogo foi definida para: " + dataDoJogo);

        centralizarTexto("Nome do Estádio: ");
        String estadio = inputChecker.checkName();

        centralizarTexto("Nome da Cidade: ");
        String cidade = inputChecker.checkName();

        jogo = new Jogo(mandante, visitante, dataDoJogo, estadio, cidade);

        centralizarTexto("Dados do Jogo: ");
        jogo.dadosJogo();

        centralizarTexto("Jogo entre " + mandante.getNome() + "  E  " + visitante.getNome() + " foi iniciado!");

        jogo.gerarResultado();
        jogo.gerarCartoes();
        jogo.gerarLesao();
        jogo.gerarResultado();
        jogo.exibirResultado();
    }

    /**
     * @return O estado da flag de controle da aplicação
     */
    public static Boolean isFlag() {
        return flag;
    }

    /**
     * @return o scanner para input do usuário.
     */
    public AutoCloseable getScanner() {
        return scanner;
    }

}


