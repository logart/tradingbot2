package org.logart.strategy;

import org.apache.commons.lang3.tuple.Pair;

/**
 * Strategy that bids zero. Used for first trade.
 */
public class ZeroGameStrategy extends BidStrategy{

    @Override
    public int calculateOptimalBid(Pair<Integer, Integer> previousBid) {
        return 0;
    }
}
