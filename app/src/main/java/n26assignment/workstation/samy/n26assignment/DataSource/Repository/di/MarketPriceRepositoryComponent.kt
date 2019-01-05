package n26assignment.workstation.samy.n26assignment.DataSource.Repository.di

import dagger.Component
import n26assignment.workstation.samy.n26assignment.DataSource.Repository.MarketPriceRepository

@Component(modules = [MarketPriceRepositoryModule::class])
interface MarketPriceRepositoryComponent {
    fun getMarketPriceRepository(): MarketPriceRepository
}