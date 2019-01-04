package n26assignment.workstation.samy.n26assignment.DataSource.network

import io.reactivex.Observable
import n26assignment.workstation.samy.base.DataSource.BaseRetrofitRequest
import n26assignment.workstation.samy.base.DataSource.ErrorParser
import n26assignment.workstation.samy.base.Model.ErrorModel
import n26assignment.workstation.samy.base.Model.MarketPriceApiResponse
import n26assignment.workstation.samy.n26assignment.DataSource.MarketPriceDataSource
import retrofit2.Call
import retrofit2.Callback


class MarketPriceRequest : BaseRetrofitRequest(), MarketPriceDataSource {
    private var call: Call<MarketPriceApiResponse>? = null

    override fun gerMarketPrices(period: String): Observable<MarketPriceApiResponse> {
        call = client.getMarketPrices(period)
        return Observable.create<MarketPriceApiResponse> {
            call?.enqueue(object : Callback<MarketPriceApiResponse> {
                override fun onResponse(
                    call: Call<MarketPriceApiResponse>,
                    response: retrofit2.Response<MarketPriceApiResponse>?
                ) {
                    if (response?.isSuccessful!!) {
                        response.body()?.let { marketPriceApiResponse -> it.onNext(marketPriceApiResponse) }
                    } else {
                        val errorModel: ErrorModel = ErrorParser.parseError(response)
                        it.onError(errorModel)
                    }
                }

                override fun onFailure(call: Call<MarketPriceApiResponse>, t: Throwable) {
                    val errorModel = ErrorModel("", t.message)
                    it.onError(errorModel)
                }
            })
        }
    }
}