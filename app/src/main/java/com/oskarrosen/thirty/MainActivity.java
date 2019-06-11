package com.oskarrosen.thirty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private Button mButtonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonStart = findViewById(R.id.buttonStart);
        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "mButtonStart click listener");
                showThirtyActivity();
            }
        });


    }

    private void showThirtyActivity() {
        Log.d(TAG,"showThirtyctivity");

        Intent intent = new Intent(getBaseContext(), ThirtyActivity.class);
        //intent.putExtra("EXTRA_ANSWER_IS_TRUE", answerIsTrue);
        startActivityForResult(intent, 0);
    }
}
