package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.AddTestCasePage;
import pages.ProjectPage;
import pages.TestCasesProjectPage;

public class AddTestCaseStep extends BaseStep {

    public AddTestCaseStep(WebDriver driver,String title,String preconditions,String steps,String expectedResult) throws InterruptedException {
        super(driver);
        addTestCaseStep(title, preconditions, steps, expectedResult);
    }

    private void addTestCaseStep(String title,String preconditions,String steps,String expectedResult) throws InterruptedException {
        ProjectPage projectPage = new ProjectPage(driver,false);
        projectPage.clickButtonTestCases();

        TestCasesProjectPage testCasesProjectPage = new TestCasesProjectPage(driver, false);
        testCasesProjectPage.clickButtonAddTestCases();
        AddTestCasePage addTestCasePage = new AddTestCasePage(driver,false);
        addTestCasePage.setTitle(title);
        addTestCasePage.setPreconditions(preconditions);
        addTestCasePage.setSteps(steps);
        addTestCasePage.setExpected(expectedResult);
        addTestCasePage.clickAddTestCaseAccept();
    }
}
