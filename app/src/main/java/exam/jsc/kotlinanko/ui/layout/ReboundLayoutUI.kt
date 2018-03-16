package exam.jsc.kotlinanko.ui.layout

import android.view.View
import android.widget.LinearLayout
import exam.jsc.kotlinanko.ui.activity.MonthViewActivity
import exam.jsc.kotlinanko.ui.activity.ReboundLayoutActivity
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.verticalLayout

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class ReboundLayoutUI : BaseUI<ReboundLayoutActivity>() {
    override fun createContentView(ui: AnkoContext<ReboundLayoutActivity>, root: LinearLayout): View = with(root) {
        verticalLayout {

        }
    }

}