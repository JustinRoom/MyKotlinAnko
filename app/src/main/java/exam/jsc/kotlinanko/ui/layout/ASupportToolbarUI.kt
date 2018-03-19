package exam.jsc.kotlinanko.ui.layout

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import exam.jsc.kotlinanko.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.navigationIconResource


/**
 * Created on 2018/3/16.
 * @author jsc
 */
open class ASupportToolbarUI {
    lateinit var toolbar: Toolbar
    fun <T : AppCompatActivity> initToolbar(v: ViewGroup, ui: AnkoContext<T>): View = with(v) {
        frameLayout {
            include<View>(R.layout.support_toolbar) {
                toolbar = find(R.id.toolbar)
                toolbar.navigationIconResource = R.drawable.ic_arrow_back_white_24dp
                ui.owner.setSupportActionBar(toolbar)
                toolbar.setNavigationOnClickListener {
                    ui.owner.finish()
                }
            }.lparams(width = matchParent, height = matchParent)
        }
    }

    inline fun <T : AppCompatActivity> setSupportActionBar(activity: T, title: CharSequence? = "") {
        activity.title = title
        activity.supportActionBar?.title = title
    }

    fun getActionBarSize(context: Context): Int {
        val typedValue = TypedValue()
        val attribute = intArrayOf(android.R.attr.actionBarSize)
        val array = context.obtainStyledAttributes(typedValue.resourceId, attribute)
        val value = array.getDimensionPixelSize(0, 0)
        array.recycle()
        return value
    }
}