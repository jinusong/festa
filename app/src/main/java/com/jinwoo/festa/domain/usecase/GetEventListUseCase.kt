package com.jinwoo.festa.domain.usecase

import com.jinwoo.festa.domain.base.UseCase
import com.jinwoo.festa.domain.entity.EventEntity
import com.jinwoo.festa.domain.entity.EventService
import io.reactivex.Flowable

class GetEventListUseCase(val service: EventService): UseCase<ArrayList<EventEntity>, Int>() {
    override fun createFlowable(data: Int): Flowable<ArrayList<EventEntity>>
            = service.getEventList(data)
}