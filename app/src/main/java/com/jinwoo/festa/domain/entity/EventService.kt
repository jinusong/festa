package com.jinwoo.festa.domain.entity

import com.jinwoo.festa.data.entity.PageData
import io.reactivex.Flowable

interface EventService  {
    fun getEventList(pageSize: Int): Flowable<ArrayList<EventEntity>>
}