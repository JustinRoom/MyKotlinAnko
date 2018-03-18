package jsc.kit

import android.content.Context
import android.view.ViewManager
import android.widget.ImageView
import android.widget.TextView
import jsc.kit.archeaderview.LGradientArcHeaderView
import jsc.kit.archeaderview.PictureArcHeaderView
import jsc.kit.itemlayout.JSCItemLayout
import jsc.kit.itemlayout.MyItemLayout
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.internals.AnkoInternals

/**
 * Created on 2018/3/15.
 * @author jsc
 */
//inline fun ViewManager.jscItemLayout() = jscItemLayout {}
inline fun ViewManager.jscItemLayout(theme: Int = 0, init: JSCItemLayout.() -> Unit): JSCItemLayout {
    return ankoView({ JSCItemLayout(it) }, theme, init)
}

inline fun ViewManager.pictureArcHeaderView() = pictureArcHeaderView {}
inline fun ViewManager.pictureArcHeaderView(theme: Int = 0, init: PictureArcHeaderView.() -> Unit): PictureArcHeaderView {
    return ankoView({ PictureArcHeaderView(it) }, theme, init)
}

inline fun ViewManager.lGradientArcHeaderView() = lGradientArcHeaderView {}
inline fun ViewManager.lGradientArcHeaderView(theme: Int = 0, init: LGradientArcHeaderView.() -> Unit): LGradientArcHeaderView {
    return ankoView({ LGradientArcHeaderView(it) }, theme, init)
}


inline fun ViewManager.myItemLayout(
        ctx: Context = AnkoInternals.getContext(this),
        theme: Int = 0,
        init: MyItemLayout.() -> Unit
): MyItemLayout {
    return ankoView({ MyItemLayout(ctx) }, theme, init)
}

//icon
inline fun <T : MyItemLayout> T.ilIcon(
        init: ImageView.() -> Unit
): T {
    getIconView().init()
    return this
}

//label
inline fun <T : MyItemLayout> T.ilLabel(
        init: TextView.() -> Unit
): T {
    getLabelView().init()
    return this
}

//arrow
inline fun <T : MyItemLayout> T.ilArrow(
        init: ImageView.() -> Unit
): T {
    getArrowView().init()
    return this
}