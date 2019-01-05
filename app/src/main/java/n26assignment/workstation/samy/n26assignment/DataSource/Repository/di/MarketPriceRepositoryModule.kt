package n26assignment.workstation.samy.n26assignment.DataSource.Repository.di

import dagger.Module
import dagger.Provides
import n26assignment.workstation.samy.n26assignment.DataSource.MarketPriceDataSource
import n26assignment.workstation.samy.n26assignment.DataSource.network.MarketPriceRequest


@Module

class MarketPriceRepositoryModule {
    @Provides
    fun getMarketPriceRequest(): MarketPriceDataSource {
        return MarketPriceRequest()
    }
}