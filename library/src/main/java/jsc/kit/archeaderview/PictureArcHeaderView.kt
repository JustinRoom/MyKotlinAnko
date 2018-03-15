package jsc.kit.archeaderview

import android.content.Context
import android.graphics.*
import android.support.annotation.DrawableRes
import android.util.AttributeSet
import org.jetbrains.anko.assets


/**
 * Created by Justin Qin on 3/15/2018.
 */
class PictureArcHeaderView : BaseArcHeaderView {
    private var bitmap: Bitmap? = null
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

    fun setSrc(fileName: String) {
        var options = BitmapFactory.Options()
        options.inPremultiplied = false
        setSrc(BitmapFactory.decodeStream(context.assets.open(fileName), null, options))
    }

    fun setSrc(@DrawableRes drawableId: Int) {
        setSrc(BitmapFactory.decodeResource(resources, drawableId))
    }

    fun setSrc(bitmap: Bitmap) {
        this.bitmap = bitmap;
        resetShader()
        postInvalidate()
    }

    fun getBitmap(): Bitmap? {
        return bitmap;
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