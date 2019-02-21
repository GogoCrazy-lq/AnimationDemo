package com.lq.animationdemo.simple.tween

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.lq.animationdemo.R
import kotlinx.android.synthetic.main.activity_animation_scale.*

/**
 * 作者：Created by liuqian on 2019/2/15 14:10
 * 描述：
 */
class AlphaTweenAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_alpha)

        initView()
    }

    private fun initView() {
        val an = AnimationUtils.loadAnimation(this, R.anim.animation_tween_alpha)
        an.repeatCount = -1  //无限次
        an.repeatMode = Animation.REVERSE //不间断播放 开始->结束->开始->结束->开始..
        an.duration = 2000
        view.startAnimation(an)
    }
}
