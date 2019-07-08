package com.jinwoo.festa.presentation.main

import com.jinwoo.festa.domain.entity.EventEntity
import com.jinwoo.festa.domain.usecase.GetEventListUseCase
import com.jinwoo.festa.presentation.base.BasePresenter
import com.jinwoo.festa.presentation.mapper.EventModelMapper
import com.jinwoo.festa.presentation.model.EventModel
import io.reactivex.subscribers.DisposableSubscriber

class MainPresenter(val getEventListUseCase: GetEventListUseCase, val eventModelMapper: EventModelMapper)
    : BasePresenter<MainContract.View>(), MainContract.Presenter {

    override fun createView(view: MainContract.View) {
        super.createView(view)
        getEventList()
    }

    private fun getEventList() {
        val eventList = ArrayList<EventModel>()
        getEventListUseCase.execute(24,
            object: DisposableSubscriber<List<EventEntity>>() {
                override fun onComplete() {
                    if (eventList.first().state) view.createToast("조회 성공")
                    else view.createToast("네트워크 상태를 확인해주세요.")
                    view.setEventListAdapter(eventList)
                }
                override fun onNext(t: List<EventEntity>) {
                    t.map { eventList.add(eventModelMapper.mapFrom(it)) }
                }
                override fun onError(t: Throwable) {
                    view.createToast("오류가 발생했습니다.")
                }
            })
    }

    override fun destroyView() {
        super.destroyView()
        getEventListUseCase.clear()
    }

}