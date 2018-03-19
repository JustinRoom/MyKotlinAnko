package exam.jsc.kotlinanko.ui.activity.component

import android.os.Bundle
import exam.jsc.kotlinanko.ui.activity.ABaseActivity
import exam.jsc.kotlinanko.ui.layout.componet.JSCRoundCornerProgressBarUI
import org.jetbrains.anko.setContentView

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class JSCRoundCornerProgressBarActivity: ABaseActivity() {

    val ui = JSCRoundCornerProgressBarUI()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui.setContentView(this)
        ui.setSupportActionBar(this, getCusTitle())
    }
}