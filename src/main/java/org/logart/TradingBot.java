package org.logart;

import org.apache.commons.lang3.tuple.Pair;
import org.logart.strategy.BidStrategy;
import org.logart.strategy.ZeroGameStrategy;

public class TradingBot implements Bidder {


    private BidStrategy bidStrategy;

    private Pair<Integer, Integer> previousBid;
    private AuctionState auction;

    public TradingBot() {
        //in real world this will be injected by IOC container
        this.auction = AuctionState.getInstance();
        this.bidStrategy = new ZeroGameStrategy();
    }

    public void init(int quantity, int cash) {
        auction.init(quantity, cash);
    }

    public int placeBid() {
        return bidStrategy.calculateOptimalBid(previousBid);
    }

    public void bids(int own, int other) {
        auction.updateState(own, other);
        previousBid = Pair.of(own, other);
//replace bid strategy after first bid
        bidStrategy = auction.getCurrentStrategy();
    }
}
