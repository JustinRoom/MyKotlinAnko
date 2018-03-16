package exam.jsc.kotlinanko.ui.layout

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import exam.jsc.kotlinanko.R
import org.jetbrains.anko.appcompat.v7.navigationIconResource
import org.jetbrains.anko.find
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.include
import org.jetbrains.anko.matchParent


/**
 * Created on 2018/3/16.
 * @author jsc
 */
open class ASupportToolbarUI {
    lateinit var toolbar: Toolbar
    fun initToolbar(v: ViewGroup): View = with(v) {
        frameLayout {
            include<View>(R.layout.support_toolbar){
                toolbar = find(R.id.toolbar)
                toolbar.navigationIconResource = R.drawable.ic_arrow_back_white_24dp
            }.lparams(width = matchParent, height = matchParent)
        }
    }

    fun <T: AppCompatActivity>setSupportActionBar(title:CharSequence, activity: T, naviListener:View.OnClickListener?, menuListener:Toolbar.OnMenuItemClickListener?){
        toolbar.title = title
        activity.setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener(naviListener)
        toolbar.setOnMenuItemClickListener(menuListener)
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