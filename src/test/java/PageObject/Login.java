package PageObject;

import org.openqa.selenium.JavascriptExecutor;
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


  /*  public WebElement user_name(){
        return (WebElement) ((JavascriptExecutor) driver).executeScript("return document.querySelector(\"#app > amplify-authenticator\").shadowRoot.querySelector(\"div > slot > amplify-sign-in\").shadowRoot.querySelector(\"amplify-form-section > amplify-auth-fields\").shadowRoot.querySelector(\"div > amplify-username-field\").shadowRoot.querySelector(\"amplify-form-field\").shadowRoot.querySelector(\"#username\")");
    }
    public WebElement password(){
        return (WebElement) ((JavascriptExecutor) driver).executeScript("return document.querySelector(\"#app > amplify-authenticator\").shadowRoot.querySelector(\"div > slot > amplify-sign-in\").shadowRoot.querySelector(\"amplify-form-section > amplify-auth-fields\").shadowRoot.querySelector(\"div > amplify-password-field\").shadowRoot.querySelector(\"amplify-form-field\").shadowRoot.querySelector(\"#password\")");
    }
    public WebElement submit_button(){
        return (WebElement) ((JavascriptExecutor) driver).executeScript("return document.querySelector(\"#app > amplify-authenticator\").shadowRoot.querySelector(\"div > slot > amplify-sign-in\").shadowRoot.querySelector(\"amplify-form-section > div.sign-in-form-footer > slot > slot:nth-child(2) > amplify-button\")");
    }*/

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
