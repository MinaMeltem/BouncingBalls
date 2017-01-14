package com.example.bouncingballs;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by meltemyildirim on 1/10/17.
 */

public class BouncingBalls extends View {

    private Paint paint = new Paint();
    boolean movingRight = true;
    boolean movingUp = true;

    private int circleXPosition;
    private int circleYPosition;
    private int circleXSpeed;
    private int circleYSpeed;
    private int circleRadius;
    private int circleColor;
    private int circleRightEdge;


    public BouncingBalls(Context context) {
        super(context);

    }

    public BouncingBalls(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.BouncingBalls, 0, 0);
        try {
            circleRadius = a.getDimensionPixelSize(R.styleable.BouncingBalls_circleRadius, 0);
            circleXPosition = a.getDimensionPixelSize(R.styleable.BouncingBalls_circleXPosition, 0);
            circleYPosition = a.getDimensionPixelSize(R.styleable.BouncingBalls_circleYPosition, 0);
            circleXSpeed = a.getDimensionPixelSize(R.styleable.BouncingBalls_circleXSpeed, 0);
            circleYSpeed = a.getDimensionPixelSize(R.styleable.BouncingBalls_circleYSpeed, 0);
            circleRadius = a.getDimensionPixelSize(R.styleable.BouncingBalls_circleRadius, 10);
            circleRightEdge = a.getDimensionPixelSize(R.styleable.BouncingBalls_circleRightEdge, 0);
            circleColor = a.getColor(R.styleable.BouncingBalls_circleColor, Color.BLACK);

        } finally {
            a.recycle();
        }
    }

    public BouncingBalls(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(circleColor);
        canvas.drawCircle(circleXPosition, circleYPosition, circleRadius, paint);

        //moving right - left

        if (circleXPosition >= circleRightEdge) {
            movingRight = false;
        }

        if (circleXPosition <= 0) {
            movingRight = true;
        }


        if (movingRight) {
            circleXPosition += circleXSpeed;
        } else {
            circleXPosition -= circleXSpeed;
        }



        if (circleXPosition >= circleRightEdge) {
            movingRight = false;
        }

        if (circleXPosition <= 0) {
            movingRight = true;
        }

        if (movingRight) {
            circleXPosition += circleXSpeed;
        } else {
            circleXPosition -= circleXSpeed;
        }

        //moving up - down

        if (circleYPosition >= getHeight()) {
            movingUp = false;
        }

        if (circleYPosition <= 0) {
            movingUp = true;
        }

        if (movingUp) {
            circleYPosition += circleYSpeed;
        } else {
            circleYPosition -= circleYSpeed;
        }

        if (circleXPosition >= getWidth()) {
            movingRight = false;
        }

        if (circleXPosition <= 0) {
            movingRight = true;
        }

        if (movingRight) {
            circleXPosition += circleXSpeed;
        } else {
            circleXPosition -= circleXSpeed;
        }

    }
}
