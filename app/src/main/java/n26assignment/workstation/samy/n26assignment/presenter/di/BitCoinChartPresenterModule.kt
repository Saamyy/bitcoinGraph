package n26assignment.workstation.samy.n26assignment.presenter.di

import dagger.Module
import dagger.Provides
import n26assignment.workstation.samy.n26assignment.usecase.BitCoinChartUseCase
import n26assignment.workstation.samy.n26assignment.usecase.di.DaggerBitCoinChartUseCaseComponent

@Module

class BitCoinChartPresenterModule {
    @Provides
    fun getBitCoinChartUseCase(): BitCoinChartUseCase {
        return DaggerBitCoinChartUseCaseComponent.create().getBitCoinChartUseCase()
    }
}