package com.jinwoo.festa.domain.entity

import io.reactivex.Flowable

interface EventRepository {
    fun getEventList(page: Int): Flowable<EventListEntity>

    fun getEventDetail(eventId: Int): Flowable<EventEntity>

    fun getLocalEventList(): EventListEntity

    fun saveLocalEventList(eventList: EventListEntity)
}