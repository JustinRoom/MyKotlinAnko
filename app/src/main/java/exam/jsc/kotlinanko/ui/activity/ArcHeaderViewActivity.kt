package exam.jsc.kotlinanko.ui.activity

import android.os.Bundle
import exam.jsc.kotlinanko.ui.layout.ArcHeaderViewUI
import org.jetbrains.anko.setContentView

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class ArcHeaderViewActivity: ABaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ArcHeaderViewUI().setContentView(this)
    }
}