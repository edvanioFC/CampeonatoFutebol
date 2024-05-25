package utils;

import static java.lang.System.out;

public class TextoUtil {

    public static void centralizarTexto(String texto) {
        int larguraTela = 155;
        int espacos = (larguraTela - texto.length()) / 2;
        String espacoBranco = " ".repeat(Math.max(0, espacos));
       out.println(espacoBranco + texto);
    }
}
