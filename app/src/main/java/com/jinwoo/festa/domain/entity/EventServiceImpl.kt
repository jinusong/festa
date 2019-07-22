package com.jinwoo.festa.domain.entity

import io.reactivex.Flowable

class EventServiceImpl(val repo: EventRepository): EventService {
    override fun getEventList(pageSize: Int): Flowable<EventListEntity> =
        repo.getEventList(pageSize)
            .doOnNext { repo.saveLocalEventList(it) }
            .onErrorReturn { repo.getLocalEventList() }
}