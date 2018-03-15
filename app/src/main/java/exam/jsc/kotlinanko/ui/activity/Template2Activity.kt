package exam.jsc.kotlinanko.ui.activity

import android.os.Bundle
import android.widget.TextView
import exam.jsc.kotlinanko.ui.layout.Template2UI

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class Template2Activity : ABaseActivity() {
    lateinit var tvUser: TextView
    lateinit var tvEmail: TextView

    private val template2UI: Template2UI = Template2UI()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(template2UI.bind(this))

    }

    override fun onDestroy() {
        super.onDestroy()
        template2UI.unbind(this)
    }
}