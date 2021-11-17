import  static spark.Spark.*;

import dao.Sql2oPlacesDao;
import dao.Sql2oReviewsDao;
import models.Places;
import models.Reviews;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.List;
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
            model.put("places",placeDao.getAllPlaces());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //new place form
        get("/places/new",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model, "place-form.hbs");
        }, new HandlebarsTemplateEngine() );

        //process new place
        post("/places/process",(request, response)->{
            String placeName = request.queryParams("placeName");
            String placeLocation = request.queryParams("placeLocation");
            String imageUrl = request.queryParams("imageUrl");
            String placeDescription = request.queryParams("placeDescription");
            Places newPlace = new Places(placeName,placeLocation,placeDescription,imageUrl);
            placeDao.addPlace(newPlace);
            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());

        //get review form
        get("/review/new",(request, response)->{
            Map<String, Object>model = new HashMap<>();
            return new ModelAndView(model, "review-form.hbs");
        }, new HandlebarsTemplateEngine());

        //process review form
        post("/places/process",(request, response)->{
            int rating = Integer.parseInt(request.queryParams("rating"));
            //To Do - add fields
//            Reviews newReview = new Reviews();
//            reviewDao.addReview(newReview);
//            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());

        //get a specifc place details
        get("/places/:id",(request, response)->{
            Map<String, Object>model = new HashMap<>();
            int placeId = Integer.parseInt(request.params("id"));
            Places foundPlace = placeDao.getPlaceById(placeId);
            model.put("selectedPlace",foundPlace);
            List<Reviews> reviewsByPlace =  placeDao.getReviewsByPlace(placeId);
            model.put("reviews",reviewsByPlace);
            return new ModelAndView(model, "place-details.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
