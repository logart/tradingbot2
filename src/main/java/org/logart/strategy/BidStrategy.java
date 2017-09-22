package org.logart.strategy;

import org.apache.commons.lang3.tuple.Pair;
import org.logart.AuctionState;

public abstract class BidStrategy {

    protected AuctionState auctionState;

    public int calculateOptimalPrice() {
        return auctionState.getRemainingQuantity() /
                (auctionState.getOtherRemainingCash() + auctionState.getOwnRemainingCash());
    }

    public int calculateOtherOptimalPrice(){
        return (2 * auctionState.getOtherRemainingCash())/
                (auctionState.getCountToWin() - auctionState.getOtherQuantity());
    }

    public int calculateOwnOptimalPrice(){
        return (2 * auctionState.getOwnRemainingCash())/
                (auctionState.getCountToWin() - auctionState.getOwnQuantity());
    }

    public abstract int calculateOptimalBid(Pair<Integer, Integer> previousBid);
}
