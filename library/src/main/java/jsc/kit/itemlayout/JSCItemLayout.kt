package jsc.kit.itemlayout

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import jsc.kit.R
import jsc.kit.common.DotView
import jsc.kit.common.dotView
import org.jetbrains.anko.*


/**
 * Created on 2018/3/14.
 * @author jsc
 */
open class JSCItemLayout : FrameLayout {

    private lateinit var iconView: ImageView
    private lateinit var labelView: TextView
    private lateinit var dotView: DotView
    private lateinit var arrowView: ImageView

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() = apply {
        verticalLayout {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL

            //icon
            iconView = imageView {
                imageResource = R.drawable.kit_ic_assignment_blue_24dp
            }

            //label
            labelView = textView("Label") {
                leftPadding = dip(12)
                rightPadding = dip(12)
                textColor = 0xFF333333.toInt()
            }.lparams(0, wrapContent, 1.0f)

            //dot
            dotView = dotView {
                gravity= Gravity.CENTER
                dotColor = Color.RED
                visibility = View.INVISIBLE
                textColor = Color.WHITE
                textSize = 8.0f
            }.lparams(dip(8), dip(8))

            //arrow
            arrowView = imageView {
                imageResource = R.drawable.kit_ic_chevron_right_gray_24dp
            }
        }
    }

    fun getIconView(): ImageView = iconView
    fun getLabelView(): TextView = labelView
    fun getDotView(): DotView = dotView
    fun getArrowView(): ImageView = arrowView
}