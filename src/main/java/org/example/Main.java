package org.example;

public class Main{
    public static void main(String[] args) throws Exception {
        Ig11Camp gestorCampeonato = new Ig11Camp();
        Ig11Camp.instrucao();
        while (Ig11Camp.isFlag()) {
            Ig11Camp.menu();
            Ig11Camp.opcoes();
        }
        gestorCampeonato.getScanner().close();
    }
}





















/*package org.example;
import Campeonato.*;
import Enums.*;
import utils.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

import static utils.TextoUtil.centralizarTexto;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Equipa> equipas = new ArrayList<>();
    private static final VerificaInput inputChecker = new VerificaInput();
    private static Jogo jogo;
    private static boolean flag = true;

    public static void main(String[] args ) throws InterruptedException {
        instrucao();
        while (flag) {
            menu();
            opcoes();
        }
    }

    private static void opcoes() throws InterruptedException {
        int opcao = inputChecker.checkInt();
        switch (opcao) {
            case 1:
                criarEquipa();
                break;
            case 2:
                if (equipas.isEmpty()) {
                    centralizarTexto("Primeiro, crie pelo menos uma equipe.\n");
                }else {
                    cadastrarJogador();
                }

                break;
            case 3:
                padrao();
                break;
            case 4:
                if (equipas.size() < 2) {
                    centralizarTexto("Você precisa ter as equipas criadas para imprimir os planteis.\n");
                }else{
                    imprimirPlanteis();
                }

                break;
            case 5:
                if (equipas.size() < 2) {
                    centralizarTexto("Você precisa ter as equipas criadas para imprimir os planteis.\n");
                }else{
                    imprimirEscalacao();
                }

                break;
            case 6:
                if (equipas.size() < 2){
                    centralizarTexto("É necessário ter pelo menos 2 equipas para simular um jogo.\n");
                }else{
                    simularJogo();
                }

                break;
            case 7:
                if (equipas.size() < 2){
                    centralizarTexto("Treinamento só depois do jogo.\n");
                }else {
                    permitirTreinamento();
                }
                break;
            case 8:
                if(equipas.size() < 2) {
                    centralizarTexto("Precisamos ter equipas para aplicar cartão aos seus jogadores");
                }else{
                    aplicarCartao();
                }
                break;
            case 9:
                if(equipas.size() < 2) {
                    centralizarTexto("Precisamos ter equipas para aplicar suspensão aos seus jogadores");
                }else{ aplicarSuspensao();}
                break;
            case 10:
                centralizarTexto("SAINDO");
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j <i ; j++) {
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

    private static void instrucao() {
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

    private static void menu() {
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
        centralizarTexto("------------9. aplicar Suspensão-----------");
        centralizarTexto("------------10. Sair-----------------------");
        centralizarTexto("---------------Escolha uma opção_________: ");
    }

    private static void aplicarCartao(){
        exibirEquipas();
        int equipaEscolhida = getValideEquipa();
        Equipa equipa = equipas.get(equipaEscolhida);
        exibirJogadores(equipa);
        int jogadorEscolhido = getValidJogador(equipa);
        aplicarCartaoJogador(equipa, jogadorEscolhido);
    }

    private static void aplicarCartaoJogador(Equipa equipa, int jogadorIndex) {
        Jogador jogador = equipa.getRelacionados().get(jogadorIndex);
        jogador.aplicarCartao(Cartao.AMARELO, 1);
        TextoUtil.centralizarTexto("Jogador " + jogador.getNome() + " recebeu um cartão amarelo");
    }

    private static void aplicarSuspensao(){
        exibirEquipas();
        int equipaEscolhida = getValideEquipa();
        Equipa equipa = equipas.get(equipaEscolhida);
        exibirJogadores(equipa);
        int jogadorEscolhido = getValidJogador(equipa);
        suspenderJogador(equipa, jogadorEscolhido);
    }

    private static void exibirEquipas(){
        IntStream.range(0, equipas.size())
                .forEach(i -> centralizarTexto((i + 1) + ". " + equipas.get(i).getNome()));
    }

    private static int getValideEquipa(){
        int index = inputChecker.checkInt();
        while(index < 0 || index > equipas.size()){
            centralizarTexto("Equipa não encontrada. Tente novamente.");
            index = inputChecker.checkInt();
        }
        return index;
    }

    private static void exibirJogadores(Equipa equipa) {
        equipa.relacionarJogadores().stream()
                .map(Jogador::exibirJogador)
                .forEach(TextoUtil::centralizarTexto);
    }

    private static int getValidJogador(Equipa equipa) {
        int index = inputChecker.checkInt() - 1;
        while(index < 0 || index > equipa.getPlantel().size()){
            centralizarTexto("Jogador não encontrado. Tente novamente.");
            index = inputChecker.checkInt() - 1;
        }

        return index;
    }

    private static void suspenderJogador(Equipa equipa, int jogadorIndex) {
        Jogador jogador = equipa.getRelacionados().get(jogadorIndex);
        jogador.setSuspenso(Suspenso.SIM);
        TextoUtil.centralizarTexto("Jogador " + jogador.getNome() + "foi suspenso");
    }

    private static void permitirTreinamento(){
        if (jogo != null ){
            jogo.permitirTreinamento();
        }
        else{
            centralizarTexto("Simule um jogo e depois execute o treinamento");
        }
    }

    private static void criarEquipa() {
        centralizarTexto("Quantidade de Equipas que pretende criar: ");
        int quantidade = inputChecker.checkInt();
        while (quantidade < 0 ) {
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

    private static void cadastrarJogador() {
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
        while(posicaoEscolhida < 0 || posicaoEscolhida >= Posicao.values().length) {
            centralizarTexto("Posição inválida. Tente novamente.");
            posicaoEscolhida = inputChecker.checkInt() - 1;
        }

        Posicao posicao = Posicao.values()[posicaoEscolhida];

        centralizarTexto("Qualidade (0-100): ");
        int qualidade = inputChecker.checkInt();
        while(qualidade < 0 || qualidade > 100) {
            centralizarTexto("Qualidade deve ser um valor entre 0 e 100.");
            qualidade = inputChecker.checkInt();
        }

        centralizarTexto("Escolha a equipe do jogador:");
        for (int i = 0; i < equipas.size(); i++) {
            centralizarTexto((i + 1) + ". " + equipas.get(i).getNome());
        }
        int equipeEscolhida = inputChecker.checkInt() - 1;
        while(equipeEscolhida < 0 || equipeEscolhida > equipas.size()) {
            centralizarTexto("Equipe não encontrada. Tente novamente.");
            equipeEscolhida = inputChecker.checkInt() - 1;
        }

        Equipa equipa = equipas.get(equipeEscolhida);

        Jogador jogador = new Jogador(id, nome, apelido, dataNascimento, numero, posicao, qualidade);
        equipa.adicionarJogador(jogador);

        centralizarTexto("Jogador cadastrado com sucesso na equipe " + equipa.getNome() + "!");
    }

    private static void padrao() {
        // Mandante
        ArrayList<Jogador> jogadoresMandante = new ArrayList<>();
        jogadoresMandante.add(new Jogador(1, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 1, Posicao.GOLEIRO, 85));
        jogadoresMandante.add(new Jogador(2, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 2, Posicao.ZAGUEIRO_DIREITO, 90));
        jogadoresMandante.add(new Jogador(3, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 3, Posicao.ZAGUEIRO_ESQUERDO, 88));
        jogadoresMandante.add(new Jogador(4, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 4, Posicao.LATERAL_DIREITO, 86));
        jogadoresMandante.add(new Jogador(5, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 5, Posicao.LATERAL_ESQUERDO, 87));
        jogadoresMandante.add(new Jogador(6, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 6, Posicao.MEDIO_DEFENSIVO, 89));
        jogadoresMandante.add(new Jogador(7, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 7, Posicao.MEDIO_ESQUERDO, 85));
        jogadoresMandante.add(new Jogador(8, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 8, Posicao.MEDIO_DIREITO, 84));
        jogadoresMandante.add(new Jogador(9, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 9, Posicao.ATACANTE_DIREITO, 92));
        jogadoresMandante.add(new Jogador(10, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 10, Posicao.ATACANTE_ESQUERDO, 91));
        jogadoresMandante.add(new Jogador(11, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 11, Posicao.CENTRO_AVANTE, 93));
        jogadoresMandante.add(new Jogador(12, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 12, Posicao.GOLEIRO, 80));
        jogadoresMandante.add(new Jogador(13, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 13, Posicao.ZAGUEIRO_DIREITO, 81));
        jogadoresMandante.add(new Jogador(14, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 14, Posicao.ZAGUEIRO_ESQUERDO, 82));
        jogadoresMandante.add(new Jogador(15, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 15, Posicao.LATERAL_DIREITO, 83));
        jogadoresMandante.add(new Jogador(16, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 16, Posicao.LATERAL_ESQUERDO, 84));
        jogadoresMandante.add(new Jogador(17, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 17, Posicao.MEDIO_DEFENSIVO, 85));
        jogadoresMandante.add(new Jogador(18, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 18, Posicao.MEDIO_ESQUERDO, 86));
        jogadoresMandante.add(new Jogador(19, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 19, Posicao.MEDIO_DIREITO, 87));
        jogadoresMandante.add(new Jogador(20, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 20, Posicao.ATACANTE_DIREITO, 88));
        jogadoresMandante.add(new Jogador(21, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 21, Posicao.ATACANTE_ESQUERDO, 89));
        jogadoresMandante.add(new Jogador(22, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 22, Posicao.CENTRO_AVANTE, 90));
        jogadoresMandante.add(new Jogador(23, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 23, Posicao.GOLEIRO, 78));
        jogadoresMandante.add(new Jogador(24, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 24, Posicao.ZAGUEIRO_DIREITO, 79));
        jogadoresMandante.add(new Jogador(25, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 25, Posicao.ZAGUEIRO_ESQUERDO, 80));
        jogadoresMandante.add(new Jogador(26, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 26, Posicao.LATERAL_DIREITO, 81));

        Equipa equipaMandante = new Equipa("Equipa Padrão1", "MD", 1900, jogadoresMandante);
        equipas.add(equipaMandante);

        // Visitante
        ArrayList<Jogador> jogadoresVisitante = new ArrayList<>();
        jogadoresVisitante.add(new Jogador(1, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 1, Posicao.GOLEIRO, 85));
        jogadoresVisitante.add(new Jogador(2, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 2, Posicao.ZAGUEIRO_DIREITO, 90));
        jogadoresVisitante.add(new Jogador(3, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 3, Posicao.ZAGUEIRO_ESQUERDO, 88));
        jogadoresVisitante.add(new Jogador(4, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 4, Posicao.LATERAL_DIREITO, 86));
        jogadoresVisitante.add(new Jogador(5, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 5, Posicao.LATERAL_ESQUERDO, 87));
        jogadoresVisitante.add(new Jogador(6, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 6, Posicao.MEDIO_DEFENSIVO, 89));
        jogadoresVisitante.add(new Jogador(7, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 7, Posicao.MEDIO_ESQUERDO, 85));
        jogadoresVisitante.add(new Jogador(8, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 8, Posicao.MEDIO_DIREITO, 84));
        jogadoresVisitante.add(new Jogador(9, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 9, Posicao.ATACANTE_DIREITO, 92));
        jogadoresVisitante.add(new Jogador(10, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 10, Posicao.ATACANTE_ESQUERDO, 91));
        jogadoresVisitante.add(new Jogador(11, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 11, Posicao.CENTRO_AVANTE, 93));
        jogadoresVisitante.add(new Jogador(12, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 12, Posicao.GOLEIRO, 80));
        jogadoresVisitante.add(new Jogador(13, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 13, Posicao.ZAGUEIRO_DIREITO, 81));
        jogadoresVisitante.add(new Jogador(14, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 14, Posicao.ZAGUEIRO_ESQUERDO, 82));
        jogadoresVisitante.add(new Jogador(15, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 15, Posicao.LATERAL_DIREITO, 83));
        jogadoresVisitante.add(new Jogador(16, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 16, Posicao.LATERAL_ESQUERDO, 84));
        jogadoresVisitante.add(new Jogador(17, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 17, Posicao.MEDIO_DEFENSIVO, 85));
        jogadoresVisitante.add(new Jogador(18, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 18, Posicao.MEDIO_ESQUERDO, 86));
        jogadoresVisitante.add(new Jogador(19, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 19, Posicao.MEDIO_DIREITO, 87));
        jogadoresVisitante.add(new Jogador(20, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 20, Posicao.ATACANTE_DIREITO, 88));
        jogadoresVisitante.add(new Jogador(21, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 21, Posicao.ATACANTE_ESQUERDO, 89));
        jogadoresVisitante.add(new Jogador(22, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 22, Posicao.CENTRO_AVANTE, 90));
        jogadoresVisitante.add(new Jogador(23, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 23, Posicao.GOLEIRO, 78));
        jogadoresVisitante.add(new Jogador(24, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 24, Posicao.ZAGUEIRO_DIREITO, 79));
        jogadoresVisitante.add(new Jogador(25, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 25, Posicao.ZAGUEIRO_ESQUERDO, 80));
        jogadoresVisitante.add(new Jogador(26, GeradorNomes.gerarNome(), GeradorNomes.gerarApelido(), DataUtil.gerarDataAleatoria(), 26, Posicao.LATERAL_DIREITO, 81));

        Equipa equipaVisitante = new Equipa("Equipa Padrão2", "VT", 1900, jogadoresVisitante);
        equipas.add(equipaVisitante);
        centralizarTexto("Equipas padrão carregadas com sucesso!\n");
    }

    private static void imprimirEscalacao() {
        for (Equipa equipa: equipas) equipa.relacionarJogadores();

        centralizarTexto("Convocações das Equipas:");
        for (Equipa equipa : equipas) equipa.imprimirEscalacao();
        centralizarTexto(" \n \n");
    }

    private static void imprimirPlanteis(){
        centralizarTexto("Planteis das Equipas:");
        for (Equipa equipa: equipas) equipa.imprimirPlantel();
        centralizarTexto(" \n \n \n");
    }

    private static void simularJogo() {
        centralizarTexto("Escolha a equipe mandante:");
        for (int i = 0; i < equipas.size(); i++) {
            centralizarTexto(String.format("%d. %s", i + 1, equipas.get(i).getNome()));
        }

        int mandanteIndex = inputChecker.checkInt() - 1;
        while(mandanteIndex < 0 || mandanteIndex >= equipas.size()) {
            centralizarTexto("Equipe não encontrada. Tente novamente.");
            mandanteIndex = inputChecker.checkInt() - 1;
        }

        centralizarTexto("Escolha a equipe visitante:");
        for (int i = 0; i < equipas.size(); i++) {
            if (i != mandanteIndex) {
                centralizarTexto((i + 1) + " " + equipas.get(i).getNome());
            }
        }

        int visitanteIndex = inputChecker.checkInt() - 1;
        while(visitanteIndex < 0 || visitanteIndex >= equipas.size() || visitanteIndex == mandanteIndex) {
            centralizarTexto("Equipe não encontrada Ou já selecionada. Tente novamente.");
            visitanteIndex = inputChecker.checkInt() - 1;
        }

        Equipa mandante = equipas.get(mandanteIndex);
        Equipa visitante = equipas.get(visitanteIndex);

        if (mandante.getPlantel().size() < 23 || visitante.getPlantel().size() < 26) {
            centralizarTexto("Ambas as equipes precisam ter 23 jogadores nomínimo.");
            return;
        }

        centralizarTexto("Data do Jogo (AAAA-MM-DD): ");
        LocalDate dataDoJogo = DataUtil.gerarDataAleatoria();
        centralizarTexto("A data do jogo foi definida para: " + dataDoJogo);

        centralizarTexto("Estádio: ");
        String estadio = inputChecker.checkName();

        centralizarTexto("Cidade: ");
        String cidade = inputChecker.checkName();

        jogo = new Jogo(mandante, visitante, dataDoJogo, estadio, cidade);

        centralizarTexto("Dados do Jogo: ");
        String dados = jogo.toString();
        centralizarTexto(dados);

        centralizarTexto("Jogo entre " + mandante.getNome() + "  E  " + visitante.getNome() + " foi iniciado!");

        jogo.gerarResultado();
        jogo.gerarCartoes();
        jogo.gerarLesao();
        jogo.gerarResultado();
        jogo.exibirResultado();
    }
}
*/