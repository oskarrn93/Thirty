package com.oskarrosen.thirty;

public class ScoreOptions {

    private boolean used;
    private ScoreOptionsEnum soe;

    public enum ScoreOptionsEnum {
        LOW,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        ELEVEN,
        TWELVE
    }
    public static ScoreOptionsEnum LOW = ScoreOptionsEnum.LOW;
    public static ScoreOptionsEnum FOUR = ScoreOptionsEnum.FOUR;
    public static ScoreOptionsEnum FIVE = ScoreOptionsEnum.FIVE;
    public static ScoreOptionsEnum SIX = ScoreOptionsEnum.SIX;
    public static ScoreOptionsEnum SEVEN = ScoreOptionsEnum.SEVEN;
    public static ScoreOptionsEnum EIGHT = ScoreOptionsEnum.EIGHT;
    public static ScoreOptionsEnum NINE = ScoreOptionsEnum.NINE;
    public static ScoreOptionsEnum TEN = ScoreOptionsEnum.TEN;
    public static ScoreOptionsEnum ELEVEN = ScoreOptionsEnum.ELEVEN;
    public static ScoreOptionsEnum TWELVE = ScoreOptionsEnum.TWELVE;


    public ScoreOptions(ScoreOptionsEnum soe) {
        this.used = false;
        this.soe = soe;

    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public ScoreOptionsEnum getValueEnum() {
        return this.soe;
    }

    public boolean getUsed() {
        return this.used;
    }

    public String toString() {
        String str;

        switch (this.soe) {
            case LOW:
                str = "Low";
                break;
            case FOUR:
                str = "Four";
                break;
            case FIVE:
                str = "Five";
                break;
            case SIX:
                str = "Six";
                break;
            case SEVEN:
                str = "Seven";
                break;
            case EIGHT:
                str = "Eight";
                break;
            case NINE:
                str = "Nine";
                break;
            case TEN:
                str = "Ten";
                break;
            case ELEVEN:
                str = "Eleven";
                break;
            case TWELVE:
                str = "Twelve";
                break;
            default:
                str = null;
        }

        return str;
    }
 }
