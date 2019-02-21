package com.lq.animationdemo

import android.view.View

/**
 *作者：Created by liuqian on 2019/2/15 11:43
 *描述：
 */

fun View.onClick(listener: View.OnClickListener) : View{
    setOnClickListener(listener)
    return this
}