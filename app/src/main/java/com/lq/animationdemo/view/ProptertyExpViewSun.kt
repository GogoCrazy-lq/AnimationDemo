package com.lq.animationdemo.view

import android.animation.*
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.lq.animationdemo.transition.TransitionActivity.Companion.interpolatorList

/**
 * 作者：Created by liuqian on 2019/2/19 14:56
 * 描述：
 */
class ProptertyExpViewSun @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    View(context, attrs, defStyleAttr) {


    private val mainColor = Color.parseColor("#FFD54F")//设置圆环画笔颜色
    private val mainSunRectColor = Color.parseColor("#FFE082")
    private val mainSunShadowColor = Color.parseColor("#c9c9c9")

    private val circlePaintRang = Paint()
    private val circlePaintFill = Paint()
    private var circleRadius: Float = 0.0f
    private var circleRadiusWhite: Float = 10.0f

    //圆弧画笔
    private var arcPaint: Paint
    private var arcLongStartAngle = 250.0f //开始角度
    private var arcShortStartAngle = 0.0f //开始角度

    private var sunPaint: Paint
    private var sunShadowPaint: Paint

    private var sunShadowR: Float = 0.0f //阴影范围

    private var circleSunRadius: Float = 0.0f //太阳圆环半径变化
    private var sunRectSize = 0.0f
    private var sunRectRoate = 0.0f

    //画云朵
    private var cloudPaint: Paint
    private var cloudCircleRadius = 0.0f

    init {
        circlePaintRang.flags = ANTI_ALIAS_FLAG
        circlePaintRang.color = Color.WHITE
        circlePaintRang.strokeWidth = 0.0f
        circlePaintRang.style = Paint.Style.FILL

        circlePaintFill.flags = ANTI_ALIAS_FLAG
        circlePaintFill.color = mainColor
        circlePaintFill.style = Paint.Style.FILL

        arcPaint = Paint()
        arcPaint.flags = ANTI_ALIAS_FLAG
        arcPaint.color = mainColor
        arcPaint.style = Paint.Style.STROKE
        arcPaint.strokeCap = Paint.Cap.ROUND //圆头
        arcPaint.strokeWidth = 15.0f

        sunPaint = Paint()
        sunPaint.flags = ANTI_ALIAS_FLAG
        sunPaint.color = mainSunRectColor
        sunPaint.style = Paint.Style.FILL

        sunShadowPaint = Paint()
        sunShadowPaint.flags = ANTI_ALIAS_FLAG
        sunShadowPaint.color = mainSunShadowColor
        sunShadowPaint.style = Paint.Style.FILL

        cloudPaint = Paint()
        cloudPaint.flags = ANTI_ALIAS_FLAG
        cloudPaint.color = Color.WHITE
        cloudPaint.style = Paint.Style.FILL
    }

    private var isReRunAni = true  //是否需要开启动画  开启后不再开启
    private var count: Int = 0 //动画执行到了第几段了
    private var isCanvasCloud = false

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        when (count) {
            0, 1 -> { //圆环动画
                canvas.drawCircle(
                    (width / 2).toFloat(),
                    (height / 2).toFloat(),
                    circleRadius,
                    circlePaintFill
                )  //开始圆环 开始为0
                createCircleRang(canvas, circleRadiusWhite)
                if (isReRunAni) {
                    isReRunAni = false
                    //中间层大圆实心
                    count = 1
                    startAnimationOrange()
                }
            }
            2 -> { //圆弧动画

                val raduiusArc = width / 4  //半径  直径 width/2

                var sweepLongAngle = if (arcLongStartAngle >= 0.0f) {
                    340.0f - (270.0f - arcLongStartAngle)
                } else {
                    90.0f - Math.abs(arcLongStartAngle)
                }

                canvas.drawArc(
                    RectF(
                        (width / 4 + raduiusArc / 2).toFloat(),
                        (height / 2 - raduiusArc / 2).toFloat(),
                        (width / 2 + raduiusArc / 2).toFloat(),
                        (height / 2 + raduiusArc / 2).toFloat()
                    ), arcLongStartAngle, sweepLongAngle, false, arcPaint
                )

                canvas.drawArc(
                    RectF(
                        (width / 4 + raduiusArc / 2 + 40).toFloat(),
                        (height / 2 - raduiusArc / 2 + 40).toFloat(),
                        (width / 2 + raduiusArc / 2 - 40).toFloat(),
                        (height / 2 + raduiusArc / 2 - 40).toFloat()
                    ), arcShortStartAngle, 300.0f - arcShortStartAngle, false, arcPaint
                )
            }

            3 -> { //开始绘制太阳
                canvas.drawCircle(
                    (width / 2).toFloat(),
                    (height / 2).toFloat(),
                    circleSunRadius,
                    circlePaintFill
                )
            }

            4 -> { //绘制太阳的两个正方形  同时绘制椭圆阴影

                val left: Float = width / 2 - sunRectSize
                val top: Float = height / 2 - sunRectSize
                val right: Float = width / 2 + sunRectSize
                val bottom: Float = height / 2 + sunRectSize

                //设置线性渐变范围
                val linearGradient = LinearGradient(
                    left, top, right, bottom,
                    Color.parseColor("#FFEE58"),
                    Color.parseColor("#FF8F00"),
                    Shader.TileMode.CLAMP
                )
                sunPaint.shader = linearGradient

                canvas.save()  //保存之前状态

                val rect = Rect(left.toInt(), top.toInt(), right.toInt(), bottom.toInt())

//                //先旋转画布 45度开始
                if (sunRectRoate > 0.0f) {
                    Log.e("当前旋转中", "$sunRectRoate")
                }
                canvas.rotate(sunRectRoate, (width / 2).toFloat(), (height / 2).toFloat())  //旋转动画
                canvas.drawRect(rect, sunPaint)
                canvas.rotate(45.0f, (width / 2).toFloat(), (height / 2).toFloat())
                canvas.drawRect(rect, sunPaint)
                canvas.restore() //恢复保存的状态

                //绘制一次圆形再次
                canvas.drawCircle(
                    (width / 2).toFloat(),
                    (height / 2).toFloat(),
                    circleSunRadius,
                    circlePaintFill
                )
                val sunRectDiagonalLeng = Math.sqrt(((width / 2 * width / 2) * 2).toDouble()) / 2 //半个对角线长度
                val ovalF = RectF(
                    width / 2 - sunShadowR,
                    (height / 2 + sunRectDiagonalLeng + 80).toFloat(),
                    width / 2 + sunShadowR,
                    (height / 2 + sunRectDiagonalLeng + 25).toFloat()
                )
                canvas.drawOval(ovalF, sunShadowPaint) //绘制椭圆形阴影


                //绘制云朵 五朵
                //五个圆环,定义圆环半径 r1= sunR/4 , r2= 3r1/4 , r3=r1/2 , r4 = r1 , r5=r2
                // (width / 16)
                if (isCanvasCloud) {
                    canvas.drawCircle(
                        (width / 2).toFloat(),
                        (height / 2 + width / 20).toFloat(),
                        cloudCircleRadius,
                        cloudPaint
                    )

                    canvas.drawCircle(
                        (width / 2).toFloat() + (width / 14),
                        (height / 2 + width / 20).toFloat(),
                        cloudCircleRadius * 3 / 4,
                        cloudPaint
                    )

                    canvas.drawCircle(
                        (width / 2).toFloat() + (width / 14) + (width / 15),
                        (height / 2 + width / 20).toFloat(),
                        cloudCircleRadius / 2,
                        cloudPaint
                    )

                    canvas.drawCircle(
                        (width / 2).toFloat() + (width / 14) / 2,
                        (height / 2 + width / 20 / 4).toFloat(),
                        cloudCircleRadius,
                        cloudPaint
                    )

                    canvas.drawCircle(
                        (width / 2).toFloat() + (width / 14) + (width / 15) / 2,
                        (height / 2 + width / 20 / 4).toFloat(),
                        cloudCircleRadius / 2,
                        cloudPaint
                    )
//                    canvas.save()
//                    //矩形裁剪
//                    canvas.clipRect(
//                        Rect(
//                            width / 2 - width / 16,
//                            height / 2 + width / 20,
//                            width / 2 + width / 14 + width / 15 + width / 16 / 2,
//                            height / 2 + width / 20 + width / 16
//                        )
//                    )
//                    canvas.restore()
                    canvas.drawRect(
                        Rect(
                            width / 2 - width / 16,
                            height / 2 + width / 20 + width / 20 / 2,
                            width / 2 + width / 14 + width / 15 + width / 16 / 2,
                            height / 2 + width / 20 + width / 16
                        ), circlePaintFill
                    )
                }
            }
        }
    }

    private fun startAnimationOrange() {
        val animationOrange = ObjectAnimator.ofFloat(this, "circleRadius", 0.0f, (width / 4).toFloat())
        animationOrange.duration = 400
        animationOrange.interpolator = interpolatorList[4] //BounceInterpolator
        animationOrange.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                //留出一个外环圆来
                startAnimationWhite()
            }
        })
        animationOrange.start()
    }

    private fun startAnimationWhite() {
        val animationWhite =
            ObjectAnimator.ofFloat(
                this, "circleRadiusWhite",
                circleRadiusWhite, (width / 4).toFloat() - 10.0f
            )
        animationWhite.duration = 200
        animationWhite.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                //清空画布中的两个圆
                setCircleRadiusWhite(0.0f)
                setCircleRadius(0.0f)
                startAnimationArc()
            }
        })
        animationWhite.start()
    }

    private fun startAnimationArc() {
        count = 2
        val animationArcLong = ObjectAnimator.ofFloat(this, "ArcLongStartAngle", 250.0f, -90.0f)
        val animationArcShort = ObjectAnimator.ofFloat(this, "ArcShortStartAngle", 0.0f, 300.0f)
        val set = AnimatorSet()
        set.duration = 400
        set.playTogether(animationArcLong, animationArcShort)
        set.interpolator = interpolatorList[6] //DecelerateInterpolator
        set.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                showSunAnimation()
            }
        })
        set.start()
    }

    /**
     * 显示太阳动画  同时伴随着有阴影的显示
     */
    private fun showSunAnimation() {
        count = 3
        val animationSunCircle = ObjectAnimator.ofFloat(this, "circleSunRadius", 0.0f, (width / 4).toFloat())
        animationSunCircle.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                count = 4  //标识绘制太阳矩形
            }
        })

        val sunRectDiagonalLeng = Math.sqrt(((width / 2 * width / 2) * 2).toDouble()) / 2 //半个对角线长度
        //变化方块大小
        val animaionSunRect = ObjectAnimator.ofFloat(this, "sunRectSize", 0.0f, (width / 4).toFloat())
        //变化阴影大小
        val animationSunShadowAni = ObjectAnimator.ofFloat(this, "sunShadowR", 0.0f, sunRectDiagonalLeng.toFloat())
        val setTogether = AnimatorSet()
        setTogether.duration = 1000
        setTogether.interpolator = interpolatorList[4]
        setTogether.playTogether(animaionSunRect, animationSunShadowAni)
        setTogether.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                isCanvasCloud = true
                showCloudAndRoateAni()
            }
        })

        val set = AnimatorSet()
        set.duration = 300
        set.playSequentially(animationSunCircle, setTogether)
        set.start()
    }

    /**
     * 云显示动画以及旋转大太阳动画
     */
    private fun showCloudAndRoateAni() {
        //定义属性动画修改半径
        val aniCloudCircle = ObjectAnimator.ofFloat(this, "cloudCircleRadius", 0.0f, (width / 16).toFloat())
        aniCloudCircle.duration = 1000

        val animaionSunRectRoate = ObjectAnimator.ofFloat(this, "sunRectRoate", 0.0f, 500000000.0f) //转吧
        animaionSunRectRoate.repeatCount = -1
        animaionSunRectRoate.repeatMode = ValueAnimator.RESTART
        animaionSunRectRoate.duration = 5000000

        val set = AnimatorSet()
        set.playSequentially(aniCloudCircle, animaionSunRectRoate)
        set.start()
    }

    /**
     * 重新播放
     */
    private fun ReStartAni() {
        count = 1
        circleRadius = 0.0f
        circleRadiusWhite = 10.0f
        arcLongStartAngle = 250.0f
        arcShortStartAngle = 0.0f
        isCanvasCloud = false
        startAnimationOrange()
    }


    /**
     * 创建最上层小的圆环以及最大的圆环
     */
    private fun createCircleRang(canvas: Canvas, raduius: Float) {
        canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), raduius, circlePaintRang)
    }


    fun getCircleRadius(): Float {
        return circleRadius
    }

    fun setCircleRadius(circleRadius: Float) {
        this.circleRadius = circleRadius
        postInvalidate()
    }


    fun getCircleRadiusWhite(): Float {
        return circleRadiusWhite
    }

    fun setCircleRadiusWhite(circleRadiusWhite: Float) {
        this.circleRadiusWhite = circleRadiusWhite
        postInvalidate()
    }


    fun getArcLongStartAngle(): Float {
        return arcLongStartAngle
    }

    fun setArcLongStartAngle(arcLongStartAngle: Float) {
        this.arcLongStartAngle = arcLongStartAngle
        postInvalidate()
    }


    fun getArcShortStartAngle(): Float {
        return arcShortStartAngle
    }

    fun setArcShortStartAngle(arcShortStartAngle: Float) {
        this.arcShortStartAngle = arcShortStartAngle
        postInvalidate()
    }

    fun getCircleSunRadius(): Float {
        return circleSunRadius
    }

    fun setCircleSunRadius(circleSunRadius: Float) {
        this.circleSunRadius = circleSunRadius
        postInvalidate()
    }

    fun getSunRectSize(): Float {
        return sunRectSize
    }

    fun setSunRectSize(sunRectSize: Float) {
        this.sunRectSize = sunRectSize
        postInvalidate()
    }


    fun getSunShadowR(): Float {
        return sunShadowR
    }

    fun setSunShadowR(sunShadowR: Float) {
        this.sunShadowR = sunShadowR
    }

    fun getSunRectRoate(): Float {
        return sunRectRoate
    }

    fun setSunRectRoate(sunRectRoate: Float) {
        this.sunRectRoate = sunRectRoate
        postInvalidate()
    }


    fun getCloudCircleRadius(): Float {
        return cloudCircleRadius
    }

    fun setCloudCircleRadius(cloudCircleRadius: Float) {
        this.cloudCircleRadius = cloudCircleRadius
        postInvalidate()
    }


}