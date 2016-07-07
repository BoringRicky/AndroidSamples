package com.bdqn.app.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import com.bdqn.app.R;

public class ViewAnimationSampleActivity extends AppCompatActivity {

    private Button btnAnimationTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation_sample);
        btnAnimationTarget = (Button) findViewById(R.id.btnAnimationTarget);
    }

    public void showAnimation(View view){
        //1.透明度 渐变 动画
//        alphaAnimation();

        //2.旋转动画
//        rotateAnimation();

        //3.位移动画
//        translateAnimation();

        //4.缩放动画
//        scaleAnimation();

        //5.动画集合
//        animationSet();

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.view_animation);
        btnAnimationTarget.startAnimation(animation);



    }

    /**
     * 动画集合
     */
    private void animationSet() {
        AnimationSet animationSet = new AnimationSet(true);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1f);
        alphaAnimation.setDuration(1000);
        animationSet.addAnimation(alphaAnimation);

        TranslateAnimation translateAnimation = new TranslateAnimation(0f,100f,0f,200f);
        translateAnimation.setDuration(1000);
        animationSet.addAnimation(translateAnimation);

        btnAnimationTarget.startAnimation(animationSet);
    }

    /**
     * 缩放动画
     */
    private void scaleAnimation() {
        //以原点为轴,X轴方向从0倍放大到0.5倍,Y轴方向从0倍放大到1倍,就是从原点开始,将控件的宽放大0.5倍,高放大1倍
//        ScaleAnimation scaleAnimation = new ScaleAnimation(0f,0.5f,0f,1f);
        //.x轴方向以目标控件宽的一半为X轴缩放点的坐标,Y轴方向以目标控件高的一半为Y轴缩放点的坐标,就是以目标控件的中心为轴,将控件宽放大0.5倍,高放大1倍
        ScaleAnimation scaleAnimation = new ScaleAnimation(0f,0.5f,0,1f,ScaleAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setDuration(500);
        scaleAnimation.setFillAfter(true);
        btnAnimationTarget.startAnimation(scaleAnimation);


        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.e("start","Animation start");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.e("start","Animation end");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.e("start","Animation Repeat");
            }
        });

    }


    /**
     * 位移动画
     */
    private void translateAnimation() {
        //X轴方向从0移动到100,Y轴方向从0移动到200
        TranslateAnimation translateAnimation = new TranslateAnimation(0f,100f,0f,200f);
        translateAnimation.setDuration(500);
        translateAnimation.setFillAfter(true);
        btnAnimationTarget.startAnimation(translateAnimation);
    }


    /**
     * 旋转动画
     */
    private void rotateAnimation() {
        //1.以原点为轴 从 0度  顺时针旋转到 30 度
//        RotateAnimation rotateAnimation = new RotateAnimation(0f,30f);
        //2.以(100,100)为轴 从0度 顺时针旋转到 360 度
//        RotateAnimation rotateAnimation = new RotateAnimation(0f,360f,100f,100f);
        //3.x轴方向以目标控件宽的一半为X轴旋转点的坐标,Y轴方向以目标控件高的一半为Y轴旋转点的坐标,就是以目标控件的中心为轴,如果目标控价的宽为200,高为100,这旋转轴的坐标为(100,50)
        RotateAnimation rotateAnimation = new RotateAnimation(0f,360f,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(500);
        //保持动画完毕的状态
        rotateAnimation.setFillAfter(true);
        btnAnimationTarget.startAnimation(rotateAnimation);
    }


    /**
     * 透明度渐变动画
     */
    private void alphaAnimation(){
        AlphaAnimation alphaAnimation = new AlphaAnimation(0f,1f);
        alphaAnimation.setDuration(3000);

        //1.第一种启动方式
        btnAnimationTarget.startAnimation(alphaAnimation);

        //2.第二种启动方式
//        btnAnimationTarget.setAnimation(alphaAnimation);
//        alphaAnimation.start();
    }



}
