package n26assignment.workstation.samy.n26assignment.presenter.di

import dagger.Component
import n26assignment.workstation.samy.n26assignment.presenter.BitCoinChartPresenter

@Component(modules = [BitCoinChartPresenterModule::class])

interface BitCoinChartPresenterComponent {
    fun getBitCoinChartPresenter(): BitCoinChartPresenter

}