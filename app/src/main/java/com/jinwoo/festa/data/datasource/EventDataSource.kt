package com.jinwoo.festa.data.datasource

import com.jinwoo.festa.data.database.entity.Event
import com.jinwoo.festa.data.entity.EventData
import io.reactivex.Flowable

interface EventDataSource {
    fun getRemoteEventList(page: Int): Flowable<List<EventData>>

    fun saveDbEventList(event: List<Event>)

    fun getDbEventList(): List<Event>

    fun getDbEvent(eventId: Int): Flowable<Event>
}