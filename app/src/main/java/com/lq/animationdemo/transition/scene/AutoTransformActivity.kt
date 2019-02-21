package com.lq.animationdemo.transition.scene

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import com.lq.animationdemo.R
import kotlinx.android.synthetic.main.activity_scene_start.*

/**
 *作者：Created by liuqian on 2019/2/18 10:59
 *描述：改变当前视图层级中view的状态 beginDelayedTransition实现
 */
class AutoTransformActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_start)
        initView2()
    }

    private fun initView2() {

        sceneBtn.setOnClickListener {
            TransitionManager.beginDelayedTransition(cl_parent, AutoTransition())
            if (textView.visibility != View.VISIBLE) {
                textView.visibility = View.VISIBLE
            } else {
                textView.visibility = View.GONE
            }
        }
    }


}