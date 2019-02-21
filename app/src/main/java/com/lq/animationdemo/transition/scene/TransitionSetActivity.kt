package com.lq.animationdemo.transition.scene

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeImageTransform
import android.transition.ChangeTransform
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import com.lq.animationdemo.R
import kotlinx.android.synthetic.main.activity_scene_set.*

/**
 *作者：Created by liuqian on 2019/2/18 10:59
 *描述：
 */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class TransitionSetActivity : AppCompatActivity() {

    private var width: Int = 0
    private var height: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_set)



        initView()
    }


    private var boolean: Boolean = true

    private fun initView() {
        addImage(rl_content1).scaleType = ImageView.ScaleType.CENTER_CROP
        button.setOnClickListener {
            val transitionSet = TransitionSet()
            transitionSet.ordering = TransitionSet.ORDERING_TOGETHER //一起播放or顺序播放

            val changeTransform = ChangeTransform()
            transitionSet.addTransition(changeTransform)

            val changeImageTransform = ChangeImageTransform()
            transitionSet.addTransition(changeImageTransform)


            TransitionManager.beginDelayedTransition(cl_parent, transitionSet)


            rl_content1.removeAllViews()
            rl_content2.removeAllViews()
            if (boolean) {
                boolean = false
                val image = addImage(rl_content2)
                image.scaleType = ImageView.ScaleType.FIT_XY
                image.rotation = 150f
            } else {
                boolean = true
                addImage(rl_content1).scaleType = ImageView.ScaleType.CENTER_CROP
            }
        }
    }

    private fun addImage(relative: RelativeLayout): ImageView {
        val image = ImageView(this)
        image.layoutParams =
            RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        image.id = R.id.createview1_id
        image.setImageResource(R.drawable.katong)
        relative.addView(image)
        return image
    }
}