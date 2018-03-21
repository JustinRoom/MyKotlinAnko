package jsc.kit.common

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.support.annotation.ColorInt
import android.util.AttributeSet
import android.widget.TextView

/**
 * <p></p>
 * <br>Email:1006368252@qq.com
 * <br>QQ:1006368252
 *
 * @author jsc
 */
class DotView : TextView {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    @ColorInt
    var dotColor:Int = 0
    set(value) {
        field = value
        postInvalidate()
    }

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        paint.color = dotColor
        paint.style = Paint.Style.FILL
        canvas?.drawCircle(width/2.0f, height / 2.0f, width / 2.0f, paint)
        super.onDraw(canvas)
    }
}