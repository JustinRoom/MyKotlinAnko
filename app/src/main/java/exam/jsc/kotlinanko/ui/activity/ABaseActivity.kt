package exam.jsc.kotlinanko.ui.activity

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import exam.jsc.kotlinanko.JSCApplication
import org.jetbrains.anko.AnkoLogger

/**
 * Created on 2018/3/14.
 * @author jsc
 */
abstract class ABaseActivity : AppCompatActivity() {

    lateinit var jscApplication: JSCApplication
    val logger = AnkoLogger(javaClass.simpleName)

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

        title = getCusTitle()
    }

    fun getCusTitle():String{
        return javaClass.simpleName.replace("Activity", "")
    }
}