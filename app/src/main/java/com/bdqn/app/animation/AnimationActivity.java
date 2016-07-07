package com.bdqn.app.animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bdqn.app.R;

public class AnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);


    }


    public void showViewAnimation(View view){
        startActivity(new Intent(this, ViewAnimationSampleActivity.class));
    }

    public void showObjectAnimation(View view){
        startActivity(new Intent(this,ObjectAnimationSampleActivity.class));
    }

}
