package pages;

import baseEntities.BasePage;
import elements.homeWork_13.CheckBox;
import elements.homeWork_13.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardAddProjectPage extends BasePage {

    private final static String endpoint ="index.php?/admin/projects/add/1";


    private final static By field_name = By.id("name");
    private final static By field_announcement = By.id("announcement");
    private final static By header_title = By.className("content-header-title page_title");
    private final static By add_project_accept_button = By.id("accept");
    private final static  By check_box = By.id("show_announcement");
    private final static By suite_mode = By.name("suite_mode");

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
    public WebElement getAnnouncementField() {return  driver.findElement(field_announcement);}

    public WebElement getAddProjectAcceptButton() {return driver.findElement(add_project_accept_button);}


    public void setProjectName(String name) {
        getNameField().sendKeys(name);
    }

    public void setAnnouncement(String name) {
        getAnnouncementField().sendKeys(name);
    }

    public void mark_show_announcement(){
        new CheckBox(driver,check_box).mark();
    }

    public void unMark_show_announcement(){
            new CheckBox(driver,check_box).unMark();
    }

    public void clickAddProjectAcceptButton() {
        getAddProjectAcceptButton().click();
    }

    public void check_SuiteMode(int number){

    RadioButton radioButton = new RadioButton(driver, suite_mode);

        radioButton.selectByIndex(number);
    }
}
