package utils;

import static java.lang.System.out;
/**
 * Classe utilitária para centralizar texto.
 */
public class CentralizadorTextoUtil {

    /**
     * Centraliza um texto fornecido.
     *
     * @param texto O texto a ser centralizado.
     */
    public static void centralizarTexto(String texto) {
         /**
         * @note A largura da tela foi definida com base na minha tela, que tem 155
         */
        int larguraTela = 155;
        /**
         * @note O número de espaços a adicionar antes do texto para centralizá-lo.
        */
        int espacos = (larguraTela - texto.length()) / 2;
        /**
         * @note A string de espaços em branco.
        */
        String espacoBranco = " ".repeat(Math.max(0, espacos));
        /**
         * @note Imprime o texto centralizado.
        */
        out.println(espacoBranco + texto);
    }
}