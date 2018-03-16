package jsc.kit.archeaderview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Shader
import android.support.annotation.IntRange
import android.util.AttributeSet
import android.view.View


/**
 * Created by Justin Qin on 3/15/2018.
 */
abstract class BaseArcHeaderView : View {
    private val path = Path()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    var arcHeight: Int = 100
    set(value) {
        field = value
        resetShader()
        postInvalidate()
    }

    @IntRange(from = 0, to = 1)
    var direction: Int = 0
    set(value) {
        field = value
        postInvalidate()
    }

    private var shader: Shader? = null

    abstract fun initShader(): Shader
    fun resetShader() {
        shader = null
    }

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        resetShader()
        postInvalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        if (shader == null)
            shader = initShader()
        paint.shader = shader
        calPath()
        canvas?.drawPath(path, paint)
    }

    private fun calPath() {
        val w = width * 1.0f
        val h = height * 1.0f
        path.reset()
        path.moveTo(0f, 0f)
        when (direction) {
            0 -> {
                path.lineTo(0f, h - arcHeight)
                path.quadTo(w / 2.0f, h + arcHeight, w, h - arcHeight)
                path.lineTo(w, 0f)
            }
            1 -> {
                path.lineTo(0f, h)
                path.quadTo(w / 2.0f, h - arcHeight * 2, w, h)
                path.lineTo(w, 0f)
            }
        }
        path.close()
    }
}