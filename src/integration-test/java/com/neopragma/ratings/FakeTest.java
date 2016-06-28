package com.neopragma.ratings;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(IntegrationTest.class)
public class FakeTest {

    @Test
    public void shouldRunOnlyInMavenIntegrationTestPhase() {
        System.out.println("FakeTest is running.");
        assertTrue(true);
    }
}
