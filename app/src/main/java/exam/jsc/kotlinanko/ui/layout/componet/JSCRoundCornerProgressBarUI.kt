package exam.jsc.kotlinanko.ui.layout.componet

import android.view.View
import android.widget.LinearLayout
import exam.jsc.kotlinanko.ui.activity.component.JSCRoundCornerProgressBarActivity
import exam.jsc.kotlinanko.ui.layout.BaseUI
import org.jetbrains.anko.verticalLayout

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class JSCRoundCornerProgressBarUI : BaseUI<JSCRoundCornerProgressBarActivity>() {
    override fun createContentView(layout: LinearLayout): View = with(layout) {
        verticalLayout {

        }
    }

}