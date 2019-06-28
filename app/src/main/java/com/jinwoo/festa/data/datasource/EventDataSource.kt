package com.jinwoo.festa.data.datasource

import com.jinwoo.festa.data.database.entity.Event
import com.jinwoo.festa.data.entity.EventData
import io.reactivex.Flowable

interface EventDataSource {
    fun getRemoteEventList(pageSize: Int): Flowable<List<EventData>>

    fun saveDbEventList(event: Event)

    fun getDbEventList(): List<Event>
}