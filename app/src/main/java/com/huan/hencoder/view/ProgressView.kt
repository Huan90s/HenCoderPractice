package com.huan.hencoder.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.widget.ImageView
import java.util.jar.Attributes

/**
 * Created by huan on 2018/3/13.
 */

class ProgressView : ImageView{

    val RADIUS: Float = 10f

    var progress: Float = 0f
        set(value) {
            field = value
            invalidate()
        }

    var color: Int = 0
        set(value) {
            field = value
            invalidate()
        }

    var position: PointF = PointF()
        set(value) {
            field = value
            invalidate()
        }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet): super(context,attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var paint = Paint()
        paint.color = Color.BLUE
        paint.strokeWidth = 6f
        paint.isAntiAlias = false
        paint.style = Paint.Style.STROKE

        canvas.drawArc(0f,0f, width.toFloat(), height.toFloat(),90f, progress,false,paint)


        canvas.drawCircle(RADIUS + position.x, RADIUS + position.y, RADIUS, paint)


        setBackgroundColor(color)

    }
}
