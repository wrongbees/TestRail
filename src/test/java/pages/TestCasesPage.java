package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCasesPage extends BasePage {
    private  static String id;// нужно будет доделать
    private final static String endpoint = "index.php?/cases/view" + id;

    private final static By button_edit =
            By.xpath("//*[@class='toolbar-button toolbar-button-last content-header-button" +
                    " button-responsive button-edit toolbar-button-first']");
    private final static By button_delete = By.id("deleteCases");
    private final static By mark_as_deleted = By.xpath("//*[@id='casesDeletionDialog']//a[contains(text(),'Mark as Deleted')]");

    private final static String check_box_delete = "//*[text() ='replace' and @class = 'title']/ancestor::tr//input";
   // private final static String check_box_delete = "//span[text() ='Союз']/ancestor::tr[contains(@id,'row')]/td[6]";



    public TestCasesPage(WebDriver driver, boolean openPageByUrl) throws InterruptedException {
        super(driver, openPageByUrl);

    }

    public TestCasesPage(WebDriver driver, boolean openPageByUrl, String id) throws InterruptedException {
        super(driver, openPageByUrl);
        this.id = id;
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL() + endpoint);
    }

    @Override
    public boolean isPageOpened() throws InterruptedException {
        try {
            return getButtonEditTestCase().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement getButtonEditTestCase() {
        return driver.findElement(button_edit);
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

    public void clickButtonEditTestCase() {
        getButtonEditTestCase().click();
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
