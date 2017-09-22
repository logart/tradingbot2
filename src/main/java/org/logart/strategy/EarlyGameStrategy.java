package org.logart.strategy;

import org.apache.commons.lang3.tuple.Pair;
import org.logart.AuctionState;

/**
 * This strategy tries to save as much money as it could and also make competitor to maximize his loss;
 * But also this strategy wants to buy if the price is optimal (remaining quantity/remaining money).
 */
public class EarlyGameStrategy extends BidStrategy {

    public EarlyGameStrategy(AuctionState auctionState) {
        this.auctionState = auctionState;
    }

    @Override
    public int calculateOptimalBid(Pair<Integer, Integer> previousBid) {

        int competitorPreviousBid = previousBid.getRight();
        int otherOptimalPrice = calculateOtherOptimalPrice();
        int optimalBid;
        if (competitorPreviousBid > otherOptimalPrice) {
            optimalBid = Math.random() < 0.5 ?
                    otherOptimalPrice / 2 : otherOptimalPrice - 1;
        } else {
            optimalBid = competitorPreviousBid + 1;
        }

        if (optimalBid < 0) {
            optimalBid = 0;
        }

        return optimalBid;
    }
}
