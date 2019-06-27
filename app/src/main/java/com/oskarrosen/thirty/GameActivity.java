package com.oskarrosen.thirty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class GameActivity extends AppCompatActivity {

    private final String TAG = "GameActivity";
    private Button mButtonGameShowResult;
    private Button mButtonGameRollDie;

    private ImageView mImageViewGameDie;

    private Spinner mSpinnerScoreOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Thirty thirty = new Thirty(this);

        setContentView(R.layout.activity_game);

        mImageViewGameDie = findViewById(R.id.imageViewGameDie1);

        mButtonGameShowResult = findViewById(R.id.buttonGameShowResult);
        mButtonGameShowResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Log.d(TAG, "mButtonGameShowResult click listener");
            showResultActivity();
            }
        });

        mButtonGameRollDie = findViewById(R.id.buttonGameRollDie);
        mButtonGameRollDie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            thirty.roll();
            Log.d(TAG, "mButtonGameShowResult click listener");

            Log.d(TAG, "thirty getDice: " + thirty.getDice());
            Log.d(TAG, "thirty getDiceRetry: " +thirty.getDiceRetry());
            }
        });


       mSpinnerScoreOption = findViewById(R.id.spinnerScoreOption);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        for(ScoreOptions so : thirty.getScoreOptions()) {
            spinnerArrayAdapter.add(so.toString());
        }

        mSpinnerScoreOption.setAdapter(spinnerArrayAdapter);

    }

    private void showResultActivity() {
        Log.d(TAG,"showResultActivity");

        Intent intent = new Intent(getBaseContext(), ResultActivity.class);
        //intent.putExtra("EXTRA_ANSWER_IS_TRUE", answerIsTrue);
        startActivityForResult(intent, 0);
    }
}
