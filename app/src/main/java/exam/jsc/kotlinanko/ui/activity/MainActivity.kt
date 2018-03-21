package exam.jsc.kotlinanko.ui.activity

import android.os.Bundle
import android.view.View
import exam.jsc.kotlinanko.R
import exam.jsc.kotlinanko.ui.layout.MainUI
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity

class MainActivity : ABaseActivity() {
    val ui = MainUI()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui.setContentView(this)
        ui.setSupportActionBar(this, getCusTitle())
        ui.hideNavigationMenu()
        ui.l = View.OnClickListener {
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
                else ->{
                    showCustomToast("Here is the custom tips content.")
                }
            }
        }
    }

}
