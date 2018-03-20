package exam.jsc.kotlinanko.ui.activity

import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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

    var lastToast: View? = null
    fun showCustomToast(txt: CharSequence, topMargin: Int = 0){
        val content = find<FrameLayout>(android.R.id.content)
        lastToast?.animation?.cancel()
        content.removeView(lastToast)

        val params = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT)
        params.gravity = Gravity.CENTER_HORIZONTAL
        params.topMargin = topMargin
        params.leftMargin = dip(64)
        params.rightMargin = dip(64)
        val v = TextView(this)
        v.padding = dip(12)
        v.backgroundColor = Color.GREEN.withAlpha(0xEE)
        v.gravity = Gravity.CENTER_HORIZONTAL
        v.textSize = 16f
        v.textColor = Color.BLACK
        v.text = txt
        lastToast = v
        content.addView(v, params)

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
                v.postDelayed({
                    content.removeView(v)
                }, 2000)
            }

            override fun onAnimationStart(animation: Animation?) {
            }
        })
        inAnim.duration = 300
        v.startAnimation(inAnim)
    }
}