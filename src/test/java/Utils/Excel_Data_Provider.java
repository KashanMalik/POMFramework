package Utils;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Excel_Data_Provider {

    XSSFWorkbook wb;

    public Excel_Data_Provider(){

        try {
            File src=new File("./Functions/TestData/testdata.xlsx");
            FileInputStream fis= new FileInputStream(src);
            wb=new XSSFWorkbook(fis);
        } catch (IOException e) {
            System.out.println("Unable to read data from excel file"+e.getMessage());
        }
    }

    /**************** Method to get string values from excel sheet ****************************/
    public String getStringData(String sheetname,int row,int column){
        return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
    }
    /**************** Method to get numeric values from excel sheet ****************************/
    public double getNumericData(String sheetname,int row,int column){
        return wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
    }
}
