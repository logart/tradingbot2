package org.logart.strategy;

import org.junit.Test;

import static org.junit.Assert.*;

public class LateGameStrategyTest {
    @Test
    public void lateGameStrategyShouldBuyWithMinimalPrice() {
        LateGameStrategy strategy = new LateGameStrategy();
        assertEquals(1, strategy.calculateOptimalBid(null));
    }
}