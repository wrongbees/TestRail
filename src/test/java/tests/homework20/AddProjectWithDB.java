package tests.homework20;

import adapters.ProjectsAdapter;
import baseEntities.BaseApiTest;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.Add_Delete_Search_ProjectStep;
import steps.LoginStep;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddProjectWithDB extends BaseApiTest {

    @Test
    public void addProjectWithDbTest() throws SQLException, InterruptedException {
        logger.info("Test is started....");

        /**
         * Подготовка трех проектов с последующим добавлением их в postgres.
         */
        for (int i = 1; i < 4; i++) {
            Project project = Project.builder()
                    .name(String.format("Project_Lesson_20_№0%d", i))
                    .announcement("I don_t have time to do my homework")
                    .announcement_visibility_state(true)
                    .suite_mode(i)
                    .build();

            projectsTableAdapter.addProject(project);
        }

        /**
         * Создаем проекты с помощью UI в TestRail...
         */

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login();
        Add_Delete_Search_ProjectStep add_delete_search_projectStep = new Add_Delete_Search_ProjectStep(driver);

        ResultSet rs = projectsTableAdapter.getAllProjects();

        while (rs.next()) {
            Project projectForAdd = Project.builder().build();
            projectForAdd.setName(rs.getString("project_name"));
            projectForAdd.setAnnouncement(rs.getString("announcement"));
            projectForAdd.setAnnouncement_visibility_state(Boolean.parseBoolean(rs.getString("announcement_visibility_state")));
            projectForAdd.setSuite_mode(Integer.parseInt(rs.getString("suite_mode")));

            add_delete_search_projectStep.addProject(projectForAdd);
        }

        /**
         * Api запрос на извлечение всех проектов TestRail...
         * Проекты будут хранится в List<Project> projectList...
         * Проверка будет осуществляться путем поиска проектов из ResultSet rs в projectList.
         * Из проектов которые совпали с проектами из projectList составили foundProjectsList
         */

        List<Project> foundProjectsList = new ArrayList<>();

        rs = projectsTableAdapter.getAllProjects();
        while (rs.next()) {
            List<Project> projectList = new ProjectsAdapter().get();

            for (Project project : projectList) {
                if (rs.getString("project_name").equals(project.getName())) {
                    foundProjectsList.add(project);
                }
            }
        }

        /**
         * По названиям проектов из foundProjectsList находим проекты
         * в postgres  и сравниваем поля project_name,announcement, suite_mode
         */
        for (Project project : foundProjectsList) {
            rs = projectsTableAdapter.getProjectByName(project.getName());
            while (rs.next()) {

                Assert.assertEquals(project.getName(), rs.getString("project_name"));
                Assert.assertEquals(project.getAnnouncement(), rs.getString("announcement"));
                Assert.assertEquals(project.getSuite_mode(), Integer.parseInt(rs.getString("suite_mode")));
            }
        }

        logger.info("Test is finished....");


    }
}
