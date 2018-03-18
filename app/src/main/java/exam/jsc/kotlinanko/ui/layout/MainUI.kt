package exam.jsc.kotlinanko.ui.layout

import android.graphics.Color
import android.view.Gravity
import android.view.View
import exam.jsc.kotlinanko.R
import exam.jsc.kotlinanko.ui.activity.MainActivity
import jsc.kit.*
import org.jetbrains.anko.*

class MainUI(val l:View.OnClickListener?): AnkoComponent<MainActivity>, AToolbarUI() {

    constructor():this(null)

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            fitsSystemWindows = true
            initToolbar(this).lparams(width = matchParent, height = getActionBarSize(context))

            val itemNames = listOf("Template1", "Template2", "FragmentTemplate", "Component")
            val itemIds = listOf(R.id.btn_template1, R.id.btn_template2, R.id.btn_fragment_template, R.id.btn_component)
            verticalLayout {
                padding = dimen(R.dimen.fab_margin)
                for (index in itemNames.indices) {
                    jscItemLayout() {
                        id = itemIds[index]
                        leftPadding = dip(16)
                        rightPadding = dip(16)
                        topPadding = dip(8)
                        bottomPadding = dip(8)
                        backgroundResource = R.drawable.ripple_round_corner_white_r4
                        label =itemNames[index]
                        setOnClickListener(l)
                    }.lparams {
                        width = matchParent
                        height = wrapContent
                        if (index > 0)
                            topMargin = dip(4)
                    }
                }

                myItemLayout {
                    leftPadding = dip(16)
                    rightPadding = dip(16)
                    topPadding = dip(8)
                    bottomPadding = dip(8)
                    backgroundResource = R.drawable.ripple_round_corner_white_r4
                }.ilIcon {
                    imageResource = R.drawable.kit_ic_assignment_blue_24dp
                }.ilLabel {
                    text = "MyItemLayout\nHello, \u3000Justin"
                    textColor = Color.BLUE
                    textSize = 12f
                }.ilArrow {
                    imageResource= R.drawable.kit_ic_chevron_right_gray_24dp
                    alpha = 0.4f
                }.lparams(matchParent, wrapContent){
                    topMargin = dip(4)
                }
            }.lparams(width = matchParent, height = wrapContent) {

            }
        }
    }
}