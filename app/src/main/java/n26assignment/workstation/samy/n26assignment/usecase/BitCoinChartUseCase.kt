package n26assignment.workstation.samy.n26assignment.usecase

import android.arch.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import n26assignment.workstation.samy.base.model.ErrorModel
import n26assignment.workstation.samy.base.model.MarketPrice
import n26assignment.workstation.samy.n26assignment.dataSource.repository.MarketPriceRepository
import n26assignment.workstation.samy.n26assignment.model.Period
import javax.inject.Inject

class BitCoinChartUseCase @Inject constructor() {
    @Inject
    lateinit var marketPriceRepository: MarketPriceRepository
    @Inject
    lateinit var bag: CompositeDisposable

    fun getMarketPrice(
        historyPeriod: Period,
        marketPriceList: MutableLiveData<List<MarketPrice>>,
        errorModel: MutableLiveData<ErrorModel>
    ) {
        val disposable = marketPriceRepository.getMarketPrice(historyPeriod.value)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                marketPriceList.value = it.values
            }, {
                errorModel.value = it as ErrorModel
            })
        bag.add(disposable)
    }

    fun disposeObservable() {
        bag.clear()
    }


}