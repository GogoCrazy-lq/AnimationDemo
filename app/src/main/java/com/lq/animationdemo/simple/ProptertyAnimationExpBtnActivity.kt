package com.lq.animationdemo.simple

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.lq.animationdemo.R
import kotlinx.android.synthetic.main.activity_propterty_animation_exp_btn.*

/**
 * Created by liuqian on 2019/2/21 11:46
 * Describe:
 */
class ProptertyAnimationExpBtnActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_propterty_animation_exp_btn)
        btn.setOnClickListener {
            btn.startAni()
        }
    }
}