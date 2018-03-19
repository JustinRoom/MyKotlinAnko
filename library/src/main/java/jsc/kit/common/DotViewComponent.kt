package jsc.kit.common

import android.content.Context
import android.view.ViewManager
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.internals.AnkoInternals

/**
 * Created on 2018/3/19.
 * @author jsc
 */


inline fun ViewManager.dotView(
        ctx: Context = AnkoInternals.getContext(this),
        theme: Int = 0,
        init: DotView.() -> Unit
): DotView {
    return ankoView({ DotView(ctx) }, theme, init)
}