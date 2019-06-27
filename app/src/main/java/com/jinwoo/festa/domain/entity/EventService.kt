package com.jinwoo.festa.domain.entity

import io.reactivex.Flowable

interface EventService  {
    fun getEventList(pageSize: Int): Flowable<ArrayList<EventEntity>>

    fun getLocalEventList(): ArrayList<EventEntity>

    fun saveLocalEventList(eventList: ArrayList<EventEntity>)
}