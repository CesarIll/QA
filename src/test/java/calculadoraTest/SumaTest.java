package calculadoraTest;

import calculadora.Calculadora;
import org.junit.*;

public class SumaTest {
    Calculadora cal;

    @BeforeClass
    public void before(){
        cal = new Calculadora();
    }

    @Test
    public void sumarPares(){
        int actualResult = cal.sumar(5,3);
        int expectedResult = 8;
        Assert.assertEquals("ERROR: la suma es incorrecta", expectedResult, actualResult);
    }

    @Test
    public void sumarImpares(){
        int actualResult = cal.sumar(5,3);
        int expectedResult = 8;
        Assert.assertEquals("ERROR: la suma es incorrecta", expectedResult, actualResult);
    }

    @Test
    public void sumarImparesPares(){
        int actualResult = cal.sumar(5,3);
        int expectedResult = 8;
        Assert.assertEquals("ERROR: la suma es incorrecta", expectedResult, actualResult);
    }
}
