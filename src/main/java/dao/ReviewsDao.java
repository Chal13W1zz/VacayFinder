package dao;

import models.Reviews;

import java.util.List;

public interface ReviewsDao {
    //Create
    void addReview(Reviews review);

    //Read
    List<Reviews> getAllReviews();
    Reviews getReviewById(int id);

    //Update

    //Delete
    void deleteAllReviews();
    void deleteReviewById(int id);

}
