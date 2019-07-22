package com.jinwoo.festa.domain.entity

import io.reactivex.Flowable

interface EventRepository {
    fun getEventList(pageSize: Int): Flowable<EventListEntity>

    fun getLocalEventList(): EventListEntity

    fun saveLocalEventList(eventList: EventListEntity)
}