package n26assignment.workstation.samy.base.Presenter

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.support.annotation.CallSuper
import n26assignment.workstation.samy.base.Model.ErrorModel

abstract class BasePresenter <V>{
    private var  view: V? =null
    private lateinit var context:Context
    private var errorModel:MutableLiveData<ErrorModel> = MutableLiveData()

    fun attachView(view: V,context: Context) {
        this.view = view
        this.context=context
        onViewAttached()
    }

    fun detachView() {
        this.view = null
        onViewDetached()
    }
    fun view() = view
    fun context()=context
    fun errorModel()=errorModel

    abstract fun onViewAttached()

    abstract fun onViewDetached()
}