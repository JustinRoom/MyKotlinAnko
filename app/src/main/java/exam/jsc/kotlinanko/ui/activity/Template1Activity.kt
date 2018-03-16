package exam.jsc.kotlinanko.ui.activity

import android.os.Bundle
import android.view.View
import exam.jsc.kotlinanko.ui.layout.Template1UI
import org.jetbrains.anko.setContentView

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class Template1Activity : ABaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val template1UI = Template1UI()
        template1UI.setContentView(this)
        template1UI.setSupportActionBar(getCusTitle(), this, View.OnClickListener {
            finish()
        }, null)
    }
}