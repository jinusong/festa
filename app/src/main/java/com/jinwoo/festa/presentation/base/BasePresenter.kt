package com.jinwoo.festa.presentation.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.lang.ref.WeakReference

abstract class BasePresenter<T: BaseContract.View>: BaseContract.Presenter<T> {
    var weakReference: WeakReference<T>? =  null

    val view: T
        get() = weakReference?.get()!!

    override fun createView(view: T) {
        weakReference = WeakReference(view)
        view.setPresenter(this)
    }

    override fun destroyView() {
        weakReference?.clear()
    }
}