package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
        //homework 2
        AjaxElementLocatorFactory PageFactory = new AjaxElementLocatorFactory(driver, 10);
        org.openqa.selenium.support.PageFactory.initElements(driver, this);
    }
    //Solution for homework 2
    @FindBy(name = "email")
    protected WebElement email;
    @FindBy(name = "password")
    protected WebElement password;
    @FindBy(tagName = "button")
    protected WebElement loginBtn;
    @FindBy(tagName = "h5")
    protected WebElement titleText;
    @FindBy(className = "help-block")
    protected WebElement errorText;


    public void setEmail(String strEmail){
        email.sendKeys(strEmail);
    }

    public void setPassword(String strPassword){
        password.sendKeys(strPassword);
    }

    public void clickLogin(){
        loginBtn.click();
    }

    public String getLoginTitle(){
        return titleText.getText();
    }

    public boolean isErrorVisible(){
        return errorText.isDisplayed();
    }


    public LoginPage loginToTestkwidos(String email, String password){
        setEmail(email);
        setPassword(password);
        clickLogin();
        return this;
    }
}
