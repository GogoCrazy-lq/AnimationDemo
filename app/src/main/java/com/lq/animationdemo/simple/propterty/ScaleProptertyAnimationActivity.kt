package com.lq.animationdemo.simple.propterty

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lq.animationdemo.R
import kotlinx.android.synthetic.main.activity_animation_scale.*

/**
 * 作者：Created by liuqian on 2019/2/15 14:12
 * 描述：缩放动画
 */
class ScaleProptertyAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_scale)
        initView()
    }

    private fun initView() {
        val an = ObjectAnimator.ofFloat(view, "scaleY", 0.0f, 1.0f, 1.5f, 2.0f, 1.0f)
        an.duration = 2000
        an.repeatCount = -1
        an.repeatMode = ValueAnimator.REVERSE
        an.start()
    }
}