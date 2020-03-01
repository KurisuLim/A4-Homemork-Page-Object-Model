package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    protected static String BASE_URL = "https://testkwidos.tk/" ;

    //Solution for Homework 1
    By loginButton = By.cssSelector("ul.user.nav");
    By signUpButton = By.cssSelector("div.guest-home label.wr-register-type__btn");

    public HomePage openHomePage(){
        driver.get(BASE_URL);
        return this;
    }

    // navigates to login page
    public LoginPage toLoginPage(){
        waitElementVisibilityAndClick(loginButton);
        return new LoginPage(driver);
    }

    //navigate to signup page
    public SignupPage toSignUpPage(){
        waitElementVisibilityAndClick(signUpButton);
        return new SignupPage(driver);
    }
}
