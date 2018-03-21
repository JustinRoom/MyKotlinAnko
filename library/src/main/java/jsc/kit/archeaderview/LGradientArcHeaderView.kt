package jsc.kit.archeaderview

import android.content.Context
import android.graphics.LinearGradient
import android.graphics.Shader
import android.util.AttributeSet


/**
 * <p></p>
 * <br>Email:1006368252@qq.com
 * <br>QQ:1006368252
 *
 * @author jsc
 */
class LGradientArcHeaderView : BaseArcHeaderView {
    var startColor: Int = 0xFFFF3A80.toInt()
    set(value) {
        field = value
        resetShader()
        postInvalidate()
    }

    var endColor: Int = 0xFFFF3745.toInt()
    set(value) {
        field = value
        resetShader()
        postInvalidate()
    }

    override fun initShader(): Shader {
            return LinearGradient(width / 2.0f, 0f, width / 2.0f, height * 1.0f, startColor, endColor, Shader.TileMode.MIRROR)
    }

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

}