package com.lq.animationdemo.simple.propterty

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lq.animationdemo.R
import kotlinx.android.synthetic.main.activity_animation_rotate.*

/**
 * 作者：Created by liuqian on 2019/2/15 14:19
 * 描述：
 */
class RotateProptertyAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_rotate)
        initView()
    }

    private fun initView() {
        val an = ObjectAnimator.ofFloat(view, "rotationX", 0.0f, 360.0f, 160.0f, 240.0f, 0.0f)
        an.duration = 2000
        an.repeatCount = -1
        an.repeatMode = ValueAnimator.REVERSE
        an.start()
    }
}