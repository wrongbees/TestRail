package tests;

import baseEntities.BaseTest;
import data.StaticProvider;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProjectPage;
import pages.TestCasesProjectPage;
import steps.*;

public class AddEditDeleteCasesSmokeTests extends BaseTest {

    @Test(dataProviderClass = StaticProvider.class, dataProvider = "dataForAddTestCase")
    public void AddCaseInProject(String projectName,String title, String preconditions, String steps, String expectedResult) throws InterruptedException {

        new LoginStep(driver);

        new AddProjectStep(driver, projectName);

        new SearchProjectByNameStep(driver, projectName);

        new AddTestCaseStep(driver, title, preconditions, steps, expectedResult);

        new SearchProjectByNameStep(driver, projectName);

        ProjectPage project_Page = new ProjectPage(driver, false);
        Thread.sleep(500);// иногда без сна не прогружается элемент использующийся в следующей строке
        // но по этому элементу работает wait() в конструкторе ProjectPage. (не понимаю)
        project_Page.clickButtonTestCases();

        TestCasesProjectPage testCasesProjectPage = new TestCasesProjectPage(driver, false);
        Thread.sleep(500);// без него в 50% не прогружается искомый элемент
        Assert.assertTrue(testCasesProjectPage.getTitleTestCase(title).isDisplayed(),
                "Тест кейс не добавлен.");

    }

    @Test( dataProviderClass = StaticProvider.class, dataProvider = "dataForEditTestCase",
    dependsOnMethods = "AddCaseInProject")
    public void editCaseInProject(String projectName,String title, String new_title,
                                  String preconditions, String steps, String expectedResult) throws InterruptedException {

         new LoginStep(driver);

        new SearchProjectByNameStep(driver, projectName);

        new SearchTestCaseInProjectStep(driver,title);

        new EditTestCaseStep(driver, new_title,preconditions,steps,expectedResult);

        ProjectPage project_Page = new ProjectPage(driver, false);
        Thread.sleep(500);// иногда без сна не прогружается элемент использующийся в следующей строке
                                // но по этому элементу работает wait() в конструкторе ProjectPage. (не понимаю)
        project_Page.clickButtonTestCases();

        TestCasesProjectPage testCasesProjectPage = new TestCasesProjectPage(driver, false);
        Thread.sleep(500);// без него в 50% не прогружается искомый элемент
        Assert.assertTrue(testCasesProjectPage.getTitleTestCase(new_title).isDisplayed(),
                "Тест кейс не исправлен.");

    }

    @Test(dataProviderClass = StaticProvider.class, dataProvider = "dataForDeleteTestCase"
            ,dependsOnMethods = "editCaseInProject")
    public void deleteCaseInProject(String projectName,String title) throws InterruptedException {
        new LoginStep(driver);

        new SearchProjectByNameStep(driver, projectName);

        //new SearchTestCaseInProjectStep(driver,title);

        new DeleteTestCaseStep(driver,title);

        TestCasesProjectPage testCasesProjectPage = new TestCasesProjectPage(driver, false);
        Thread.sleep(500);

        boolean expectedResult;
        try{
            expectedResult=testCasesProjectPage.getTitleTestCase(title).isDisplayed();
        }catch (NoSuchElementException ex){
            expectedResult = false;
        }
        Assert.assertFalse(expectedResult,"Тест кейс не удален.");

    }


}
