package n26assignment.workstation.samy.n26assignment.view

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.View
import n26assignment.workstation.samy.base.Model.ErrorModel
import n26assignment.workstation.samy.base.Model.MarketPrice
import n26assignment.workstation.samy.base.View.BaseActivity
import n26assignment.workstation.samy.n26assignment.R
import n26assignment.workstation.samy.n26assignment.model.Period
import n26assignment.workstation.samy.n26assignment.presenter.BitCoinChartPresenter
import android.widget.TextView
import com.robinhood.spark.SparkView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.Toast
import android.text.format.DateFormat
import java.util.*


class BitCoinChartActivity : BaseActivity<BitCoinChartPresenter, BitCoinChartViewContract>(), BitCoinChartViewContract {

    private val bitCoinChartPresenter = BitCoinChartPresenter()
    private val graphAdapter = GraphAdapter()
    private var progressBar: ProgressBar? = null
    private var graphContainer: RelativeLayout? = null
    private var graph: SparkView? = null
    private var startDate: TextView? = null
    private var endDate: TextView? = null
    private var maxRate: TextView? = null
    private var minRate: TextView? = null

    override fun presenter() = bitCoinChartPresenter
    override fun view() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitcoin_chart)
        initView()
    }

    override fun onResume() {
        super.onResume()
        presenter().getMarketPrice(Period.YEAR)
        presenter().getMarketPriceList().observe(this, Observer<List<MarketPrice>>(::showData))
        presenter().getErrorModel().observe(this, Observer<ErrorModel>(::showError))
    }

    private fun initView() {
        progressBar = findViewById(R.id.progressBar)
        graphContainer = findViewById(R.id.graph_container)
        graph = findViewById(R.id.graph)
        startDate = findViewById(R.id.start_date)
        endDate = findViewById(R.id.end_date)
        maxRate = findViewById(R.id.max_rate)
        minRate = findViewById(R.id.min_rate)
        graph?.adapter = graphAdapter
    }

    private fun showData(data: List<MarketPrice>?) {
        graphAdapter.data = data
        val firstItem = data?.get(0)
        val lastItem = data?.get(data.size - 1)
        maxRate?.text = lastItem?.value.toString()
        minRate?.text = firstItem?.value.toString()
        startDate?.text = getStringDate(firstItem?.timeSpan)
        endDate?.text = getStringDate(lastItem?.timeSpan)
        showLoading(false)

    }

    private fun getStringDate(timestamp: Long?): String? {
        val requiredFormat = "dd-MM-yyyy"
        val dateInMilliseconds = timestamp ?: 0
        val date = Date(dateInMilliseconds.times(1000))
        return DateFormat.format(requiredFormat, date).toString()
    }

    private fun showError(errorModel: ErrorModel?) {
        Toast.makeText(
            this, errorModel?.message,
            Toast.LENGTH_LONG
        ).show()
        showLoading(false)
    }


    override fun showLoading(show: Boolean) {
        if (show) {
            progressBar?.visibility = View.VISIBLE
            graphContainer?.visibility = View.GONE
        } else {
            progressBar?.visibility = View.GONE
            graphContainer?.visibility = View.VISIBLE
        }
    }


}
