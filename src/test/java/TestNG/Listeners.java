package TestNG;

import org.testng.IExecutionListener;
import org.testng.annotations.Test;


@org.testng.annotations.Listeners(customListenerrs.class)

public class Listeners{


    @Test
    public void demo1() {


        long id =Thread.currentThread().getId();

        System.out.println("thread  id is "+ id +getClass().getSimpleName());

    }
    @Test
    public void demo2() {

        long id =Thread.currentThread().getId();

        System.out.println("thread  id is "+ id +getClass().getSimpleName());;

    }
}
