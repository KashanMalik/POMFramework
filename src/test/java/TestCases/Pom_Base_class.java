package TestCases;


import PageObject.Login;
import Utils.Browser_Manager;
import Utils.Config_Data_Provider;
import Utils.Excel_Data_Provider;
import Utils.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

public class Pom_Base_class {


    WebDriver driver;
    public Excel_Data_Provider excelobj;
    public Config_Data_Provider configobj;
    public ExtentReports extent;
    ExtentSparkReporter spark;
    ExtentTest logger;

    Login loginobj;


    /**************** Object Creation ****************************/
    @BeforeSuite
    public void set_up_suite(){
        Reporter.log("Setting up Extent Reports",true);

        excelobj=new Excel_Data_Provider();
        configobj=new Config_Data_Provider();
        extent=new ExtentReports();
        spark= new ExtentSparkReporter(System.getProperty("user.dir") + "/Functions/Reports/Test.html");
        Reporter.log("Extent Report environment set successfully");
    }


    /**************** Open browser using value pass from xml file at run time ****************************/
    @Parameters({"browser","Url"})
    @BeforeClass
    public void set_up(String browser,String url){
        Reporter.log("Setting up Browser and Url",true);
        driver=Browser_Manager.start_application(driver,browser,url);
        Reporter.log("Browser and Url set successfully",true);

        instantiate_objects();
    }

    /**************** Object Creation ****************************/
    public void instantiate_objects(){
        Reporter.log("Instantiation Object",true);
        loginobj=PageFactory.initElements(driver,Login.class);
    }
    /**************** Open browser using value pass from config file ****************************/
   /* @BeforeClass
    public void set_up(){
        Reporter.log("Setting up Browser and Url",true);
        driver=Browser_Manager.start_application(driver,configobj.getBrowser(),configobj.getUrl());
        Reporter.log("Browser and Url set successfully",true);

        instantiate_objects();
    }*/



    /**************** Capture screenshot in the end of testcase ****************************/
    @AfterMethod
    public void tear_down_method(ITestResult result){

        Reporter.log("Setting up screenshot  ",true);
        if(result.getStatus()==ITestResult.FAILURE){
            logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capture_screenshot(driver)).build());
        }
        else if(result.getStatus()==ITestResult.SUCCESS){
            logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capture_screenshot(driver)).build());
        }
        extent.attachReporter(spark);
        extent.flush( );

        Reporter.log("<<<<<<<<< Report generated successfully >>>>>>>>>>>",true);
    }

    /**************** Close browser ****************************/
    @AfterClass
    public void tear_down(){
        Browser_Manager.close_browser(driver);
    }

    }




