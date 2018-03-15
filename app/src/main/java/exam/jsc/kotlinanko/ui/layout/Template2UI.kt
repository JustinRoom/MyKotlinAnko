package exam.jsc.kotlinanko.ui.layout

import android.view.View
import exam.jsc.kotlinanko.ui.activity.Template2Activity
import org.jetbrains.anko.UI
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class Template2UI : ViewBinder<Template2Activity> {
    override fun bind(t: Template2Activity): View {
        return t.UI {
            verticalLayout {
                fitsSystemWindows = true
                t.tvUser = textView("Justin")
                t.tvEmail = textView("1006368252@qq.com")
            }
        }.view
    }

    override fun unbind(t: Template2Activity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}