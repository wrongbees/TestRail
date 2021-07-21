package elements.homeWork_13;

import elements.Button;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Waits;

import java.util.ArrayList;
import java.util.List;

public class DropDown {
    private final WebDriver driver;
    private UIElement uiElement;
    private Waits wait;
    private List<UIElement> dropDownElements = new ArrayList<>();
    private List<Button> buttonsDrDownList = new ArrayList<>();
    private Button buttonDrDown;
    private String attributeName;

    private final String for_search_drop_down_elements = "//*[@id='replace' or class = 'replace']//a";


    public DropDown(WebDriver driver, By by) {
        this.driver = driver;
        this.wait = new Waits(driver, 2);
        this.buttonDrDown = new Button(driver, by);
    }

    public void openingDropDown() {
        buttonDrDown.click();
        createAttributeName();
    }

    private void createAttributeName() {
        String href = buttonDrDown.getAttribute("href");
        this.attributeName = href.substring(href.lastIndexOf("#") + 1);
         System.out.println(attributeName);
        dropDownElementsListCreator();
    }

    private void dropDownElementsListCreator() {
        By all_elements = By.xpath(for_search_drop_down_elements.replace("replace", attributeName));
        wait.waitForToBeClickable(all_elements);

        for (WebElement element : driver.findElements(all_elements)){
            dropDownElements.add(new UIElement(driver,element));
        }

    }
    public int getElementsCount(){
        return dropDownElements.size();
    }

    public void printElementsText(){
        for (UIElement element: dropDownElements){
            System.out.println(element.getText());
        }
    }

    public void selectElement(int index){
        dropDownElements.get(index+1).click();
    }
}


