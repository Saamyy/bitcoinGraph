package n26assignment.workstation.samy.n26assignment.usecase.di

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import n26assignment.workstation.samy.n26assignment.DataSource.Repository.MarketPriceRepository
import n26assignment.workstation.samy.n26assignment.DataSource.Repository.di.DaggerMarketPriceRepositoryComponent

@Module

class BitCoinChartUseCaseModule {
    @Provides
    fun getMarketPriceRepository(): MarketPriceRepository {
        return DaggerMarketPriceRepositoryComponent.create().getMarketPriceRepository()
    }

    @Provides
    fun getCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }
}