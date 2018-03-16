package exam.jsc.kotlinanko.ui.fragment

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.centerInParent
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.textColor
import org.jetbrains.anko.textView

/**
 * Created on 2018/3/15.
 * @author jsc
 */
class FragmentT: Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return UI {
            relativeLayout {
                textView("This is a fragment.") {
                    textSize = 16f
                    textColor = Color.YELLOW
                }.lparams {
                    centerInParent()
                }
            }
        }.view
    }
}