package com.example.bouncingballs;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final long UPDATE_DELAY_TIMES_MS = 20;
    private Handler handler;
    private ArrayList<BouncingBalls> viewsToUpdate = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        RelativeLayout root = (RelativeLayout) findViewById(R.id.activity_main);
        for (int index = 0; index < root.getChildCount(); index++) {
            viewsToUpdate.add((BouncingBalls) root.getChildAt(index));
        }
        handler = new Handler();
        updateBall().run();
    }

    private Runnable updateBall() {
        return () -> {
            for (BouncingBalls b : viewsToUpdate) {
                b.invalidate();
            }
            handler.postDelayed(updateBall(), UPDATE_DELAY_TIMES_MS);
        };
    }
}
