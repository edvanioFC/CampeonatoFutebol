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
        System.out.println("\n");
    }
}
