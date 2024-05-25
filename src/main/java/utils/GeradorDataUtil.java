package utils;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Classe utilitária para gerar datas aleatórias.
 */
public class GeradorDataUtil {

    /**
     * Gera uma data aleatória entre 01/01/1980 e 31/12/2002.
     *
     * @return Uma data aleatória como um objeto LocalDate.
     */
    public static LocalDate gerarDataAleatoria() {
        /**
         *@note Data de início do intervalo.
         */

        LocalDate inicio = LocalDate.of(1980, 1, 1);
        /**
         * @note Data de fim do intervalo.
         */
         LocalDate fim = LocalDate.of(2002, 12, 31);

        /**
         * @note Converte as datas de início e fim para dias desde a época (01/01/1970).
         */
        long inicioEmDias = inicio.toEpochDay();
        long fimEmDias = fim.toEpochDay();
        /**
         * @note Gera um número aleatório de dias entre o início e o fim.
         */
        long diasAleatorios = ThreadLocalRandom.current().nextLong(inicioEmDias, fimEmDias);

        /**
         * @return a data correspondente ao número aleatório de dias desde a época.
         */
        return LocalDate.ofEpochDay(diasAleatorios);
    }
}