package exam.jsc.kotlinanko.ui.activity

import android.os.Bundle
import android.view.View
import exam.jsc.kotlinanko.ui.layout.VerticalStepViewUI
import org.jetbrains.anko.setContentView

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class VerticalStepViewActivity: ABaseActivity() {

    val ui = VerticalStepViewUI()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui.setContentView(this)
        ui.setSupportActionBar(getCusTitle(), this, View.OnClickListener {
            finish()
        }, null)
    }
}