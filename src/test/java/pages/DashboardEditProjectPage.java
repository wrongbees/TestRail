package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardEditProjectPage extends BasePage {

    private static String id;// нужно будет доделать
    private final static String endpoint = "index.php?/admin/projects/edit/" + id;

    private final static By field_name = By.id("name");
    private final static By button_save_project = By.id("accept");

    public DashboardEditProjectPage(WebDriver driver, boolean openPageByUrl, String id) throws InterruptedException {
        super(driver, openPageByUrl);
        this.id = id;
    }

    public DashboardEditProjectPage(WebDriver driver, boolean openPageByUrl) throws InterruptedException {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL()+endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getNameField().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getNameField() {
        return driver.findElement(field_name);
    }

    public WebElement getButtonSaveProject(){
        return driver.findElement(button_save_project);
    }




    public void setEditName(String name) {
        getNameField().clear();
        getNameField().sendKeys(name);
    }

    public void clickButtonSaveProject() {
        getButtonSaveProject().click();
    }
}
