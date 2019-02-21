package com.lq.animationdemo.simple.propterty

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lq.animationdemo.R
import kotlinx.android.synthetic.main.activity_animation_translate.*

/**
 * 作者：Created by liuqian on 2019/2/15 14:17
 * 描述：
 */
class TranslateProptertyAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_translate)
        initView()
    }

    /**
     * 移动基点是当前view的左上角
     */
    private fun initView() {
        val an = ObjectAnimator.ofFloat(view, "translationX", -10.0f, -50.0f, -100.0f, -50.0f, -10.0f, 0.0f, 10.0f, 50.0f, 100.0f, 200.0f, 300.0f, 400.0f, 500.0f)
        an.duration = 2000
        an.repeatCount = -1
        an.repeatMode = ValueAnimator.REVERSE
        an.start()
    }
}