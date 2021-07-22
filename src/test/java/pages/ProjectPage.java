package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectPage extends BasePage {
    private static String id;// нужно будет доделать
    private final static String endpoint = "index.php?/projects/overview" + id;

    private final static By button_test_cases = By.id("navigation-suites");


    public ProjectPage(WebDriver driver, boolean openPageByUrl) throws InterruptedException {
        super(driver, openPageByUrl);
    }

    public ProjectPage(WebDriver driver, boolean openPageByUrl, String id) throws InterruptedException {
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
            return getButtonTestCases().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement getButtonTestCases() {
        return driver.findElement(button_test_cases);
    }

    public void clickButtonTestCases() {
        getButtonTestCases().click();
    }
}
