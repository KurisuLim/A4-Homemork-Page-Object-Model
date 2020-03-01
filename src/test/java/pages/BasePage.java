package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }


    public void waitVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementVisibilityAndClick(WebElement element){
        waitVisibility(element);
        element.click();
    }

    public void waitForUrlChange(String url){
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(url)));
    }

}
