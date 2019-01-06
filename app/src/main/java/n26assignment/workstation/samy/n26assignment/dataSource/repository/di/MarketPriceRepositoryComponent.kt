package n26assignment.workstation.samy.n26assignment.dataSource.repository.di

import dagger.Component
import n26assignment.workstation.samy.n26assignment.dataSource.repository.MarketPriceRepository

@Component(modules = [MarketPriceRepositoryModule::class])
interface MarketPriceRepositoryComponent {
    fun getMarketPriceRepository(): MarketPriceRepository
}