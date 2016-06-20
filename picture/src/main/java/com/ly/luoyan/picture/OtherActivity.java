package com.ly.luoyan.picture;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

import com.fivehundredpx.android.blur.BlurringView;
import com.ly.luoyan.picture.R;

import java.util.Random;

/**
 * Demonstrates the use of the blurring view.
 */
public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        mBlurringView = (BlurringView) findViewById(R.id.blurring_view);
        View blurredView = findViewById(R.id.blurred_view);

        // Give the blurring view a reference to the blurred view.
        mBlurringView.setBlurredView(blurredView);


    }



    private BlurringView mBlurringView;


}
