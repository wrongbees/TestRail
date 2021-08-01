package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {

    private final static String endpoint = "index.php?/dashboard";


    private final static By navigation_dashboard = By.id("navigation-dashboard");
    private final static By button_add_project = By.id("sidebar-projects-add");

    private final static String project_by_name = "//*[(text()='replace')]";


    public DashboardPage(WebDriver driver, boolean openPageByUrl) throws InterruptedException {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL() + endpoint);

    }

    @Override
    public boolean isPageOpened() {
        try {
            return getDashboardNavigation().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getDashboardNavigation() {return driver.findElement(navigation_dashboard);
    }

    public WebElement getButtonAddProject() {return driver.findElement(button_add_project);
    }



    public void clickAddProjectButton() {getButtonAddProject().click();}

    public void chooseAProjectByName(String name) {
        driver.findElement(By.xpath(project_by_name.replace("replace",name))).click();
    }



}
