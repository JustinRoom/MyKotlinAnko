package exam.jsc.kotlinanko.ui.layout

import android.view.View
import android.widget.LinearLayout
import exam.jsc.kotlinanko.ui.activity.JSCItemLayoutActivity
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.verticalLayout

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class JSCItemLayoutUI : BaseUI<JSCItemLayoutActivity>() {
    override fun createContentView(ui: AnkoContext<JSCItemLayoutActivity>, root: LinearLayout): View = with(root) {
        verticalLayout {

        }
    }

}