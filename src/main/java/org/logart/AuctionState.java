package org.logart;

import org.logart.strategy.*;

import java.util.Objects;

public class AuctionState {
    public static final double FIRST_THIRD_OF_A_GAME = 0.6666;
    private static AuctionState INSTANCE;

    private int initialQuantity;
    private int countToWin;
    private int remainingQuantity;

    private int initialCash;
    private int otherRemainingCash;
    private int ownRemainingCash;

    private int ownQuantity;
    private int otherQuantity;

    private BidStrategy earlyGameStrategy = new EarlyGameStrategy(this);
    private BidStrategy midGameStrategy = new MidGameStrategy(this);
    private BidStrategy lateGameStrategy = new LateGameStrategy();
    private BidStrategy zeroGameStrategy = new ZeroGameStrategy();

    public static AuctionState getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new AuctionState();
        }
        return INSTANCE;
    }

    public void init(int quantity, int cash) {
        this.initialQuantity = quantity;
        this.initialCash = cash;

        this.otherRemainingCash = cash;
        this.ownRemainingCash = cash;
        this.remainingQuantity = quantity;

        this.countToWin = 1 + quantity / 2;
    }

    public void updateState(int own, int other) {
        remainingQuantity -= 2;
        otherRemainingCash -= other;
        ownRemainingCash -= own;

        if (own > other) {
            ownQuantity += 2;
        } else if (own < other) {
            otherQuantity += 2;
        } else {
            ownQuantity += 1;
            otherQuantity += 1;
        }
    }

    public int getInitialQuantity() {
        return initialQuantity;
    }

    public int getRemainingQuantity() {
        return remainingQuantity;
    }

    public int getInitialCash() {
        return initialCash;
    }

    public int getOtherRemainingCash() {
        return otherRemainingCash;
    }

    public int getOwnRemainingCash() {
        return ownRemainingCash;
    }

    public int getOwnQuantity() {
        return ownQuantity;
    }

    public int getOtherQuantity() {
        return otherQuantity;
    }

    public int getCountToWin() {
        return countToWin;
    }

    public BidStrategy getCurrentStrategy() {
        double gamePart = 1.0 * this.remainingQuantity / this.initialQuantity;
        BidStrategy result;

        if (gamePart > FIRST_THIRD_OF_A_GAME) {
            result = earlyGameStrategy;
        } else if (ownOptimalPrice() == 1) {
            result = lateGameStrategy;
        } else if (ownOptimalPrice() == 0) {
            result = zeroGameStrategy;
        } else {
            result = midGameStrategy;
        }

        return result;
    }

    private int ownOptimalPrice() {
        if (countToWin == ownQuantity) {
            return 0;
        } else {
            return (2 * ownRemainingCash) / (countToWin - ownQuantity);
        }
    }
}
