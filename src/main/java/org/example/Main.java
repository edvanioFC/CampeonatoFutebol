package org.example;
/**
 * @author EdvanioFC (Edvanio Correia)
 * @version 1.0
 * @note Esta aplicação é um sistema de gestão de campeonatos de futebol.
 * Classe principal da aplicação.
 * Esta classe contém o método principal que é o ponto de entrada da aplicação.
 * Cria uma instância da classe Ig11CampGest, exibe as instruções e entra em um loop onde exibe o menu e lida com as escolhas do usuário.
 * O loop continua até que o usuário escolha sair da aplicação.
 * Finalmente, fecha o scanner e imprime uma nova linha.
 */
public class Main{
    /**
     * O método principal da aplicação.
     * Este é o ponto de entrada da aplicação.
     * Cria uma instância da classe Ig11CampGest, exibe as instruções e entra em um loop onde exibe o menu e lida com as escolhas do usuário.
     * O loop continua até que o usuário escolha sair da aplicação.
     * Finalmente, fecha o scanner e imprime uma nova linha.
     *
     * @param args Os argumentos da linha de comando.
     * @throws Exception Se ocorrer um erro.
     */
    public static void main(String[] args) throws Exception {
        Ig11CampGest gestorCampeonato = new Ig11CampGest();
        Ig11CampGest.instrucao();
        while (Ig11CampGest.isFlag()) {
            Ig11CampGest.menu();
            Ig11CampGest.opcoes();
        }
        gestorCampeonato.getScanner().close();
        System.out.println("\n");
    }
}