package TestNG;

import org.testng.IExecutionListener;

public class customListenerrs implements IExecutionListener {


    @Override
    public void onExecutionStart() {


        long endTime = System.currentTimeMillis();
        System.out.println("Execution started at" + endTime);
    }

    @Override
    public void onExecutionFinish() {
        long starttime =   System.currentTimeMillis();

        System.out.println("Execution finished at" + starttime);

    }
}
