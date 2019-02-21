package com.lq.animationdemo.simple.propterty

import android.animation.ObjectAnimator
import android.animation.ValueAnimator.REVERSE
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lq.animationdemo.R
import kotlinx.android.synthetic.main.activity_animation_set.*

/**
 * 作者：Created by liuqian on 2019/2/15 14:10
 * 描述：
 */
class AlphaProptertyAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_alpha)
        initView()
    }

    private fun initView() {
        val an = ObjectAnimator.ofFloat(view, "alpha", 0.1f, 1f, 0.5f, 0.8f, 0.3f, 1.0f)
        an.duration = 2000
        an.repeatCount = -1
        an.repeatMode = REVERSE
        an.start()
    }
}
