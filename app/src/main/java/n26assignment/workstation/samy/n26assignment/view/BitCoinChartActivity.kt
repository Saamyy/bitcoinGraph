package n26assignment.workstation.samy.n26assignment.view

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.os.Bundle
import n26assignment.workstation.samy.base.Model.ErrorModel
import n26assignment.workstation.samy.base.Model.MarketPrice
import n26assignment.workstation.samy.base.View.BaseActivity
import n26assignment.workstation.samy.n26assignment.R
import n26assignment.workstation.samy.n26assignment.model.Period
import n26assignment.workstation.samy.n26assignment.presenter.BitCoinChartPresenter
import kotlin.reflect.KFunction1

class BitCoinChartActivity : BaseActivity<BitCoinChartPresenter, BitCoinChartViewContract>(), BitCoinChartViewContract {

    val bitCoinChartPresenter = BitCoinChartPresenter()
    override fun presenter() = bitCoinChartPresenter
    override fun view() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitcoin_chart)
    }

    override fun onResume() {
        super.onResume()
        presenter().getMarketPrice(Period.ONE_MONTH)
        presenter().getMarketPriceList().observe(this, Observer<List<MarketPrice>>(::showData))
        presenter().getErrorModel().observe(this, Observer<ErrorModel>(::showError))

    }
    private fun showData(data: List<MarketPrice>?) {
        println(data)
    }


    private fun showError(errorModel: ErrorModel?) {
        print(errorModel)
    }


    override fun showLoading(show: Boolean) {

    }


}
