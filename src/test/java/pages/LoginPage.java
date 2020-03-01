package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
        //Will enable on the next homework
        //AjaxElementLocatorFactory PageFactory = new AjaxElementLocatorFactory(driver, 10);
        //org.openqa.selenium.support.PageFactory.initElements(driver, this);
    }

    protected By email = By.name("email");
    protected By password = By.name("password");
    protected By loginBtn = By.tagName("button");
    protected By titleText = By.tagName("h5");
    protected By errorText = By.className("help-block");



    public void setEmail(String strEmail){
        driver.findElement(email).sendKeys(strEmail);
    }

    public void setPassword(String strPassword){
        driver.findElement(password).sendKeys(strPassword);
    }

    public void clickLogin(){
        waitElementVisibilityAndClick(loginBtn);
    }

    public String getLoginTitle(){
        return driver.findElement(titleText).getText();
    }

    public boolean isErrorVisible(){
        return driver.findElement(errorText).isDisplayed();
    }


    public LoginPage loginToTestkwidos(String email, String password){
        setEmail(email);
        setPassword(password);
        clickLogin();
        return this;
    }
}
