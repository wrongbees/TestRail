package steps;


import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardEditProjectPage;
import pages.DashboardProjectsPage;

public class EditProjectNameStep extends BaseStep {

    public EditProjectNameStep(WebDriver driver, String projectName, String newProjectName) throws InterruptedException {
        super(driver);

       editProject(projectName, newProjectName);
    }

    private void editProject(String projectName, String newProjectName) throws InterruptedException {

        DashboardProjectsPage dashboardPage = new DashboardProjectsPage(driver, true);
        dashboardPage.chooseAProjectByName(projectName);

        DashboardEditProjectPage dashboardEditProjectPage = new DashboardEditProjectPage(driver, false);
        dashboardEditProjectPage.setEditName(newProjectName);
        dashboardEditProjectPage.clickButtonSaveProject();

    }


}
