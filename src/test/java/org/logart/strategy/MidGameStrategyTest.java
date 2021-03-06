package org.logart.strategy;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Test;
import org.logart.AuctionState;

import static org.junit.Assert.*;

public class MidGameStrategyTest {

    private MidGameStrategy strategy;

    @Before
    public void setUp() {
        AuctionState auctionState = new AuctionState();
        auctionState.init(10, 15);
        strategy = new MidGameStrategy(auctionState);
    }

    @Test
    public void mgsShouldBidHigherThenCompetitorOptimalPrice() {
        int optimalPrice = strategy.calculateOwnOptimalPrice()+1;
        int bid = strategy.calculateOptimalBid(Pair.of(0, 0));
        assertEquals(optimalPrice, bid);
    }
}