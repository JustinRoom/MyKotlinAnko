package exam.jsc.kotlinanko.ui.activity

import android.os.Bundle
import exam.jsc.kotlinanko.R
import exam.jsc.kotlinanko.ui.fragment.FragmentT
import exam.jsc.kotlinanko.ui.layout.FragmentTemplateUI
import org.jetbrains.anko.setContentView

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class FragmentTemplateActivity : ABaseActivity() {
    val ui = FragmentTemplateUI()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui.setContentView(this)
        ui.setSupportActionBar(this, getCusTitle())
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, FragmentT()).commit()
    }
}