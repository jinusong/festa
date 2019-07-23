package com.jinwoo.festa.presentation.eventdetail

import com.jinwoo.festa.presentation.base.BasePresenter

class EventDetailPresenter: BasePresenter<EventDetailContract.View>(), EventDetailContract.Presenter {
    override fun createView(view: EventDetailContract.View) {
        super.createView(view)

    }

    override fun destroyView() {
        super.destroyView()
    }
}