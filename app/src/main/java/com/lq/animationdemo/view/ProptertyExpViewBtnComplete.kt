package com.lq.animationdemo.view

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import com.lq.animationdemo.transition.TransitionActivity.Companion.interpolatorList


/**
 * Created by liuqian on 2019/2/21 11:19
 * Describe: 矩形圆角按钮点击后渐变为圆形图标动画
 */
class ProptertyExpViewBtnComplete @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var textPaint: Paint = Paint()
    private val textColor: Int = Color.parseColor("#FFFFFF")
    private var rectPaint: Paint = Paint()
    private val rectColor: Int = Color.parseColor("#9575CD")
    private var circleAngle = 0.0f
    private var btnWidth: Int = 0 //变化范围width /2 - height/2

    init {

        textPaint.flags = Paint.ANTI_ALIAS_FLAG
        textPaint.color = textColor
        textPaint.style = Paint.Style.FILL
        textPaint.textSize =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 18.0f, context.resources.displayMetrics)
        textPaint.textAlign = Paint.Align.CENTER

        rectPaint.flags = Paint.ANTI_ALIAS_FLAG
        rectPaint.color = rectColor
        rectPaint.style = Paint.Style.FILL
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //首先绘制一个圆角矩形
        val rect = RectF(btnWidth.toFloat(), 0.0f, width.toFloat() - btnWidth, height.toFloat())
        canvas.drawRoundRect(rect, circleAngle, circleAngle, rectPaint)
        val fontMetrics = textPaint.fontMetrics
        val textHeight = (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom //baseline距离文字中心距离
        canvas.drawText(
            "完成",
            (width / 2).toFloat(),
            (height / 2).toFloat() + textHeight,
            textPaint
        ) //文字默认定位的是Y轴基线位置  所以要整体向下偏移
    }

    fun startAni() {
        startEditCircleRadiusAnimaion()
    }

    private fun startEditCircleRadiusAnimaion() {
        val aniCircleRadius = ObjectAnimator.ofFloat(this, "circleAngle", 0.0f, (height / 2).toFloat())
        val aniBtnWidth = ObjectAnimator.ofInt(this, "btnWidth", 0, width / 2 - height / 2)
        val set = AnimatorSet()
        set.duration = 1000
        set.playTogether(aniCircleRadius, aniBtnWidth)
        set.interpolator = interpolatorList[4]
        set.addListener(object : AnimatorListenerAdapter() {

            override fun onAnimationStart(animation: Animator?) {
                super.onAnimationStart(animation)
                isClickable = false
            }

            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                isClickable = true
            }
        })
        set.start()
    }


    fun getCircleAngle(): Float {
        return circleAngle
    }

    fun setCircleAngle(circleAngle: Float) {
        this.circleAngle = circleAngle
        postInvalidate()
    }


    fun getBtnWidth(): Int {
        return btnWidth
    }

    fun setBtnWidth(btnWidth: Int) {
        this.btnWidth = btnWidth
        postInvalidate()
    }
}