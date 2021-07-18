package pages;

import baseEntities.BasePage;
import org.openqa.selenium.*;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class AddTestCasePage extends BasePage {
    private static String id;// нужно будет доделать
    private final static String endpoint = "index.php?/projects/overview" + id;

    private final static By list_empty_icon = By.id("entityAttachmentListEmptyIcon");
    private final static By button_add_test_cases_accept = By.id("accept");
    private final static By title_field = By.id("title");
    private final static By preconds_display = By.id("custom_preconds_display");
    private final static By steps_display = By.id("custom_steps_display");
    private final static By expected_display = By.id("custom_expected_display");
    private final static By add_file_window = By.id("libraryAttachmentsAddItem");
    private final static By library_attachments_add_item = By.id("libraryAttachmentsAddItem");
    private final static By button_attachment_new_Submit = By.id("attachmentNewSubmit");

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
            return getButtonAddTestCasesAccept().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement getListEmptyIcon() {
        return waits.waitForVisibility(list_empty_icon);
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

    public WebElement getAddFileWindow() { return waits.waitForVisibility(add_file_window); }

    public WebElement getLibraryAttachmentsAddItem() { return waits.waitForVisibility(library_attachments_add_item); }

    public WebElement getButtonAttachmentNewSubmit(){
        return waits.waitForToBeClickable(button_attachment_new_Submit);
        }

    public WebElement getButtonAddTestCasesAccept(){return waits.waitForVisibility(button_add_test_cases_accept);}

    public void clickAddFileListEmpty() {
        getListEmptyIcon().click();
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

    public void clickAddFileWindow() { getAddFileWindow().click();}

    public void clickButtonAddTestCasesAccept(){ getButtonAddTestCasesAccept().click(); }

    public void clickButtonAttachmentNewSubmit() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].click();",getButtonAttachmentNewSubmit());}

    public void clickLibraryAttachmentsAddItem(String fileName) throws AWTException {

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].click();",  getLibraryAttachmentsAddItem());

        Robot rb = new Robot();
        File file = new File(getClass().getClassLoader().getResource("images/" + fileName).getFile());
        String path = file.getPath();
        System.out.println(path);

        StringSelection str = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        rb.delay(2000);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);


        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.delay(2000);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

        clickButtonAttachmentNewSubmit();

}
}

