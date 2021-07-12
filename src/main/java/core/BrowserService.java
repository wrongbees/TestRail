package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BrowserService {
    private ReadProperties properties =new ReadProperties();
    private DriverManagerType driverManagerType;
    private WebDriver driver;
    private Waits wait;

  public BrowserService() {
      switch (properties.getBrowser().toLowerCase()) {
          case  "chrome" :
              WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
              ChromeOptions chromeOptions = new ChromeOptions();
              chromeOptions.addArguments("start-maximized");
           //   chromeOptions.addArguments("window-size=1920,1200");
              chromeOptions.addArguments("disable-gpu");
              chromeOptions.setHeadless(properties.getHeadless());
              driver = new ChromeDriver(chromeOptions);
              driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
              break;
          case  "firefox" :
              WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();

              FirefoxOptions firefoxOptions = new FirefoxOptions();
              firefoxOptions.setHeadless(properties.getHeadless());

              driver = new FirefoxDriver(firefoxOptions);
              break;
          case  "ie" :
              WebDriverManager.getInstance(DriverManagerType.IEXPLORER).setup();
              driver = new InternetExplorerDriver();
              break;
          default:
              throw new AssertionError("Данный браузер не поддерживается");

      }
      wait = new Waits(driver, properties.getTimeout());
  }

    public WebDriver getDriver() {
        return driver;
    }

    public Waits getWait(){
      return  wait;
    }
}
