package n26assignment.workstation.samy.n26assignment.DataSource

import io.reactivex.Observable
import n26assignment.workstation.samy.base.Model.MarketPriceApiResponse
import n26assignment.workstation.samy.n26assignment.DataSource.network.MarketPriceRequest

class MarketPriceRepository {

    private lateinit var remote: MarketPriceDataSource

    fun getMarketPrice(period :String):Observable<MarketPriceApiResponse>{
        remote= MarketPriceRequest()
        return remote.gerMarketPrices(period)
    }

}