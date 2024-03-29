package com.jinwoo.festa.presentation.main

import com.jinwoo.festa.domain.entity.EventListEntity
import com.jinwoo.festa.domain.usecase.GetEventListUseCase
import com.jinwoo.festa.presentation.base.BasePresenter
import com.jinwoo.festa.presentation.mapper.EventModelMapper
import com.jinwoo.festa.presentation.model.EventListModel
import io.reactivex.subscribers.DisposableSubscriber
import kotlin.collections.ArrayList

class MainPresenter(val getEventListUseCase: GetEventListUseCase, val eventModelMapper: EventModelMapper)
    : BasePresenter<MainContract.View>(), MainContract.Presenter {

    var page: Int = 0

    override fun createView(view: MainContract.View) {
        super.createView(view)
        showStartEventList()
    }

    override fun showStartEventList() {
        page++
        var eventList = EventListModel(false, ArrayList())

        getEventListUseCase.execute(page, object: DisposableSubscriber<EventListEntity>() {
                override fun onComplete() {
                    if (eventList.isRemote) view.createToast("조회 성공")
                    else view.createToast("네트워크 상태를 확인해주세요.")

                    if (page == 1) view.showEventListAdapter(ArrayList(eventList.eventModelList))
                    else view.updateEventListAdapter(ArrayList(eventList.eventModelList))
                }
                override fun onNext(t: EventListEntity) {
                    eventList = EventListModel(t.isRemote, t.eventEntity.map { eventModelMapper.mapFrom(it) })
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