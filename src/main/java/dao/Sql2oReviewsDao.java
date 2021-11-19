package dao;

import models.Reviews;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;

public class Sql2oReviewsDao implements ReviewsDao{

    private final Sql2o sql2o;

    public Sql2oReviewsDao(Sql2o sql2o) {
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
    public void addReview(Reviews review) {
        getDrivers();
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO ratings (rating, placeId, reviewer, reviewerLocation, reviewMessage, createdAt) VALUES  (:rating, :placeId, :reviewer, :reviewerLocation, :reviewMessage, now())";
            int id = (int) conn.createQuery(sql, true)
                    .bind(review)
                    .executeUpdate()
                    .getKey();
            review.setId(id);
        }catch(Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public List<Reviews> getAllReviews() {
        getDrivers();
        try(Connection conn = sql2o.open()){
            String sql = "SELECT * FROM reviews";
            return conn.createQuery(sql)
                    .executeAndFetch(Reviews.class);
        }
    }

    @Override
    public Reviews getReviewById(int id) {
        getDrivers();
        try(Connection conn = sql2o.open()){
            String sql = "SELECT * FROM reviews WHERE id = :id";
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Reviews.class);
        }
    }

    @Override
    public void deleteAllReviews() {
        getDrivers();
        try(Connection conn = sql2o.open()){
            String sql = "DELETE FROM reviews *";
            conn.createQuery(sql)
                    .executeUpdate();
        }catch(Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public void deleteReviewById(int id) {
        getDrivers();
        try(Connection conn = sql2o.open()){
            String sql = "DELETE FROM reviews WHERE id = :id";
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }
}
