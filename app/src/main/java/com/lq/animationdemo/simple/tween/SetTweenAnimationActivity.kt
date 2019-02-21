package com.lq.animationdemo.simple.tween

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import com.lq.animationdemo.R
import kotlinx.android.synthetic.main.activity_animation_scale.*

/**
 *作者：Created by liuqian on 2019/2/15 14:20
 *描述：
 */
class SetTweenAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_set)
        initView()
    }

    //fillBefore动画结束后是否view停留在结束为止 ， shareInterpolator子元素是否共用这个插值器

    /**
     * AnimationSet相关属性失效 未知  可通过监听器实现重复播放
     */
    private fun initView() {
//        android:fillBefore="false"
//        android:repeatMode="restart"
//        android:repeatCount="infinite"
//        android:shareInterpolator="true"
        val an: AnimationSet = AnimationUtils.loadAnimation(this, R.anim.animation_tween_set) as AnimationSet
        an.interpolator = LinearInterpolator()
        an.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                view.startAnimation(an)
            }

            override fun onAnimationStart(animation: Animation?) {
            }
        })
        view.startAnimation(an)
    }


}