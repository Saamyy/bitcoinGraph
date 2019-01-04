package n26assignment.workstation.samy.base.DataSource

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

open class BaseRetrofitMarketPriceDataSource {
    private val BaseUrl: String = "https://api.blockchain.info"
    private var httpClient = OkHttpClient.Builder()

    var retrofit = getRetrofitCall()
    protected var client = retrofit.create(RestClient::class.java)

    private fun getRetrofitCall(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient.build())
            .build()
    }
}