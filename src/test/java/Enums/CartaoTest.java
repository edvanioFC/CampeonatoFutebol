package Enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class CartaoTest {


    Cartao cartao = Cartao.AMARELO;

    @Test
    public void testGetDescricao() {
        String result = cartao.getDescricao();
        Assertions.assertEquals("Amarelo", result);
    }
}
