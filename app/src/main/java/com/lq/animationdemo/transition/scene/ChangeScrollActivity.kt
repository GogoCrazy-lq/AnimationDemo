package com.lq.animationdemo.transition.scene

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeScroll
import android.transition.TransitionManager
import com.lq.animationdemo.R
import com.lq.animationdemo.transition.TransitionActivity.Companion.interpolatorList
import kotlinx.android.synthetic.main.activity_scene_scroll.*

/**
 *作者：Created by liuqian on 2019/2/18 10:59
 *描述：
 */
@RequiresApi(Build.VERSION_CODES.M)
class ChangeScrollActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_scroll)
        initView()
    }

    private fun initView() {
        val changeScroll = ChangeScroll()
        changeScroll.duration = 500
        changeScroll.interpolator = interpolatorList[3]
        sceneBtn.setOnClickListener {
            TransitionManager.beginDelayedTransition(cl_parent, changeScroll)
            textView.scrollBy(-10, -10)
        }
    }
}