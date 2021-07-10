package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardAddProjectPage extends BasePage {

    private final static String endpoint ="index.php?/admin/projects/add/1";


    private final static By field_name = By.id("name");
    private final static By header_title = By.className("content-header-title page_title");
    private final static By add_project_accept_button = By.id("accept");


    public DashboardAddProjectPage(WebDriver driver, boolean openPageByUrl) throws InterruptedException {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {driver.get(properties.getURL()+endpoint);

    }

    @Override
    public boolean isPageOpened() {
        try {
            return getNameField().isDisplayed();
        } catch (NoSuchElementException ex){
            return  false;
        }
    }


    public WebElement getTitle(){return driver.findElement(header_title);}

    public WebElement getNameField() {return  driver.findElement(field_name);}

    public WebElement getAddProjectAcceptButton() {return driver.findElement(add_project_accept_button);}


    public void setProjectName(String name) {
        getNameField().sendKeys(name);
    }

    public void clickAddProjectAcceptButton() {
        getAddProjectAcceptButton().click();
    }
}
