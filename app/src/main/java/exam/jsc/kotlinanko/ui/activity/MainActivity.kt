package exam.jsc.kotlinanko.ui.activity

import android.os.Bundle
import android.view.View
import exam.jsc.kotlinanko.R
import exam.jsc.kotlinanko.ui.layout.MainUI
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity

class MainActivity : ABaseActivity() {
    private val l = View.OnClickListener {
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
                showCustomToast("Here is the custom tips content.", actionBarSize)
            }
        }
    }
    val ui = MainUI(l)
    var actionBarSize: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui.setContentView(this)
        ui.setSupportActionBar(this, getCusTitle())
        ui.hideNavigationMenu()
        actionBarSize = ui.getActionBarSize(this)
    }

}
