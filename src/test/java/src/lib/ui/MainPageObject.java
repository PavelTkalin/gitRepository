package src.lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPageObject {

    protected AppiumDriver driver;

    public MainPageObject(AppiumDriver driver) {

        this.driver = driver;

    }


    public WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + " \n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


    public WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {

        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;

    }


    public WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) {

        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;

    }




    public boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + " \n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }


    public WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }


    public void assertElementHasText(By by, String error_message, long timeoutInSeconds) {

        WebElement title_element = waitForElementPresent(by, "Page not found", 5);
        String article_title = title_element.getText();

    }


    public int getAmountOfElements(By by) {

        List elements = driver.findElements(by);
        return elements.size();
    }

    //   System.out.println("First test run");


    public void assertElementNotPresent(By by, String error_message) {

        int amount_of_elements = getAmountOfElements(by);
        if (amount_of_elements > 0) {
            String default_message = "An element" + by.toString() + "supposed to be not present";
            throw new AssertionError(default_message + " " + error_message);


        }


    }

    public String waitForElementAndGetAttribute(By by, String attribute, String error_message, long timeOutInSeconds) {


        WebElement element = waitForElementPresent(by, attribute, timeOutInSeconds);
        return element.getAttribute(attribute);


    }


    public void assertElementIsPresenting(By by, String error_message, long timeoutInSeconds) {
        boolean isTrue = driver.findElement(by).isDisplayed();
        Assert.assertTrue(isTrue);


    }




}
