package baseEntities;

import models.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.DataBaseServices;

import java.sql.ResultSet;

public class ProjectsTableAdapter {
    DataBaseServices dbServices;

    Logger logger = LoggerFactory.getLogger(ProjectsTableAdapter.class);

    public ProjectsTableAdapter(DataBaseServices dbServices) {
        this.dbServices = dbServices;
    }


        public ResultSet getAllProjects(){
        String sql = "SELECT * FROM public.projects;";

        return dbServices.executeQuery(sql);
    }

    public ResultSet getProjectByName(String name) {
        String sql = String.format("SELECT id, project_name, announcement, announcement_visibility_state, suite_mode " +
                "FROM public.projects " +
                "WHERE project_name = '%s';",name);
        logger.info(sql);

       return dbServices.executeQuery(sql);
    }

    public boolean addProject(Project project) {

        String insertSQL = String.format("INSERT INTO public.projects(" +
                        "project_name, announcement_visibility_state, announcement, suite_mode)" +
                        "VALUES ('%s', '%s', '%s', '%s');", project.getName(), project.isAnnouncement_visibility_state(),
                project.getAnnouncement(), project.getSuite_mode());

         logger.info(insertSQL);

        return dbServices.executeSQL(insertSQL);
    }

    public boolean createTable() {

        String createTableSQL = "CREATE TABLE projects (" +
                "id SERIAL PRIMARY KEY, " +
                "project_name CHARACTER VARYING(50), " +
                "announcement_visibility_state BOOLEAN," +
                "announcement CHARACTER VARYING(500), " +//
                "suite_mode INTEGER" +
                ");";

        return dbServices.executeSQL(createTableSQL);
    }

    public boolean dropTable() {
        String dropTableSQL = "DROP TABLE projects;";
        return dbServices.executeSQL(dropTableSQL);
    }
}
