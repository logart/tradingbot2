package org.logart;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

@Ignore
/**
 * This test is used for debug purposes. It may fail because of rounding issues.
 */
public class TradingBotTest {

    @Test
    public void testCompleteGame() {
        TradingBot bot = new TradingBot();
        bot.init(30,30);

        //# round 1
        int initialBid = bot.placeBid();
        assertEquals(0, initialBid);
        bot.bids(initialBid, 4);

        //# round 2
        int optimalBid = bot.placeBid();
        assertTrue(optimalBid == 2 || optimalBid == 1);
        bot.bids(optimalBid, 3);

        //# round 3
        optimalBid = bot.placeBid();
        assertEquals(4, optimalBid);
        bot.bids(optimalBid, 3);

        //# round 4
        optimalBid = bot.placeBid();
        assertEquals(4, optimalBid);
        bot.bids(optimalBid, 3);

        //# round 5
        optimalBid = bot.placeBid();
        assertEquals(1, optimalBid);
        bot.bids(optimalBid, 3);

        //# round 6
        optimalBid = bot.placeBid();
        assertEquals(1, optimalBid);
        bot.bids(optimalBid, 3);

        //# round 7
        optimalBid = bot.placeBid();
        assertEquals(4, optimalBid);
        bot.bids(optimalBid, 3);

        //# round 8
        optimalBid = bot.placeBid();
        assertTrue(optimalBid == 3 || optimalBid == 4);
        bot.bids(optimalBid, 3);

        //# round 9
        optimalBid = bot.placeBid();
        assertEquals(3, optimalBid);
        bot.bids(optimalBid, 0);

        //# round 10
        optimalBid = bot.placeBid();
        assertEquals(3, optimalBid);
        bot.bids(optimalBid, 0);

        //# round 11
        optimalBid = bot.placeBid();
        assertEquals(3, optimalBid);
        bot.bids(optimalBid, 4);

        //# round 12
        optimalBid = bot.placeBid();
        assertTrue(optimalBid == 1 || optimalBid == 0);
        bot.bids(optimalBid, 0);

        //# round 13
        optimalBid = bot.placeBid();
        assertEquals(1, optimalBid);
        bot.bids(optimalBid, 0);

        //# round 14
        optimalBid = bot.placeBid();
        assertTrue(optimalBid == 0);
        bot.bids(optimalBid, 0);

        //# round 15
        optimalBid = bot.placeBid();
        assertEquals(0, optimalBid);
        bot.bids(optimalBid, 0);

    }
}