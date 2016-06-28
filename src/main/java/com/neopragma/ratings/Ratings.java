package com.neopragma.ratings;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;

public class Ratings {

    private Map<Integer, Integer> range;

    public Ratings() {
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

    public List<Player> adjust(List<Player> winnerAndLoser) {
        Player winner = winnerAndLoser.get(0);
        Player loser = winnerAndLoser.get(1);
        int adjustment = setAdjustment(winner.getRatingValue() - loser.getRatingValue());
        winner.setRatingValue(winner.getRatingValue() + adjustment);
        if (adjustment > loser.getRatingValue()) {
            adjustment = loser.getRatingValue();
        }
        loser.setRatingValue(loser.getRatingValue() - adjustment);
        return winnerAndLoser;
    }

    private int setAdjustment(int ratingDifference) {
        for (Integer key : range.keySet()) {
            if ( ratingDifference <= key ) {
                return range.get(key);
            }
        }
        return 0;
    }
}
