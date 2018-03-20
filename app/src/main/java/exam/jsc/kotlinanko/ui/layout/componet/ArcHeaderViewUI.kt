package exam.jsc.kotlinanko.ui.layout.componet

import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import exam.jsc.kotlinanko.ui.activity.component.ArcHeaderViewActivity
import exam.jsc.kotlinanko.ui.layout.BaseUI
import jsc.kit.archeaderview.lGradientArcHeaderView
import jsc.kit.archeaderview.pictureArcHeaderView
import org.jetbrains.anko.button
import org.jetbrains.anko.dip
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.verticalLayout

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class ArcHeaderViewUI : BaseUI<ArcHeaderViewActivity>() {

    override fun createContentView(layout: LinearLayout): View = with(layout) {
        verticalLayout {
            val headerView = lGradientArcHeaderView {
                startColor = 0xffFF4081.toInt()
                endColor = 0x22FF4081
                arcHeight = dip(30)
            }.lparams(width = matchParent, height = dip(180))

            button("change_color") {
                onClick {
                    headerView.startColor = 0xff3F51B5.toInt()
                }
            }.lparams() {
                topMargin = dip(16)
                gravity = Gravity.CENTER_HORIZONTAL
            }

            pictureArcHeaderView {
                src = "img/6.jpg"
                arcHeight = dip(30)
                direction = 1
            }.lparams(width = matchParent, height = dip(180))
        }
    }
}