package com.lq.animationdemo.transition.scene

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.lq.animationdemo.R
import com.lq.animationdemo.onClick
import kotlinx.android.synthetic.main.activity_scene_list.*

/**
 *作者：Created by liuqian on 2019/2/17 15:36
 *描述：
 */

class SceneTransitinListActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_list)
        initView()
    }


    private fun initView() {
        autoTransitionBtn.onClick(this)
        changeBoundsBtn.onClick(this)
        slideBtn.onClick(this)
        explodeBtn.onClick(this)
        changeTransformBtn.onClick(this)
        changeScrollBtn.onClick(this)
        fadeBtn.onClick(this)
        changeClipBoundsBtn.onClick(this)
        changeImageTransformBtn.onClick(this)
        pathMotionBtn.onClick(this)
        setBtn.onClick(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.autoTransitionBtn -> {
                startActivity(Intent().setClass(this, AutoTransformActivity::class.java))
            }
            R.id.changeBoundsBtn -> {
                startActivity(Intent().setClass(this, ChangeBoundsActivity::class.java))
            }
            R.id.slideBtn -> {
                startActivity(Intent().setClass(this, SlideActivity::class.java))
            }
            R.id.explodeBtn -> {
                startActivity(Intent().setClass(this, ExplodeActivity::class.java))
            }
            R.id.changeTransformBtn -> {
                startActivity(Intent().setClass(this, ChangeTransformActivity::class.java))
            }
            R.id.changeScrollBtn -> {
                startActivity(Intent().setClass(this, ChangeScrollActivity::class.java))
            }
            R.id.fadeBtn -> {
                startActivity(Intent().setClass(this, FadeActivity::class.java))
            }
            R.id.changeClipBoundsBtn -> {
                startActivity(Intent().setClass(this, ChangeClipBoundsActivity::class.java))
            }
            R.id.changeImageTransformBtn -> {
                startActivity(Intent().setClass(this, ChangeImageTransformActivity::class.java))
            }

            R.id.pathMotionBtn -> {
                startActivity(Intent().setClass(this, PathMotionActivity::class.java))
            }

            R.id.setBtn -> {
                startActivity(Intent().setClass(this, TransitionSetActivity::class.java))
            }
        }
    }
}