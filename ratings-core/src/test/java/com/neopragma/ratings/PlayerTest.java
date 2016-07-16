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
public class PlayerTest {

    private @Mock Name name;
    private @Mock Rating rating;
    private Player player;

    @Before
    public void beforeEachExample() {
        player = new Player(name, rating);
        when(name.getFullName()).thenReturn("testname");
        when(rating.getValue()).thenReturn(1000);
    }

    @Test
    public void itSetsThePlayerName() {
        assertEquals("testname", player.getName().getFullName());
    }

    @Test
    public void itReturnsTheRatingValueAsAnInt() {
        assertEquals(1000, player.getRatingValue());
    }

    @Test
    public void itSetsTheRatingValue() {
        player.setRatingValue(500);
        verify(rating, times(1)).setValue(500);
    }


}
