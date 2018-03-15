package jsc.kit.archeaderview

import android.content.Context
import android.graphics.*
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.util.AttributeSet


/**
 * Created by Justin Qin on 3/15/2018.
 */
class LGradientArcHeaderView : BaseArcHeaderView {
    private var startColor: Int = 0xFFFF3A80.toInt()
    private var endColor: Int = 0xFFFF3745.toInt()
    override fun initShader(): Shader {
            return LinearGradient(width / 2.0f, 0f, width / 2.0f, height * 1.0f, startColor, endColor, Shader.TileMode.MIRROR)
    }

    fun setColors(@ColorInt startColor: Int, @ColorInt endColor: Int) {
        this.startColor = startColor
        this.endColor = endColor
        resetShader()
        postInvalidate()
    }

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

}