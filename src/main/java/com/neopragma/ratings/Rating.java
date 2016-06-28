package com.neopragma.ratings;

public class Rating {

    private Integer value;

    public Rating(Integer value) {
        setValue(value);
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        if (value < 0) {
            throw new RuntimeException("Rating can't be less than zero.");
        }
        this.value = value;
    }

}
