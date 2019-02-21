package com.lq.animationdemo.transition.scene

import android.graphics.Point
import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeClipBounds
import android.transition.TransitionManager
import android.util.Log
import com.lq.animationdemo.R
import com.lq.animationdemo.transition.TransitionActivity.Companion.interpolatorList
import kotlinx.android.synthetic.main.activity_scene_start.*

/**
 *作者：Created by liuqian on 2019/2/18 10:59
 *描述：
 */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class ChangeClipBoundsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_clip)
        initView()
    }

    private fun initView() {
        val point = Point()
        windowManager.defaultDisplay.getSize(point)
        sceneBtn.setOnClickListener {
            val bounds = Rect(8, point.y / 2 , point.x , point.y -8)   //只能小于操作view的大小
            val changeClipBounds = ChangeClipBounds()
            changeClipBounds.duration = 500
            changeClipBounds.interpolator = interpolatorList[3]
            TransitionManager.beginDelayedTransition(cl_parent, changeClipBounds)
            val boundssss = ViewCompat.getClipBounds(view)
            Log.e("操作view的", "left:${boundssss?.left} , top:${boundssss?.top} , right:${boundssss?.right} , bottom:${boundssss?.bottom}")
            if (bounds == ViewCompat.getClipBounds(view)) {
                ViewCompat.setClipBounds(view, null)
            } else {
                ViewCompat.setClipBounds(view, bounds)
            }
        }
    }
}