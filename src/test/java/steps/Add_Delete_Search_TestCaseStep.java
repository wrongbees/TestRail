package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.awt.*;

public class Add_Delete_Search_TestCaseStep extends BaseStep {

    public Add_Delete_Search_TestCaseStep(WebDriver driver) {
        super(driver);
    }

    public void choiceOfProcedureTestCases() throws InterruptedException {
        ProjectPage projectPage = new ProjectPage(driver, false);
        projectPage.clickButtonTestCases();
    }

    public void choiceOfProcedureAddTestCase() throws InterruptedException {
        TestCasesProjectPage testCasesProjectPage = new TestCasesProjectPage(driver, false);
        testCasesProjectPage.clickButtonAddTestCases();
    }

    public void addTestCaseThisParameters(String title, String preconditions, String steps, String expectedResult,String fileName) throws InterruptedException, AWTException {
        ProjectPage projectPage = new ProjectPage(driver, false);
        projectPage.clickButtonTestCases();

        TestCasesProjectPage testCasesProjectPage = new TestCasesProjectPage(driver,false);
        testCasesProjectPage.clickButtonAddTestCases();

        AddTestCasePage addTestCasePage = new AddTestCasePage(driver, false);


        addTestCasePage.setTitle(title);
        addTestCasePage.setPreconditions(preconditions);
        addTestCasePage.setSteps(steps);
        addTestCasePage.setExpected(expectedResult);

        if(fileName!=null){
            addTestCasePage.clickAddFileListEmpty();

            addTestCasePage.clickAddFileWindow();

            addTestCasePage.clickLibraryAttachmentsAddItem(fileName);
        }

        addTestCasePage.clickButtonAddTestCasesAccept();
    }
    public void acceptAddTestCase() throws InterruptedException {
        AddTestCasePage addTestCasePage = new AddTestCasePage(driver, false);
        addTestCasePage.clickButtonAddTestCasesAccept();
    }
    public void searchTestCaseByName(String caseName) throws InterruptedException {
        ProjectPage project_Page = new ProjectPage(driver, false);
        project_Page.clickButtonTestCases();

        TestCasesProjectPage testCasesProjectPage = new TestCasesProjectPage(driver, false);
        testCasesProjectPage.clickTitleTestCase(caseName);
    }

    public void editTestCaseStep(String title,String preconditions,String steps,String expectedResult) throws InterruptedException {
        TestCasesPage testCasesPage = new TestCasesPage(driver, false);
        testCasesPage.clickButtonEditTestCase();

        EditTestCasePage editTestCasePage = new EditTestCasePage(driver,false);
        editTestCasePage.setTitle(title);
        editTestCasePage.setPreconditions(preconditions);
        editTestCasePage.setSteps(steps);
        editTestCasePage.setExpected(expectedResult);
        editTestCasePage.clickSaveTestCaseAccept();
    }
}
