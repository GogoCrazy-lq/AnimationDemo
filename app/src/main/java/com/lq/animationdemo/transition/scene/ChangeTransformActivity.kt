package com.lq.animationdemo.transition.scene

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeTransform
import android.transition.TransitionManager
import android.view.View
import android.widget.RelativeLayout
import android.widget.RelativeLayout.*
import com.lq.animationdemo.R
import kotlinx.android.synthetic.main.activity_scene_changetransform.*

/**
 *作者：Created by liuqian on 2019/2/18 10:59
 *描述：
 */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class ChangeTransformActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_changetransform)
        initView()
    }


    /**
     * 加入时间不能太长  会导致卡顿500以下吧感觉 或者默认  越长越厉害
     */
    @SuppressLint("ResourceAsColor")
    private fun initView() {
        addView(rl_content1, 150)
        addView2(rl_content1, 150, ALIGN_PARENT_TOP)
        button.setOnClickListener {
            TransitionManager.beginDelayedTransition(cl_parent, ChangeTransform())
            if (rl_content2.childCount > 0) {
                rl_content2.removeAllViews() //移除容器中的所有view
                addView(rl_content1, 150)
                addView2(rl_content1, 150, ALIGN_PARENT_TOP)
            } else {
                rl_content1.removeAllViews()
                addView(rl_content2, 200)
                addView2(rl_content2, 150, ALIGN_PARENT_BOTTOM)
                rl_content2.getChildAt(0).rotation = 45f
            }
        }
    }

    private fun addView(parent: RelativeLayout, size: Int) {
        val view = View(this)
        view.id = R.id.createview1_id
        view.setBackgroundColor(Color.parseColor("#ff0000"))
        val params = RelativeLayout.LayoutParams(size, size)
        params.addRule(CENTER_IN_PARENT)
        view.layoutParams = params
        parent.addView(view)
    }

    private fun addView2(parent: RelativeLayout, size: Int, align: Int) {
        val view = View(this)
        view.id = R.id.createview2_id
        view.setBackgroundColor(Color.parseColor("#0000ff"))
        val params = RelativeLayout.LayoutParams(size, size)
        params.addRule(align)
        params.addRule(CENTER_HORIZONTAL)
        view.layoutParams = params
        parent.addView(view)

    }


}