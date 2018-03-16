package exam.jsc.kotlinanko.ui.activity

import android.os.Bundle
import android.view.View
import exam.jsc.kotlinanko.R
import exam.jsc.kotlinanko.ui.layout.MainUI
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity

class MainActivity : ABaseActivity() {
    lateinit var mainUI: MainUI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainUI = MainUI(View.OnClickListener {
            when (it.id) {
                R.id.btn_template1 -> {
                    startActivity<Template1Activity>()
                }
                R.id.btn_template2 -> {
                    startActivity<Template2Activity>()
                }
                R.id.btn_fragment_template -> {
                    startActivity<FragmentTemplateActivity>()
                }
                R.id.btn_component -> {
                    startActivity<ComponentsActivity>()
                }
            }
        })
        mainUI.setContentView(this)
        mainUI.setTitle(getCusTitle())
        mainUI.setBackListener(null)
        mainUI.showBack(false)
    }
}
