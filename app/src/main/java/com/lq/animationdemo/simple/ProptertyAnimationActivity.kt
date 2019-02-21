package com.lq.animationdemo.simple

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.lq.animationdemo.R
import com.lq.animationdemo.onClick
import com.lq.animationdemo.simple.propterty.*
import kotlinx.android.synthetic.main.activity_type_animation.*

/**
 *作者：Created by liuqian on 2019/2/15 13:38
 *描述：
 * 用来控制动画的变化速度，可以理解成动画渲染器，当然我们也可以自己实现Interpolator 接口，自行来控制动画的变化速度，而Android中已经为我们提供了五个可供选择的实现类。
 * 1.LinearInterpolator：动画以均匀的速度改变。
 * 2.AccelerateInterpolator：在动画开始的地方改变速度较慢，然后开始加速。
 * 3.AccelerateDecelerateInterpolator：在动画开始、结束的地方改变速度较慢，中间时加速。
 * 4.CycleInterpolator：动画循环播放特定次数，变化速度按正弦曲线改变
 *  Math.sin(2 * mCycles * Math.PI * input)。
 * 5.DecelerateInterpolator：在动画开始的地方改变速度较快，然后开始减速。
 * 6.AnticipateInterpolator：反向，先向相反方向改变一段再加速播放。
 * 7.AnticipateOvershootInterpolator：开始的时候向后然后向前甩一定值后返回最后的值。
 * 8.BounceInterpolator： 跳跃，快到目的值时值会跳跃，如目的值100，后面的值可能依次为85，77，70，          80，90，100。
 * 9.OvershottInterpolator：回弹，最后超出目的值然后缓慢改变到目的值。
 */
class ProptertyAnimationActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_type_animation)
        initView()
    }

    private fun initView() {
        alphaBtn.onClick(this)
        scaleBtn.onClick(this)
        translateBtn.onClick(this)
        rotateBtn.onClick(this)
        setBtn.onClick(this)
        expSunBtn.visibility = View.VISIBLE
        expSunBtn.onClick(this)
        expChangeBtn.visibility = View.VISIBLE
        expChangeBtn.onClick(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.alphaBtn -> {
                startActivity(Intent().setClass(this, AlphaProptertyAnimationActivity::class.java))
            }
            R.id.scaleBtn -> {
                startActivity(Intent().setClass(this, ScaleProptertyAnimationActivity::class.java))
            }
            R.id.translateBtn -> {
                startActivity(Intent().setClass(this, TranslateProptertyAnimationActivity::class.java))
            }
            R.id.rotateBtn -> {
                startActivity(Intent().setClass(this, RotateProptertyAnimationActivity::class.java))
            }
            R.id.setBtn -> {
                startActivity(Intent().setClass(this, SetProptertyAnimationActivity::class.java))
            }
            R.id.expSunBtn -> {
                startActivity(Intent().setClass(this, ProptertyAnimationExpActivity::class.java))
            }
            R.id.expChangeBtn -> {
                startActivity(Intent().setClass(this, ProptertyAnimationExpBtnActivity::class.java))
            }
        }
    }
}