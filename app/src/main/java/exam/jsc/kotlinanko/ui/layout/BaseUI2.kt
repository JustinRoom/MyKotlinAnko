package exam.jsc.kotlinanko.ui.layout

import android.content.Context
import android.os.Build
import android.support.design.widget.CoordinatorLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import exam.jsc.kotlinanko.R
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.appcompat.v7.navigationIconResource
import org.jetbrains.anko.find

/**
 * Created on 2018/3/16.
 * @author jsc
 */
abstract class BaseUI2<in T : AppCompatActivity> : AnkoComponent<T> {
    lateinit var toolbar: Toolbar

    override fun createView(ui: AnkoContext<T>): View {
        val root = CoordinatorLayout(ui.ctx)
        root.fitsSystemWindows = true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            root.elevation = 0f
        }

        val layout = LinearLayout(root.context)
        layout.orientation = LinearLayout.VERTICAL
        root.addView(layout, CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.MATCH_PARENT, CoordinatorLayout.LayoutParams.MATCH_PARENT))

        val toolbarLayout = createToolbar(ui)
        layout.addView(toolbarLayout, LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT))
        val contentView = createContentView(ui)
        layout.addView(contentView, LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT))
        return root
    }

    private fun createToolbar(ui: AnkoContext<T>): View {
        val toolbarLayout = LayoutInflater.from(ui.ctx).inflate(R.layout.support_toolbar2, null)
        toolbar = toolbarLayout.find(R.id.toolbar)
        toolbar.navigationIconResource = R.drawable.ic_arrow_back_white_24dp
        ui.owner.setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            ui.owner.finish()
        }
        return toolbarLayout
    }

    fun getActionBarSize(context: Context): Int {
        val typedValue = TypedValue()
        val attribute = intArrayOf(android.R.attr.actionBarSize)
        val array = context.obtainStyledAttributes(typedValue.resourceId, attribute)
        val value = array.getDimensionPixelSize(0, 0)
        array.recycle()
        return value
    }

    inline fun <T : AppCompatActivity> setSupportActionBar(activity: T, title: CharSequence? = "") {
        activity.title = title
        activity.supportActionBar?.title = title
    }

    abstract fun createContentView(ui: AnkoContext<T>): View
}