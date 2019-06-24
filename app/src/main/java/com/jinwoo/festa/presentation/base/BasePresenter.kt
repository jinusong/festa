package com.jinwoo.festa.presentation.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.lang.ref.WeakReference

abstract class BasePresenter<T: BaseContract.View>(val composite: CompositeDisposable):
    BaseContract.Presenter<T> {
    var weakReference: WeakReference<T>? =  null

    val view: T
        get() = weakReference?.get()!!

    fun add(disposable: Disposable)
            = CompositeDisposable().add(disposable)

    override fun createView(view: T) {
        weakReference = WeakReference(view)
        view.setPresenter(this)
    }

    override fun destroyView() {
        weakReference?.clear()
        composite.clear()
    }
}