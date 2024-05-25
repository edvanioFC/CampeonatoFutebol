package utils;


import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class DataUtil {

    public static LocalDate gerarDataAleatoria() {
        LocalDate inicio = LocalDate.of(1980, 1, 1); // data de início
        LocalDate fim = LocalDate.of(2002, 12, 31); // data de fim

        long inicioEmDias = inicio.toEpochDay();
        long fimEmDias = fim.toEpochDay();
        long diasAleatorios = ThreadLocalRandom.current().nextLong(inicioEmDias, fimEmDias);


        return LocalDate.ofEpochDay(diasAleatorios);
    }
}