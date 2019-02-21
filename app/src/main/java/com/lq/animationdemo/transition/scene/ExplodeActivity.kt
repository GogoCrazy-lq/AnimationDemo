package com.lq.animationdemo.transition.scene

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.transition.Explode
import android.transition.TransitionManager
import android.view.View
import com.lq.animationdemo.R
import com.lq.animationdemo.transition.TransitionActivity.Companion.interpolatorList
import kotlinx.android.synthetic.main.activity_scene_explode.*

/**
 *作者：Created by liuqian on 2019/2/18 10:59
 *描述：
 */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class ExplodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_explode)
        initView()
    }

    private var isStatus: Boolean = true
    private var lastClickTime: Long = 0L
    private fun initView() {

        val explode = Explode()
        explode.duration = 1000
        explode.interpolator = interpolatorList[3]

        button.setOnClickListener {
            if (System.currentTimeMillis() - lastClickTime < 1000L) {
                return@setOnClickListener
            }
            lastClickTime = System.currentTimeMillis()
            TransitionManager.beginDelayedTransition(cl_parent, explode)
            if (isStatus) {
                isStatus = false
                view.visibility = View.GONE
                view1.visibility = View.GONE
                view2.visibility = View.GONE
                view3.visibility = View.VISIBLE
                view4.visibility = View.GONE
            } else {
                isStatus = true
                view.visibility = View.VISIBLE
                view1.visibility = View.VISIBLE
                view2.visibility = View.VISIBLE
                view3.visibility = View.GONE
                view4.visibility = View.VISIBLE
            }
        }
    }
}