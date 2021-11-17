import  static spark.Spark.*;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.Map;
import java.util.HashMap;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");

        //get and display index page
        get("/",(request, response)->{
            Map<String, Object>model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/places/new",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model, "place-form.hbs");
        }, new HandlebarsTemplateEngine() );

        get("/places/new",(request, response)->{
            Map<String, Object>model = new HashMap<>();
            return new ModelAndView(model, "review-form.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
