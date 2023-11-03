package com.example.framelayoutverticalalignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<MyFrameLayout>(R.id.frame_layout_1).name = "FrameLayout1"
        findViewById<MyFrameLayout>(R.id.frame_layout_2).name = "FrameLayout2"
        findViewById<MyFrameLayout>(R.id.frame_layout_3).name = "FrameLayout3"
        findViewById<MyFrameLayout>(R.id.frame_layout_4).name = "FrameLayout4"
    }
}
