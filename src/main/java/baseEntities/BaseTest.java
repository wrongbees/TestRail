package baseEntities;

import core.BrowserService;
import core.ReadProperties;
import org.testng.annotations.Listeners;
import utils.Listener;
import utils.Waits;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
@Listeners(Listener.class)
public class BaseTest {
    protected  BrowserService browserService;
    public WebDriver driver;
    protected ReadProperties properties;
    protected Waits wait;


    @BeforeTest
    public void setupTest(){
        properties =ReadProperties.getInstance();
    }


    @BeforeMethod
    public void setupMethod(){
         browserService = new BrowserService();
        driver = browserService.getDriver();
        wait = browserService.getWait();
    }


     @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }


}
