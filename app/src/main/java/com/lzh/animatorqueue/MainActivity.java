package com.lzh.animatorqueue;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lzh.animator_queue_library.ViewPropertyAnimatorQueue;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                createAnim().start();
                break;

            case R.id.button2:
                ViewPropertyAnimatorQueue.from(textView).cancel();
                break;

            case R.id.button3:
                ViewPropertyAnimatorQueue.from(textView).clearAnimation();
                break;
        }
    }

    private ViewPropertyAnimatorQueue createAnim() {
        ViewPropertyAnimatorQueue queue = ViewPropertyAnimatorQueue.from(textView);
        if (queue.getAnimationSize() == 0) {
            queue.newAnimation()
                    .alpha(0.5f)
                    .x(0)
                    .y(0)
                    .rotation(360)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            Toast.makeText(MainActivity.this, "第一个动画结束", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setDuration(1000)

                    .newAnimation()
                    .rotation(360)
                    .x(540)
                    .y(270)
                    .setDuration(2000)

                    .newAnimation()
                    .rotationX(180)
                    .translationX(-400)
                    .translationY(50)
                    .scaleX(0.5f)
                    .setDuration(1000)

                    .newAnimation()
                    .scaleX(1)
                    .x(20)
                    .y(500)
                    .setStartDelay(1000)
                    .setDuration(1000)

                    .newAnimation()
                    .translationX(0)
                    .translationY(0)
                    .rotationX(0)
                    .alpha(1)
                    .rotation(0)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            Toast.makeText(MainActivity.this, "最后一个动画开始", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setDuration(2000);
        }
        return queue;
    }
}
