package com.jinwoo.festa.domain.entity

import io.reactivex.Flowable

interface EventService  {
    fun getEventList(pageSize: Int): Flowable<EventListEntity>

    fun getEventDetail(eventId: Int): Flowable<EventEntity>

    fun saveLike(like: LikeEntity): Flowable<Unit>
}