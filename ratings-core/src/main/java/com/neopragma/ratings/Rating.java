package com.neopragma.ratings;

/**
 * Domain concept "Rating" encapsulates a player rating and ensures it cannot
 * have an invalid value.
 */
public class Rating {

    private Integer value;

    /**
     * @param value - the new value of the rating.
     */
    public Rating(final Integer value) {
        setValue(value);
    }

    /**
     * @return current rating value.
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Guarantees the value that is set will be valid.
     * @param value - the proposed value to be set.
     */
    public void setValue(final Integer value) {
        if (value < 0) {
            throw new RuntimeException("Rating can't be less than zero.");
        }
        this.value = value;
    }

}
