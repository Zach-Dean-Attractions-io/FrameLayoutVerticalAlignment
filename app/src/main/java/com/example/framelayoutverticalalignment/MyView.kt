package com.example.framelayoutverticalalignment

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View

class MyView(context: Context, attrs: AttributeSet): View(context, attrs) {

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        Log.d("AlignmentTesting", "MyView | left: $left, top: $top, right: $right, bottom: $bottom")
        super.onLayout(changed, left, top, right, bottom)
    }

}
