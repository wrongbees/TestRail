package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private final static String endpoint ="/index.php?/auth/login";

    private final static By loginpage_installationname = By.className("loginpage-installationname");
    private final static By name_by = By.id("name");
    private final static By password_by = By.id("password");
    private final static By button_login_by = By.id("button_primary");



    public LoginPage(WebDriver driver, boolean openPageByUrl) throws InterruptedException {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL());


    }

    @Override
    public boolean isPageOpened()  {
        try {
            return getLoginPageInstallationName().isDisplayed();
        } catch (NoSuchElementException ex){
            return  false;
        }
    }

    public WebElement getLoginPageInstallationName(){ return driver.findElement(loginpage_installationname);}

    public WebElement getNameField(){ return driver.findElement(name_by);}

    public WebElement getPasswordField(){ return driver.findElement(password_by);}

    public WebElement getLoginButton(){ return driver.findElement(button_login_by);}

    public void setLoginName(String name){
        getNameField().sendKeys(name);
    }

    public void setPassword(String password){
        getPasswordField().sendKeys(password);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

}
