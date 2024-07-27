package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testng04 {




    @Test (groups = {"sanity", "QA"})
        public void sanityrun() {

            System.out.println("sanity");
            System.out.println("QA");

        }
    @Test (groups = {"sanity","QA"})
        public void Reg() {

            System.out.println("reg");

        }

    @Test (groups = {"sanity","smoke","dev"})
        public void Smokerun() {

            System.out.println("smoke");

        }



}
