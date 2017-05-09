package com.lzh.animator_queue_library;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewPropertyAnimator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhihua on 2017/5/8.
 */

public class ViewPropertyAnimatorQueue {

    private List<AnimProperty> properties = new ArrayList<>();
    @NonNull
    private View targetView;
    private int currentPropertyPos = -1;
    private Animator.AnimatorListener taskListener = new AnimatorListenerAdapter() {
        @Override
        public void onAnimationEnd(Animator animation) {
            if (isStart && ++currentPropertyPos < properties.size()){
                createAnim(properties.get(currentPropertyPos)).start();
            } else {
                isStart = false;
            }
        }
    };
    private boolean isStart = false;

    public static ViewPropertyAnimatorQueue from(View view){
        ViewPropertyAnimatorQueue queue = (ViewPropertyAnimatorQueue) view.getTag(R.id.tag_animation);
        if (queue == null){
            queue = new ViewPropertyAnimatorQueue(view);
        }
        return queue;
    }

    private ViewPropertyAnimatorQueue(@NonNull View targetView) {
        this.targetView = targetView;
        targetView.setTag(R.id.tag_animation, this);
    }

    public void start() {
        if (isStart) return;
        isStart = true;
        currentPropertyPos = -1;
        if (++currentPropertyPos < properties.size()){
            createAnim(properties.get(currentPropertyPos)).start();
        }
    }

    public void cancel() {
        if (!isStart) return;
        isStart = false;
        targetView.animate().cancel();
    }

    public boolean isRunning(){
        return isStart;
    }

    public int getAnimationSize(){
        return properties.size();
    }

    public ViewPropertyAnimatorQueue clearAnimation() {
        cancel();
        targetView.clearAnimation();
        properties.clear();
        currentPropertyPos = -1;
        return this;
    }

    public ViewPropertyAnimatorQueue newAnimation() {
        properties.add(new AnimProperty());
        return this;
    }

    public ViewPropertyAnimatorQueue setDuration(long duration) {
        check();
        properties.get(properties.size() - 1).duration = duration;
        return this;
    }

    public ViewPropertyAnimatorQueue setStartDelay(long startDelay) {
        check();
        properties.get(properties.size() - 1).startDelay = startDelay;
        return this;
    }

    public ViewPropertyAnimatorQueue setInterpolator(TimeInterpolator interpolator) {
        check();
        properties.get(properties.size() - 1).interpolator = interpolator;
        return this;
    }

    public ViewPropertyAnimatorQueue setListener(Animator.AnimatorListener listener) {
        check();
        properties.get(properties.size() - 1).listener = listener;
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public ViewPropertyAnimatorQueue setUpdateListener(ValueAnimator.AnimatorUpdateListener listener) {
        check();
        properties.get(properties.size() - 1).updateListener = listener;
        return this;
    }

    public ViewPropertyAnimatorQueue x(float value) {
        check();
        properties.get(properties.size() - 1).x = value;
        return this;
    }

    public ViewPropertyAnimatorQueue xBy(float value) {
        check();
        properties.get(properties.size() - 1).xBy = value;
        return this;
    }

    public ViewPropertyAnimatorQueue y(float value) {
        check();
        properties.get(properties.size() - 1).y = value;
        return this;
    }

    public ViewPropertyAnimatorQueue yBy(float value) {
        check();
        properties.get(properties.size() - 1).yBy = value;
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ViewPropertyAnimatorQueue z(float value) {
        check();
        properties.get(properties.size() - 1).z = value;
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ViewPropertyAnimatorQueue zBy(float value) {
        check();
        properties.get(properties.size() - 1).zBy = value;
        return this;
    }

    public ViewPropertyAnimatorQueue rotation(float value) {
        check();
        properties.get(properties.size() - 1).rotation = value;
        return this;
    }

    public ViewPropertyAnimatorQueue rotationBy(float value) {
        check();
        properties.get(properties.size() - 1).rotationBy = value;
        return this;
    }

    public ViewPropertyAnimatorQueue rotationX(float value) {
        check();
        properties.get(properties.size() - 1).rotationX = value;
        return this;
    }

    public ViewPropertyAnimatorQueue rotationXBy(float value) {
        check();
        properties.get(properties.size() - 1).rotationXBy = value;
        return this;
    }

    public ViewPropertyAnimatorQueue rotationY(float value) {
        check();
        properties.get(properties.size() - 1).rotationY = value;
        return this;
    }

    public ViewPropertyAnimatorQueue rotationYBy(float value) {
        check();
        properties.get(properties.size() - 1).rotationYBy = value;
        return this;
    }

    public ViewPropertyAnimatorQueue translationX(float value) {
        check();
        properties.get(properties.size() - 1).translationX = value;
        return this;
    }

    public ViewPropertyAnimatorQueue translationXBy(float value) {
        check();
        properties.get(properties.size() - 1).translationXBy = value;
        return this;
    }

    public ViewPropertyAnimatorQueue translationY(float value) {
        check();
        properties.get(properties.size() - 1).translationY = value;
        return this;
    }

    public ViewPropertyAnimatorQueue translationYBy(float value) {
        check();
        properties.get(properties.size() - 1).translationYBy = value;
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ViewPropertyAnimatorQueue translationZ(float value) {
        check();
        properties.get(properties.size() - 1).translationZ = value;
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ViewPropertyAnimatorQueue translationZBy(float value) {
        check();
        properties.get(properties.size() - 1).translationZBy = value;
        return this;
    }

    public ViewPropertyAnimatorQueue scaleX(float value) {
        check();
        properties.get(properties.size() - 1).scaleX = value;
        return this;
    }

    public ViewPropertyAnimatorQueue scaleXBy(float value) {
        check();
        properties.get(properties.size() - 1).scaleXBy = value;
        return this;
    }

    public ViewPropertyAnimatorQueue scaleY(float value) {
        check();
        properties.get(properties.size() - 1).scaleY = value;
        return this;
    }

    public ViewPropertyAnimatorQueue scaleYBy(float value) {
        check();
        properties.get(properties.size() - 1).scaleYBy = value;
        return this;
    }

    public ViewPropertyAnimatorQueue alpha(float value) {
        check();
        properties.get(properties.size() - 1).alpha = value;
        return this;
    }

    public ViewPropertyAnimatorQueue alphaBy(float value) {
        check();
        properties.get(properties.size() - 1).alphaBy = value;
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public ViewPropertyAnimatorQueue withLayer() {
        check();
        properties.get(properties.size() - 1).withLayer = true;
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public ViewPropertyAnimatorQueue withStartAction(Runnable runnable) {
        check();
        properties.get(properties.size() - 1).startAction = runnable;
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public ViewPropertyAnimatorQueue withEndAction(Runnable runnable) {
        check();
        properties.get(properties.size() - 1).endAction = runnable;
        return this;
    }

    private void check() {
        if (properties.isEmpty())
            throw new IllegalStateException("no animator, do you forget call newAnimation()");
    }

    private ViewPropertyAnimator createAnim(AnimProperty property) {
        ViewPropertyAnimator animator = targetView.animate();
        if (property.duration != null) animator.setDuration(property.duration);
        if (property.startDelay != null) animator.setStartDelay(property.startDelay);
        if (property.interpolator != null) animator.setInterpolator(property.interpolator);
        if (property.x != null) animator.x(property.x);
        if (property.xBy != null) animator.xBy(property.xBy);
        if (property.y != null) animator.y(property.y);
        if (property.yBy != null) animator.yBy(property.yBy);
        if (property.translationX != null) animator.translationX(property.translationX);
        if (property.translationXBy != null) animator.translationXBy(property.translationXBy);
        if (property.translationY != null) animator.translationY(property.translationY);
        if (property.translationYBy != null) animator.translationYBy(property.translationYBy);
        if (property.rotation != null) animator.rotation(property.rotation);
        if (property.rotationBy != null) animator.rotationBy(property.rotationBy);
        if (property.rotationX != null) animator.rotationX(property.rotationX);
        if (property.rotationXBy != null) animator.rotationXBy(property.rotationXBy);
        if (property.rotationY != null) animator.rotationY(property.rotationY);
        if (property.rotationYBy != null) animator.rotationYBy(property.rotationYBy);
        if (property.scaleX != null) animator.scaleX(property.scaleX);
        if (property.scaleXBy != null) animator.scaleXBy(property.scaleXBy);
        if (property.scaleY != null) animator.scaleY(property.scaleY);
        if (property.scaleYBy != null) animator.scaleYBy(property.scaleYBy);
        if (property.alpha != null) animator.alpha(property.alpha);
        if (property.alphaBy != null) animator.alphaBy(property.alphaBy);

        animator.setListener(new ProxyListener(property.listener, taskListener));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            if (property.withLayer) animator.withLayer();
            if (property.startAction != null) animator.withStartAction(property.startAction);
            if (property.endAction != null) animator.withEndAction(property.endAction);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (property.updateListener != null)
                animator.setUpdateListener(property.updateListener);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (property.z != null) animator.z(property.z);
            if (property.zBy != null) animator.zBy(property.zBy);
            if (property.translationZ != null) animator.translationZ(property.translationZ);
            if (property.translationZBy != null) animator.translationZBy(property.translationZBy);
        }

        return animator;
    }

    private static class AnimProperty {
        Long duration;
        Long startDelay;
        TimeInterpolator interpolator;
        Animator.AnimatorListener listener;
        ValueAnimator.AnimatorUpdateListener updateListener;
        Float x;
        Float xBy;
        Float y;
        Float yBy;
        Float z;
        Float zBy;
        Float translationX;
        Float translationXBy;
        Float translationY;
        Float translationYBy;
        Float translationZ;
        Float translationZBy;
        Float rotation;
        Float rotationBy;
        Float rotationX;
        Float rotationXBy;
        Float rotationY;
        Float rotationYBy;
        Float scaleX;
        Float scaleXBy;
        Float scaleY;
        Float scaleYBy;
        Float alpha;
        Float alphaBy;
        boolean withLayer;
        Runnable startAction;
        Runnable endAction;
    }

    private static class ProxyListener extends AnimatorListenerAdapter{
        private Animator.AnimatorListener targetListener;
        private Animator.AnimatorListener taskListener;
        private ProxyListener(Animator.AnimatorListener targetListener, Animator.AnimatorListener taskListener) {
            this.targetListener = targetListener;
            this.taskListener = taskListener;
        }

        @Override
        public void onAnimationCancel(Animator animation) {
            if (targetListener != null) targetListener.onAnimationCancel(animation);
            if (taskListener != null) taskListener.onAnimationCancel(animation);
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            if (targetListener != null) targetListener.onAnimationEnd(animation);
            if (taskListener != null) taskListener.onAnimationEnd(animation);
        }

        @Override
        public void onAnimationRepeat(Animator animation) {
            if (targetListener != null) targetListener.onAnimationRepeat(animation);
            if (taskListener != null) taskListener.onAnimationRepeat(animation);
        }

        @Override
        public void onAnimationStart(Animator animation) {
            if (targetListener != null) targetListener.onAnimationStart(animation);
            if (taskListener != null) taskListener.onAnimationStart(animation);
        }
    }
}
