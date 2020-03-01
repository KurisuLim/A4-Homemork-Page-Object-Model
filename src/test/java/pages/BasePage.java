package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }


    public void waitVisibility(By element){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    }

    public void waitElementVisibilityAndClick(By element){
        waitVisibility(element);
        driver.findElement(element).click();
    }

    public void waitForUrlChange(String url){
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(url)));
    }

}
