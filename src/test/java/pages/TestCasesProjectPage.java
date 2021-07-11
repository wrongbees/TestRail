package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCasesProjectPage extends BasePage {
    private static String id;// нужно будет доделать
    private final static String endpoint = "index.php?/suites/view" + id;

    private final String test_case_by_name = "//*[text() ='replace' and @class='title']";
    private final static String check_box_delete = "//*[text() ='replace' and @class = 'title']/ancestor::tr//input";
    private final static By button_delete = By.id("deleteCases");
    private final static By mark_as_deleted = By.xpath("//*[@id='casesDeletionDialog']//a[contains(text(),'Mark as Deleted')]");

    private final static By button_add_test_cases = By.id("sidebar-cases-add");

    public TestCasesProjectPage(WebDriver driver, boolean openPageByUrl) throws InterruptedException {
        super(driver, openPageByUrl);
    }

    public TestCasesProjectPage(WebDriver driver, boolean openPageByUrl, String id) throws InterruptedException {
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
            return getButtonAddTestCases().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

    }
    public WebElement getButtonAddTestCases() {
        return driver.findElement(button_add_test_cases);
    }

    public WebElement getTitleTestCase(String caseName) {
        return driver.findElement(By.xpath(test_case_by_name.replace("replace",caseName)));
    }
    public WebElement getCheckForDelete(String caseName){
        return driver.findElement(By.xpath(check_box_delete.replace("replace",caseName)));
    }
    public WebElement getButtonDelete() {
        return driver.findElement(button_delete);
    }

    public WebElement getMarkAsDeleted() {
        return driver.findElement(mark_as_deleted);
    }

    public void clickButtonAddTestCases() {
        getButtonAddTestCases().click();
    }

    public void clickTitleTestCase(String caseName) {
        getTitleTestCase(caseName).click();
    }

    public void clickCheckForDelete(String caseName){
        getCheckForDelete(caseName).click();
    }
    public void clickButtonDelete() {
        getButtonDelete().click();
    }

    public void clickMarkAsDeleted() {
        getMarkAsDeleted().click();
    }
}



