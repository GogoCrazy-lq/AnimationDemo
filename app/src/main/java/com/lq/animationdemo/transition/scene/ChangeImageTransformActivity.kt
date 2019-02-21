package com.lq.animationdemo.transition.scene

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeImageTransform
import android.transition.TransitionManager
import android.widget.ImageView
import com.lq.animationdemo.R
import kotlinx.android.synthetic.main.activity_scene_changeimage.*

/**
 *作者：Created by liuqian on 2019/2/18 10:59
 *描述：
 */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class ChangeImageTransformActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_changeimage)
        initView()
    }

    private fun initView() {
        val typeList = arrayOf(
                ImageView.ScaleType.FIT_CENTER,
                ImageView.ScaleType.CENTER,
                ImageView.ScaleType.CENTER_CROP,
                ImageView.ScaleType.CENTER_INSIDE,
                ImageView.ScaleType.FIT_END,
                ImageView.ScaleType.FIT_START,
                ImageView.ScaleType.FIT_XY,
                ImageView.ScaleType.MATRIX
        )

        button.setOnClickListener {
            TransitionManager.beginDelayedTransition(cl_parent, ChangeImageTransform())
            imageView2.scaleType = typeList[(Math.random() * 8).toInt()]
        }
    }
}