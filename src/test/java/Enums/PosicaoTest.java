package Enums;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosicaoTest {

    Posicao posicao = Posicao.GOLEIRO;

    @Test
    public void testGetDescricao() {
        String result = posicao.getDescricao();
        Assertions.assertEquals( "Goleiro" , result);

    }

    @Test
    public void testGetPosicao() {
        String result = posicao.getPosicao();
        Assertions.assertEquals("GK", result);
    }
}
