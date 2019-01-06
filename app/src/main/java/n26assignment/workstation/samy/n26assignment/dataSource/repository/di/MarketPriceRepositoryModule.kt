package n26assignment.workstation.samy.n26assignment.dataSource.repository.di

import dagger.Module
import dagger.Provides
import n26assignment.workstation.samy.n26assignment.dataSource.MarketPriceDataSource
import n26assignment.workstation.samy.n26assignment.dataSource.network.MarketPriceRequest


@Module

class MarketPriceRepositoryModule {
    @Provides
    fun getMarketPriceRequest(): MarketPriceDataSource {
        return MarketPriceRequest()
    }
}