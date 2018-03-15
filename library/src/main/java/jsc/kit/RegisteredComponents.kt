package jsc.kit

import android.view.ViewManager
import jsc.kit.itemlayout.JSCItemLayout
import jsc.kit.test.CusLayout
import org.jetbrains.anko.custom.ankoView

/**
 * Created on 2018/3/15.
 * @author jsc
 */
inline fun ViewManager.jscItemLayout() = jscItemLayout {}
inline fun ViewManager.jscItemLayout(theme: Int = 0, init: JSCItemLayout.() -> Unit): JSCItemLayout {
    return ankoView({ JSCItemLayout(it) }, theme, init)
}

inline fun ViewManager.cusLayout() = cusLayout {}
inline fun ViewManager.cusLayout(theme: Int = 0, init: CusLayout.() -> Unit): CusLayout {
    return ankoView({ CusLayout(it) }, theme, init)
}