package n26assignment.workstation.samy.n26assignment.dataSource.repository

import io.reactivex.Observable
import n26assignment.workstation.samy.base.model.MarketPriceApiResponse
import n26assignment.workstation.samy.n26assignment.dataSource.MarketPriceDataSource
import javax.inject.Inject

class MarketPriceRepository @Inject constructor() {
    @Inject
    lateinit var remote: MarketPriceDataSource

    fun getMarketPrice(period: String): Observable<MarketPriceApiResponse> {
        return remote.gerMarketPrices(period)
    }

}