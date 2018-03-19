package exam.jsc.kotlinanko.ui.activity.component

import android.os.Bundle
import exam.jsc.kotlinanko.ui.activity.ABaseActivity
import exam.jsc.kotlinanko.ui.layout.componet.JSCItemLayoutUI
import org.jetbrains.anko.setContentView

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class JSCItemLayoutActivity: ABaseActivity() {

    val ui = JSCItemLayoutUI()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui.setContentView(this)
        ui.setSupportActionBar(this, getCusTitle())
    }
}