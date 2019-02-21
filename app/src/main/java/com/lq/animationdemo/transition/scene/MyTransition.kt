package com.lq.animationdemo.transition.scene

import android.animation.Animator
import android.transition.Transition
import android.transition.TransitionValues
import android.view.ViewGroup

/**
 *作者：Created by liuqian on 2019/2/19 13:16
 *描述：
 */
class MyTransition : Transition(){

    override fun captureStartValues(transitionValues: TransitionValues?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun captureEndValues(transitionValues: TransitionValues?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createAnimator(sceneRoot: ViewGroup?, startValues: TransitionValues?, endValues: TransitionValues?): Animator {
        return super.createAnimator(sceneRoot, startValues, endValues)
    }

}