package baseEntities;

import core.BrowserService;
import core.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import services.DataBaseServices;
import utils.Listener;

import static io.restassured.RestAssured.given;

//@Listeners(Listener.class)
public class BaseApiTest {

    public static Logger logger = LoggerFactory.getLogger(BaseApiTest.class);
    public DataBaseServices dbService;
    public WebDriver driver;
    protected ReadProperties properties;
    protected ProjectsTableAdapter projectsTableAdapter;

    @BeforeSuite
    public void prepareDate() {
        dbService = new DataBaseServices();

        projectsTableAdapter = new ProjectsTableAdapter(dbService);
        projectsTableAdapter.dropTable();
        projectsTableAdapter.createTable();

    }

    @BeforeTest
    public void setup() {
        RestAssured.baseURI = "https://aqa06onl07.testrail.io/";

        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)

                .auth().preemptive().basic(
                        ReadProperties.getInstance().getUsername(),
                        ReadProperties.getInstance().getPassword());

        // dbService = new DataBaseServices();
        //properties = ReadProperties.getInstance();
        driver = new BrowserService().getDriver();
    }

    @AfterTest
    public void tearDown() {
        dbService.closeConnection();
        driver.quit();
    }

}

