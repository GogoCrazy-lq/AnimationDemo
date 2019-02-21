package com.lq.animationdemo.transition

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lq.animationdemo.R
import kotlinx.android.synthetic.main.activity_activity_to_activity.*

/**
 * 作者：Created by liuqian on 2019/2/21 15:33
 * 描述：
 */

class ActivityToActivityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity_to_activity)

        activityTransitionBtn.setOnClickListener {
            finish()
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.down_in2, R.anim.down_out2)
    }
}