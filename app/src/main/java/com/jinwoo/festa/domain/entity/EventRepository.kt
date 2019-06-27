package com.jinwoo.festa.domain.entity

import io.reactivex.Flowable

interface EventRepository {
    fun getEventList(pageSize: Int): Flowable<ArrayList<EventEntity>>

    fun getLocalEventList(): ArrayList<EventEntity>

    fun saveLocalEventList(eventList: ArrayList<EventEntity>)
}