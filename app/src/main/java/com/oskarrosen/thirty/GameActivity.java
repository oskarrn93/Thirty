package com.oskarrosen.thirty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private final String TAG = "GameActivity";
    private Button mButtonGameShowResult;
    private Button mButtonGameRollDie;

    private ImageView mImageViewGameDie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mImageViewGameDie = findViewById(R.id.imageViewGameDie);

        mButtonGameShowResult = findViewById(R.id.buttonGameShowResult);
        mButtonGameShowResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Log.d(TAG, "mButtonGameShowResult click listener");
            showResultActivity();
            }
        });


        final Die.Side[] diceSide = Die.getPossibleValues();
        final Random random = new Random();

        
        mButtonGameRollDie = findViewById(R.id.buttonGameRollDie);
        mButtonGameRollDie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Log.d(TAG, "mButtonGameShowResult click listener");

            Enum diceValue = diceSide[random.nextInt(diceSide.length)];
            Die die = new Die((Die.Side) diceValue);

            mImageViewGameDie.setImageResource(die.getImage());

            Log.d(TAG, "die image: " + die.getImage());
            Log.d(TAG, "die value: " + die.getValue());
            }
        });

    }

    private void showResultActivity() {
        Log.d(TAG,"showResultActivity");

        Intent intent = new Intent(getBaseContext(), ResultActivity.class);
        //intent.putExtra("EXTRA_ANSWER_IS_TRUE", answerIsTrue);
        startActivityForResult(intent, 0);
    }
}
