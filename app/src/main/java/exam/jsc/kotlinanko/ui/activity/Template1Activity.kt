package exam.jsc.kotlinanko.ui.activity

import android.os.Bundle
import android.widget.TextView
import exam.jsc.kotlinanko.ui.layout.Template1UI
import org.jetbrains.anko.setContentView

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class Template1Activity: ABaseActivity() {
    lateinit var tvUser:TextView
    lateinit var tvEmail:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Template1UI().setContentView(this)
    }
}