package n26assignment.workstation.samy.n26assignment.usecase.di

import dagger.Component
import n26assignment.workstation.samy.n26assignment.DataSource.Repository.di.MarketPriceRepositoryModule
import n26assignment.workstation.samy.n26assignment.usecase.BitCoinChartUseCase

@Component(modules = [BitCoinChartUseCaseModule::class])

interface BitCoinChartUseCaseComponent {
    fun getBitCoinChartUseCase(): BitCoinChartUseCase
}