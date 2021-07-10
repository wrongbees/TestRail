package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardAddProjectPage;
import pages.DashboardProjectsPage;

public class AddProjectStep extends BaseStep {

    public AddProjectStep(WebDriver driver, String projectName) throws InterruptedException {
        super(driver);

        DashboardProjectsPage dashboardPage = new DashboardProjectsPage(driver, true);
        dashboardPage.clickButtonAddProject();

        DashboardAddProjectPage dashboardAddProjectPage = new DashboardAddProjectPage(driver, false);
        dashboardAddProjectPage.setProjectName(projectName);
        dashboardAddProjectPage.clickAddProjectAcceptButton();

    }

}
