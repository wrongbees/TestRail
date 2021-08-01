package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.ProjectPage;
import pages.TestCasesProjectPage;

public class SearchTestCaseInProjectStep extends BaseStep {
    private String caseName;
    public SearchTestCaseInProjectStep(WebDriver driver, String caseName) throws InterruptedException {
        super(driver);
        this.caseName = caseName;
        searchProjectByName();
    }
    private void searchProjectByName() throws InterruptedException {
        ProjectPage project_Page = new ProjectPage(driver, false);
        project_Page.clickButtonTestCases();

        TestCasesProjectPage testCasesProjectPage = new TestCasesProjectPage(driver, false);
        testCasesProjectPage.clickTitleTestCase(caseName);
    }
}
