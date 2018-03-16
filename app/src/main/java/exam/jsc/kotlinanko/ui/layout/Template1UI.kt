package exam.jsc.kotlinanko.ui.layout

import android.view.View
import android.widget.LinearLayout
import exam.jsc.kotlinanko.ui.activity.Template1Activity
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class Template1UI : BaseUI<Template1Activity>() {
    override fun createContentView(ui: AnkoContext<Template1Activity>, root: LinearLayout): View = with(root) {
        verticalLayout {
            textView("Justin")
            textView("1006368252@qq.com")
        }
    }

}