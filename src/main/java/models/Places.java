package models;

import java.util.Objects;

public class Places {
    private String placeName;
    private String placeLocation;
    private String placeDescription;
    private String imageUrl;
    private int id;

    public Places(String placeName, String placeLocation, String placeDescription, String imageUrl) {
        this.placeName = placeName;
        this.placeLocation = placeLocation;
        this.placeDescription = placeDescription;
        this.imageUrl = imageUrl;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceLocation() {
        return placeLocation;
    }

    public void setPlaceLocation(String placeLocation) {
        this.placeLocation = placeLocation;
    }

    public String getPlaceDescription() {
        return placeDescription;
    }

    public void setPlaceDescription(String placeDescription) {
        this.placeDescription = placeDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Places)) return false;
        Places that = (Places) o;
        return id == that.id &&
                Objects.equals(placeName, that.placeName) &&
                Objects.equals(placeLocation, that.placeLocation) &&
                Objects.equals(placeDescription, that.placeDescription) &&
                Objects.equals(imageUrl, that.imageUrl);
    }
    @Override
    public int hashCode() {
        return Objects.hash(placeName, placeLocation, placeDescription, imageUrl,id);
    }
}
