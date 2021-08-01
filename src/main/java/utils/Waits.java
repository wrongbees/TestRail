package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Waits {
    WebDriverWait wait;

    public Waits(WebDriver driver, int timeOut) {
         wait = new WebDriverWait(driver,timeOut);
    }

    public WebElement waitForVisibility(By by){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public WebElement waitForVisibility(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public Boolean waitForVisibilityList(List<WebElement> elementsList){
        return wait.until(ExpectedConditions.invisibilityOfAllElements(elementsList));
    }

    public WebElement waitForToBeClickable(By by){
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public WebElement waitForToBeClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Boolean waitForToBeNotClickable(By by){return wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(by)));
    }

    public Boolean waitForToBeNotClickable(WebElement element){

        return wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(element)));
    }


    public List<WebElement> waitForVisibilityAllElements(By by){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public boolean waitForInvisibility(By by){
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public boolean waitForInvisibility(WebElement element){
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public boolean waitForVisibilityText(By by, String text){
        return wait.until(ExpectedConditions.textToBe(by, text));
    }
    public boolean waitForAttribute(By by, String attributeName, String attributeValue){
        return wait.until(ExpectedConditions.attributeToBe(by,attributeName, attributeValue));
    }

    public boolean waitAttributeToBeEmpty(WebElement element, String attributeName){
        return wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attributeName));
    }
    public boolean waitAttributeContains(WebElement element, String attributeName, String attributeValue){
        return wait.until(ExpectedConditions.attributeContains(element, attributeName, attributeValue));
    }

//    public boolean waitForWindows(int windowCount){
//        return wait.until(ExpectedConditions.nu)
//    }






}
