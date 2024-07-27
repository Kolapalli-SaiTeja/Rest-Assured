package DDT;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelUtil {


    static Workbook book;

    static Sheet sheet;

    public static String File_Name ="src/test/resources.XLSX/Book1.xlsx";





    public static Object[][] getTestData(String sheetName) throws Exception {


        FileInputStream file;

        file = new FileInputStream(File_Name);

        book = WorkbookFactory.create(file);

        sheet = book.getSheet(sheetName);

        //System.out.println(sheetName);

        int s = sheet.getRow(0).getLastCellNum();
        System.out.println(s);

      Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i =0; i<sheet.getLastRowNum();i++)
        {

        for (int j=0; j<sheet.getRow(0).getLastCellNum(); j++){


            data[i][j] =sheet.getRow(i+1).getCell(j).toString();

        }


        }
        return data;

    }

@DataProvider

    public Object [][] getData() throws Exception{

        return getTestData("Sheet1");
}



    }

