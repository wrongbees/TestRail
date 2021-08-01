package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditTestCasePage extends BasePage {
    private static String id;// нужно будет доделать
    private final static String endpoint = "index.php?/cases/edit" + id;

    private final static By button_save_test_cases = By.id("accept");
    private final static By title_field = By.id("title");
    private final static By preconds_display = By.id("custom_preconds_display");
    private final static By steps_display = By.id("custom_steps_display");
    private final static By expected_display = By.id("custom_expected_display");

    public EditTestCasePage(WebDriver driver, boolean openPageByUrl) throws InterruptedException {
        super(driver, openPageByUrl);
    }

    public EditTestCasePage(WebDriver driver, boolean openPageByUrl, String id) throws InterruptedException {
        super(driver, openPageByUrl);
        this.id = id;

    }
    @Override
    protected void openPage() {
        driver.get(properties.getURL() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getSaveTestCaseAccept().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement getSaveTestCaseAccept() {
        return driver.findElement(button_save_test_cases);
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

    public void clickSaveTestCaseAccept() {
        getSaveTestCaseAccept().click();
    }

    public void setTitle(String title) {
        getTitleField().clear();
        getTitleField().sendKeys(title);
    }

    public void setPreconditions(String preconditions) {
        getPreconditionsDisplay().clear();
        getPreconditionsDisplay().sendKeys(preconditions);
    }

    public void setSteps(String steps) {
        getStepsDisplay().clear();
        getStepsDisplay().sendKeys(steps);
    }

    public void setExpected(String expected) {
        getExpectedDisplay().clear();
        getExpectedDisplay().sendKeys(expected);
    }
}
