package utils;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class GeradorDataUtilTest {

    @Test
    public void testGerarDataAleatoria() {
        LocalDate result = GeradorDataUtil.gerarDataAleatoria();
        Assert.assertEquals(LocalDate.of(2024, Month.MAY, 25), result);
    }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme