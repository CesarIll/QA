package calculadoraTest;

import calculadora.Calculadora;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RestaTest {
    Calculadora cal;

    @Before
    public void before(){
        cal = new Calculadora();
    }

    @Test
    public void restarPares(){
        int actualResult = cal.restar(11,3);
        int expectedResult = 8;
        Assert.assertEquals("ERROR: la resta es incorrecta", expectedResult, actualResult);
    }

    @Test
    public void restarImpares(){
        int actualResult = cal.restar(11,3);
        int expectedResult = 8;
        Assert.assertEquals("ERROR: la resta es incorrecta", expectedResult, actualResult);
    }

    @Test
    public void restarImparesPares(){
        int actualResult = cal.restar(11,3);
        int expectedResult = 8;
        Assert.assertEquals("ERROR: la resta es incorrecta", expectedResult, actualResult);
    }
}
