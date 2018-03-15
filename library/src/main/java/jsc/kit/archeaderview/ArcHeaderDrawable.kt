package jsc.kit.archeaderview

import android.graphics.*
import android.graphics.drawable.Drawable
import android.support.annotation.IntRange


/**
 * @param mArcHeight
 * @param direction
 * @param bitmap
 */
class ArcHeaderDrawable(val mArcHeight: Int = 100, @IntRange(from = 0, to = 1) val direction: Int, val bitmap: Bitmap) : Drawable() {
    private val mPath: Path = Path()
    private val mPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun draw(canvas: Canvas?) {
        mPaint.shader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        calPath()
        canvas?.drawPath(mPath, mPaint)
    }

    private fun calPath() {
        mPath.reset()
        val w = intrinsicWidth * 1.0f
        val h = intrinsicHeight * 1.0f
        mPath.moveTo(0f, 0f)
        when (direction) {
            0 -> {
                mPath.lineTo(0f, h - mArcHeight)
                mPath.quadTo(w / 2.0f, h + mArcHeight, w, h - mArcHeight)
                mPath.lineTo(w, 0f)
            }
            1 -> {
                mPath.lineTo(0f, h)
                mPath.quadTo(w / 2.0f, h - mArcHeight * 2, w, h)
                mPath.lineTo(w, 0f)
            }
        }
        mPath.close()
    }

    override fun setAlpha(alpha: Int) {
        mPaint.alpha = alpha
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        mPaint.colorFilter = colorFilter
    }

    override fun getIntrinsicHeight(): Int {
        return bitmap.height
    }

    override fun getIntrinsicWidth(): Int {
        return bitmap.width
    }
}