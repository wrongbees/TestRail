package elements.homeWork_13;


import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Waits;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.List;

public class DropDown {
    private final WebDriver driver;
    private Waits wait;
    private List<UIElement> dropDownElements = new ArrayList<>();
    private UIElement uiElement;
    private String attributeName;

    /***
     *
     * @param driver
     * @param by необходимо передать значение любого аттрибута элемента
     *           активизирующего выбранное поле dropdown.
     */
    public DropDown(WebDriver driver, By by) {
        this.driver = driver;
        this.wait = new Waits(driver, 2);
        this.uiElement = new UIElement(driver, by);
    }

    public void openingDropDown() throws UnexpectedException {
        uiElement.click();
        createAttributeName();
    }

    private void createAttributeName() throws UnexpectedException {
        String href = uiElement.getAttribute("href");
        System.out.println(href);
        this.attributeName = href.substring(href.lastIndexOf("#") + 1);


        if (!attributeName.equals("javascript:void(0)")) {
            dropDownElementsListCreator();
        } else {
            throw new UnexpectedException("The selected dropdown is empty.");
        }
    }

    private void dropDownElementsListCreator() {

        By all_elements = By.xpath(String.format("//*[@id='%s']//a",attributeName));
        wait.waitForToBeClickable(all_elements);

        for (WebElement element : driver.findElements(all_elements)) {
            dropDownElements.add(new UIElement(driver, element));
        }

    }

    public int getElementsCount() {
        return dropDownElements.size();
    }

    public void printElementsText() {
        for (UIElement element : dropDownElements) {
            System.out.println(element.getText());
        }
    }

    public void selectElement(int index) {
        dropDownElements.get(index - 1).click();
    }

    public void selectElement(String text) {
        for (UIElement element : dropDownElements) {
            if (element.getText().equalsIgnoreCase(text)) {
                element.click();
                break;
            }
        }
    }
}


