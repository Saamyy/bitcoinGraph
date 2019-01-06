package n26assignment.workstation.samy.n26assignment.dataSource

import io.reactivex.Observable
import n26assignment.workstation.samy.base.model.MarketPriceApiResponse

interface MarketPriceDataSource {
    fun gerMarketPrices(period: String): Observable<MarketPriceApiResponse>
}