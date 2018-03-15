package exam.jsc.kotlinanko.ui.layout

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.View
import exam.jsc.kotlinanko.R
import exam.jsc.kotlinanko.ui.activity.ArcHeaderViewActivity
import jsc.kit.lGradientArcHeaderView
import jsc.kit.pictureArcHeaderView
import org.jetbrains.anko.*

/**
 * Created by Justin Qin on 3/15/2018.
 */
class ArcHeaderViewUI : AnkoComponent<ArcHeaderViewActivity> {
    override fun createView(ui: AnkoContext<ArcHeaderViewActivity>): View = with(ui) {
        verticalLayout {
            lGradientArcHeaderView {
                setColors(0xFFFF4081.toInt(), 0x22FF4081)
                setArcHeight(dip(30))
            }.lparams(width = matchParent, height = dip(180))

            pictureArcHeaderView {
//                setSrc(R.mipmap.text_picture)
                setSrc("img/6.jpg")
                setArcHeight(dip(30))
                setDirection(1)
            }.lparams(width = matchParent, height = dip(180)){
                topMargin = dip(32)
            }
        }
    }
}