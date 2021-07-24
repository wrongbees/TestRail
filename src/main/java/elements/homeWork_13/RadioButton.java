package elements.homeWork_13;

import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RadioButton {
    private UIElement uiElement;
    private List<UIElement> options = new ArrayList<>();
    private WebDriver driver;

    /***
     * RadioButton ui element для улучшения работы
     * @param driver
     * @param by необходимо передать значение аттрибута name
     *
     */
    public RadioButton(WebDriver driver, By by) {
        this.driver = driver;

        for (WebElement element : driver.findElements(by)) {
            options.add(new UIElement(driver, element));
        }
    }

    public void selectByIndex(int index) {
        for (UIElement element : options) {
            if (Integer.parseInt(element.getAttribute("value")) == index) {
                element.click();
                break;
            }
        }
    }

    public void selectByText(String optionName) {
        for (UIElement element : options) {
            if (getTextValue(element).equalsIgnoreCase(optionName)) {
                element.click();
                break;
            }
        }
    }

    public Boolean isSelected(int index) {
        for (UIElement element : options) {
            if (Integer.parseInt(element.getAttribute("value")) == index) {
                return element.isSelected();
            }
        }
        return null;
    }

    public Boolean isSelected(String optionName) {
        for (UIElement element : options) {

            if (getTextValue(element).equalsIgnoreCase(optionName)) {
                return element.isSelected();
            }
        }
        return null;
    }

    private String getTextValue(UIElement element){
        try {
            return element.getParent().findElement(By.tagName("strong")).getText();
        } catch (NoSuchElementException ex) {
            return element.getParent().findElement(By.tagName("p")).getText();
        }
    }
}

