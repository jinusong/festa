package com.jinwoo.festa.domain.entity

import io.reactivex.Flowable

interface EventRepository {
    fun getEventList(pageSize: Int): Flowable<List<EventEntity>>

    fun getLocalEventList(): List<EventEntity>

    fun saveLocalEventList(eventList: List<EventEntity>)
}