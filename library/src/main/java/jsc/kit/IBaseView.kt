package jsc.kit

import android.content.Context
import android.util.AttributeSet

/**
 * Created on 2018/3/17.
 * @author jsc
 */
interface IBaseView {
    fun init(context: Context)
    fun retrieveAttributes(attrs: AttributeSet)
}