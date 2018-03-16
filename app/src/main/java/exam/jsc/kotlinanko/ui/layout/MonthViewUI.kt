package exam.jsc.kotlinanko.ui.layout

import android.view.View
import android.widget.LinearLayout
import exam.jsc.kotlinanko.ui.activity.MonthViewActivity
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.verticalLayout

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class MonthViewUI : BaseUI<MonthViewActivity>() {
    override fun createContentView(ui: AnkoContext<MonthViewActivity>, root: LinearLayout): View = with(root) {
        verticalLayout {

        }
    }

}