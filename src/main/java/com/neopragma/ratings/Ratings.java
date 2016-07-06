package com.neopragma.ratings;

import java.util.List;
import java.util.Map;

/**
 * This class is responsible for calculating ratings based on match results.
 */
public class Ratings {

    /**
     * The ranges of differences in player ratings that determine how many
     * points to add to or subtract from the players' ratings after a match.
     */
    private Map<Integer, Integer> ranges;

    /**
     * Instantiates a valid Ratings object.
     * @param ranges - list of range upper bounds and adjustment points.
     */
    public Ratings(final Map ranges) {
        this.ranges = ranges;
    }

    /**
     * Adjust the winner's rating upward and the loser's rating downward
     * according to rules based on which player was originally rated higher
     * than the other, and by how much.
     * @param winnerAndLoser - the winner first and the loser second, with
     * their ratings as of the start of the match.
     * @return List&lt;Player&gt; - the winner first and the loser second, with the
     * adjusted ratings.
     */
    public final List<Player> adjust(final List<Player> winnerAndLoser) {
        Player winner = winnerAndLoser.get(0);
        Player loser = winnerAndLoser.get(1);
        int adjustment =
            setAdjustment(winner.getRatingValue() - loser.getRatingValue());
        winner.setRatingValue(winner.getRatingValue() + adjustment);
        if (adjustment > loser.getRatingValue()) {
            adjustment = loser.getRatingValue();
        }
        loser.setRatingValue(loser.getRatingValue() - adjustment);
        return winnerAndLoser;
    }

    /**
     * Determine the correct adjustment based on the difference in player
     * ratings and which player won the match.
     * @param ratingDifference - the difference in the players' ratings
     * at the start of the match.
     * @return the adjustment to be made to each player's rating.
     */
    private int setAdjustment(final int ratingDifference) {
        for (Integer key : ranges.keySet()) {
            if (ratingDifference <= key) {
                return ranges.get(key);
            }
        }
        return 0;
    }
}
