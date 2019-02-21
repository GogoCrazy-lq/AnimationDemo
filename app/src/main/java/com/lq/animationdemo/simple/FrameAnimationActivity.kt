package com.lq.animationdemo.simple

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lq.animationdemo.R
import kotlinx.android.synthetic.main.activity_frame_animation.*

/**
 * Created by liuqian on 2019/2/21 11:18
 * Describe:
 */
class FrameAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_animation)
        initView()
    }

    private fun initView() {
        imageView.setImageResource(R.drawable.animation_frame)
        val animationDrawable = imageView.drawable as AnimationDrawable
        animationDrawable.start()
    }
}
