package org.logart.strategy;

import org.apache.commons.lang3.tuple.Pair;

/**
 * This strategy will buy the rest off the resources after competitor will not have any money
 * by the minimal price.
 */
public class LateGameStrategy extends BidStrategy {
    @Override
    public int calculateOptimalBid(Pair<Integer, Integer> previousBid) {
        return 1;
    }
}
