package n26assignment.workstation.samy.base.View

import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import n26assignment.workstation.samy.base.Presenter.BasePresenter

abstract class BaseActivity<P : BasePresenter<V>, V> : AppCompatActivity() {

    abstract fun view(): V

    abstract fun presenter(): P

    @CallSuper
    override fun onResume() {
        super.onResume()
        attachPresenter()
    }

    @CallSuper
    override fun onPause() {
        super.onPause()
        detachPresenter()
    }

    @CallSuper
    open fun attachPresenter() = presenter().attachView(view(), this)

    @CallSuper
    open fun detachPresenter() = presenter().detachView()


}