package exam.jsc.kotlinanko.ui.layout

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import exam.jsc.kotlinanko.R
import org.jetbrains.anko.*

/**
 * Created on 2018/3/16.
 * @author jsc
 */
abstract class CustomBaseUI<in T : AppCompatActivity> : AnkoComponent<T> {
    lateinit var toolbar: RelativeLayout
    lateinit var titleView: TextView
    lateinit var navigationView: ImageView
    lateinit var menuView: ImageView

    override fun createView(ui: AnkoContext<T>): View = with(ui){
        verticalLayout {
            fitsSystemWindows = true

            //toolbar
            toolbar = relativeLayout {
                backgroundColor = resources.getColor(R.color.colorPrimary)
                leftPadding = dip(8)
                rightPadding = dip(8)

                //title
                titleView = textView("Title"){
                    textSize = 20f
                    textColor = Color.WHITE
                    gravity = Gravity.CENTER_HORIZONTAL
                }.lparams {
                    width = matchParent
                    height = wrapContent
                    centerVertically()
                }

                //left
                navigationView = imageView {
                    padding = dip(4)
                    imageResource = R.drawable.ic_arrow_back_white_32dp
                }.lparams {
                    centerVertically()
                }

                //right
                menuView = imageView {
                    padding = dip(4)
                    imageResource = R.drawable.ic_more_vert_white_32dp
                }.lparams {
                    alignParentRight()
                    centerVertically()
                }

            }.lparams(matchParent, getActionBarSize(context))

            createContentView(this)
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
        titleView.text = title
        navigationView.setOnClickListener {
            activity.finish()
        }
    }

    fun hideNavigationMenu(){
        navigationView.visibility = View.INVISIBLE
        menuView.visibility = View.INVISIBLE
    }

    abstract fun createContentView(layout: LinearLayout):View
}