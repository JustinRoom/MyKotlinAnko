package exam.jsc.kotlinanko.ui.layout

import android.graphics.BitmapFactory
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import exam.jsc.kotlinanko.R
import exam.jsc.kotlinanko.ui.activity.Template1Activity
import jsc.kit.archeaderview.ArcHeaderDrawable
import org.jetbrains.anko.*

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class Template1UI : BaseUI2<Template1Activity>() {
    override fun createContentView(ui: AnkoContext<Template1Activity>): View {
        return LinearLayout(ui.ctx).apply {
            orientation = LinearLayout.VERTICAL
            textView("Justin")
            textView("1006368252@qq.com")

            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.text_picture)
            val drawable = ArcHeaderDrawable(dip(30), bitmap)
            imageView {
                scaleType = ImageView.ScaleType.CENTER_CROP
                setImageDrawable(drawable)
            }
        }
    }
}