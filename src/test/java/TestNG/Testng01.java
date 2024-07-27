package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testng01 {


    @BeforeMethod
    public void demo1() {

        System.out.println("before method");

    }
    @Test
    public void demo2() {

        System.out.println("Test1");

    }

    @Test
    public void demo3() {

        System.out.println("Test2");

    }


    @AfterMethod
    public void demo4() {

        System.out.println("After method");

    }


}
