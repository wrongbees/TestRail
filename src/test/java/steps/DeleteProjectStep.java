package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardProjectsPage;

public class DeleteProjectStep extends BaseStep {

    public DeleteProjectStep(WebDriver driver, String projectName) throws InterruptedException {
        super(driver);
        deleteProject(projectName);
    }

    private void deleteProject(String projectName) throws InterruptedException {
        DashboardProjectsPage dashboardPage = new DashboardProjectsPage(driver, true);
        dashboardPage.deleteAProjectByName(projectName);
        dashboardPage.clickDeleteCheckBoxAccept();
        dashboardPage.clickDeleteAcceptOk();
    }
}
