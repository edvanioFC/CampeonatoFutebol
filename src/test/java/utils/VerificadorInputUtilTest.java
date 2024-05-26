package utils;

import org.junit.Assert;
import org.junit.Test;

public class VerificadorInputUtilTest {
    //Field scanner of type Scanner - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    VerificadorInputUtil verificadorInputUtil = new VerificadorInputUtil();

    @Test
    public void testCheckInt() {
        int result = verificadorInputUtil.checkInt();
        Assert.assertEquals(0, result);
    }

    @Test
    public void testCheckString() {
        String result = verificadorInputUtil.checkString();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testCheckName() {
        String result = verificadorInputUtil.checkName();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme