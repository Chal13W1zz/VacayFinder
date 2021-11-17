import  static spark.Spark.*;

import dao.Sql2oPlacesDao;
import dao.Sql2oReviewsDao;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.Map;
import java.util.HashMap;

public class App {

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        String connectionString = "jdbc:postgresql://ec2-54-146-82-179.compute-1.amazonaws.com:5432/d8k5b9n8qelpe6?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
        Sql2o sql2o = new Sql2o(connectionString,"unqlgrdrsuhcnd","e9168f3235c5131b486032499a7b43f27a202671e120f96c560093c2583fb1a0");
        Sql2oPlacesDao placeDao = new Sql2oPlacesDao(sql2o);
        Sql2oReviewsDao  reviewDao = new Sql2oReviewsDao(sql2o);

        //get and display index page
        get("/",(request, response)->{
            Map<String, Object>model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());



    }
}
