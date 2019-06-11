package com.oskarrosen.thirty;

public class Die {
    private Side side;
    private int image;
    private int value;

    public enum Side {
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX
    }

    public static Side ONE = Side.ONE;
    public static Side TWO = Side.TWO;
    public static Side THREE = Side.THREE;
    public static Side FOUR = Side.FOUR;
    public static Side FIVE = Side.FIVE;
    public static Side SIX = Side.SIX;

    public Die(Side side) {
        this.side = side;
        this.setImage();
        this.setValue();
    }

    private void setImage() {
        switch (this.side) {
            case ONE:
                this.image = R.drawable.grey1;
                break;
            case TWO:
                this.image = R.drawable.grey2;
                break;
            case THREE:
                this.image = R.drawable.grey3;
                break;
            case FOUR:
                this.image = R.drawable.grey4;
                break;
            case FIVE:
                this.image = R.drawable.grey5;
                break;
            case SIX:
                this.image = R.drawable.grey6;
                break;
            default:
                this.image = 0;
        }
    }

    private void setValue() {
        this.value = this.getValueFromSide(this.side);

    }

    private int getValueFromSide(Side side) {
        int value = 0;

        switch (side) {
            case ONE:
                value = 1;
                break;
            case TWO:
                value = 2;
                break;
            case THREE:
                value = 3;
                break;
            case FOUR:
                value = 4;
                break;
            case FIVE:
                value = 5;
                break;
            case SIX:
                value = 6;
                break;
            default:
                value = 0;
        }

        return value;
    }

    public int getImage() {
        return this.image;
    }

    public int getValue() {
        return this.value;
    }

    public static Side[] getPossibleValues() {
        Side[] values = Die.Side.values();
        return values;
    }

}
