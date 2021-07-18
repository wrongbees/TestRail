package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardAddProjectPage;
import pages.DashboardPage;
import pages.DashboardProjectsPage;

public class Add_Delete_Search_ProjectStep extends BaseStep {
    public Add_Delete_Search_ProjectStep(WebDriver driver)  {
        super(driver);
    }

    public void addProject(String projectName) throws InterruptedException {
        DashboardProjectsPage dashboardPage = new DashboardProjectsPage(driver, true);
        dashboardPage.clickButtonAddProject();

        DashboardAddProjectPage dashboardAddProjectPage = new DashboardAddProjectPage(driver, false);
        dashboardAddProjectPage.setProjectName(projectName);
        dashboardAddProjectPage.clickAddProjectAcceptButton();

    }
    public void deleteProject(String projectName) throws InterruptedException {
        DashboardProjectsPage dashboardPage = new DashboardProjectsPage(driver, true);
        dashboardPage.deleteAProjectByName(projectName);
        dashboardPage.clickDeleteCheckBoxAccept();
        dashboardPage.clickDeleteAcceptOk();
    }

    public void searchProjectByName( String projectName) throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage(driver,true);
        dashboardPage.chooseAProjectByName(projectName);
    }


}
