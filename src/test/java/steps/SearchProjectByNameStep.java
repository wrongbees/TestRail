package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;

public class SearchProjectByNameStep extends BaseStep {
    private String projectName;
    public SearchProjectByNameStep(WebDriver driver, String projectName) throws InterruptedException {
        super(driver);
        this.projectName = projectName;
        searchProjectByName();
    }
    private void searchProjectByName() throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage(driver,true);
        dashboardPage.chooseAProjectByName(projectName);
    }
}
