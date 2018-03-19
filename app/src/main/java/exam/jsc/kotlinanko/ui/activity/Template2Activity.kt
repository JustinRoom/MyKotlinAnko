package exam.jsc.kotlinanko.ui.activity

import android.os.Bundle
import exam.jsc.kotlinanko.ui.layout.Template2UI
import org.jetbrains.anko.setContentView

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class Template2Activity : ABaseActivity() {
    val ui = Template2UI()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui.setContentView(this)
        ui.setSupportActionBar(this, getCusTitle())

    }
}