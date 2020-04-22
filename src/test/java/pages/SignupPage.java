package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SignupPage extends BasePage{

    public SignupPage(WebDriver driver) {
        super(driver);
        //solution for homework 2
        AjaxElementLocatorFactory PageFactory = new AjaxElementLocatorFactory(driver, 10);
        org.openqa.selenium.support.PageFactory.initElements(driver, this);
    }

    Users user = new Users();;
    Faker faker = new Faker();

//    protected By firstName = By.cssSelector("input[formcontrolname='firstName']");
//    protected By lastName = By.cssSelector("input[formcontrolname='lastName']");
//    protected By businessName = By.cssSelector("input[formcontrolname='businessName']");
//    protected By phone = By.cssSelector("input[formcontrolname='phone']");
//    protected By email = By.cssSelector("input[formcontrolname='email']");
//    protected By password = By.cssSelector("input[formcontrolname='password']");
//    protected By termsOfService = By.cssSelector("div.card-content div:nth-child(8) div p-checkbox");
//    protected By createAccountBtn = By.tagName("button");
//    public By alert = By.cssSelector(".alert");

    @FindBy(css = "input[formcontrolname='firstName']")
    protected WebElement firstName;
    @FindBy(css = "input[formcontrolname='lastName']")
    protected WebElement lastName;
    @FindBy(css = "input[formcontrolname='businessName']")
    protected WebElement businessName;
    @FindBy(css = "input[formcontrolname='phone']")
    protected WebElement phone;
    @FindBy(css = "input[formcontrolname='email']")
    protected WebElement email;
    @FindBy(css = "input[formcontrolname='password']")
    protected WebElement password;
    @FindBy(css = "div.card-content div:nth-child(8) div p-checkbox")
    protected WebElement termsOfService;
    @FindBy(tagName = "button")
    protected WebElement createAccountBtn;
    @FindBy(css = ".alert")
    public WebElement alert;


    public void setFirstName(String fName){
        firstName.sendKeys(fName);
    }

    public void setLastName(String lName){
        lastName.sendKeys(lName);
    }

    public void setBusinessName(String bName){
        businessName.sendKeys(bName);
    }

    public void setPhone(String pNum){
        phone.sendKeys(pNum);
    }

    public void setEmail(String text){
        email.sendKeys(text);
    }

    public void setPassword(String text){
        password.sendKeys(text);
    }

    public void checkboxTOS(){
        termsOfService.click();
    }
    public void clickCreateAccount(){
        createAccountBtn.click();
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
