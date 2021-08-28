package steps;

import baseEntities.BaseStep;
import models.Project;
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

    public void addProject(Project project) throws InterruptedException {
        DashboardProjectsPage dashboardPage = new DashboardProjectsPage(driver, true);
        dashboardPage.clickButtonAddProject();

        DashboardAddProjectPage dashboardAddProjectPage = new DashboardAddProjectPage(driver, false);
        dashboardAddProjectPage.setProjectName(project.getName());

        if(project.getAnnouncement() != null){dashboardAddProjectPage.setAnnouncement(project.getAnnouncement());}

        if (project.isAnnouncement_visibility_state()) {
            dashboardAddProjectPage.mark_show_announcement();
        } else {
            dashboardAddProjectPage.unMark_show_announcement();
        }

        if(project.getSuite_mode() > 0 & project.getSuite_mode() < 4){
            dashboardAddProjectPage.check_SuiteMode(project.getSuite_mode());}

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
