package com.jinwoo.festa.domain.entity

import com.jinwoo.festa.data.entity.PageData
import io.reactivex.Flowable

class EventServiceImpl(val repo: EventRepository): EventService {
    override fun getEventList(pageSize: Int): Flowable<ArrayList<EventEntity>>
            = repo.getEventList(pageSize)
}