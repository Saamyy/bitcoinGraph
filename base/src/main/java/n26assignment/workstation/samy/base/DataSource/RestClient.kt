package n26assignment.workstation.samy.base.DataSource

import io.reactivex.Single
import n26assignment.workstation.samy.base.Model.MarketPriceApiRespnce
import retrofit2.http.GET
import retrofit2.http.Query

interface RestClient {
    @GET("/charts/market-price?format=json")
    fun getMarketPrices(
        @Query("timespan") timeSpan : String
    ): Single<MarketPriceApiRespnce>
}