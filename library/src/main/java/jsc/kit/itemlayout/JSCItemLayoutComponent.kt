package jsc.kit.itemlayout

import android.content.Context
import android.view.ViewManager
import android.widget.ImageView
import android.widget.TextView
import jsc.kit.common.DotView
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.internals.AnkoInternals

/**
 * Created on 2018/3/15.
 * @author jsc
 */

inline fun ViewManager.jscItemLayout(
        ctx: Context = AnkoInternals.getContext(this),
        theme: Int = 0,
        init: JSCItemLayout.() -> Unit
): JSCItemLayout {
    return ankoView({ JSCItemLayout(ctx) }, theme, init)
}

//icon
inline fun <T : JSCItemLayout> T.ilIcon(
        init: ImageView.() -> Unit
): T {
    getIconView().init()
    return this
}

//label
inline fun <T : JSCItemLayout> T.ilLabel(
        init: TextView.() -> Unit
): T {
    getLabelView().init()
    return this
}

//dot
inline fun <T : JSCItemLayout> T.ilDot(
        init: DotView.() -> Unit
): T {
    getDotView().init()
    return this
}

//arrow
inline fun <T : JSCItemLayout> T.ilArrow(
        init: ImageView.() -> Unit
): T {
    getArrowView().init()
    return this
}