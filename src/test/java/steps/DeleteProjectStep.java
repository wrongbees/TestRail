package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardProjectsPage;

public class DeleteProjectStep extends BaseStep {

    public DeleteProjectStep(WebDriver driver, String projectName) {
        super(driver);

    }

    public void deleteProject(String projectName) throws InterruptedException {
        DashboardProjectsPage dashboardPage = new DashboardProjectsPage(driver, true);
        dashboardPage.deleteAProjectByName(projectName);
        dashboardPage.clickDeleteCheckBoxAccept();
        dashboardPage.clickDeleteAcceptOk();
    }
}
