package exam.jsc.kotlinanko.ui.layout

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import exam.jsc.kotlinanko.R
import exam.jsc.kotlinanko.ui.activity.ComponentsActivity
import jsc.kit.jscItemLayout
import org.jetbrains.anko.*

class ComponentsUI(var l: View.OnClickListener) : BaseUI<ComponentsActivity>() {
    private val customStyle = { v: Any ->
        when (v) {
            is TextView -> {
                v.textSize = 16f
                v.textColor = 0xFF333333.toInt()
            }
        }
    }

    override fun createContentView(ui: AnkoContext<ComponentsActivity>, root: LinearLayout): View = with(root) {
        scrollView {
            padding = dimen(R.dimen.fab_margin)
            val itemNames = listOf(
                    "ArcHeaderView",
                    "BannerView",
                    "MonthView",
                    "ReboundLayout",
                    "VerticalStepView",
                    "RefreshLayout",
                    "JSCRoundCornerProgressBar",
                    "JSCItemLayout"
            )
            val itemIds = listOf(
                    R.id.btn_arc_header_view,
                    R.id.btn_banner_view,
                    R.id.btn_month_view,
                    R.id.btn_rebound_layout,
                    R.id.btn_vertical_step_view,
                    R.id.btn_refresh_layout,
                    R.id.btn_jsc_round_corner_progress_bar,
                    R.id.btn_jsc_item_layout
            )

            verticalLayout {
                for (index in itemNames.indices) {
                    jscItemLayout {
                        id = itemIds[index]
                        leftPadding = dip(16)
                        rightPadding = dip(16)
                        topPadding = dip(12)
                        bottomPadding = dip(12)
                        backgroundResource = R.drawable.ripple_round_corner_white_r4
                        setLabel(itemNames[index])
                        setOnClickListener(l)
                    }.lparams {
                        width = matchParent
                        height = wrapContent
                        if (index > 0)
                            topMargin = dip(4)
                    }
                }
            }.lparams(width = matchParent, height = wrapContent) {

            }
        }.applyRecursively(customStyle)
    }
}