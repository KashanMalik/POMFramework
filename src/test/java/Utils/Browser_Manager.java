package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Browser_Manager {

    public static WebDriver start_application(WebDriver driver,String browsername, String appurl){
        if (browsername.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            driver=new ChromeDriver();
        }
        else if (browsername.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/drivers/firefoxdriver.exe");
            driver=new FirefoxDriver();
        }
        else {
            Assert.assertTrue(false,"No browser type sent");
        }

        driver.manage().window().maximize();
        driver.get(appurl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        return driver;
    }

    public static void close_browser(WebDriver driver){
        driver.close();
        driver.quit();
    }
}
