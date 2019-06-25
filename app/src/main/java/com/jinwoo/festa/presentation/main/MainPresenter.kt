package com.jinwoo.festa.presentation.main

import com.jinwoo.festa.domain.entity.EventEntity
import com.jinwoo.festa.presentation.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable

class MainPresenter(val getEventListUseCase: ,composite: CompositeDisposable)
    : BasePresenter<MainContract.View>(composite), MainContract.Presenter {
    override fun createView(view: MainContract.View) {
        super.createView(view)

        view.setEventListAdapter(getEventList())
    }

    private fun getEventList(): ArrayList<EventEntity> {
        add()
    }
}