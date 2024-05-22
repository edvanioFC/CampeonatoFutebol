package org.example;
import Campeonato.*;
import Enums.*;
import utils.DataUtil;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

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


        // mandante
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
        visitante.relacionarMelhoresJogadores();
        System.out.println("Relacionados Visitante");
        mandante.relacionarMelhoresJogadores();

//        jogo.gerarResultado();
//        jogo.registrarEventos();
//        jogo.exibirResultado();


    }
}

//                jogo.imprimirPlanteis();
//
//                // Permitir treinamento
//                jogo.permitirTreinamento();
//
//                // Gerar lesões
//                jogo.gerarLesoes();
//
//                // Gerar cartões
//                jogo.gerarCartoes();
//
//                // Gerar resultado do jogo
//                jogo.gerarResultado();
//
//                jogo.imprimirEventos();
//
//                // Imprimir resultados
//                jogo.imprimirResultado();
