package basicUnit;

import org.junit.*;

public class BasicJUnit1 {

    @BeforeClass
    public static void beforeClass(){
        System.out.println(" ----> BEFORE CLASS");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println(" ----> AFTER CLASS");
    }

    //Initialize | Setup
    @Before
    public void beforeMethod(){
        System.out.println(" ----> BEFORE METHOD");
    }

    //Clean-Up | Teardown
    @After
    public void afterMethod(){
        System.out.println(" ----> AFTER METHOD");
    }

    @Test
    public void verify_something(){
        System.out.println("Test 1");
    }

    @Test
    public void verify_something2(){
        System.out.println("Test 2");
    }

    @Test
    @Ignore
    public void verify_something3(){
        System.out.println("Test 3");
    }

    @Test(timeout = 2000)
    public void verify_something4(){
        System.out.println("Test 4 - Velocidad");
    }

    @Test(/*expected = ArithmeticException.class*/)
    public void verify_something5(){
        System.out.println("Test 5");
    }
}
