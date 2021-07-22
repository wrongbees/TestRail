package steps;

import baseEntities.BaseStep;
import core.ReadProperties;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginStep extends BaseStep {

    public LoginStep(WebDriver driver) {
        super(driver);
    }

    public void login(String name, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setLoginName(name);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
    }

    public void login() throws InterruptedException {
        ReadProperties properties = new ReadProperties();
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setLoginName(properties.getUsername());
        loginPage.setPassword(properties.getPassword());
        loginPage.clickLoginButton();
    }
}
