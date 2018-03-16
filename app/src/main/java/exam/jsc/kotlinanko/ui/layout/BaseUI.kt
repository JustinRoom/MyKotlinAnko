package exam.jsc.kotlinanko.ui.layout

import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.LinearLayout
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.verticalLayout

/**
 * Created on 2018/3/16.
 * @author jsc
 */
abstract class BaseUI<in T : AppCompatActivity> : AnkoComponent<T>, ASupportToolbarUI() {
    override fun createView(ui: AnkoContext<T>): View = with(ui) {
        verticalLayout {
            fitsSystemWindows = true
            initToolbar(this).lparams(width = matchParent, height = getActionBarSize(context))
            createContentView(ui, this).lparams(width = matchParent, height = matchParent)
        }
    }

    abstract fun createContentView(ui: AnkoContext<T>, root: LinearLayout): View
}