package com.jinwoo.festa.domain.entity

import io.reactivex.Flowable

interface EventService  {
    fun getEventList(pageSize: Int): Flowable<List<EventEntity>>
}