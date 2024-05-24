package org.example;
import Campeonato.*;
import Enums.*;
import utils.DataUtil;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Equipa> equipas = new ArrayList<>();
    private static Jogo jogo;
    private Random random;

    public static void main(String[] args) {
        instrucao();
        while (true) {
            menu();
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    criarEquipa();
                    break;
                case 2:
                    if (equipas.isEmpty()) {
                        centralizarTexto("Primeiro, crie pelo menos uma equipe.");
                    } else {
                        cadastrarJogador();
                    }
                    break;
                case 3:
                    padrao();
                    break;
                case 4:
                    if (equipas.size() < 2) {
                        centralizarTexto("Você precisa ter as equipas criadas para imprimir os planteis.");
                    } else {
                        imprimirPlanteis();
                    }
                    break;
                case 5:
                    if (equipas.size() < 2) {
                        centralizarTexto("É necessário ter pelo menos 2 equipes para simular um jogo.");
                    } else {
                        simularJogo();
                    }
                    break;
                case 6:
                    centralizarTexto("Saindo...");
                    centralizarTexto("Obrigado por usar o IG11CampGest!");
                    return;
                default:
                    centralizarTexto("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void centralizarTexto(String texto) {
        int larguraTela = 155;  
        int espacos = (larguraTela - texto.length()) / 2;
        String espacoBranco = " ".repeat(Math.max(0, espacos));
        System.out.println(espacoBranco + texto);
    }

    private static void instrucao() {
        centralizarTexto("------------------------------------------------");
        centralizarTexto("-----------BEM-VINDO AO IG11CAMPGEST------------");
        centralizarTexto("  Um Sistema de Gestão de Campeonato de Futebol");
        centralizarTexto("########## Instruções de Utilização #############");
        centralizarTexto("Crie pelo menos duas equipas para poder simular um jogo, as equipas devem ter um plantel de até 26 jogadores");
        centralizarTexto("Cadastre jogadores para as equipas, veja os planteis das equipas com os jogadores cadrastrados e simule um jogo entre as equipas");
        centralizarTexto("Os 18 melhores jogadores baseando em posição e qualidade serão convocados para o jogo");
        centralizarTexto("Ou simplemente carrege equipas já predefinidas, reveja os planteis e vá direto pra simulação");
    }

    private static void menu() {
        centralizarTexto("-------------------Menu--------------------");
        centralizarTexto("------------1. Criar Equipas---------------");
        centralizarTexto("------------2. Cadastrar Jogador-----------");
        centralizarTexto("------------3. Carregar 2 Equipas prontas--");
        centralizarTexto("------------4. Imprimir Planteis-----------");
        centralizarTexto("------------5. Simular Jogo----------------");
        centralizarTexto("------------6. Sair------------------------");
        centralizarTexto("---------------Escolha uma opção_________: ");
    }

    private static void criarEquipa() {
        while (equipas.size() < 2) {
            centralizarTexto("Nome da Equipa: ");
            String nome = scanner.nextLine();

            centralizarTexto("Apelido da Equipa: ");
            String apelido = scanner.nextLine();

            centralizarTexto("Ano de Fundação: ");
            int fundacao = scanner.nextInt();
            scanner.nextLine();

            Equipa equipa = new Equipa(nome, apelido, fundacao, new ArrayList<>());
            equipas.add(equipa);

            centralizarTexto("Equipa criada com sucesso!");
        }
    }

    private static void cadastrarJogador() {
        centralizarTexto("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        centralizarTexto("Nome: ");
        String nome = scanner.nextLine();

        centralizarTexto("Apelido: ");
        String apelido = scanner.nextLine();

        centralizarTexto("Data de Nascimento (AAAA-MM-DD): ");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());

        centralizarTexto("Número: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        centralizarTexto("Posição:");
        for (Posicao posicao : Posicao.values()) {
            centralizarTexto(posicao.ordinal() + 1 + ". " + posicao.getDescricao());
        }
        centralizarTexto("Escolha uma posição: ");
        int posicaoEscolhida = scanner.nextInt();
        scanner.nextLine();

        Posicao posicao = Posicao.values()[posicaoEscolhida - 1];

        centralizarTexto("Qualidade: ");
        int qualidade = scanner.nextInt();
        scanner.nextLine();

        centralizarTexto("Escolha a equipe do jogador:");
        for (int i = 0; i < equipas.size(); i++) {
            centralizarTexto((i + 1) + ". " + equipas.get(i).getNome());
        }
        int equipeEscolhida = scanner.nextInt();
        scanner.nextLine();

        Equipa equipa = equipas.get(equipeEscolhida - 1);

        Jogador jogador = new Jogador(id, nome, apelido, dataNascimento, numero, posicao, qualidade);
        equipa.adicionarJogador(jogador);

        centralizarTexto("Jogador cadastrado com sucesso na equipe " + equipa.getNome() + "!");
    }

    private static void padrao() {
        // Mandante
        ArrayList<Jogador> jogadoresMandante = new ArrayList<>();
        jogadoresMandante.add(new Jogador(1, "João", "J1", DataUtil.gerarDataAleatoria(), 1, Posicao.GOLEIRO, 85));
        jogadoresMandante.add(new Jogador(2, "Carlos", "C1", DataUtil.gerarDataAleatoria(), 2, Posicao.ZAGUEIRO_DIREITO, 90));
        jogadoresMandante.add(new Jogador(3, "Pedro", "P1", DataUtil.gerarDataAleatoria(), 3, Posicao.ZAGUEIRO_ESQUERDO, 88));
        jogadoresMandante.add(new Jogador(4, "Lucas", "L1", DataUtil.gerarDataAleatoria(), 4, Posicao.LATERAL_DIREITO, 86));
        jogadoresMandante.add(new Jogador(5, "Mateus", "M1", DataUtil.gerarDataAleatoria(), 5, Posicao.LATERAL_ESQUERDO, 87));
        jogadoresMandante.add(new Jogador(6, "Rafael", "R1", DataUtil.gerarDataAleatoria(), 6, Posicao.MEDIO_DEFENSIVO, 89));
        jogadoresMandante.add(new Jogador(7, "Henrique", "H1", DataUtil.gerarDataAleatoria(), 7, Posicao.MEDIO_ESQUERDO, 85));
        jogadoresMandante.add(new Jogador(8, "Thiago", "T1", DataUtil.gerarDataAleatoria(), 8, Posicao.MEDIO_DIREITO, 84));
        jogadoresMandante.add(new Jogador(9, "Rodrigo", "R2", DataUtil.gerarDataAleatoria(), 9, Posicao.ATACANTE_DIREITO, 92));
        jogadoresMandante.add(new Jogador(10, "Gustavo", "G1", DataUtil.gerarDataAleatoria(), 10, Posicao.ATACANTE_ESQUERDO, 91));
        jogadoresMandante.add(new Jogador(11, "Felipe", "F1", DataUtil.gerarDataAleatoria(), 11, Posicao.CENTRO_AVANTE, 93));
        jogadoresMandante.add(new Jogador(12, "Antônio", "A3", DataUtil.gerarDataAleatoria(), 12, Posicao.GOLEIRO, 80));
        jogadoresMandante.add(new Jogador(13, "Júlio", "J3", DataUtil.gerarDataAleatoria(), 13, Posicao.ZAGUEIRO_DIREITO, 81));
        jogadoresMandante.add(new Jogador(14, "Paulo", "P2", DataUtil.gerarDataAleatoria(), 14, Posicao.ZAGUEIRO_ESQUERDO, 82));
        jogadoresMandante.add(new Jogador(15, "Sérgio", "S1", DataUtil.gerarDataAleatoria(), 15, Posicao.LATERAL_DIREITO, 83));
        jogadoresMandante.add(new Jogador(16, "Bruno", "B2", DataUtil.gerarDataAleatoria(), 16, Posicao.LATERAL_ESQUERDO, 84));
        jogadoresMandante.add(new Jogador(17, "Diego", "D1", DataUtil.gerarDataAleatoria(), 17, Posicao.MEDIO_DEFENSIVO, 85));
        jogadoresMandante.add(new Jogador(18, "Eduardo", "E1", DataUtil.gerarDataAleatoria(), 18, Posicao.MEDIO_ESQUERDO, 86));
        jogadoresMandante.add(new Jogador(19, "Alex", "A2", DataUtil.gerarDataAleatoria(), 19, Posicao.MEDIO_DIREITO, 87));
        jogadoresMandante.add(new Jogador(20, "Vitor", "V1", DataUtil.gerarDataAleatoria(), 20, Posicao.ATACANTE_DIREITO, 88));
        jogadoresMandante.add(new Jogador(21, "Fábio", "F2", DataUtil.gerarDataAleatoria(), 21, Posicao.ATACANTE_ESQUERDO, 89));
        jogadoresMandante.add(new Jogador(22, "Marcelo", "M2", DataUtil.gerarDataAleatoria(), 22, Posicao.CENTRO_AVANTE, 90));
        jogadoresMandante.add(new Jogador(23, "Danilo", "D2", DataUtil.gerarDataAleatoria(), 23, Posicao.GOLEIRO, 78));
        jogadoresMandante.add(new Jogador(24, "Renato", "R3", DataUtil.gerarDataAleatoria(), 24, Posicao.ZAGUEIRO_DIREITO, 79));
        jogadoresMandante.add(new Jogador(25, "Fernando", "F3", DataUtil.gerarDataAleatoria(), 25, Posicao.ZAGUEIRO_ESQUERDO, 80));
        jogadoresMandante.add(new Jogador(26, "Ricardo", "R4", DataUtil.gerarDataAleatoria(), 26, Posicao.LATERAL_DIREITO, 81));

        Equipa equipaMandante = new Equipa("Equipa Mandante", "Mandante", 1900, jogadoresMandante);
        equipas.add(equipaMandante);

        // Visitante
        ArrayList<Jogador> jogadoresVisitante = new ArrayList<>();
        jogadoresVisitante.add(new Jogador(1, "Manuel", "M1", DataUtil.gerarDataAleatoria(), 1, Posicao.GOLEIRO, 85));
        jogadoresVisitante.add(new Jogador(2, "Augusto", "A1", DataUtil.gerarDataAleatoria(), 2, Posicao.ZAGUEIRO_DIREITO, 90));
        jogadoresVisitante.add(new Jogador(3, "Otávio", "O1", DataUtil.gerarDataAleatoria(), 3, Posicao.ZAGUEIRO_ESQUERDO, 88));
        jogadoresVisitante.add(new Jogador(4, "Joaquim", "J2", DataUtil.gerarDataAleatoria(), 4, Posicao.LATERAL_DIREITO, 86));
        jogadoresVisitante.add(new Jogador(5, "Alberto", "A2", DataUtil.gerarDataAleatoria(), 5, Posicao.LATERAL_ESQUERDO, 87));
        jogadoresVisitante.add(new Jogador(6, "Geraldo", "G2", DataUtil.gerarDataAleatoria(), 6, Posicao.MEDIO_DEFENSIVO, 89));
        jogadoresVisitante.add(new Jogador(7, "Horácio", "H2", DataUtil.gerarDataAleatoria(), 7, Posicao.MEDIO_ESQUERDO, 85));
        jogadoresVisitante.add(new Jogador(8, "Ulisses", "U1", DataUtil.gerarDataAleatoria(), 8, Posicao.MEDIO_DIREITO, 84));
        jogadoresVisitante.add(new Jogador(9, "Vinicius", "V2", DataUtil.gerarDataAleatoria(), 9, Posicao.ATACANTE_DIREITO, 92));
        jogadoresVisitante.add(new Jogador(10, "Xavier", "X1", DataUtil.gerarDataAleatoria(), 10, Posicao.ATACANTE_ESQUERDO, 91));
        jogadoresVisitante.add(new Jogador(11, "Zeca", "Z1", DataUtil.gerarDataAleatoria(), 11, Posicao.CENTRO_AVANTE, 93));
        jogadoresVisitante.add(new Jogador(12, "Bento", "B3", DataUtil.gerarDataAleatoria(), 12, Posicao.GOLEIRO, 80));
        jogadoresVisitante.add(new Jogador(13, "Caio", "C3", DataUtil.gerarDataAleatoria(), 13, Posicao.ZAGUEIRO_DIREITO, 81));
        jogadoresVisitante.add(new Jogador(14, "Davi", "D3", DataUtil.gerarDataAleatoria(), 14, Posicao.ZAGUEIRO_ESQUERDO, 82));
        jogadoresVisitante.add(new Jogador(15, "Ernesto", "E2", DataUtil.gerarDataAleatoria(), 15, Posicao.LATERAL_DIREITO, 83));
        jogadoresVisitante.add(new Jogador(16, "Félix", "F4", DataUtil.gerarDataAleatoria(), 16, Posicao.LATERAL_ESQUERDO, 84));
        jogadoresVisitante.add(new Jogador(17, "Gabriel", "G3", DataUtil.gerarDataAleatoria(), 17, Posicao.MEDIO_DEFENSIVO, 85));
        jogadoresVisitante.add(new Jogador(18, "Hugo", "H3", DataUtil.gerarDataAleatoria(), 18, Posicao.MEDIO_ESQUERDO, 86));
        jogadoresVisitante.add(new Jogador(19, "Ivan", "I1", DataUtil.gerarDataAleatoria(), 19, Posicao.MEDIO_DIREITO, 87));
        jogadoresVisitante.add(new Jogador(20, "José", "J3", DataUtil.gerarDataAleatoria(), 20, Posicao.ATACANTE_DIREITO, 88));
        jogadoresVisitante.add(new Jogador(21, "Leandro", "L3", DataUtil.gerarDataAleatoria(), 21, Posicao.ATACANTE_ESQUERDO, 89));
        jogadoresVisitante.add(new Jogador(22, "Marcelo", "M3", DataUtil.gerarDataAleatoria(), 22, Posicao.CENTRO_AVANTE, 90));
        jogadoresVisitante.add(new Jogador(23, "Natan", "N1", DataUtil.gerarDataAleatoria(), 23, Posicao.GOLEIRO, 78));
        jogadoresVisitante.add(new Jogador(24, "Osvaldo", "O2", DataUtil.gerarDataAleatoria(), 24, Posicao.ZAGUEIRO_DIREITO, 79));
        jogadoresVisitante.add(new Jogador(25, "Paulo", "P3", DataUtil.gerarDataAleatoria(), 25, Posicao.ZAGUEIRO_ESQUERDO, 80));
        jogadoresVisitante.add(new Jogador(26, "Rui", "R5", DataUtil.gerarDataAleatoria(), 26, Posicao.LATERAL_DIREITO, 81));

        Equipa equipaVisitante = new Equipa("Equipa Visitante", "Visitante", 1900, jogadoresVisitante);
        equipas.add(equipaVisitante);
        centralizarTexto("Equipas padrao carregadas com sucesso!");
    }

    private static void imprimirPlanteis() {
        for (Equipa equipa: equipas) equipa.relacionarJogadores();

        System.out.println("Planteis das Equipas:");
        for (Equipa equipa : equipas) equipa.imprimirEscalacao();
    }

   

    private static void simularJogo() {
        System.out.println("Escolha a equipe mandante:");
        for (int i = 0; i < equipas.size(); i++) {
            System.out.println(STR."\{i + 1}. \{equipas.get(i).getNome()}");
        }
        int mandanteIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.println("Escolha a equipe visitante:");
        for (int i = 0; i < equipas.size(); i++) {
            if (i != mandanteIndex) {
                System.out.println(STR."\{i + 1}. \{equipas.get(i).getNome()}");
            }
        }
        int visitanteIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        Equipa mandante = equipas.get(mandanteIndex);
        Equipa visitante = equipas.get(visitanteIndex);

        if (mandante.getPlantel().size() < 26 || visitante.getPlantel().size() < 26) {
            System.out.println("Ambas as equipes precisam ter 26 jogadores.");
            return;
        }

        System.out.print("Data do Jogo (AAAA-MM-DD): ");
        LocalDate dataDoJogo = LocalDate.parse(scanner.next());
        scanner.nextLine();

        System.out.print("Estádio: ");
        String estadio = scanner.nextLine();

        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();

        jogo = new Jogo(mandante, visitante, dataDoJogo, estadio, cidade);
        jogo.gerarResultado();
        jogo.gerarCartoes();
        jogo.gerarLesao();
        jogo.gerarResultado();
//        jogo.substituirJogador(mandante.getRelacionados(new random.netInt(11)), mandante.getRelacionados(new random.netInt(17)) ,mandante);
//        jogo.substituirJogador(visitante.getRelacionados(new random.netInt(11)), visitante.getRelacionados(new random.netInt(17)),visitante);
        jogo.exibirResultado();
    }


}

