package utils;
import java.util.Locale;
import com.github.javafaker.Faker;
import java.util.Random;

public class GeradorNomes {

        private static final Faker FAKER = new Faker(new Locale("pt-BR"));
        private static final Random RANDOM = new Random();

        public GeradorNomes(){}


        public static String gerarNome() {
            return FAKER.name().firstName();
        }

        public static String gerarApelido() {
            char letter1 = (char) ('A' + RANDOM.nextInt(26));
            char letter2 = (char) ('A' + RANDOM.nextInt(26));
            return "" + letter1 + letter2;
        }

}
