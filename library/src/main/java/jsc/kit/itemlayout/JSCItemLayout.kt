package jsc.kit.itemlayout

import android.content.Context
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.util.AttributeSet
import android.view.Gravity
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
class JSCItemLayout : FrameLayout, IBaseView {

    private lateinit var iconView: ImageView
    private lateinit var labelView: TextView
    private lateinit var arrowView: ImageView

    @DrawableRes
    var icon: Int = 0
        set(value) {
            field = value
            iconView.imageResource = value
        }

    var label: CharSequence? = null
        set(value) {
            field = value
            labelView.text = value
        }

    var labelTextSize: Float = 0f
        set(value) {
            if (value > 0) {
                field = value
                labelView.textSize = value
            }
        }

    @ColorInt
    var labelTextColor: Int = 0
        set(value) {
            field = value
            labelView.textColor = value
        }

    @DrawableRes
    var arrowIcon: Int = 0
        set(value) {
            field = value
            arrowView.imageResource = value
        }

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
        attrs?.let { retrieveAttributes(attrs) }
    }

    override fun init(context: Context) {
        val layout = LinearLayout(context)
        layout.orientation = LinearLayout.HORIZONTAL
        layout.gravity = Gravity.CENTER_VERTICAL
        addView(layout, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT))

        iconView = ImageView(context)
        layout.addView(iconView, LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT))

        labelView = TextView(context)
        labelView.leftPadding = dip(12)
        labelView.rightPadding = dip(12)
        labelView.maxLines = 1
        layout.addView(labelView, LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f))

        arrowView = ImageView(context)
        layout.addView(arrowView, LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT))

        //设置默认属性
        icon = R.drawable.kit_ic_assignment_blue_24dp
        arrowIcon = R.drawable.kit_ic_chevron_right_gray_24dp
        labelTextColor = 0xFF333333.toInt()
        labelTextSize = 14f
    }

    override fun retrieveAttributes(attrs: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.JSCItemLayout)
        val v1 = typedArray.getResourceId(R.styleable.JSCItemLayout_icon, 0)
        if (v1 != 0)
            icon = v1
        label = typedArray.getText(R.styleable.JSCItemLayout_label)
        labelTextSize = typedArray.getFloat(R.styleable.JSCItemLayout_label_text_size, 14f)
        labelTextColor = typedArray.getColor(R.styleable.JSCItemLayout_label_text_color, 0xff333333.toInt())
        val v2 = typedArray.getResourceId(R.styleable.JSCItemLayout_arrow_icon, 0)
        if (v2 != 0)
            arrowIcon = v2
        typedArray.recycle()
    }
}