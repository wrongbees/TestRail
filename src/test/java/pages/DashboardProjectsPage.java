package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DashboardProjectsPage extends BasePage {

    private final static String endpoint = "index.php?/admin/projects/overview";

    private final static By project_dashboard_title = By.className("content-header-title");
    private final static By button_add_project = By.xpath("//*[contains(text(),'Add Project')]");
    private final static By delete_checkbox = By.xpath("//*[@id='dialog-ident-deleteDialog']//input[@name ='deleteCheckbox']");
    private final static By delete_accept_ok =
            By.xpath(" //*[@id='deleteDialog']/child::div[@class = 'button-group dialog-buttons-highlighted']/child::a");

    private final static String project_by_name = "//*[(text()='replace')]";
    private final static String button_delet_project_by_name
            = "//*[text()='replace']/ancestor::tr[@class = 'even hoverSensitive']//div[@class = 'icon-small-delete']";


    public DashboardProjectsPage(WebDriver driver, boolean openPageByUrl) throws InterruptedException {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL() + endpoint);

    }

    @Override
    public boolean isPageOpened() {
        try {
            return getDashboardProjectTitle().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getDashboardProjectTitle() {return driver.findElement(project_dashboard_title);
    }

    public WebElement getButtonAddProject() {return driver.findElement(button_add_project);}

    public WebElement getDeleteCheckBoxAccept() {return driver.findElement(delete_checkbox);}

    public WebElement getDeleteAcceptOk() {return driver.findElement(delete_accept_ok);}


    public WebElement aProjectByName(String name) {
        return  driver.findElement(By.xpath(project_by_name.replace("replace",name))); }


    public void chooseAProjectByName(String name) {
        driver.findElement(By.xpath(project_by_name.replace("replace",name))).click();
    }

    public void clickButtonAddProject() {
        getButtonAddProject().click();
    }

    public void deleteAProjectByName(String name) {
        driver.findElement(By.xpath(button_delet_project_by_name.replace("replace",name))).click();
    }

    public void clickDeleteCheckBoxAccept(){
        getDeleteCheckBoxAccept().click();

    }

    public void clickDeleteAcceptOk(){
        getDeleteAcceptOk().click();
    }


}
