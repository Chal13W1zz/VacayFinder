import  static spark.Spark.*;

import models.Places;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
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
        post("/places/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String placeName = request.queryParams("placeName");
            String placeLocation = request.queryParams("placeLocation");
            String placeDescription = request.queryParams("placeDescription");
            String imageUrl = request.queryParams("imageUrl");
            Places newPlace = new Places(placeName,placeLocation,placeDescription,imageUrl);
            model.put("newPlace",newPlace);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/places/new",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine() );

        get("/form", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/places",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            ArrayList<Places> allPlaces = Places.getAll();
            model.put("allPlaces",allPlaces);
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
