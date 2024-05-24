
//        jogo.gerarResultado();
//        jogo.gerarCartoes();
//          jogo.registrarEventos();

//        jogo.exibirResultado();


//
//        Permitir treinamento
//        jogo.permitirTreinamento();
//
        //Gerar lesões

//
//        Gerar cartões
//
//
//        Gerar resultado do jogo
//        jogo.gerarResultado();
//
//        jogo.imprimirEventos();
//        Imprimir resultados
//        jogo.imprimirResultado();

/*
               // Criação dos jogadores para a equipe mandante
                ArrayList<Jogador> jogadoresMandante = new ArrayList<>();
                jogadoresMandante.add(new Jogador(1, "João", "J1", DataUtil.gerarDataAleatoria(), 1, Posicao.GOLEIRO, 85));
                jogadoresMandante.add(new Jogador(2, "Carlos", "C1", DataUtil.gerarDataAleatoria(), 2, Posicao.ZAGUEIRO_DIREITO, 90));
                jogadoresMandante.add(new Jogador(3, "Pedro", "P1", DataUtil.gerarDataAleatoria(), 3, Posicao.ZAGUEIRO_ESQUERDO, 88));
                jogadoresMandante.add(new Jogador(4, "Lucas", "L1",  DataUtil.gerarDataAleatoria(), 4, Posicao.LATERAL_DIREITO, 86));
                jogadoresMandante.add(new Jogador(5, "Mateus", "M1",  DataUtil.gerarDataAleatoria(), 5, Posicao.LATERAL_ESQUERDO, 87));
                jogadoresMandante.add(new Jogador(6, "Rafael", "R1", DataUtil.gerarDataAleatoria(), 6, Posicao.MEDIO_DEFENSIVO, 89));
                jogadoresMandante.add(new Jogador(7, "Henrique", "H1", DataUtil.gerarDataAleatoria(), 7, Posicao.MEDIO_ESQUERDO, 85));
                jogadoresMandante.add(new Jogador(8, "Thiago", "T1", DataUtil.gerarDataAleatoria(), 8, Posicao.MEDIO_DIREITO, 84));
                jogadoresMandante.add(new Jogador(9, "Rodrigo", "R2", DataUtil.gerarDataAleatoria(), 9, Posicao.ATACANTE_DIREITO, 92));
                jogadoresMandante.add(new Jogador(10, "Gustavo", "G1", DataUtil.gerarDataAleatoria(), 10, Posicao.ATACANTE_ESQUERDO, 91));
                jogadoresMandante.add(new Jogador(11, "Felipe", "F1", DataUtil.gerarDataAleatoria(), 11, Posicao.CENTRO_AVANTE, 93));

                Equipa mandante = new Equipa("Equipe Mandante", "EM", 1900, jogadoresMandante);

                // Criação dos jogadores para a equipe visitante
                ArrayList<Jogador> jogadoresVisitante = new ArrayList<>();
                jogadoresVisitante.add(new Jogador(1, "Bruno", "B1", DataUtil.gerarDataAleatoria(), 1, Posicao.GOLEIRO, 83));
                jogadoresVisitante.add(new Jogador(2, "Victor", "V1", DataUtil.gerarDataAleatoria(), 2, Posicao.ZAGUEIRO_DIREITO, 85));
                jogadoresVisitante.add(new Jogador(3, "Eduardo", "E1", DataUtil.gerarDataAleatoria(), 3, Posicao.ZAGUEIRO_ESQUERDO, 86));
                jogadoresVisitante.add(new Jogador(4, "Rogério", "R3", DataUtil.gerarDataAleatoria(), 4, Posicao.LATERAL_DIREITO, 84));
                jogadoresVisitante.add(new Jogador(5, "Jorge", "J2", DataUtil.gerarDataAleatoria(), 5, Posicao.LATERAL_ESQUERDO, 82));
                jogadoresVisitante.add(new Jogador(6, "Fabio", "F2", DataUtil.gerarDataAleatoria(), 6, Posicao.MEDIO_DEFENSIVO, 88));
                jogadoresVisitante.add(new Jogador(7, "André", "A1", DataUtil.gerarDataAleatoria(), 7, Posicao.MEDIO_ESQUERDO, 83));
                jogadoresVisitante.add(new Jogador(8, "Marcos", "M2", DataUtil.gerarDataAleatoria(), 8, Posicao.MEDIO_DIREITO, 82));
                jogadoresVisitante.add(new Jogador(9, "Diego", "D1", DataUtil.gerarDataAleatoria(), 9, Posicao.ATACANTE_DIREITO, 89));
                jogadoresVisitante.add(new Jogador(10, "Alex", "A2", DataUtil.gerarDataAleatoria(), 10, Posicao.ATACANTE_ESQUERDO, 90));
                jogadoresVisitante.add(new Jogador(11, "Ricardo", "R4", DataUtil.gerarDataAleatoria(), 11, Posicao.CENTRO_AVANTE, 91));

                Equipa visitante = new Equipa("Equipe Visitante", "EV", 1910, jogadoresVisitante);
*/

/* mandante
        ArrayList<Jogador> jogadoresMandante = new ArrayList<>();
        for (int i = 1; i <= 26; i++) {
            jogadoresMandante.add(new Jogador(i, "Jogador" + i, "J" + i, DataUtil.gerarDataAleatoria(), i, Posicao.values()[i % Posicao.values().length], 80 + i % 20));
        }

        Equipa mandante = new Equipa("Equipe Mandante", "EM", 1900, jogadoresMandante);

        // visitante
        ArrayList<Jogador> jogadoresVisitante = new ArrayList<>();
        for (int i = 1; i <= 26; i++) {
            jogadoresVisitante.add(new Jogador(i, "Jogador" + i, "J" + i, DataUtil.gerarDataAleatoria(), i, Posicao.values()[i % Posicao.values().length], 80 + i % 20));
        }

        Equipa visitante = new Equipa("Equipe Visitante", "EV", 1910, jogadoresVisitante);
        Jogo jogo = new Jogo(mandante, visitante, DataUtil.gerarDataAleatoria(), "Estádio Municipal", "Cidade X");

        System.out.println("Relacionados Mandante");
        mandante.relacionarJogadores();
        mandante.relacionarMelhoresJogadores();
        mandante.imprimirEscalacao();

        System.out.println("----------------------------");

        System.out.println("Relacionados Visitante");
        visitante.relacionarJogadores();
        visitante.relacionarMelhoresJogadores();
        visitante.imprimirEscalacao();
        System.out.println("----------------------------");

        Random random = new Random();
        Jogador jogadorLesao = jogadoresMandante.get(random.nextInt(jogadoresMandante.size()));


        //Jogador jogadorTreinamento = jogadoresMandante.get(random.nextInt(jogadoresMandante.size()));

        //Teste de lesão Treino
        /*System.out.println("Qualidade inicial: " + jogadorLesao.getQualidade());
        System.out.println("primeira lesao");
        jogadorLesao.sofrerLesao();
        System.out.println("Jogador " + jogadorLesao.getNome() + " sofreu uma lesão.");
        System.out.println(" Qualidade depois da  primeira lesao: " + jogadorLesao.getQualidade());

        System.out.println("segunda lesao");
        jogadorLesao.sofrerLesao();
        System.out.println("Jogador " + jogadorLesao.getNome() + " sofreu uma lesão.");
        System.out.println(" Qualidade depois da  segunda lesao: " + jogadorLesao.getQualidade());


        System.out.println("primeiro treino");
        jogadorLesao.executarTreinamento();
        System.out.println("Jogador " + jogadorLesao.getNome() + " executou um treinamento.");
        System.out.println("Qualidade depois do treino: " + jogadorLesao.getQualidade());
*/


/*
a equipa deve ser mandante ou

// visitante e não tenho nenhum método que
// adiciona os jogadores a equipa mandante um de cada vez,
// deves criar esse método porque tenho dois patributos mandante e visitante na classe jogo, e na equipa preciso de um método que vai adicionando os jogadores um de cada vez
*/

/*
package org.example;
import Campeonato.*;
import Enums.*;
import utils.DataUtil;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Equipa> equipas = new ArrayList<>();
    private static Jogo jogo;
    private static ArrayList<Jogador> mandante;
    private static ArrayList<Jogador> visitante;
    private static int controle = 1;


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
                        System.out.println("Primeiro, crie pelo menos uma equipe.");
                    } else {
                        cadastrarJogador();
                    }
                    break;
                case 3:
                    if (equipas.size() < 2) {
                        System.out.println("É necessário ter pelo menos 2 equipes para simular um jogo.");
                    } else {
                        simularJogo();
                    }
                    break;
                case 4:
                    if (equipas.size() < 2 && (mandante.isEmpty() || visitante.isEmpty())) {
                        System.out.println("Você precisa ter as equipas criadas para imprimir os planteis");
                    } else {
                        System.out.println("Planteis das Equipas");
                        System.out.println("Escolha a equipa que deseja imprimir o plantel:");
                        for(Equipa equipa : equipas){
                            equipa.relacionarJogadores();
                        }

                        for (Equipa equipa: equipas) {
                            equipa.imprimirEscalacao();
                        }
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void instrucao(){
        System.out.println("----------Bem-Vindo ao IG11CampGest------------");
        System.out.println("-Um Sistema de Gestão de Campeonato de Futebol-");
        System.out.println("-----------Instruções de Utilização------------");
        System.out.println("---------Crie pelo menos duas equipas----------");
        System.out.println("-Equipas devem ter um plantel de 26 jogadores--");
        System.out.println("-----Cadastre jogadores para as equipas--------");
        System.out.println("---------Veja os planteis das equipas----------");
        System.out.println("-------Simule um jogo entre as equipas---------");
        System.out.println("Carrege equipas prontas, reveja e vá direto pra simulação");
    }

    private static void menu(){
        System.out.println("-------------------Menu--------------------");
        System.out.println("------------1. Criar Equipas---------------");
        System.out.println("------------2. Cadastrar Jogador-----------");
        System.out.println("------------3. Carregar 2 Equipas prontas--");
        System.out.println("------------4. Imprimir Planteis-----------");
        System.out.println("------------6. Simular Jogo----------------");
        System.out.println("------------7. Sair------------------------");
        System.out.print("------------Escolha uma opção: ");
    }

    private static void criarEquipa() {

       do {
           System.out.print("Nome da Equipa: ");
           String nome = scanner.nextLine();

           System.out.print("Apelido da Equipa: ");
           String apelido = scanner.nextLine();

           System.out.print("Ano de Fundação: ");
           int fundacao = scanner.nextInt();
           scanner.nextLine();

           Equipa equipa = new Equipa(nome, apelido, fundacao, new ArrayList<>());
           equipas.add(equipa);

           System.out.println("Equipa criada com sucesso!");
       }while (equipas.size() < 2);
    }

    private static void cadastrarJogador() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Apelido: ");
        String apelido = scanner.nextLine();

        System.out.print("Data de Nascimento (AAAA-MM-DD): ");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());

        System.out.print("Número: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Posição:");
        for (Posicao posicao : Posicao.values()) {
            System.out.println(posicao.ordinal() + 1 + ". " + posicao.getDescricao());
        }
        System.out.print("Escolha uma posição: ");
        int posicaoEscolhida = scanner.nextInt();
        scanner.nextLine();

        Posicao posicao = Posicao.values()[posicaoEscolhida - 1];

        System.out.print("Qualidade: ");
        int qualidade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Escolha a equipe do jogador:");
        for (int i = 0; i < equipas.size(); i++) {
            System.out.println((i + 1) + ". " + equipas.get(i).getNome());
        }
        int equipeEscolhida = scanner.nextInt();
        scanner.nextLine();

        Equipa equipa = equipas.get(equipeEscolhida - 1);

        Jogador jogador = new Jogador(id, nome, apelido, dataNascimento, numero, posicao, qualidade);
        equipa.adicionarJogador(jogador);

        System.out.println("Jogador cadastrado com sucesso na equipe " + equipa.getNome() + "!");
    }

    private static void padrao () {
        //Mandante
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
        jogadoresMandante.add(new Jogador(17, "Marcelo", "M2", DataUtil.gerarDataAleatoria(), 17, Posicao.MEDIO_DEFENSIVO, 85));
        jogadoresMandante.add(new Jogador(18, "Fernando", "F2", DataUtil.gerarDataAleatoria(), 18, Posicao.MEDIO_ESQUERDO, 86));
        jogadoresMandante.add(new Jogador(19, "Cláudio", "C2", DataUtil.gerarDataAleatoria(), 19, Posicao.MEDIO_DIREITO, 87));
        jogadoresMandante.add(new Jogador(20, "Eduardo", "E2", DataUtil.gerarDataAleatoria(), 20, Posicao.ATACANTE_DIREITO, 88));
        jogadoresMandante.add(new Jogador(21, "Adriano", "A4", DataUtil.gerarDataAleatoria(), 21, Posicao.ATACANTE_ESQUERDO, 89));
        jogadoresMandante.add(new Jogador(22, "Leonardo", "L2", DataUtil.gerarDataAleatoria(), 22, Posicao.CENTRO_AVANTE, 90));
        jogadoresMandante.add(new Jogador(23, "Ricardo", "R3", DataUtil.gerarDataAleatoria(), 23, Posicao.GOLEIRO, 90));
        jogadoresMandante.add(new Jogador(24, "Valter", "V1", DataUtil.gerarDataAleatoria(), 24, Posicao.ZAGUEIRO_DIREITO, 88));
        jogadoresMandante.add(new Jogador(25, "Raimundo", "R4", DataUtil.gerarDataAleatoria(), 25, Posicao.ZAGUEIRO_ESQUERDO, 87));
        jogadoresMandante.add(new Jogador(26, "Otávio", "O1", DataUtil.gerarDataAleatoria(), 26, Posicao.LATERAL_DIREITO, 89));

        Equipa mandante = new Equipa("Equipa Mandante", "EM", 1900, jogadoresMandante);

        //Visitante
        ArrayList<Jogador> jogadoresVisitante = new ArrayList<>();
        jogadoresVisitante.add(new Jogador(1, "Bruno", "B1", DataUtil.gerarDataAleatoria(), 1, Posicao.GOLEIRO, 83));
        jogadoresVisitante.add(new Jogador(2, "Victor", "V1", DataUtil.gerarDataAleatoria(), 2, Posicao.ZAGUEIRO_DIREITO, 85));
        jogadoresVisitante.add(new Jogador(3, "Eduardo", "E1", DataUtil.gerarDataAleatoria(), 3, Posicao.ZAGUEIRO_ESQUERDO, 86));
        jogadoresVisitante.add(new Jogador(4, "Rogério", "R3", DataUtil.gerarDataAleatoria(), 4, Posicao.LATERAL_DIREITO, 84));
        jogadoresVisitante.add(new Jogador(5, "Jorge", "J2", DataUtil.gerarDataAleatoria(), 5, Posicao.LATERAL_ESQUERDO, 82));
        jogadoresVisitante.add(new Jogador(6, "Fabio", "F2", DataUtil.gerarDataAleatoria(), 6, Posicao.MEDIO_DEFENSIVO, 88));
        jogadoresVisitante.add(new Jogador(7, "André", "A1", DataUtil.gerarDataAleatoria(), 7, Posicao.MEDIO_ESQUERDO, 83));
        jogadoresVisitante.add(new Jogador(8, "Marcos", "M2", DataUtil.gerarDataAleatoria(), 8, Posicao.MEDIO_DIREITO, 82));
        jogadoresVisitante.add(new Jogador(9, "Diego", "D1", DataUtil.gerarDataAleatoria(), 9, Posicao.ATACANTE_DIREITO, 89));
        jogadoresVisitante.add(new Jogador(10, "Alex", "A2", DataUtil.gerarDataAleatoria(), 10, Posicao.ATACANTE_ESQUERDO, 90));
        jogadoresVisitante.add(new Jogador(11, "Ricardo", "R4", DataUtil.gerarDataAleatoria(), 11, Posicao.CENTRO_AVANTE, 91));
        jogadoresVisitante.add(new Jogador(12, "Gustavo", "G2", DataUtil.gerarDataAleatoria(), 12, Posicao.GOLEIRO, 93));
        jogadoresVisitante.add(new Jogador(13, "Fabrício", "F3", DataUtil.gerarDataAleatoria(), 13, Posicao.ZAGUEIRO_DIREITO, 81));
        jogadoresVisitante.add(new Jogador(14, "Elias", "E3", DataUtil.gerarDataAleatoria(), 14, Posicao.ZAGUEIRO_ESQUERDO, 82));
        jogadoresVisitante.add(new Jogador(15, "Wagner", "W1", DataUtil.gerarDataAleatoria(), 15, Posicao.LATERAL_DIREITO, 83));
        jogadoresVisitante.add(new Jogador(16, "Neto", "N1", DataUtil.gerarDataAleatoria(), 16, Posicao.LATERAL_ESQUERDO, 84));
        jogadoresVisitante.add(new Jogador(17, "Juliano", "J4", DataUtil.gerarDataAleatoria(), 17, Posicao.MEDIO_DEFENSIVO, 85));
        jogadoresVisitante.add(new Jogador(18, "Douglas", "D2", DataUtil.gerarDataAleatoria(), 18, Posicao.MEDIO_ESQUERDO, 86));
        jogadoresVisitante.add(new Jogador(19, "Cristiano", "C3", DataUtil.gerarDataAleatoria(), 19, Posicao.MEDIO_DIREITO, 87));
        jogadoresVisitante.add(new Jogador(20, "Daniel", "D3", DataUtil.gerarDataAleatoria(), 20, Posicao.ATACANTE_DIREITO, 88));
        jogadoresVisitante.add(new Jogador(21, "Felipe", "F4", DataUtil.gerarDataAleatoria(), 21, Posicao.ATACANTE_ESQUERDO, 89));
        jogadoresVisitante.add(new Jogador(22, "Clovis", "C4", DataUtil.gerarDataAleatoria(), 22, Posicao.CENTRO_AVANTE, 90));
        jogadoresVisitante.add(new Jogador(23, "Alberto", "A3", DataUtil.gerarDataAleatoria(), 23, Posicao.GOLEIRO, 85));
        jogadoresVisitante.add(new Jogador(24, "Valdir", "V2", DataUtil.gerarDataAleatoria(), 24, Posicao.ZAGUEIRO_DIREITO, 88));
        jogadoresVisitante.add(new Jogador(25, "Sebastião", "S2", DataUtil.gerarDataAleatoria(), 25, Posicao.ZAGUEIRO_ESQUERDO, 87));
        jogadoresVisitante.add(new Jogador(26, "Romário", "R5", DataUtil.gerarDataAleatoria(), 26, Posicao.LATERAL_DIREITO, 89));

        Equipa visitante = new Equipa("Equipa Visitante", "EV", 1910, jogadoresVisitante);

        jogo = new Jogo(mandante, visitante, DataUtil.gerarDataAleatoria(), "Estádio Municipal", "Cidade X");

    }

    private static void simularJogo() {

        System.out.println("Escolha a equipe mandante:");
        for (int i = 0; i < equipas.size(); i++) {
            System.out.println((i + 1) + ". " + equipas.get(i).getNome());
        }
        int mandanteIndex = scanner.nextInt() - 1;

        System.out.println("Escolha a equipe visitante:");
        for (int i = 0; i < equipas.size(); i++) {
            if (i != mandanteIndex) System.out.println((i + 1) + ". " + equipas.get(i).getNome());
            else{
                System.out.println("As equipes mandante e visitante não podem ser as mesmas.");
                return;
            }
        }
        int visitanteIndex = scanner.nextInt() - 1;

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
        jogo.exibirResultado();
    }
}
*/

/*
package org.example;
import Campeonato.*;
import Enums.*;
import utils.DataUtil;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int SCREEN_WIDTH = 80;
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
                        System.out.println("Primeiro, crie pelo menos uma equipe.");
                    } else {
                        cadastrarJogador();
                    }
                    break;
                case 3:
                    padrao();
                    break;
                case 4:
                    if (equipas.size() < 2) {
                        System.out.println("Você precisa ter as equipas criadas para imprimir os planteis.");
                    } else {
                        imprimirPlanteis();
                    }
                    break;
                case 5:
                    if (equipas.size() < 2) {
                        System.out.println("É necessário ter pelo menos 2 equipes para simular um jogo.");
                    } else {
                        simularJogo();
                    }
                    break;
                case 6:
                    System.out.println("Saindo...");
                    System.out.println("Obrigado por usar o IG11CampGest!");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void instrucao() {
        System.out.println("------------------------------------------------");
        System.out.println("-----------BEM-VINDO AO IG11CAMPGEST------------");
        System.out.println("  Um Sistema de Gestão de Campeonato de Futebol\n"+
                "########## Instruções de Utilização #############\n" +
                "Crie pelo menos duas equipas para poder simular um jogo, as equipas devem ter um plantel de até 26 jogadores\n"+
                "Cadastre jogadores para as equipas, veja os planteis das equipas com os jogadores cadrastrados e simule um jogo entre as equipas\n" +
                "Os 18 melhores jogadores baseando em posição e qualidade serão convocados para o jogo\n" +
                "Ou simplemente carrege equipas já predefinidas, reveja os planteis e vá direto pra simulação\n");
    }

    private static void menu() {
        System.out.println("-------------------Menu--------------------");
        System.out.println("------------1. Criar Equipas---------------");
        System.out.println("------------2. Cadastrar Jogador-----------");
        System.out.println("------------3. Carregar 2 Equipas prontas--");
        System.out.println("------------4. Imprimir Planteis-----------");
        System.out.println("------------5. Simular Jogo----------------");
        System.out.println("------------6. Sair------------------------");
        System.out.print("------------Escolha uma opção: ");
    }

    private static void criarEquipa() {
        while (equipas.size() < 2) {
            System.out.print("Nome da Equipa: ");
            String nome = scanner.nextLine();

            System.out.print("Apelido da Equipa: ");
            String apelido = scanner.nextLine();

            System.out.print("Ano de Fundação: ");
            int fundacao = scanner.nextInt();
            scanner.nextLine();

            Equipa equipa = new Equipa(nome, apelido, fundacao, new ArrayList<>());
            equipas.add(equipa);

            System.out.println("Equipa criada com sucesso!");
        }
    }

    private static void cadastrarJogador() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Apelido: ");
        String apelido = scanner.nextLine();

        System.out.print("Data de Nascimento (AAAA-MM-DD): ");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());

        System.out.print("Número: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Posição:");
        for (Posicao posicao : Posicao.values()) {
            System.out.println(posicao.ordinal() + 1 + ". " + posicao.getDescricao());
        }
        System.out.print("Escolha uma posição: ");
        int posicaoEscolhida = scanner.nextInt();
        scanner.nextLine();

        Posicao posicao = Posicao.values()[posicaoEscolhida - 1];

        System.out.print("Qualidade: ");
        int qualidade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Escolha a equipe do jogador:");
        for (int i = 0; i < equipas.size(); i++) {
            System.out.println((i + 1) + ". " + equipas.get(i).getNome());
        }
        int equipeEscolhida = scanner.nextInt();
        scanner.nextLine();

        Equipa equipa = equipas.get(equipeEscolhida - 1);

        Jogador jogador = new Jogador(id, nome, apelido, dataNascimento, numero, posicao, qualidade);
        equipa.adicionarJogador(jogador);

        System.out.println("Jogador cadastrado com sucesso na equipe " + equipa.getNome() + "!");
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
        jogadoresMandante.add(new Jogador(17, "Marcelo", "M2", DataUtil.gerarDataAleatoria(), 17, Posicao.MEDIO_DEFENSIVO, 85));
        jogadoresMandante.add(new Jogador(18, "Fernando", "F2", DataUtil.gerarDataAleatoria(), 18, Posicao.MEDIO_ESQUERDO, 86));
        jogadoresMandante.add(new Jogador(19, "Cláudio", "C2", DataUtil.gerarDataAleatoria(), 19, Posicao.MEDIO_DIREITO, 87));
        jogadoresMandante.add(new Jogador(20, "Eduardo", "E2", DataUtil.gerarDataAleatoria(), 20, Posicao.ATACANTE_DIREITO, 88));
        jogadoresMandante.add(new Jogador(21, "Adriano", "A4", DataUtil.gerarDataAleatoria(), 21, Posicao.ATACANTE_ESQUERDO, 89));
        jogadoresMandante.add(new Jogador(22, "Leonardo", "L2", DataUtil.gerarDataAleatoria(), 22, Posicao.CENTRO_AVANTE, 90));
        jogadoresMandante.add(new Jogador(23, "Ricardo", "R3", DataUtil.gerarDataAleatoria(), 23, Posicao.GOLEIRO, 90));
        jogadoresMandante.add(new Jogador(24, "Valter", "V1", DataUtil.gerarDataAleatoria(), 24, Posicao.ZAGUEIRO_DIREITO, 88));
        jogadoresMandante.add(new Jogador(25, "Raimundo", "R4", DataUtil.gerarDataAleatoria(), 25, Posicao.ZAGUEIRO_ESQUERDO, 87));
        jogadoresMandante.add(new Jogador(26, "Otávio", "O1", DataUtil.gerarDataAleatoria(), 26, Posicao.LATERAL_DIREITO, 89));

        Equipa mandante = new Equipa("Equipa Mandante", "EM", 1900, jogadoresMandante);

        // Visitante
        ArrayList<Jogador> jogadoresVisitante = new ArrayList<>();
        jogadoresVisitante.add(new Jogador(1, "Bruno", "B1", DataUtil.gerarDataAleatoria(), 1, Posicao.GOLEIRO, 83));
        jogadoresVisitante.add(new Jogador(2, "Victor", "V1", DataUtil.gerarDataAleatoria(), 2, Posicao.ZAGUEIRO_DIREITO, 85));
        jogadoresVisitante.add(new Jogador(3, "Eduardo", "E1", DataUtil.gerarDataAleatoria(), 3, Posicao.ZAGUEIRO_ESQUERDO, 86));
        jogadoresVisitante.add(new Jogador(4, "Rogério", "R3", DataUtil.gerarDataAleatoria(), 4, Posicao.LATERAL_DIREITO, 84));
        jogadoresVisitante.add(new Jogador(5, "Jorge", "J2", DataUtil.gerarDataAleatoria(), 5, Posicao.LATERAL_ESQUERDO, 82));
        jogadoresVisitante.add(new Jogador(6, "Fabio", "F2", DataUtil.gerarDataAleatoria(), 6, Posicao.MEDIO_DEFENSIVO, 88));
        jogadoresVisitante.add(new Jogador(7, "André", "A1", DataUtil.gerarDataAleatoria(), 7, Posicao.MEDIO_ESQUERDO, 83));
        jogadoresVisitante.add(new Jogador(8, "Marcos", "M2", DataUtil.gerarDataAleatoria(), 8, Posicao.MEDIO_DIREITO, 82));
        jogadoresVisitante.add(new Jogador(9, "Diego", "D1", DataUtil.gerarDataAleatoria(), 9, Posicao.ATACANTE_DIREITO, 89));
        jogadoresVisitante.add(new Jogador(10, "Alex", "A2", DataUtil.gerarDataAleatoria(), 10, Posicao.ATACANTE_ESQUERDO, 90));
        jogadoresVisitante.add(new Jogador(11, "Ricardo", "R4", DataUtil.gerarDataAleatoria(), 11, Posicao.CENTRO_AVANTE, 91));
        jogadoresVisitante.add(new Jogador(12, "Gustavo", "G2", DataUtil.gerarDataAleatoria(), 12, Posicao.GOLEIRO, 93));
        jogadoresVisitante.add(new Jogador(13, "Fabrício", "F3", DataUtil.gerarDataAleatoria(), 13, Posicao.ZAGUEIRO_DIREITO, 81));
        jogadoresVisitante.add(new Jogador(14, "Elias", "E3", DataUtil.gerarDataAleatoria(), 14, Posicao.ZAGUEIRO_ESQUERDO, 82));
        jogadoresVisitante.add(new Jogador(15, "Wagner", "W1", DataUtil.gerarDataAleatoria(), 15, Posicao.LATERAL_DIREITO, 83));
        jogadoresVisitante.add(new Jogador(16, "Neto", "N1", DataUtil.gerarDataAleatoria(), 16, Posicao.LATERAL_ESQUERDO, 84));
        jogadoresVisitante.add(new Jogador(17, "Juliano", "J4", DataUtil.gerarDataAleatoria(), 17, Posicao.MEDIO_DEFENSIVO, 85));
        jogadoresVisitante.add(new Jogador(18, "Douglas", "D2", DataUtil.gerarDataAleatoria(), 18, Posicao.MEDIO_ESQUERDO, 86));
        jogadoresVisitante.add(new Jogador(19, "Cristiano", "C3", DataUtil.gerarDataAleatoria(), 19, Posicao.MEDIO_DIREITO, 87));
        jogadoresVisitante.add(new Jogador(20, "Daniel", "D3", DataUtil.gerarDataAleatoria(), 20, Posicao.ATACANTE_DIREITO, 88));
        jogadoresVisitante.add(new Jogador(21, "Felipe", "F4", DataUtil.gerarDataAleatoria(), 21, Posicao.ATACANTE_ESQUERDO, 89));
        jogadoresVisitante.add(new Jogador(22, "Clovis", "C4", DataUtil.gerarDataAleatoria(), 22, Posicao.CENTRO_AVANTE, 90));
        jogadoresVisitante.add(new Jogador(23, "Alberto", "A3", DataUtil.gerarDataAleatoria(), 23, Posicao.GOLEIRO, 85));
        jogadoresVisitante.add(new Jogador(24, "Valdir", "V2", DataUtil.gerarDataAleatoria(), 24, Posicao.ZAGUEIRO_DIREITO, 88));
        jogadoresVisitante.add(new Jogador(25, "Sebastião", "S2", DataUtil.gerarDataAleatoria(), 25, Posicao.ZAGUEIRO_ESQUERDO, 87));
        jogadoresVisitante.add(new Jogador(26, "Romário", "R5", DataUtil.gerarDataAleatoria(), 26, Posicao.LATERAL_DIREITO, 89));



        Equipa visitante = new Equipa("Equipa Visitante", "EV", 1910, jogadoresVisitante);

        equipas.add(mandante);
        equipas.add(visitante);

        System.out.println("Equipes padrão carregadas com sucesso!");
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

*/

/*
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
                        centralize("Primeiro, crie pelo menos uma equipe.");
                    } else {
                        cadastrarJogador();
                    }
                    break;
                case 3:
                    padrao();
                    break;
                case 4:
                    if (equipas.size() < 2) {
                        centralize("Você precisa ter as equipas criadas para imprimir os planteis.");
                    } else {
                        imprimirPlanteis();
                    }
                    break;
                case 5:
                    if (equipas.size() < 2) {
                        centralize("É necessário ter pelo menos 2 equipes para simular um jogo.");
                    } else {
                        simularJogo();
                    }
                    break;
                case 6:
                    centralize("Saindo...");
                    centralize("Obrigado por usar o IG11CampGest!");
                    return;
                default:
                    centralize("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void instrucao() {
        String[] instructions = {
                "------------------------------------------------",
                "-----------BEM-VINDO AO IG11CAMPGEST------------",
                "  Um Sistema de Gestão de Campeonato de Futebol  ",
                "########## Instruções de Utilização #############",
                "Crie pelo menos duas equipas para poder simular",
                "um jogo, as equipas devem ter um plantel de até",
                "26 jogadores. Cadastre jogadores para as equipas,",
                "veja os planteis das equipas com os jogadores",
                "cadastrados e simule um jogo entre as equipas.",
                "Os 18 melhores jogadores baseando em posição e",
                "qualidade serão convocados para o jogo.",
                "Ou simplemente carrege equipas já predefinidas,",
                "reveja os planteis e vá direto pra simulação."
        };
        for (String line : instructions) {
            centralize(line);
        }
    }

    private static void menu() {
        String[] menuItems = {
                "-------------------Menu--------------------",
                "------------1. Criar Equipas---------------",
                "------------2. Cadastrar Jogador-----------",
                "------------3. Carregar 2 Equipas prontas--",
                "------------4. Imprimir Planteis-----------",
                "------------5. Simular Jogo----------------",
                "------------6. Sair------------------------",
                "------------Escolha uma opção: "
        };
        for (String item : menuItems) {
            centralize(item);
        }
    }

    private static void criarEquipa() {
        while (equipas.size() < 2) {
            centralize("Nome da Equipa: ");
            String nome = scanner.nextLine();

            centralize("Apelido da Equipa: ");
            String apelido = scanner.nextLine();

            centralize("Ano de Fundação: ");
            int fundacao = scanner.nextInt();
            scanner.nextLine();

            Equipa equipa = new Equipa(nome, apelido, fundacao, new ArrayList<>());
            equipas.add(equipa);

            centralize("Equipa criada com sucesso!");
        }
    }

    private static void cadastrarJogador() {
        centralize("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        centralize("Nome: ");
        String nome = scanner.nextLine();

        centralize("Apelido: ");
        String apelido = scanner.nextLine();

        centralize("Data de Nascimento (AAAA-MM-DD): ");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());

        centralize("Número: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        centralize("Posição:");
        for (Posicao posicao : Posicao.values()) {
            centralize(posicao.ordinal() + 1 + ". " + posicao.getDescricao());
        }
        centralize("Escolha uma posição: ");
        int posicaoEscolhida = scanner.nextInt();
        scanner.nextLine();

        Posicao posicao = Posicao.values()[posicaoEscolhida - 1];

        centralize("Qualidade: ");
        int qualidade = scanner.nextInt();
        scanner.nextLine();

        centralize("Escolha a equipe do jogador:");
        for (int i = 0; i < equipas.size(); i++) {
            centralize((i + 1) + ". " + equipas.get(i).getNome());
        }
        int equipeEscolhida = scanner.nextInt();
        scanner.nextLine();

        Equipa equipa = equipas.get(equipeEscolhida - 1);

        Jogador jogador = new Jogador(id, nome, apelido, dataNascimento, numero, posicao, qualidade);
        equipa.adicionarJogador(jogador);

        centralize("Jogador cadastrado com sucesso na equipe " + equipa.getNome() + "!");
    }

     private static void centralize(String texto) {
        int larguraTela = 80;
        int espacos = (larguraTela - texto.length()) / 2;
        String espacoBranco = " ".repeat(Math.max(0, espacos));
        System.out.println(espacoBranco + texto);
    }

*/


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
        int larguraTela = 155;  // Supondo uma largura de tela de 80 caracteres
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

    /*private static void imprimirPlanteis() {
        for (Equipa equipa : equipas) {
            centralizarTexto(equipa.getNome() + " - " + equipa.getApelido() + " (Fundada em: " + equipa.getFundacao() + ")");
            centralizarTexto("----------------------");
            for (Jogador jogador : equipa.getJogadores()) {
                centralizarTexto(jogador.getNumero() + " - " + jogador.getNome() + " " + jogador.getApelido() + " (" + jogador.getPosicao().getDescricao() + ")");
            }
            centralizarTexto("----------------------");
        }
    }*/

    private static void imprimirPlanteis() {
        for (Equipa equipa: equipas) equipa.relacionarJogadores();

        System.out.println("Planteis das Equipas:");
        for (Equipa equipa : equipas) equipa.imprimirEscalacao();
    }

   /* private static void simularJogo() {
        Equipa equipa1 = equipas.get(0);
        Equipa equipa2 = equipas.get(1);

        // Simulação do jogo (pode ser mais complexa)
        centralizarTexto("Simulando o jogo entre " + equipa1.getNome() + " e " + equipa2.getNome() + "...");

        Random random = new Random();
        int golosEquipa1 = random.nextInt(5); // Geração de golos aleatórios
        int golosEquipa2 = random.nextInt(5);

        centralizarTexto("Resultado: " + equipa1.getNome() + " " + golosEquipa1 + " - " + golosEquipa2 + " " + equipa2.getNome());
    }*/

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

