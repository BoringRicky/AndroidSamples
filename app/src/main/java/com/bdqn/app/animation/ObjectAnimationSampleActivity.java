package com.bdqn.app.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

import com.bdqn.app.R;

public class ObjectAnimationSampleActivity extends AppCompatActivity {

    private Button btnAnimationTarget;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animation_sample);

        btnAnimationTarget = (Button) findViewById(R.id.btnAnimationTarget);
    }


    public  void showObjectAnimations (View view){

        showCommonAnimation();

//        propertyValuesAnimation();



    }

    private void propertyValuesAnimation() {
        PropertyValuesHolder pvh1 = PropertyValuesHolder.ofFloat("translationX",300f);
        PropertyValuesHolder pvh2 = PropertyValuesHolder.ofFloat("scaleX",1f,0f,1f);
        PropertyValuesHolder pvh3 = PropertyValuesHolder.ofFloat("scaleX",1f,0f,1f);

        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(btnAnimationTarget,pvh1,pvh2,pvh3);
        objectAnimator.setDuration(500);
        objectAnimator.start();


    }


    public void showCommonAnimation(){
        //横向 移动 300
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(btnAnimationTarget,"translationX",300f);
        //竖向 移动 300
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(btnAnimationTarget,"translationY",300f);
        //旋转,以目标控件的中心为原点,旋转 300度
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(btnAnimationTarget,"rotation",300f);
        // 目标控件以X轴方向 旋转360度®
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(btnAnimationTarget,"rotationX",360f);
        // 目标控件以Y轴方向 旋转360度
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(btnAnimationTarget,"rotationY",360f);
        //目标控件 X轴方向 放大 0.5倍(缩小一半)
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(btnAnimationTarget,"scaleX",0.5f);
        //目标控件 Y轴方向 放大0.5倍(缩小一半)
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(btnAnimationTarget,"scaleY",0.5f);
        //目标控件的透明度 为 0.5
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(btnAnimationTarget,"alpha",0.5f);


//        objectAnimator.setRepeatCount(3);
//        objectAnimator.setRepeatMode(ObjectAnimator.REVERSE);
//        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.setDuration(500);
        objectAnimator.start();

        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //监听数值的变化
                float value = (float) animation.getAnimatedValue();
            }
        });


        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });


//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.setDuration(1000);
//        animatorSet.playTogether(objectAnimator1,objectAnimator2);//相当与 with
//        animatorSet.start();

//        AnimatorSet animatorSet1 =new AnimatorSet();
//        animatorSet1.play(objectAnimator1).with(objectAnimator2);
//        animatorSet1.start();


    }




}
