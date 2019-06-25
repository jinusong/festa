package com.jinwoo.festa.presentation.main

import com.jinwoo.festa.presentation.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable

class MainPresenter(composite: CompositeDisposable): BasePresenter<MainContract.View>(composite), MainContract.Presenter {
    override fun createView(view: MainContract.View) {
        super.createView(view)

    }

}