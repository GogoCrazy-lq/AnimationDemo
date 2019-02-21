package com.lq.animationdemo.simple

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.lq.animationdemo.view.ProptertyExpViewSun

/**
 *作者：Created by liuqian on 2019/2/19 14:41
 *描述：
 */

class ProptertyAnimationExpActivity : AppCompatActivity() {

    private lateinit var frameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        frameLayout = FrameLayout(this)
        frameLayout.layoutParams =
            ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        setContentView(frameLayout)
        frameLayout.addView(createView())
    }

    private fun createView(): View? {
        val proptertyExpView = ProptertyExpViewSun(this)
        val params =
            FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
        params.gravity = Gravity.CENTER
        proptertyExpView.layoutParams = params
        return proptertyExpView
    }

}