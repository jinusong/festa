package com.jinwoo.festa.domain.usecase

import com.jinwoo.festa.domain.base.UseCase
import com.jinwoo.festa.domain.entity.EventEntity
import com.jinwoo.festa.domain.entity.EventService
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable

class GetEventDetailUseCase(val service: EventService, composite: CompositeDisposable)
    : UseCase<EventEntity, Int>(composite) {
    override fun createFlowable(eventId: Int): Flowable<EventEntity>
            =  service.getEventDetail(eventId)
}