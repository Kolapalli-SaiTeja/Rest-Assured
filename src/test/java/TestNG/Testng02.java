package TestNG;

import org.testng.annotations.*;

public class Testng02 {

    public class Testng01 {
        @BeforeSuite
        public void demo1() {

            System.out.println("before Suite");

        }

        @BeforeTest
        public void demo2() {

            System.out.println("Before Test");

        }


        @BeforeClass
        public void demo3() {

            System.out.println("Before Class");

        }


        @BeforeMethod
        public void demo4() {

            System.out.println("Before method");

        }

        @Test
        public void demo99() {

            System.out.println("Test");

        }

        @AfterMethod
        public void demo6() {

            System.out.println("After Method");

        }

        @AfterClass
        public void demo7() {

            System.out.println("After class");

        }


        @AfterTest
        public void demo8() {

            System.out.println("After test");

        }


        @AfterSuite
        public void demo9() {

            System.out.println("After suite");

        }
    }

}
