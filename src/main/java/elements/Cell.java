package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cell {
    private UIElement uiElement;
    private WebDriver driver;

    public Cell(WebDriver driver, By by){
        this.driver = driver;
        uiElement = new UIElement(driver, by);
    }
    public Cell(WebDriver driver, WebElement webElement){
        this.driver = driver;
        uiElement = new UIElement(driver, webElement);
    }

    public UIElement getUIElement() {
        return uiElement;
    }
}
