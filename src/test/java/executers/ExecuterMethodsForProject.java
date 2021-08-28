package executers;

import baseEntities.BaseApiTest;
import models.Project;
import org.openqa.selenium.WebDriver;
import steps.Add_Delete_Search_ProjectStep;
import steps.LoginStep;



public class ExecuterMethodsForProject {
WebDriver driver;

    public ExecuterMethodsForProject(WebDriver driver) {
        this.driver = driver;
    }

    public void addProject(Project project) throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login();

        Add_Delete_Search_ProjectStep add_delete_search_projectStep = new Add_Delete_Search_ProjectStep(driver);

        add_delete_search_projectStep.addProject(project);

    }
}
