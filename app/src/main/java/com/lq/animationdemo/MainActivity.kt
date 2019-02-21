package com.lq.animationdemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lq.animationdemo.simple.FrameAnimationActivity
import com.lq.animationdemo.simple.ProptertyAnimationActivity
import com.lq.animationdemo.simple.TweenAnimationActivity
import com.lq.animationdemo.transition.TransitionActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        frameBtn.onClick(this)
        tweenBtn.onClick(this)
        proptertyBtn.onClick(this)
        translationBtn.onClick(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent()
        when (v?.id) {
            R.id.frameBtn -> {
                startActivity(intent.setClass(this, FrameAnimationActivity::class.java))
            }
            R.id.tweenBtn -> {
                startActivity(intent.setClass(this, TweenAnimationActivity::class.java))
            }
            R.id.proptertyBtn -> {
                startActivity(intent.setClass(this, ProptertyAnimationActivity::class.java))
            }
            R.id.translationBtn -> {
                startActivity(intent.setClass(this, TransitionActivity::class.java))
                overridePendingTransition(R.anim.up_in, R.anim.up_out)
            }

        }
    }
}
