package utils;

import java.util.Scanner;

public class VerificaInputUtil {
        private final Scanner scanner;

        public VerificaInputUtil() {
            this.scanner = new Scanner(System.in);
        }

        public int checkInt() {
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, insira um número inteiro.");
                scanner.next();
            }
            return scanner.nextInt();
        }

        public String checkString() {

            while (!scanner.hasNextLine()) {
                System.out.println("Por favor, insira uma string.");
                scanner.next();
            }
            return scanner.nextLine();
        }

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

