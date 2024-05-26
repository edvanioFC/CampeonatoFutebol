package utils;

import org.junit.Assert;
import org.junit.Test;

public class GeradorNomesUtilTest {

    @Test
    public void testGerarNome() {
        String result = GeradorNomesUtil.gerarNome();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testGerarApelido() {
        String result = GeradorNomesUtil.gerarApelido();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme