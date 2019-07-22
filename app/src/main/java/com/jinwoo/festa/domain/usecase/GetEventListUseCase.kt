package com.jinwoo.festa.domain.usecase

import com.jinwoo.festa.domain.base.UseCase
import com.jinwoo.festa.domain.entity.EventListEntity
import com.jinwoo.festa.domain.entity.EventService
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable

class GetEventListUseCase(val service: EventService, composite: CompositeDisposable)
    : UseCase<EventListEntity, Int>(composite) {
    override fun createFlowable(pageSize: Int): Flowable<EventListEntity>
            = service.getEventList(pageSize)
}