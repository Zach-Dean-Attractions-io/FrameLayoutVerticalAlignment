package com.example.framelayoutverticalalignment

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.FrameLayout

class MyFrameLayout(context: Context, attrs: AttributeSet): FrameLayout(context, attrs) {

    var name = ""

    /**
     * In the case of MyFrameLayout3. In `FrameLayout.java` lines 317-330 the switch statement
     * falls into Gravity.CENTER_VERTICAL case and we have (on a 2.625 density display):
     *
     * 0dp      = 0dp       + (60dp         - 0dp       - 40dp    ) / 2 + 0dp            - 10dp       ; (dp)
     * 0px      = 0px       + (158px        - 0px       - 105px   ) / 2 + 0px            - 26px       ; (pixels)
     * childTop = parentTop + (parentBottom - parentTop - height) / 2 + lp.topMargin - lp.bottomMargin;
     *
     * Whereas we would expect the top to be 5dp or 13px
     *
     * The formula should be
     * childTop = parentTop + (parentBottom - parentTop - height) / 2 + lp.topMargin / 2 - lp.bottomMargin / 2;
     *          = parentTop + (parentBottom - parentTop + lp.topMargin - lp.bottomMargin - height) / 2;
     *          = parentTop + topMargin + (parentBottom - parenTop - lp.topMargin - lp.bottomMargin - height) / 2;
     *
     * Why?
     *
     * The parent view has height `parentBottom - parentTop`
     * The child view has height `height`, top margin `lp.topMargin` & bottom margin `lp.bottomMargin`
     *
     * If we define remainingSpace = parentBottom - parentTop - lp.topMargin - lp.bottomMargin
     * then this is the remaining space within the parent view after the child view's margins have been accounted for.
     *
     * If the child view's height is less than or equal to the remaining space then it's top position will be:
     * childTop = parentTop + topMargin + (remainingSpace - height) / 2;
     *          = parentTop + topMargin + (parentBottom - parentTop - lp.topMargin - lp.bottomMargin - height) / 2;
     *          = parentTop + (parentBottom - parentTop - height) / 2 + lp.topMargin / 2 - lp.bottomMargin / 2;
     *
     * If the child view's height is greater than the remaining space then I'm unsure of the desired behaviour.
     */

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        Log.d("AlignmentTesting", "*".repeat(50))
        Log.d("AlignmentTesting", "$name | left: $left, top: $top, right: $right, bottom: $bottom")
        super.onLayout(changed, left, top, right, bottom)
    }

}
