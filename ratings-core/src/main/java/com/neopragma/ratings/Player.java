package com.neopragma.ratings;

/**
 * Domain concept "Player" represents a person who competes in the sport and
 * participates in the rating system.
 */
public class Player {

    private Name name;
    private Rating rating;

    /**
     * @param name - the player's name.
     * @param rating - the player's rating.
     */
    public Player(final Name name, final Rating rating) {
        this.name = name;
        this.rating = rating;
    }

    public Name getName() {
        return name;
    }

    public Rating getRating() {
        return rating;
    }

    /**
     * @param rating - the new rating to be set.
     */
    public void setRating(final Rating rating) {
        this.rating = rating;
    }

    /**
     * Convenience method to return the raw value of the rating.
     * @return the rating value as an int.
     */
    public int getRatingValue() {
        return rating.getValue().intValue();
    }

    /**
     * @param value - the new rating to be set.
     */
    public final void setRatingValue(final int value) {
        rating.setValue(value);
    }

}
