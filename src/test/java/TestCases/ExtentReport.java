package TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;

public class ExtentReport {

    @Test
    public void extenttest() {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
        ExtentTest logintest = extent.createTest("MyFirstTest");

        logintest.info("Test case for login");
        logintest.pass("test case passed successfully");

        extent.flush();
        System.out.println("Test case passed successfully");
    }
}