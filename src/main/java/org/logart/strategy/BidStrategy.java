package org.logart.strategy;

import org.apache.commons.lang3.tuple.Pair;
import org.logart.AuctionState;

public abstract class BidStrategy {

    protected AuctionState auctionState;

    public int calculateOptimalPrice() {
        return auctionState.getRemainingQuantity() /
                (auctionState.getOtherRemainingCash() + auctionState.getOwnRemainingCash());
    }

    public int calculateOtherOptimalPrice() {
        int otherRemainingToWin = auctionState.getCountToWin() - auctionState.getOtherQuantity();
        if (otherRemainingToWin == 0) {
            return 0;
        } else {
            return (2 * auctionState.getOtherRemainingCash()) / (otherRemainingToWin);
        }
    }

    public int calculateOwnOptimalPrice() {
        int ownRemainingToWin = auctionState.getCountToWin() - auctionState.getOwnQuantity();
        if (ownRemainingToWin == 0) {
            return 0;
        } else {
            return (2 * auctionState.getOwnRemainingCash()) / ownRemainingToWin;
        }
    }

    public abstract int calculateOptimalBid(Pair<Integer, Integer> previousBid);
}
