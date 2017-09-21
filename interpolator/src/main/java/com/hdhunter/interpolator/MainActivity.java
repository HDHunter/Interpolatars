package com.hdhunter.interpolator;

import android.os.Bundle;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.RadioGroup;

import com.hdhunter.interpolator.interpolator.BackInterpolator;
import com.hdhunter.interpolator.interpolator.CircInterpolator;
import com.hdhunter.interpolator.interpolator.CubicInterpolator;
import com.hdhunter.interpolator.interpolator.EasingType;
import com.hdhunter.interpolator.interpolator.ElasticInterpolator;
import com.hdhunter.interpolator.interpolator.ExpoInterpolator;
import com.hdhunter.interpolator.interpolator.QuadInterpolator;
import com.hdhunter.interpolator.interpolator.QuartInterpolator;
import com.hdhunter.interpolator.interpolator.QuintInterpolator;
import com.hdhunter.interpolator.interpolator.SineInterpolator;

public class MainActivity extends AppCompatActivity {

    private RadioGroup mInterpolatorGroup = null;
    private CurveView mCurveView = null;
    private float[] mXValues = new float[]{0.0f, 0.01f, 0.02f, 0.03f, 0.04f, 0.05f, 0.06f, 0.07f, 0.08f, 0.09f, 0.1f, 0.11f, 0.12f, 0.13f, 0.14f,
            0.15f, 0.16f, 0.17f, 0.18f, 0.19f, 0.2f, 0.21f, 0.22f, 0.23f, 0.24f, 0.25f, 0.26f, 0.27f, 0.28f,
            0.29f, 0.3f, 0.31f, 0.32f, 0.33f, 0.34f, 0.35f, 0.36f, 0.37f, 0.38f, 0.39f, 0.4f, 0.41f, 0.42f,
            0.43f, 0.44f, 0.45f, 0.46f, 0.47f, 0.48f, 0.49f, 0.5f, 0.51f, 0.52f, 0.53f, 0.54f, 0.55f, 0.56f,
            0.57f, 0.58f, 0.59f, 0.6f, 0.61f, 0.62f, 0.63f, 0.64f, 0.65f, 0.66f, 0.67f, 0.68f, 0.69f, 0.7f,
            0.71f, 0.72f, 0.73f, 0.74f, 0.75f, 0.76f, 0.77f, 0.78f, 0.79f, 0.8f, 0.81f, 0.82f, 0.83f, 0.84f,
            0.85f, 0.86f, 0.87f, 0.88f, 0.89f, 0.9f, 0.91f, 0.92f, 0.93f, 0.94f, 0.95f, 0.96f, 0.97f, 0.98f,
            0.99f, 1f};
    private float[] mYValues = new float[101];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mInterpolatorGroup = (RadioGroup) findViewById(R.id.interpolatorGroup);
        mCurveView = (CurveView) findViewById(R.id.curve);
        mCurveView.setxValues(mXValues);
        mInterpolatorGroup
                .setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        Interpolator interpolator = getInterpolator();
                        for (int i = 0; i < mXValues.length; ++i) {
                            mYValues[i] = interpolator
                                    .getInterpolation(mXValues[i]);
                        }
                        mCurveView.setyValues(mYValues);
                        mCurveView.invalidate();
                    }
                });

        mInterpolatorGroup.check(R.id.LinearInterpolator);
    }


    private Interpolator getInterpolator() {
        int checkedId = mInterpolatorGroup.getCheckedRadioButtonId();
        switch (checkedId) {
            //framework
            case R.id.AccelerateDecelerateInterpolator:
                return new AccelerateDecelerateInterpolator();
            case R.id.AccelerateInterpolator:
                return new AccelerateInterpolator();
            case R.id.AnticipateInterpolator:
                return new AnticipateInterpolator();
            case R.id.AnticipateOvershootInterpolator:
                return new AnticipateOvershootInterpolator();
            case R.id.BounceInterpolator:
                return new BounceInterpolator();
            case R.id.CycleInterpolator:
                return new CycleInterpolator(2);
            case R.id.DecelerateInterpolator:
                return new DecelerateInterpolator();
            case R.id.LinearInterpolator:
                return new LinearInterpolator();
            case R.id.OvershootInterpolator:
                return new OvershootInterpolator();
            //v4
            case R.id.FastOutLinearInInterpolator:
                return new FastOutLinearInInterpolator();
            case R.id.FastOutSlowInInterpolator:
                return new FastOutSlowInInterpolator();
            case R.id.LinearOutSlowInInterpolator:
                return new LinearOutSlowInInterpolator();
            //interpolator package
            case R.id.BackInterpolator:
                return new BackInterpolator(EasingType.IN, 0f);
            case R.id.BounceInterpolator1:
                return new com.hdhunter.interpolator.interpolator.BounceInterpolator(EasingType.IN);
            case R.id.CircInterpolator:
                return new CircInterpolator(EasingType.IN);
            case R.id.CubicInterpolator:
                return new CubicInterpolator(EasingType.IN);
            case R.id.ElasticInterpolator:
                return new ElasticInterpolator(EasingType.IN, 1, 0);
            case R.id.ExpoInterpolator:
                return new ExpoInterpolator(EasingType.IN);
            case R.id.QuadInterpolator:
                return new QuadInterpolator(EasingType.IN);
            case R.id.QuartInterpolator:
                return new QuartInterpolator(EasingType.IN);
            case R.id.QuintInterpolator:
                return new QuintInterpolator(EasingType.IN);
            case R.id.SineInterpolator:
                return new SineInterpolator(EasingType.IN);
            default:
                break;
        }
        return null;
    }
}
