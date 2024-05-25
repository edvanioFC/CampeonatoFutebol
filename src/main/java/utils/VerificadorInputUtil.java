package utils;

import java.util.Scanner;

/**
 * Classe utilitária para verificar a entrada do usuário.
 * Esta classe contém métodos para verificar se a entrada do usuário é um número inteiro, uma string ou um nome.
 */
public class VerificadorInputUtil {
    /**
     * Scanner para ler a entrada do usuário.
     */
    private final Scanner scanner;

    /**
     * Construtor padrão.
     * Inicializa o scanner.
     */
    public VerificadorInputUtil() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Verifica se a entrada do usuário é um número inteiro.
     * Se a entrada não for um número inteiro, solicita ao usuário que insira um número inteiro.
     *
     * @return O número inteiro inserido pelo usuário.
     */
    public int checkInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número inteiro.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Verifica se a entrada do usuário é uma string.
     * Se a entrada não for uma string, solicita ao usuário que insira uma string.
     *
     * @return A string inserida pelo usuário.
     */
    public String checkString() {
        while (!scanner.hasNextLine()) {
            System.out.println("Por favor, insira uma string.");
            scanner.next();
        }
        return scanner.nextLine();
    }

    /**
     * Verifica se a entrada do usuário é um nome.
     * Se a entrada for apenas números, solicita ao usuário que insira um nome válido.
     *
     * @return O nome inserido pelo usuário.
     */
    public String checkName() {
        String name;
        name = scanner.next();
        while(name.matches("[0-9]+")) {
            System.out.println("Por favor, insira um nome válido (não pode ser apenas números).");
            name = scanner.next();
        }
        return name;
    }
}