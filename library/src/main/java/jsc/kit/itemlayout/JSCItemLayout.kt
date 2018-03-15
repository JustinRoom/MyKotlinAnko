package jsc.kit.itemlayout

import android.content.Context
import android.graphics.Color
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.util.AttributeSet
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import jsc.kit.R
import org.jetbrains.anko.*



/**
 * Created on 2018/3/14.
 * @author jsc
 */
class JSCItemLayout : FrameLayout {

    private lateinit var iconView: ImageView
    private lateinit var labelView: TextView
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
            iconView = imageView {
                imageResource = R.drawable.kit_ic_assignment_blue_24dp
            }

            labelView = textView("") {
                textColor = Color.parseColor("#333333")
                leftPadding = dip(12)
                rightPadding = dip(12)
                maxLines = 1
            }.lparams(width = matchParent, height = wrapContent, weight = 1f) {

            }

            arrowView = imageView {
                imageResource = R.drawable.kit_ic_chevron_right_gray_24dp
            }
        }
    }

    fun setIcon(@DrawableRes resId: Int) {
        iconView.imageResource = resId
    }

    fun setLabel(label: String) {
        labelView.text = label
    }

    fun setLabelColor(@ColorInt labelColor: Int) {
        labelView.textColor = labelColor
    }

    /**
     * The unit is sp.
     */
    fun setLabelSize(size: Float) {
        labelView.textSize = size
    }

    fun setArrowIcon(@DrawableRes resId: Int) {
        arrowView.imageResource = resId
    }
}