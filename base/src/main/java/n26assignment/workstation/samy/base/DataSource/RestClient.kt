package n26assignment.workstation.samy.base.DataSource

import io.reactivex.Single
import n26assignment.workstation.samy.base.Model.MarketPriceApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestClient {
    @GET("/charts/market-price?format=json")
    fun getMarketPrices(
        @Query("timespan") period : String
    ): Call<MarketPriceApiResponse>
}