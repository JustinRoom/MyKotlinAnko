package exam.jsc.kotlinanko.ui.activity

import android.os.Bundle
import android.view.View
import exam.jsc.kotlinanko.ui.layout.Template2UI
import org.jetbrains.anko.setContentView

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class Template2Activity : ABaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val template2UI = Template2UI()
        template2UI.setContentView(this)
        template2UI.setSupportActionBar(getCusTitle(), this, View.OnClickListener {
            finish()
        }, null)

    }
}