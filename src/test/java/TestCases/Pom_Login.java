package TestCases;

import org.testng.annotations.Test;

public class Pom_Login extends Pom_Base_class {


    @Test(priority = 1)
    public void login(){

        logger=extent.createTest("Login");
        logger.info("Testcase for login to the page");

        loginobj.login(excelobj.getStringData("Login",0,0), excelobj.getStringData("Login",0,1) );
        logger.pass("Login Testcase passed successfully");
    }


}
