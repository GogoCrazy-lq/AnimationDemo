package com.lq.animationdemo.simple.propterty

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lq.animationdemo.R
import kotlinx.android.synthetic.main.activity_animation_scale.*

/**
 * 作者：Created by liuqian on 2019/2/15 14:20
 * 描述：
 */
class SetProptertyAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_set)
        initView1() //or initView2
    }

    private fun initView1() {
        val anAlpha = ObjectAnimator.ofFloat(view, "alpha", 0.1f, 0.5f, 1.0f, 0.3f, 0.8f, 1.0f)
        anAlpha.repeatMode = ValueAnimator.RESTART
        anAlpha.repeatCount = -1

        val anRotate = ObjectAnimator.ofFloat(view, "rotationX", 0.0f, 80.0f, 130.0f, 180.0f, 150.0f, 120.0f)
        anRotate.repeatMode = ValueAnimator.RESTART
        anRotate.repeatCount = -1

        val anScale = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.2f, 1.5f, 1.8f, 1.4f)
        anScale.repeatMode = ValueAnimator.RESTART
        anScale.repeatCount = -1

        val anTranslate = ObjectAnimator.ofFloat(
            view,
            "translationX",
            100.0f,
            200.0f,
            300.0f,
            400.0f,
            500.0f,
            600.0f,
            700.0f,
            800.0f,
            700.0f,
            600.0f
        )
        anTranslate.repeatMode = ValueAnimator.RESTART
        anTranslate.repeatCount = -1

        val set = AnimatorSet()
        set.duration = 3000
        set.playTogether(anAlpha, anRotate, anScale, anTranslate)
        set.start()
    }

    private fun initView2() {
        val alpha = PropertyValuesHolder.ofFloat("alpha", 0.1f, 0.5f, 1.0f, 0.3f, 0.8f, 1.0f)
        val rotate = PropertyValuesHolder.ofFloat("rotateX", 0.0f, 80.0f, 130.0f, 180.0f, 150.0f, 120.0f)
        val scale = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 1.2f, 1.5f, 1.8f, 1.4f)
        val translation = PropertyValuesHolder.ofFloat(
            "translationX", 100.0f, 200.0f, 300.0f, 400.0f, 500.0f, 600.0f, 700.0f, 800.0f, 700.0f, 600.0f)

        val together = ObjectAnimator.ofPropertyValuesHolder(view , alpha , rotate , scale , translation)
        together.duration = 3000
        together.repeatMode = ValueAnimator.RESTART
        together.repeatCount = -1
        together.start()
    }


}