package exam.jsc.kotlinanko.ui.activity

import android.os.Bundle
import exam.jsc.kotlinanko.R
import exam.jsc.kotlinanko.ui.fragment.FragmentT
import org.jetbrains.anko.frameLayout

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class FragmentTemplateActivity : ABaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       frameLayout {
        id = R.id.fragment_container
       }
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, FragmentT()).commit()
    }
}