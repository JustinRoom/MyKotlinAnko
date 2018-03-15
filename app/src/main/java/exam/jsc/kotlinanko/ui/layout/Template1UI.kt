package exam.jsc.kotlinanko.ui.layout

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import exam.jsc.kotlinanko.ui.activity.Template1Activity
import jsc.kit.archeaderview.ArcHeaderDrawable
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class Template1UI : AnkoComponent<Template1Activity> {
    override fun createView(ui: AnkoContext<Template1Activity>): View = with(ui) {
        verticalLayout {
            fitsSystemWindows = true

            textView("ArcHeaderDrawable:") {
                textColor = 0xff333333.toInt()
                leftPadding = dip(16)
                topPadding = dip(4)
                bottomPadding = dip(4)
            }
            val bitmap: Bitmap = BitmapFactory.decodeStream(assets.open("img/6.jpg"))
            val picView = imageView {
                scaleType = ImageView.ScaleType.CENTER_CROP
            }.lparams(width = matchParent, height = dip(240))

            frameLayout {
                verticalLayout {
                    orientation = LinearLayout.HORIZONTAL
                    button("up"){
                        onClick {
                            val drawable = ArcHeaderDrawable(dip(30), 0, bitmap)
                            picView.setImageDrawable(drawable)
                        }
                    }
                    button("down"){
                        onClick {
                            val drawable = ArcHeaderDrawable(dip(30), 1, bitmap)
                            picView.setImageDrawable(drawable)
                        }
                    }
                }.lparams(width = wrapContent, height = wrapContent){
                    gravity = Gravity.CENTER
                }
            }.lparams(width = matchParent, height = matchParent)
        }
    }
}