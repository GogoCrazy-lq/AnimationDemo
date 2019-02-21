package com.lq.animationdemo.transition.scene

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.transition.ArcMotion
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.Gravity
import android.widget.FrameLayout
import com.lq.animationdemo.R
import kotlinx.android.synthetic.main.activity_scene_path_motion.*

/**
 * 作者：Created by liuqian on 2019/2/19 11:32
 * 描述：ArcMotion、PatternPathMotion
 */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class PathMotionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_path_motion)
        initView()
    }

    private var isTop = true

    private fun initView() {

        button.setOnClickListener {
            val autoTransition = AutoTransition()
            autoTransition.pathMotion = ArcMotion()
            TransitionManager.beginDelayedTransition(cl_parent, autoTransition)
            val params = imageView.layoutParams as FrameLayout.LayoutParams
            if (isTop) {
                isTop = false
                params.gravity = Gravity.BOTTOM or Gravity.END
            } else {
                isTop = true
                params.gravity = Gravity.TOP or Gravity.START
            }
            imageView.layoutParams = params
        }
    }
}