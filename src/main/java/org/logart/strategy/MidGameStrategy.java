package org.logart.strategy;

import org.apache.commons.lang3.tuple.Pair;
import org.logart.AuctionState;

/**
 * This strategy main purpose is to be on the same page with the competitor to not lose any more bids.
 */
public class MidGameStrategy extends BidStrategy {
    public MidGameStrategy(AuctionState auctionState) {
        this.auctionState = auctionState;
    }

    @Override
    public int calculateOptimalBid(Pair<Integer, Integer> previousBid) {
        int competitorPreviousBid = previousBid.getRight();
        int ownOptimalPrice = calculateOwnOptimalPrice();
        int optimalBid;
        if (competitorPreviousBid > ownOptimalPrice) {
            optimalBid = competitorPreviousBid;
        } else {
            optimalBid = ownOptimalPrice + 1;
        }

        return optimalBid;
    }
}
