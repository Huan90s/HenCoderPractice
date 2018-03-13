package com.huan.hencoder

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * lamda 表达式
         */
        findViewById<Button>(R.id.objectBtn).setOnClickListener {
            val intent = Intent(this, ObjectAnimActivity::class.java)
            startActivity(intent)
        }

        /**
         * 对象表达式
         */
        findViewById<Button>(R.id.objectBtn).setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(this@MainActivity, ObjectAnimActivity::class.java)
                startActivity(intent)
            }

        })


    }
}
