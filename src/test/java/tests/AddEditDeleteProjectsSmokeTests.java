package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardProjectsPage;
import steps.AddProjectStep;
import steps.DeleteProjectStep;
import steps.EditProjectNameStep;
import steps.LoginStep;

public class AddEditDeleteProjectsSmokeTests extends BaseTest {

    @Test(invocationCount = 3)
    public void positiveAddProjectTest() throws InterruptedException {
        String projectName = "Lsn10_Vladimir";

        new LoginStep(driver);

        new AddProjectStep(driver,projectName);

        DashboardProjectsPage dashboardProjectsPage = new DashboardProjectsPage(driver, false);
        Assert.assertTrue(dashboardProjectsPage.aProjectByName(projectName).isDisplayed()
                , "Добавление проекта прошло не корректно.");

    }

    @Test(dependsOnMethods = "positiveEditProjectTest",expectedExceptions = NoSuchElementException.class,
    invocationCount = 3, enabled = false)
    public void positiveDeleteProjectTest() throws InterruptedException {
        String projectName = "Lesson10_Privet_06onl";
        new LoginStep(driver);
        new DeleteProjectStep(driver,projectName);

        DashboardProjectsPage dashboardProjectsPage = new DashboardProjectsPage(driver, false);
        Assert.assertFalse(dashboardProjectsPage.aProjectByName(projectName).isDisplayed()
                , "Удаление проекта не произошло.");

   }

    @Test(dependsOnMethods = "positiveAddProjectTest", invocationCount = 3, enabled = true )
    public void positiveEditProjectTest() throws InterruptedException {
        String projectName = "Lsn10_Vladimir";
        String newProjectName = "Lesson10_Privet_06onl";
        new LoginStep(driver);
       new EditProjectNameStep(driver, projectName, newProjectName);

        DashboardProjectsPage dashboardProjectsPage = new DashboardProjectsPage(driver, false);
        Assert.assertTrue(dashboardProjectsPage.aProjectByName(newProjectName).isDisplayed()
                , "Редактирование имени проекта прошло не корректно.");

    }


}
