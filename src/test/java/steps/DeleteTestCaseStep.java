package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.EditTestCasePage;
import pages.ProjectPage;
import pages.TestCasesPage;
import pages.TestCasesProjectPage;

public class DeleteTestCaseStep extends BaseStep {

    public DeleteTestCaseStep(WebDriver driver, String title) throws InterruptedException {
        super(driver);
        deleteTestCaseStep(title);
    }

    private void deleteTestCaseStep(String title) throws InterruptedException {
        ProjectPage project_Page = new ProjectPage(driver, false);
        project_Page.clickButtonTestCases();
        TestCasesProjectPage testCasesPage = new TestCasesProjectPage(driver, false);
        testCasesPage.clickCheckForDelete(title);
        testCasesPage.clickButtonDelete();
        testCasesPage.clickMarkAsDeleted();


    }
}
