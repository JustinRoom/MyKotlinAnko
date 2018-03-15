package jsc.kit.test

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.LinearLayout
import org.jetbrains.anko.textView

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class CusLayout : LinearLayout {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        orientation = LinearLayout.HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        with(this) {
            textView("View")
            textView("Button")
            textView("Text")
        }
    }
}