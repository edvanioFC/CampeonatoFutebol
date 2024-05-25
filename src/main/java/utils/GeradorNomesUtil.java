package utils;

import java.util.Locale;
import com.github.javafaker.Faker;
import java.util.Random;

/**
 * Classe utilitária para gerar nomes e apelidos.
 */
public class GeradorNomesUtil {

    /**
     * Instância do Faker configurada para o idioma pt-BR.
     */
    private static final Faker FAKER = new Faker(new Locale("pt-BR"));

    /**
     * Instância do Random para geração de números aleatórios.
     */
    private static final Random RANDOM = new Random();

    /**
     * Construtor padrão.
     */
    public GeradorNomesUtil(){}

    /**
     * Gera um nome aleatório.
     *
     * @return Um nome aleatório como uma String.
     */
    public static String gerarNome() {
        return FAKER.name().firstName();
    }

    /**
     * Gera um apelido aleatório.
     * O apelido é formado por duas letras maiúsculas aleatórias.
     *
     * @return Um apelido aleatório como uma String.
     */
    public static String gerarApelido() {
        char letter1 = (char) ('A' + RANDOM.nextInt(26));
        char letter2 = (char) ('A' + RANDOM.nextInt(26));
        return " " + letter1 + letter2;
    }

}