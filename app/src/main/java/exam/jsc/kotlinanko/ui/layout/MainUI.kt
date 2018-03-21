package exam.jsc.kotlinanko.ui.layout

import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import exam.jsc.kotlinanko.R
import exam.jsc.kotlinanko.ui.activity.MainActivity
import jsc.kit.ilArrow
import jsc.kit.ilDot
import jsc.kit.ilLabel
import jsc.kit.jscItemLayout
import org.jetbrains.anko.*

class MainUI: CustomBaseUI<MainActivity>() {

    private val itemNames = listOf("Template1", "Template2", "FragmentTemplate", "Component")
    private val itemIds = listOf(R.id.btn_template1, R.id.btn_template2, R.id.btn_fragment_template, R.id.btn_component)
    private val itemViews = ArrayList<View>()
    var l: View.OnClickListener? = null
    set(value) {
        field = value
        for(item in itemViews)
            item.setOnClickListener(value)
    }

    override fun createContentView(layout: LinearLayout): View = with(layout) {
        verticalLayout {
            padding = dimen(R.dimen.fab_margin)
            for (index in itemNames.indices) {
                val itemView = jscItemLayout {
                    id = itemIds[index]
                    leftPadding = dip(16)
                    rightPadding = dip(16)
                    topPadding = dip(12)
                    bottomPadding = dip(12)
                    backgroundResource = R.drawable.ripple_round_corner_white_r4
                }.ilLabel {
                    text = itemNames[index]
                    textSize = 16f
                }.ilDot {
                    if (index == itemNames.lastIndex)
                        visibility = View.VISIBLE
                }.ilArrow {
                    alpha = 0.4f
                }.lparams(matchParent, wrapContent) {
                    width = matchParent
                    height = wrapContent
                    if (index > 0)
                        topMargin = dip(4)
                }
                itemViews.add(itemView)
            }

            val button = button("showTips").lparams {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = dip(16)
            }
            itemViews.add(button)
        }
    }
}