package com.lq.animationdemo.simple.tween

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.lq.animationdemo.R
import kotlinx.android.synthetic.main.activity_animation_scale.*

/**
 *作者：Created by liuqian on 2019/2/15 14:19
 *描述：
 */
class RotateTweenAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_rotate)
        initView()
    }

    private fun initView() {
        val an = AnimationUtils.loadAnimation(this, R.anim.animation_tween_rotate)
        an.repeatCount = -1
        an.repeatMode = Animation.REVERSE
        an.duration = 2000
        view.startAnimation(an)
    }
}