package com.neopragma.ratings;

public class Player {

    private Name name;
    private Rating rating;

    public Player(Name name, Rating rating) {
        this.name = name;
        this.rating = rating;
    }

    public Name getName() {
        return name;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public int getRatingValue() {
        return rating.getValue().intValue();
    }

    public void setRatingValue(int value) {
        rating.setValue(value);
    }

}
