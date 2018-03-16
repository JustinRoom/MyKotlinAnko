package exam.jsc.kotlinanko.ui.layout.componet

import android.view.View
import android.widget.LinearLayout
import exam.jsc.kotlinanko.ui.activity.component.ReboundLayoutActivity
import exam.jsc.kotlinanko.ui.layout.BaseUI
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