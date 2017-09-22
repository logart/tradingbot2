package org.logart.strategy;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Test;
import org.logart.AuctionState;

import static org.junit.Assert.*;

public class EarlyGameStrategyTest {

    private EarlyGameStrategy strategy;

    @Before
    public void setUp() throws Exception {
        AuctionState auctionState = new AuctionState();
        auctionState.init(10, 15);
        strategy = new EarlyGameStrategy(auctionState);
    }

    @Test
    public void earlyGameStrategyShouldBidLessThenPreviousBidIfLessThenOptimalPrice() {
        int bid = strategy.calculateOptimalBid(Pair.of(0, 1));
        assertEquals(0, bid);
    }

    @Test
    public void earlyGameStrategyShouldBidNonNegativeValue() {
        assertTrue(strategy.calculateOptimalBid(Pair.of(0, 0)) >= 0);
    }

    @Test
    public void earlyGameStrategyShouldBidOptimalPriceIfCompetitorTriesToRaiseThePrice() {
        int optimalPrice = strategy.calculateOptimalPrice();
        int bid = strategy.calculateOptimalBid(Pair.of(0, optimalPrice + 1));
        assertEquals(optimalPrice, bid);
    }
}