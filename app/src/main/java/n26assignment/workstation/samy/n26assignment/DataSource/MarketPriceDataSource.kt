package n26assignment.workstation.samy.n26assignment.DataSource

import io.reactivex.Observable
import n26assignment.workstation.samy.base.Model.MarketPriceApiResponse

interface MarketPriceDataSource {
    fun gerMarketPrices(period: String): Observable<MarketPriceApiResponse>
}