package exam.jsc.kotlinanko.ui.layout

import android.view.View
import exam.jsc.kotlinanko.ui.activity.Template1Activity
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class Template1UI : AnkoComponent<Template1Activity> {
    override fun createView(ui: AnkoContext<Template1Activity>): View = with(ui) {
        verticalLayout {
            val activity = ui.owner
            fitsSystemWindows = true
            activity.tvUser = textView("Justin")
            activity.tvEmail = textView("1006368252@qq.com")
        }
    }
}