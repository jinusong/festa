package com.jinwoo.festa.domain.usecase

import com.jinwoo.festa.domain.base.UseCase
import com.jinwoo.festa.domain.entity.EventEntity
import com.jinwoo.festa.domain.entity.EventService
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable

class GetEventListUseCase(val service: EventService, composite: CompositeDisposable)
    : UseCase<List<EventEntity>, Int>(composite) {
    override fun createFlowable(data: Int): Flowable<List<EventEntity>>
            = service.getEventList(data)

    fun getLocalEventList(): List<EventEntity>
            = service.getLocalEventList()

    fun saveLocalEventList(eventList: ArrayList<EventEntity>)
            = service.saveLocalEventList(eventList)
}