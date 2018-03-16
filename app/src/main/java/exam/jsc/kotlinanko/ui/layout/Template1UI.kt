package exam.jsc.kotlinanko.ui.layout

import android.view.View
import exam.jsc.kotlinanko.ui.activity.Template1Activity
import org.jetbrains.anko.*

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class Template1UI : AnkoComponent<Template1Activity>, ASupportToolbarUI() {
    override fun createView(ui: AnkoContext<Template1Activity>): View = with(ui) {
        verticalLayout {
            fitsSystemWindows = true
            initToolbar(this).lparams(width = matchParent, height = getActionBarSize(context))

            textView("Justin")
            textView("1006368252@qq.com")
        }
    }
}