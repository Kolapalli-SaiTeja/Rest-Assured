package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testng05 {



    @Parameters("browser")

    @Test
    void demo (String value){


        System.out.println("Browser is " + value);


    }





}
