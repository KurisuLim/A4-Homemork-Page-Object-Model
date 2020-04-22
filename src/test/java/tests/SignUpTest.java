package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.SignupPage;

public class SignUpTest extends BaseTest {
    SignupPage page;
    HomePage home;
    BasePage base;

    @BeforeMethod
    public void signUpPage(){
        base = new BasePage(driver);
        home = new HomePage(driver);
        page = new SignupPage(driver);
        home.toSignUpPage();
        String expected = "Kwidos";
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void emptySignUp(){
        page.emptySignup();
        System.out.println("Empty Signup Success");
        //the Create Account Button is disabled if
        //the credential is incorrect
    }

    @Test
    public void invalidSignUp(){
        page.wrongSignUp();
        System.out.println("Invalid Signup Success");
        //the Create Account Button is disabled if
        //the credential is incorrect
    }

    @Test
    public void validSignUp(){
        page.validSignUp();
        Assert.assertTrue(page.alert.isDisplayed());
        System.out.println("Valid Signup Success");
    }

}
