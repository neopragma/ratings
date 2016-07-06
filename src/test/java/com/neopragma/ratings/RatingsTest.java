package com.neopragma.ratings;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

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
public class RatingsTest {

    private static final int PLAYER_1 = 0;
    private static final int PLAYER_2 = 1;
    private static TreeMap<Integer, Integer> range;

    @Mock private Name anyName;
    private Ratings ratings;

    @BeforeClass
    public static void beforeAllExamples() {
        range = new TreeMap<Integer, Integer>();
        range.put(20, 0);
        range.put(19, 1);
        range.put(9, 2);
        range.put(3, 3);
        range.put(0, 4);
        range.put(-1, 5);
        range.put(-4, 6);
        range.put(-10, 7);
        range.put(-20, 8);
        range.put(-30, 9);
        range.put(-40, 10);
        range.put(-50, 12);
    }

    @Before
    public void beforeEachExample() {
        ratings = new Ratings(range);
    }

    @Test
    public void whenPlayersAreEqual_winnerGains_4() {
        assertNewRatingOf(PLAYER_1, 1004, ratings.adjust(setUpPlayers(1000, 1000)));
    }

    @Test
    public void whenPlayersAreEqual_loserDrops_4() {
        assertNewRatingOf(PLAYER_2, 996, ratings.adjust(setUpPlayers(1000, 1000)));
    }

    @Test
    public void whenWinnerWasHigherBy_1_winnerGains_3() {
        assertNewRatingOf(PLAYER_1, 823, ratings.adjust(setUpPlayers(820, 819)));
    }

    @Test
    public void whenWinnerWasHigherBy_1_loserDrops_3() {
        assertNewRatingOf(PLAYER_2, 816, ratings.adjust(setUpPlayers(820, 819)));
    }

    @Test
    public void whenWinnerWasHigherBy_3_winnerGains_3() {
        assertNewRatingOf(PLAYER_1, 3419, ratings.adjust(setUpPlayers(3416, 3413)));
    }

    @Test
    public void whenWinnerWasHigherBy_3_loserDrops_3() {
        assertNewRatingOf(PLAYER_2, 3410, ratings.adjust(setUpPlayers(3416, 3413)));
    }

    @Test
    public void whenWinnerWasHigherBy_4_winnerGains_2() {
        assertNewRatingOf(PLAYER_1, 1108, ratings.adjust(setUpPlayers(1106, 1102)));
    }

    @Test
    public void whenWinnerWasHigherBy_4_loserDrops_2() {
        assertNewRatingOf(PLAYER_2, 1100, ratings.adjust(setUpPlayers(1106, 1102)));
    }

    @Test
    public void whenWinnerWasHigherBy_9_winnerGains_2() {
        assertNewRatingOf(PLAYER_1, 480, ratings.adjust(setUpPlayers(478, 469)));
    }

    @Test
    public void whenWinnerWasHigherBy_9_loserDrops_2() {
        assertNewRatingOf(PLAYER_2, 467, ratings.adjust(setUpPlayers(478, 469)));
    }

    @Test
    public void whenWinnerWasHigherBy_10_winnerGains_1() {
        assertNewRatingOf(PLAYER_1, 500, ratings.adjust(setUpPlayers(499, 489)));
    }

    @Test
    public void whenWinnerWasHigherBy_10_loserDrops_1() {
        assertNewRatingOf(PLAYER_2, 488, ratings.adjust(setUpPlayers(499, 489)));
    }

    @Test
    public void whenWinnerWasHigherBy_19_winnerGains_1() {
        assertNewRatingOf(PLAYER_1, 520, ratings.adjust(setUpPlayers(519, 500)));
    }

    @Test
    public void whenWinnerWasHigherBy_19_loserDrops_1() {
        assertNewRatingOf(PLAYER_2, 499, ratings.adjust(setUpPlayers(519, 500)));
    }

    @Test
    public void whenWinnerWasLowerBy_1_winnerGains_5() {
        assertNewRatingOf(PLAYER_1, 505, ratings.adjust(setUpPlayers(500, 501)));
    }

    @Test
    public void whenWinnerWasLowerBy_1_loserDrops_5() {
        assertNewRatingOf(PLAYER_2, 496, ratings.adjust(setUpPlayers(500, 501)));
    }

    @Test
    public void whenWinnerWasLowerBy_3_winnerGains_5() {
        assertNewRatingOf(PLAYER_1, 505, ratings.adjust(setUpPlayers(500, 503)));
    }

    @Test
    public void whenWinnerWasLowerBy_3_loserDrops_5() {
        assertNewRatingOf(PLAYER_2, 498, ratings.adjust(setUpPlayers(500, 503)));
    }

    @Test
    public void whenWinnerWasLowerBy_4_winnerGains_6() {
        assertNewRatingOf(PLAYER_1, 506, ratings.adjust(setUpPlayers(500, 504)));
    }

    @Test
    public void whenWinnerWasLowerBy_4_loserDrops_6() {
        assertNewRatingOf(PLAYER_2, 498, ratings.adjust(setUpPlayers(500, 504)));
    }

    @Test
    public void whenWinnerWasLowerBy_9_winnerGains_6() {
        assertNewRatingOf(PLAYER_1, 506, ratings.adjust(setUpPlayers(500, 509)));
    }

    @Test
    public void whenWinnerWasLowerBy_9_loserDrops_6() {
        assertNewRatingOf(PLAYER_2, 503, ratings.adjust(setUpPlayers(500, 509)));
    }

    @Test
    public void whenWinnerWasLowerBy_10_winnerGains_7() {
        assertNewRatingOf(PLAYER_1, 507, ratings.adjust(setUpPlayers(500, 510)));
    }

    @Test
    public void whenWinnerWasLowerBy_10_loserDrops_7() {
        assertNewRatingOf(PLAYER_2, 503, ratings.adjust(setUpPlayers(500, 510)));
    }

    @Test
    public void whenWinnerWasLowerBy_19_winnerGains_7() {
        assertNewRatingOf(PLAYER_1, 507, ratings.adjust(setUpPlayers(500, 519)));
    }

    @Test
    public void whenWinnerWasLowerBy_19_loserDrops_7() {
        assertNewRatingOf(PLAYER_2, 512, ratings.adjust(setUpPlayers(500, 519)));
    }

    @Test
    public void whenWinnerWasLowerBy_20_winnerGains_8() {
        assertNewRatingOf(PLAYER_1, 508, ratings.adjust(setUpPlayers(500, 520)));
    }

    @Test
    public void whenWinnerWasLowerBy_20_loserDrops_8() {
        assertNewRatingOf(PLAYER_2, 512, ratings.adjust(setUpPlayers(500, 520)));
    }

    @Test
    public void whenWinnerWasLowerBy_29_winnerGains_8() {
        assertNewRatingOf(PLAYER_1, 508, ratings.adjust(setUpPlayers(500, 529)));
    }

    @Test
    public void whenWinnerWasLowerBy_29_loserDrops_8() {
        assertNewRatingOf(PLAYER_2, 521, ratings.adjust(setUpPlayers(500, 529)));
    }

    @Test
    public void whenWinnerWasLowerBy_30_winnerGains_9() {
        assertNewRatingOf(PLAYER_1, 509, ratings.adjust(setUpPlayers(500, 530)));
    }

    @Test
    public void whenWinnerWasLowerBy_30_loserDrops_9() {
        assertNewRatingOf(PLAYER_2, 521, ratings.adjust(setUpPlayers(500, 530)));
    }

    @Test
    public void whenWinnerWasLowerBy_39_winnerGains_9() {
        assertNewRatingOf(PLAYER_1, 509, ratings.adjust(setUpPlayers(500, 539)));
    }

    @Test
    public void whenWinnerWasLowerBy_39_loserDrops_9() {
        assertNewRatingOf(PLAYER_2, 530, ratings.adjust(setUpPlayers(500, 539)));
    }

    @Test
    public void whenWinnerWasLowerBy_40_winnerGains_10() {
        assertNewRatingOf(PLAYER_1, 510, ratings.adjust(setUpPlayers(500, 540)));
    }

    @Test
    public void whenWinnerWasLowerBy_40_loserDrops_10() {
        assertNewRatingOf(PLAYER_2, 530, ratings.adjust(setUpPlayers(500, 540)));
    }

    @Test
    public void whenWinnerWasLowerBy_49_winnerGains_10() {
        assertNewRatingOf(PLAYER_1, 510, ratings.adjust(setUpPlayers(500, 549)));
    }

    @Test
    public void whenWinnerWasLowerBy_49_loserDrops_10() {
        assertNewRatingOf(PLAYER_2, 539, ratings.adjust(setUpPlayers(500, 549)));
    }

    @Test
    public void whenWinnerWasLowerBy_50_winnerGains_12() {
        assertNewRatingOf(PLAYER_1, 512, ratings.adjust(setUpPlayers(500, 550)));
    }

    @Test
    public void whenWinnerWasLowerBy_50_loserDrops_12() {
        assertNewRatingOf(PLAYER_2, 538, ratings.adjust(setUpPlayers(500, 550)));
    }

    @Test
    public void whenWinnerWasLowerBy_1000_winnerGains_12() {
        assertNewRatingOf(PLAYER_1, 512, ratings.adjust(setUpPlayers(500, 1500)));
    }

    @Test
    public void whenWinnerWasLowerBy_1000_loserDrops_12() {
        assertNewRatingOf(PLAYER_2, 1488, ratings.adjust(setUpPlayers(500, 1500)));
    }

    @Test
    public void whenLoserWouldGoNegative_itSetsTheRatingTo_0() {
        assertNewRatingOf(PLAYER_2, 0, ratings.adjust(setUpPlayers(3, 3)));
    }

    private void assertNewRatingOf(int winner, int expectedRating, List<Player> result) {
        assertEquals(new Integer(expectedRating), result.get(winner).getRating().getValue());
    }

    private List<Player> setUpPlayers(int winnerRating, int loserRating) {
        Player winner = new Player(anyName, new Rating(winnerRating));
        Player loser = new Player(anyName, new Rating(loserRating));
        List<Player> players = new ArrayList<Player>();
        players.add(winner);
        players.add(loser);
        return players;
    }
}
