package baseEntities;

import core.BrowserService;
import core.ReadProperties;
import core.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected  WebDriver driver;
    protected ReadProperties properties;
    protected Waits wait;


    @BeforeTest
    public void setupTest(){
        properties =new  ReadProperties();
    }


    @BeforeMethod
    public void setupMethod(){
        BrowserService browserService = new BrowserService();
        driver = browserService.getDriver();
        wait = browserService.getWait();
    }


     @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }


}
