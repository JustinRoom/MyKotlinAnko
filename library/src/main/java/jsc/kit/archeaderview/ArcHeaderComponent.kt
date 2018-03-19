package jsc.kit.archeaderview

import android.content.Context
import android.view.ViewManager
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.internals.AnkoInternals

/**
 * Created on 2018/3/15.
 * @author jsc
 */
inline fun ViewManager.lGradientArcHeaderView(
        ctx: Context = AnkoInternals.getContext(this),
        theme: Int = 0,
        init: LGradientArcHeaderView.() -> Unit
): LGradientArcHeaderView {
    return ankoView({ LGradientArcHeaderView(ctx) }, theme, init)
}

inline fun ViewManager.pictureArcHeaderView(
        ctx: Context = AnkoInternals.getContext(this),
        theme: Int = 0,
        init: PictureArcHeaderView.() -> Unit
): PictureArcHeaderView {
    return ankoView({ PictureArcHeaderView(ctx) }, theme, init)
}