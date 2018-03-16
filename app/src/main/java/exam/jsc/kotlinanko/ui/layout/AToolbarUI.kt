package exam.jsc.kotlinanko.ui.layout

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import exam.jsc.kotlinanko.R
import org.jetbrains.anko.*


/**
 * Created on 2018/3/16.
 * @author jsc
 */
open class AToolbarUI {
    lateinit var tvTitle: TextView
    lateinit var ivBack: ImageView
    lateinit var menuContainer: LinearLayout
    fun initToolbar(v: ViewGroup): View = with(v) {
        relativeLayout {
            backgroundColor = resources.getColor(R.color.colorPrimary)
            leftPadding = dip(12)
            rightPadding = dip(12)

            tvTitle = textView("Title") {
                textSize = 18f
                textColor = Color.WHITE
                gravity = Gravity.CENTER
            }.lparams(width = wrapContent, height = matchParent) {
                centerHorizontally()
            }

            ivBack = imageView {
                imageResource = R.drawable.ic_arrow_back_white_24dp
            }.lparams(width = wrapContent, height = wrapContent) {
                centerVertically()
            }

            menuContainer = verticalLayout {
                orientation = LinearLayout.HORIZONTAL
            }.lparams(width = wrapContent, height = wrapContent) {
                alignParentRight()
                centerVertically()
            }
        }
    }

    fun setTitle(title: String) {
        tvTitle.text = title
    }

    fun setMenu(menuView: View) {
        if (menuContainer.childCount > 0)
            menuContainer.removeAllViews()
        val params = LinearLayout.LayoutParams(wrapContent, wrapContent)
        params.gravity = Gravity.CENTER_VERTICAL
        menuContainer.addView(menuView, params)
    }

    fun setBackListener(listener: View.OnClickListener?) {
        ivBack.setOnClickListener(listener)
    }

    fun showBack(show: Boolean) {
        ivBack.visibility = if (show) View.VISIBLE else View.INVISIBLE
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