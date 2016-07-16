package com.neopragma.ratings;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RatingTest {
    private Rating rating;

    @Test
    public void itAcceptsTheValue_0() {
        rating = new Rating(0);
        assertEquals(0, rating.getValue().intValue());
    }

    @Test(expected=RuntimeException.class)
    public void itThrowsWhenNegativeValueIsPassed() {
        rating = new Rating(-1);
    }

}
