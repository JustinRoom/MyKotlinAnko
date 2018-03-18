package jsc.kit.itemlayout

import android.content.Context
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewManager
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import jsc.kit.IBaseView
import jsc.kit.R
import org.jetbrains.anko.*


    /**
     * Created on 2018/3/14.
     * @author jsc
     */
    open class MyItemLayout : LinearLayout {

        private lateinit var iconView: ImageView
        private lateinit var labelView: TextView
        private lateinit var arrowView: ImageView

        constructor(context: Context) : this(context, null)
        constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
        constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
            init()
        }

        private fun init() = apply{
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL

            //icon
            iconView = imageView(){
                imageResource = R.drawable.kit_ic_assignment_blue_24dp
            }
            iconView.layoutParams = LayoutParams(wrapContent, wrapContent)

            //label
            labelView = textView {
                textSize = 14f
                textColor = 0xFF333333.toInt()
                leftPadding = dip(12)
                rightPadding = dip(12)
            }
            labelView.layoutParams = LayoutParams(0, wrapContent, 1.0f)

            //arrow
            arrowView = imageView(){
                imageResource = R.drawable.kit_ic_chevron_right_gray_24dp
            }
            arrowView.layoutParams = LayoutParams(wrapContent, wrapContent)
        }

        fun getIconView(): ImageView {
            return iconView
        }

        fun getLabelView(): TextView {
            return labelView
        }

        fun getArrowView(): ImageView {
            return arrowView
        }
    }