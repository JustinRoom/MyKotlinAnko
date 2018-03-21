package jsc.kit.archeaderview

import android.content.Context
import android.graphics.*
import android.support.annotation.DrawableRes
import android.util.AttributeSet


/**
 * <p></p>
 * <br>Email:1006368252@qq.com
 * <br>QQ:1006368252
 *
 * @author jsc
 */
class PictureArcHeaderView : BaseArcHeaderView {
    private var bitmap: Bitmap? = null
    var src: Any? = null
    set(value) {
        value?.let {
            when(value){
                is String ->{
                    val options = BitmapFactory.Options()
                    options.inPremultiplied = true
                    bitmap = BitmapFactory.decodeStream(context.assets.open(value), null, options)
                    update()
                }

                is @DrawableRes Int ->{
                    bitmap = BitmapFactory.decodeResource(resources, value)
                    update()
                }

                is Bitmap ->{
                    bitmap = value
                    update()
                }
            }
        }
    }

    override fun initShader(): Shader {
        if (bitmap == null)
            return LinearGradient(width / 2.0f, 0f, width / 2.0f, height * 1.0f, 0xFFF2F2F2.toInt(), 0xFFF2F2F2.toInt(), Shader.TileMode.MIRROR)

        val tempBitmap: Bitmap
        tempBitmap = if (bitmap!!.width >= width && bitmap!!.height >= height) {
            val x = (bitmap!!.width - width) / 2
            val y = (bitmap!!.height - height) / 2
            Bitmap.createBitmap(bitmap, x, y, width, height)
        } else {
            Bitmap.createScaledBitmap(bitmap, width, height, false)
        }

        return BitmapShader(tempBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
    }

    private fun update() {
        resetShader()
        postInvalidate()
    }

    fun getBitmap(): Bitmap? {
        return bitmap
    }

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        bitmap!!.recycle()
        bitmap = null
    }
}