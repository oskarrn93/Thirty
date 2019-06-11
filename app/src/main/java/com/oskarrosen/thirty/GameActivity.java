package com.oskarrosen.thirty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class GameActivity extends AppCompatActivity {

    private final String TAG = "GameActivity";
    private Button mButtonGameShowResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mButtonGameShowResult = findViewById(R.id.buttonGameShowResult);
        mButtonGameShowResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "mButtonGameShowResult click listener");
                showResultActivity();
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
