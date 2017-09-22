package org.logart;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuctionStateTest {

    private AuctionState auctionState;

    @Before
    public void setUp() throws Exception {
        auctionState = new AuctionState();
        auctionState.init(10, 15);
    }

    @Test
    public void initShouldSetCorrectValues() {
        assertEquals(15, auctionState.getInitialCash());
        assertEquals(10, auctionState.getInitialQuantity());
        assertEquals(0, auctionState.getOtherQuantity());
        assertEquals(15, auctionState.getOtherRemainingCash());
        assertEquals(0, auctionState.getOwnQuantity());
        assertEquals(15, auctionState.getOwnRemainingCash());
        assertEquals(10, auctionState.getRemainingQuantity());
    }

    @Test
    public void updateStateShouldDecreaseOtherCashAndIncreaseQuantity() {
        auctionState.updateState(2,3);
        assertEquals(12, auctionState.getOtherRemainingCash());
        assertEquals(2, auctionState.getOtherQuantity());
    }


    @Test
    public void updateStateShouldDecreaseOwnCash() {
        auctionState.updateState(3,2);
        assertEquals(12, auctionState.getOwnRemainingCash());
        assertEquals(2, auctionState.getOwnQuantity());
    }


    @Test
    public void updateStateShouldDecreaseBothCash() {
        auctionState.updateState(2,2);
        assertEquals(13, auctionState.getOtherRemainingCash());
        assertEquals(13, auctionState.getOwnRemainingCash());
        assertEquals(1, auctionState.getOtherQuantity());
        assertEquals(1, auctionState.getOwnQuantity());
    }
}