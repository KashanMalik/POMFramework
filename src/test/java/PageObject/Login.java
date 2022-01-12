package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    WebDriver driver;

    @FindBy(xpath = "//input[@id='username']")
    WebElement id;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement sign_in;

   public Login(WebDriver driver){
       this.driver=driver;
       PageFactory.initElements(driver,this);
   }

    public void login(String s1,String s2){
        id.sendKeys(s1);
        password.sendKeys(s2);
        sign_in.click();
    }

}
