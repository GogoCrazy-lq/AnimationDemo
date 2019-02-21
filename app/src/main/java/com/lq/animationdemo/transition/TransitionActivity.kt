package com.lq.animationdemo.transition

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.*
import android.widget.Button
import com.lq.animationdemo.R
import com.lq.animationdemo.onClick
import com.lq.animationdemo.transition.scene.SceneTransitinListActivity
import com.lq.animationdemo.transition.share.SharedElementActivity
import kotlinx.android.synthetic.main.activity_translation.*

/**
 * 作者：Created by liuqian on 2019/2/17 12:03
 * 描述： 三个重点  scene  transition transitionManager
 * 1.scene 用于保存布局中view的属性 开始 和 结束
 * 2.transition 过渡动画  用于scene开始属性过渡到scene结束属性的效果
 * 3.transitionManager transitionManager
 * scene = Scene.getSceneForLayout(该布局根view , 要保存的view ， context) or Scene(根view ， 当前view)
 */
class TransitionActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        val interpolatorList: Array<Interpolator> = arrayOf(
                AnticipateInterpolator(),
                AccelerateInterpolator(),
                AccelerateDecelerateInterpolator(),
                AnticipateOvershootInterpolator(),
                BounceInterpolator(),
                CycleInterpolator(2.0f),
                DecelerateInterpolator(),
                LinearInterpolator(),
                OvershootInterpolator()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_translation)
        initView()
    }

    private fun initView() {
        sceneTransitionBtn.onClick(this)
        sharedElementTransitionBtn.onClick(this)
        activityTransitionBtn.onClick(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.sceneTransitionBtn -> {
                startActivity(Intent().setClass(this, SceneTransitinListActivity::class.java))
            }
            R.id.sharedElementTransitionBtn -> { //activity之间元素共享
                val intent = Intent(this, SharedElementActivity::class.java)
                val bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        this,
                        sharedElementTransitionBtn,
                        resources.getString(R.string.share_btn)).toBundle()
                startActivity(intent, bundle)
            }
            R.id.activityTransitionBtn -> { //界面单纯跳转切换动画
                startActivity(Intent().setClass(this, ActivityToActivityActivity::class.java))
                overridePendingTransition(R.anim.up_in2, R.anim.up_out2)
            }
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.down_in, R.anim.down_out)
    }
}