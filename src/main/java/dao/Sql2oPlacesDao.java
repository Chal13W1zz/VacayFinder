package dao;

import models.Places;
import models.Reviews;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oPlacesDao implements PlacesDao{
    private final Sql2o sql2o;

    public Sql2oPlacesDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public static void getDrivers(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addPlace(Places place) {
        getDrivers();
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO places (placeName, placeLocation, placeDescription, imageUrl) VALUES (:placeName, :placeLocation, :placeDescription, :imageUrl)";
            int id = (int) conn.createQuery(sql, true)
                    .bind(place)
                    .executeUpdate()
                    .getKey();
            place.setId(id);
        }catch(Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public List<Places> getAllPlaces() {
        getDrivers();
        try(Connection conn = sql2o.open()){
            String sql = "SELECT * FROM places";
            return conn.createQuery(sql)
                    .executeAndFetch(Places.class);
        }
    }

    @Override
    public Places getPlaceById(int id) {
        getDrivers();
        try(Connection conn = sql2o.open()){
            String sql = "SELECT * FROM places WHERE id = :id";
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Places.class);
        }
    }

    @Override
    public List<Reviews> getReviewsByPlace(int id) {
        getDrivers();
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM reviews WHERE id = :id")
                    .addParameter("id",id)
                    .executeAndFetch(Reviews.class);
        }
    }

    @Override
    public void deleteAllPlaces() {
        getDrivers();
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM places *")
                    .executeUpdate();
        }catch(Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public void deletePlaceById(int id) {
        getDrivers();
        try(Connection conn = sql2o.open()){
            String sql = "DELETE FROM places WHERE id = :id";
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Sql2oException e){
            System.out.println(e);
        }
    }
}
