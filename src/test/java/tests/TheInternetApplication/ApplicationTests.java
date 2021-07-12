package tests.TheInternetApplication;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApplicationTests extends BaseTest {

    @Test
    public void contextMenuTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        By hot_spot = By.id("hot-spot");

        Actions actions = new Actions(driver);
        actions
                .moveToElement(wait.waitForToBeClickable(hot_spot))
                .contextClick()
                .build()
                .perform();
    }

    @Test
    public void DynamicControlsTest(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        By checkbox_by = By.xpath("//*[@type = 'checkbox']");
        By button_remove_by = By.xpath("//button[@onclick='swapCheckbox()']");
        By message_by = By.id("message");

        Actions actions = new Actions(driver);

        final WebElement checkbox = wait.waitForVisibility(checkbox_by);
        checkbox.click();

        wait.waitForVisibility(button_remove_by).click();
        wait.waitForVisibility(message_by);
        Assert.assertThrows(StaleElementReferenceException.class, checkbox::isDisplayed);






    }
}
