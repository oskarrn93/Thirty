package com.oskarrosen.thirty;

import android.media.Image;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class Thirty {
    private String TAG = "Thirty";

    private GameActivity gameActivity;
    private Die[] dice;
    private Die[] diceRetry;

    private Die.Side[] diceSides;

    private int counter;

    private int maxRolls = 5;

    private Random random;

    private ArrayList<ScoreOptions> scoreOptions;

    private ArrayList<ScoreOptions> usedScoreOptions;


    public Thirty (GameActivity gameActivity) {

        this.gameActivity = gameActivity;

        this.dice = new Die[6];
        this.diceRetry = new Die[2];

        this.diceSides = Die.getPossibleValues();

        this.counter = 0;

        this.random = new Random();


        this.scoreOptions = new ArrayList<>(ScoreOptions.ScoreOptionsEnum.values().length);

       for(ScoreOptions.ScoreOptionsEnum soe : ScoreOptions.ScoreOptionsEnum.values())
       {
            this.scoreOptions.add(new ScoreOptions(soe));
       }

        for(ScoreOptions so : this.scoreOptions)
        {
            System.out.println(so.toString());
        }



    }

    public void roll() {
        Log.d(TAG, "roll()");

        Log.d(TAG, "counter: " + this.counter);

        if(this.counter > this.maxRolls) {
            Log.d(TAG, "max number of rolls");
            this.reset();
            //return;
        }

        Die.Side side = this.generateRandomDieSide();
        Die die = new Die(side);
        Log.d(TAG, "die: " + die.toString());

        this.dice[counter] = die;

        this.setImage();

        this.counter++;
    }

    private Die.Side generateRandomDieSide() {
        Log.d(TAG, "generateRandomDieSide()");
        int index = random.nextInt(this.diceSides.length);
        return diceSides[index];
    }

    private ImageView getDieImageView(int value) {
        Log.d(TAG, "getDieImageView()");
        Log.d(TAG, "value: " + value);

        ImageView view;
        if(value == 0) {
            view = gameActivity.findViewById(R.id.imageViewGameDie1);
        }
        else if(value == 1) {
            view = gameActivity.findViewById(R.id.imageViewGameDie2);
        }
        else if(value == 2) {
            view = gameActivity.findViewById(R.id.imageViewGameDie3);
        }
        else if(value == 3) {
            view = gameActivity.findViewById(R.id.imageViewGameDie4);
        }
        else if(value == 4) {
            view = gameActivity.findViewById(R.id.imageViewGameDie5);
        }
        else if(value == 5) {
            view = gameActivity.findViewById(R.id.imageViewGameDie6);
        } else {
            view = gameActivity.findViewById(0);
        }

        Log.d(TAG, "view: " + view);

        return view;
    }

    private void setImage() {
        Log.d(TAG, "setImage()");
        ImageView view = this.getDieImageView(this.counter);

        view.setImageResource(this.dice[this.counter].getImage());
    }

    public Die[] getDice() {
        Log.d(TAG, "getDice()");
        return this.dice;
    }

    public Die[] getDiceRetry() {
        Log.d(TAG, "getDiceRetry()");
        return this.diceRetry;
    }

    public ArrayList<ScoreOptions> getScoreOptions() {
        return this.scoreOptions;
    }

    private void reset() {
        Log.d(TAG, "reset()");

        this.dice = new Die[6];
        this.diceRetry = new Die[2];
        this.counter = 0;

        ImageView view;
        for(int a = 0; a < 6; a++) {
            view = this.getDieImageView(a);
            view.setImageResource(R.drawable.white);
        }
    }
}
