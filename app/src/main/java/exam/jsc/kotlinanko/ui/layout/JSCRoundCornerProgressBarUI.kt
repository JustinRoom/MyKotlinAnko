package exam.jsc.kotlinanko.ui.layout

import android.view.View
import android.widget.LinearLayout
import exam.jsc.kotlinanko.ui.activity.JSCRoundCornerProgressBarActivity
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.verticalLayout

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class JSCRoundCornerProgressBarUI : BaseUI<JSCRoundCornerProgressBarActivity>() {
    override fun createContentView(ui: AnkoContext<JSCRoundCornerProgressBarActivity>, root: LinearLayout): View = with(root) {
        verticalLayout {

        }
    }

}