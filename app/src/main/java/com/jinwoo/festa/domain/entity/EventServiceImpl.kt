package com.jinwoo.festa.domain.entity

import io.reactivex.Flowable

class EventServiceImpl(val repo: EventRepository): EventService {
    override fun getEventList(page: Int): Flowable<EventListEntity> =
        repo.getEventList(page)
            .doOnNext { repo.saveLocalEventList(it) }
            .onErrorReturn {
                val eventListEntity = repo.getLocalEventList()
                EventListEntity(eventListEntity.isRemote, eventListEntity.eventEntity.reversed())
            }
}