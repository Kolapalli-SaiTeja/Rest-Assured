package DDT;

import org.testng.annotations.Test;

public class DDT01 {


    @Test (dataProvider = "getData",dataProviderClass = ExcelUtil.class)
    public  void testlogin(String username, String password){

        System.out.println( username);
        System.out.println( password);


    }


}
