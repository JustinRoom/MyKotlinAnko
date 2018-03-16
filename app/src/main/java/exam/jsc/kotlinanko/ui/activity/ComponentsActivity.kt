package exam.jsc.kotlinanko.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import exam.jsc.kotlinanko.R
import exam.jsc.kotlinanko.ui.layout.ComponentsUI
import org.jetbrains.anko.setContentView

/**
 * Created on 2018/3/14.
 * @author jsc
 */
class ComponentsActivity : ABaseActivity() {

    private val l: View.OnClickListener = View.OnClickListener {
        when (it.id) {
            R.id.btn_arc_header_view -> {
                startActivity(Intent(this, ArcHeaderViewActivity::class.java))
            }
            R.id.btn_banner_view -> {
                startActivity(Intent(this, BannerViewActivity::class.java))
            }
            R.id.btn_month_view -> {
                startActivity(Intent(this, MonthViewActivity::class.java))
            }
            R.id.btn_rebound_layout -> {
                startActivity(Intent(this, ReboundLayoutActivity::class.java))
            }
            R.id.btn_vertical_step_view -> {
                startActivity(Intent(this, VerticalStepViewActivity::class.java))
            }
            R.id.btn_refresh_layout -> {
                startActivity(Intent(this, RefreshLayoutActivity::class.java))
            }
            R.id.btn_jsc_round_corner_progress_bar -> {
                startActivity(Intent(this, JSCRoundCornerProgressBarActivity::class.java))
            }
            R.id.btn_jsc_item_layout -> {
                startActivity(Intent(this, JSCItemLayoutActivity::class.java))
            }
        }
    }

    val ui = ComponentsUI(l)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui.setContentView(this)
        ui.setSupportActionBar(getCusTitle(), this, View.OnClickListener {
            finish()
        }, null)
    }
}