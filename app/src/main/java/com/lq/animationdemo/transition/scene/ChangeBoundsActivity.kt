package com.lq.animationdemo.transition.scene

import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeBounds
import android.transition.TransitionManager
import com.lq.animationdemo.R
import com.lq.animationdemo.transition.TransitionActivity.Companion.interpolatorList
import kotlinx.android.synthetic.main.activity_scene_start.*

/**
 *作者：Created by liuqian on 2019/2/18 10:59
 *描述：
 */
class ChangeBoundsActivity : AppCompatActivity() {


    private lateinit var firstSet: ConstraintSet
    private lateinit var changeSet: ConstraintSet


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_start)
        initView()
    }

    private var isBottom: Boolean = true
    private fun initView() {
        firstSet = ConstraintSet()
        firstSet.clone(cl_parent)
        changeSet = ConstraintSet()
        changeSet.clone(this, R.layout.activity_scene_change)

        sceneBtn.setOnClickListener {
            val changeBounds = ChangeBounds()
            changeBounds.interpolator = interpolatorList[3]
            changeBounds.duration = 1000
            TransitionManager.beginDelayedTransition(cl_parent, changeBounds)
            if (isBottom) {
                isBottom = false
                changeSet.applyTo(cl_parent)
            } else {
                isBottom = true
                firstSet.applyTo(cl_parent)
            }
        }
    }
}