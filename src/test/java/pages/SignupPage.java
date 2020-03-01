package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage extends BasePage{

    public SignupPage(WebDriver driver) {
        super(driver);
        //Will enable on the next homework
        //AjaxElementLocatorFactory PageFactory = new AjaxElementLocatorFactory(driver, 10);
        //org.openqa.selenium.support.PageFactory.initElements(driver, this);
    }

    Users user = new Users();;
    Faker faker = new Faker();

    protected By firstName = By.cssSelector("input[formcontrolname='firstName']");
    protected By lastName = By.cssSelector("input[formcontrolname='lastName']");
    protected By businessName = By.cssSelector("input[formcontrolname='businessName']");
    protected By phone = By.cssSelector("input[formcontrolname='phone']");
    protected By email = By.cssSelector("input[formcontrolname='email']");
    protected By password = By.cssSelector("input[formcontrolname='password']");
    protected By termsOfService = By.cssSelector("div.card-content div:nth-child(8) div p-checkbox");
    protected By createAccountBtn = By.tagName("button");
    public By alert = By.cssSelector(".alert");

    public void setFirstName(String fName){
        driver.findElement(firstName).sendKeys(fName);
    }

    public void setLastName(String lName){
        driver.findElement(lastName).sendKeys(lName);
    }

    public void setBusinessName(String bName){
        driver.findElement(businessName).sendKeys(bName);
    }

    public void setPhone(String pNum){
        driver.findElement(phone).sendKeys(pNum);
    }

    public void setEmail(String text){
        driver.findElement(email).sendKeys(text);
    }

    public void setPassword(String text){
        driver.findElement(password).sendKeys(text);
    }

    public void checkboxTOS(){
        driver.findElement(termsOfService).click();
    }
    public void clickCreateAccount(){
        waitElementVisibilityAndClick(createAccountBtn);
    }

    public SignupPage emptySignup(){
        setFirstName(user.emptySignUp().firstName);
        setLastName(user.emptySignUp().lastName);
        setBusinessName(user.emptySignUp().businessName);
        setPhone(user.emptySignUp().phone);
        setEmail(user.emptySignUp().email);
        setPassword(user.emptySignUp().password);

        return this;
    }

    public SignupPage wrongSignUp(){
        setFirstName(user.wrongSignUp().firstName);
        setLastName(user.wrongSignUp().lastName);
        setBusinessName(user.wrongSignUp().businessName);
        setPhone(user.wrongSignUp().phone);
        setEmail(user.wrongSignUp().email);
        setPassword(user.wrongSignUp().password);

        return this;
    }

    public SignupPage validSignUp(){
        setFirstName(faker.name().firstName());
        setLastName(faker.name().lastName());
        setBusinessName(faker.name().fullName());
        setPhone(faker.phoneNumber().phoneNumber());
        setEmail(faker.name().firstName() + faker.number().randomNumber() +  "@example.org");
        setPassword(faker.internet().password() + faker.number().randomNumber() + faker.job().field());
        checkboxTOS();
        clickCreateAccount();
        return this;
    }
}
