package exam.jsc.kotlinanko.ui.activity

import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.FrameLayout
import android.widget.TextView
import exam.jsc.kotlinanko.JSCApplication
import org.jetbrains.anko.*


/**
 * Created on 2018/3/14.
 * @author jsc
 */
abstract class ABaseActivity : AppCompatActivity() {

    val logger = AnkoLogger(javaClass.simpleName)
    lateinit var jscApplication: JSCApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置屏幕方向：
        //"unspecified":默认值 由系统来判断显示方向.判定的策略是和设备相关的，所以不同的设备会有不同的显示方向.
        //"landscape":横屏显示（宽比高要长）
        //"portrait":竖屏显示(高比宽要长)
        //"user":用户当前首选的方向
        //"behind":和该Activity下面的那个Activity的方向一致(在Activity堆栈中的)
        //"sensor":有物理的感应器来决定。如果用户旋转设备这屏幕会横竖屏切换。
        //"nosensor":忽略物理感应器，这样就不会随着用户旋转设备而更改了（"unspecified"设置除外）。
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        //获取自定义的Application
        jscApplication = application as JSCApplication
    }

    fun getCusTitle():String{
        return javaClass.simpleName.replace("Activity", "")
    }

    var lastToastView: View? = null
    fun showCustomToast(@StringRes resId: Int){
        val txt = getString(resId)
        showCustomToast(txt)
    }

    fun showCustomToast(txt: CharSequence){
//        val content = find<FrameLayout>(android.R.id.content).
        val decorView = window.decorView as FrameLayout
        lastToastView?.animation?.cancel()
        decorView.removeView(lastToastView)

        val params = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT)
        params.gravity = Gravity.CENTER_HORIZONTAL
        params.topMargin = getStatusBarHeight() + getActionBarSize()
        params.leftMargin = dip(64)
        params.rightMargin = dip(64)
        val toastView = TextView(this)
        toastView.padding = dip(12)
        toastView.backgroundColor = Color.GREEN.withAlpha(0xEE)
        toastView.gravity = Gravity.CENTER_HORIZONTAL
        toastView.textSize = 16f
        toastView.textColor = Color.BLACK
        toastView.text = txt
        lastToastView = toastView
        decorView.addView(toastView, params)

        val inAnim = TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 1.0f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f
        )
        inAnim.setAnimationListener(object: Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                toastView.postDelayed({
                    decorView.removeView(toastView)
                }, 2000)
            }

            override fun onAnimationStart(animation: Animation?) {
            }
        })
        inAnim.duration = 300
        toastView.startAnimation(inAnim)
    }

    fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

    fun getActionBarSize(): Int {
        val typedValue = TypedValue()
        val attribute = intArrayOf(android.R.attr.actionBarSize)
        val array = obtainStyledAttributes(typedValue.resourceId, attribute)
        val value = array.getDimensionPixelSize(0, 0)
        array.recycle()
        return value
    }
}