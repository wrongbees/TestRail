package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.*;

public class EditTestCaseStep extends BaseStep {

    public EditTestCaseStep(WebDriver driver, String title, String preconditions, String steps, String expectedResult) throws InterruptedException {
        super(driver);
        editTestCaseStep(title, preconditions, steps, expectedResult);
    }

    private void editTestCaseStep(String title,String preconditions,String steps,String expectedResult) throws InterruptedException {
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
