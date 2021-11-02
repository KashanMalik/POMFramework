package Utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Helper {

    /**************** Method to capture screenshot ****************************/
    public static String capture_screenshot(WebDriver driver){
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String screenshotpath=System.getProperty("user.dir")+"/Functions/Screenshots/Chase"+"_"+ getCurrentDateTime() +".png";

        try {
            FileHandler.copy(src,new File(screenshotpath));
            System.out.println("Screenshot captured");
        } catch (IOException e) {
            System.out.println("Unable to capture a screenshot"+e.getMessage());
        }
        return screenshotpath;
    }
    /**************** Method to get current date and time ****************************/
    public static String getCurrentDateTime(){
        DateFormat customformat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        Date currentdate=new Date();
        return customformat.format(currentdate);
    }
}
