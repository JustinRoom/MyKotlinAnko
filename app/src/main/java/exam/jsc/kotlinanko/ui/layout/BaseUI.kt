package exam.jsc.kotlinanko.ui.layout

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import exam.jsc.kotlinanko.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.navigationIconResource

/**
 * Created on 2018/3/16.
 * @author jsc
 */
abstract class BaseUI<in T : AppCompatActivity> : AnkoComponent<T> {
    lateinit var toolbar: Toolbar

    override fun createView(ui: AnkoContext<T>): View = with(ui){
        verticalLayout {
            createToolbar(this)
            createContentView(this).lparams(matchParent, matchParent)
        }
    }

    fun getActionBarSize(context: Context): Int {
        val typedValue = TypedValue()
        val attribute = intArrayOf(android.R.attr.actionBarSize)
        val array = context.obtainStyledAttributes(typedValue.resourceId, attribute)
        val value = array.getDimensionPixelSize(0, 0)
        array.recycle()
        return value
    }

    fun <T : AppCompatActivity> setSupportActionBar(activity: T, title: CharSequence? = "") {
        toolbar.title = title
        activity.setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            activity.finish()
        }
    }

    private fun createToolbar(layout: LinearLayout):View {
        val toolbarLayout = LayoutInflater.from(layout.context).inflate(R.layout.support_toolbar, layout)
        toolbar = toolbarLayout.find(R.id.toolbar)
        toolbar.navigationIconResource = R.drawable.ic_arrow_back_white_32dp
        toolbar.title = "Title"
        return toolbarLayout
    }

    abstract fun createContentView(layout: LinearLayout):View
}