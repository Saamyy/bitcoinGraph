package n26assignment.workstation.samy.n26assignment.DataSource.Repository

import io.reactivex.Observable
import n26assignment.workstation.samy.base.Model.MarketPriceApiResponse
import n26assignment.workstation.samy.n26assignment.DataSource.MarketPriceDataSource
import n26assignment.workstation.samy.n26assignment.DataSource.network.MarketPriceRequest
import javax.inject.Inject

class MarketPriceRepository @Inject constructor() {
    @Inject
    lateinit var remote: MarketPriceDataSource

    fun getMarketPrice(period: String): Observable<MarketPriceApiResponse> {
        return remote.gerMarketPrices(period)
    }

}