package com.huan.hencoder

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.TypeEvaluator
import android.graphics.Point
import android.graphics.PointF
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.huan.hencoder.view.ProgressView

class ObjectAnimActivity : AppCompatActivity() {

    private var ivLauncher: ImageView? = null

    private var mProgressView: ProgressView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_anim)
        ivLauncher = findViewById<ImageView>(R.id.ivLauncher)
        ObjectAnimator.ofFloat(ivLauncher,"translationX", 200f).setDuration(1500).start();


        mProgressView = findViewById<ProgressView>(R.id.mProgressView)
        ObjectAnimator.ofFloat(mProgressView, "progress",270f).setDuration(2000).start()



        val animator = ObjectAnimator.ofInt(mProgressView, "color", 0xffff0000.toInt(),0xff00ff00.toInt()).setDuration(1500)
        animator.setEvaluator(ArgbEvaluator())
        animator.start()

        //自定义TypeEvaluator
        ObjectAnimator.ofObject(mProgressView, "position",PointEvaluator(),
                PointF(0f,0f), PointF(100f,200f)).setDuration(1500).start()


    }

    class PointEvaluator : TypeEvaluator<PointF>{
        override fun evaluate(fraction: Float, startValue: PointF, endValue: PointF): PointF {
            var x: Float = (endValue.x - startValue.x) * fraction.plus(startValue.x)
            var y: Float = (endValue.y - startValue.y) * fraction.plus(startValue.y)

            return PointF(x,y)

        }

    }
}
