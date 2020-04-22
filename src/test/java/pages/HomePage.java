package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage extends BasePage {

    protected static String BASE_URL = "https://testkwidos.tk/" ;

    public HomePage(WebDriver driver) {
        super(driver);
        //homework 2
        AjaxElementLocatorFactory PageFactory = new AjaxElementLocatorFactory(driver, 10);
        org.openqa.selenium.support.PageFactory.initElements(driver, this);
        driver.get(BASE_URL);

    }



    //Solution for Homework 2
    @FindBy(css = "ul.user.nav")
     protected WebElement loginButton;
    @FindBy(css = "div.guest-home label.wr-register-type__btn")
     WebElement signUpButton;

    // navigates to login page
    public void toLoginPage(){
        loginButton.click();
    }

    //navigate to signup page
    public SignupPage toSignUpPage(){
        waitElementVisibilityAndClick(signUpButton);
        return new SignupPage(driver);
    }
}
