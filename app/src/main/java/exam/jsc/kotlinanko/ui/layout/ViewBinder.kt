package exam.jsc.kotlinanko.ui.layout

import android.view.View

interface ViewBinder<in T> {
    fun bind(t: T):View
    fun unbind(t: T)
}