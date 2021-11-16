package dao;

import models.Places;
import models.Reviews;

import java.util.List;

public interface PlacesDao {

    //Create
    void addPlace(Places place);

    //Read
    List<Places> getAllPlaces();
    Places getPlaceById(int id);
    List<Reviews> getReviewsByPlace(int placeId);

    //Update

    //Delete
    void deleteAllPlaces();
    void deletePlaceById(int id);
}
