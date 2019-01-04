package n26assignment.workstation.samy.n26assignment.usecase

import android.arch.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import n26assignment.workstation.samy.base.Model.ErrorModel
import n26assignment.workstation.samy.base.Model.MarketPrice
import n26assignment.workstation.samy.n26assignment.DataSource.MarketPriceRepository
import n26assignment.workstation.samy.n26assignment.model.Period

class MarketPriceUseCase(
    var marketPriceList: MutableLiveData<List<MarketPrice>>,
    var errorModel: MutableLiveData<ErrorModel>
) {
    private var marketPriceRepository: MarketPriceRepository = MarketPriceRepository()
    private val bag: CompositeDisposable = CompositeDisposable()

    fun getMarket(historyPeriod: Period) {
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

    fun DisposeObservable() {
        bag.clear()
    }


}