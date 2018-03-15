package exam.jsc.kotlinanko.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger

/**
 * Created on 2018/3/14.
 * @author jsc
 */
abstract class ABaseActivity : AppCompatActivity(), AnkoLogger {

    val logger = AnkoLogger(javaClass.simpleName)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = javaClass.simpleName.replace("Activity", "")
    }

}