package exam.jsc.kotlinanko.ui.layout

import android.view.View
import android.widget.LinearLayout
import exam.jsc.kotlinanko.R
import exam.jsc.kotlinanko.ui.activity.FragmentTemplateActivity
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.frameLayout

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class FragmentTemplateUI : BaseUI<FragmentTemplateActivity>() {
    override fun createContentView(ui: AnkoContext<FragmentTemplateActivity>, root: LinearLayout): View = with(root) {
        frameLayout {
            id = R.id.fragment_container
        }
    }

}