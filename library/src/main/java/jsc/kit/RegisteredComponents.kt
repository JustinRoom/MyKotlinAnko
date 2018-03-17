package jsc.kit

import android.view.ViewManager
import jsc.kit.archeaderview.LGradientArcHeaderView
import jsc.kit.archeaderview.PictureArcHeaderView
import jsc.kit.itemlayout.JSCItemLayout
import org.jetbrains.anko.custom.ankoView

/**
 * Created on 2018/3/15.
 * @author jsc
 */
inline fun ViewManager.jscItemLayout() = jscItemLayout {}

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