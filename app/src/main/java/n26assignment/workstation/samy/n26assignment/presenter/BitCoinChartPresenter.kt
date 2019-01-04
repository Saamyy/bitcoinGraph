package n26assignment.workstation.samy.n26assignment.presenter

import android.arch.lifecycle.MutableLiveData
import n26assignment.workstation.samy.base.Model.ErrorModel
import n26assignment.workstation.samy.base.Model.MarketPrice
import n26assignment.workstation.samy.base.Presenter.BasePresenter
import n26assignment.workstation.samy.n26assignment.view.BitCoinChartActivity
import n26assignment.workstation.samy.n26assignment.model.Period
import n26assignment.workstation.samy.n26assignment.usecase.BitCoinChartUseCase
import n26assignment.workstation.samy.n26assignment.view.BitCoinChartViewContract

class BitCoinChartPresenter : BasePresenter<BitCoinChartViewContract>() {

    private lateinit var marketPriceList: MutableLiveData<List<MarketPrice>>
    private lateinit var errorModel: MutableLiveData<ErrorModel>
    private lateinit var bitCoinChartUseCase: BitCoinChartUseCase

    override fun onViewAttached() {
        marketPriceList = MutableLiveData()
        errorModel = errorModel()
        bitCoinChartUseCase = BitCoinChartUseCase(marketPriceList, errorModel)
    }

    fun getMarketPrice(period: Period) {
        view()?.showLoading(true)
        bitCoinChartUseCase.getMarketPrice(period)
    }

    fun getMarketPriceList():MutableLiveData<List<MarketPrice>>{
        view()?.showLoading(false)
        return marketPriceList
    }
     fun getErrorModel(): MutableLiveData<ErrorModel>{
         view()?.showLoading(false)
         return errorModel
     }

    override fun onViewDetached() {
        bitCoinChartUseCase.disposeObservable()
    }
}