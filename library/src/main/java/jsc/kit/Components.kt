package jsc.kit

import android.content.Context
import android.view.ViewManager
import android.widget.ImageView
import android.widget.TextView
import jsc.kit.archeaderview.LGradientArcHeaderView
import jsc.kit.archeaderview.PictureArcHeaderView
import jsc.kit.common.DotView
import jsc.kit.itemlayout.JSCItemLayout
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.internals.AnkoInternals

/**
 * <p></p>
 * <br>Email:1006368252@qq.com
 * <br>QQ:1006368252
 *
 * @author jsc
 */
//>>>>>>>>>>>>>>>>>>>>>>>>>>>【JSCItemLayout】
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


//>>>>>>>>>>>>>>>>>>>>>>>>>>>【DotView】
inline fun ViewManager.dotView(
        ctx: Context = AnkoInternals.getContext(this),
        theme: Int = 0,
        init: DotView.() -> Unit
): DotView {
    return ankoView({ DotView(ctx) }, theme, init)
}



//>>>>>>>>>>>>>>>>>>>>>>>>>>>【LGradientArcHeaderView】
inline fun ViewManager.lGradientArcHeaderView(
        ctx: Context = AnkoInternals.getContext(this),
        theme: Int = 0,
        init: LGradientArcHeaderView.() -> Unit
): LGradientArcHeaderView {
    return ankoView({ LGradientArcHeaderView(ctx) }, theme, init)
}




//>>>>>>>>>>>>>>>>>>>>>>>>>>>【PictureArcHeaderView】
inline fun ViewManager.pictureArcHeaderView(
        ctx: Context = AnkoInternals.getContext(this),
        theme: Int = 0,
        init: PictureArcHeaderView.() -> Unit
): PictureArcHeaderView {
    return ankoView({ PictureArcHeaderView(ctx) }, theme, init)
}