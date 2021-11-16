package models;

import java.sql.Timestamp;
import java.util.Objects;

public class Reviews {
    private int id;
    private int rating;
    private int placeId;
    private String reviewer;
    private String reviewerLocation;
    private String reviewMessage;
    private Timestamp createdAt;

    public Reviews(int rating, int placeId, String reviewer, String reviewerLocation, String reviewMessage, Timestamp createdAt) {
        this.rating = rating;
        this.placeId = placeId;
        this.reviewer = reviewer;
        this.reviewerLocation = reviewerLocation;
        this.reviewMessage = reviewMessage;
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reviews reviews = (Reviews) o;
        return id == reviews.id && rating == reviews.rating && placeId == reviews.placeId && Objects.equals(reviewer, reviews.reviewer) && Objects.equals(reviewerLocation, reviews.reviewerLocation) && Objects.equals(reviewMessage, reviews.reviewMessage) && Objects.equals(createdAt, reviews.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rating, placeId, reviewer, reviewerLocation, reviewMessage, createdAt);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getReviewerLocation() {
        return reviewerLocation;
    }

    public void setReviewerLocation(String reviewerLocation) {
        this.reviewerLocation = reviewerLocation;
    }

    public String getReviewMessage() {
        return reviewMessage;
    }

    public void setReviewMessage(String reviewMessage) {
        this.reviewMessage = reviewMessage;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

}

