package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddTestCasePage extends BasePage {
    private static String id;// нужно будет доделать
    private final static String endpoint = "index.php?/projects/overview" + id;

    private final static By button_add_test_cases = By.id("accept");
    private final static By title_field = By.id("title");
    private final static By preconds_display = By.id("custom_preconds_display");
    private final static By steps_display = By.id("custom_steps_display");
    private final static By expected_display = By.id("custom_expected_display");

    public AddTestCasePage(WebDriver driver, boolean openPageByUrl) throws InterruptedException {
        super(driver, openPageByUrl);
    }

    public AddTestCasePage(WebDriver driver, boolean openPageByUrl, String id) throws InterruptedException {
        super(driver, openPageByUrl);
        this.id = id;

    }
    @Override
    protected void openPage() {
        driver.get(properties.getURL() + endpoint);
    }

    @Override
    public boolean isPageOpened(){
        try {
            return getAddTestCaseAccept().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement getAddTestCaseAccept() {
        return driver.findElement(button_add_test_cases);
    }

    public WebElement getTitleField() {
        return driver.findElement(title_field);
    }

    public WebElement getPreconditionsDisplay() {
        return driver.findElement(preconds_display);
    }

    public WebElement getStepsDisplay() {
        return driver.findElement(steps_display);
    }

    public WebElement getExpectedDisplay() {
        return driver.findElement(expected_display);
    }

    public void clickAddTestCaseAccept() {
        getAddTestCaseAccept().click();
    }

    public void setTitle(String title) {
        getTitleField().sendKeys(title);
    }

    public void setPreconditions(String preconditions) {
        getPreconditionsDisplay().sendKeys(preconditions);
    }

    public void setSteps(String steps) {
        getStepsDisplay().sendKeys(steps);
    }

    public void setExpected(String expected) {
        getExpectedDisplay().sendKeys(expected);
    }
}
